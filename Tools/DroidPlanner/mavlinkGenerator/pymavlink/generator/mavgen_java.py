#!/usr/bin/env python
'''
parse a MAVLink protocol XML file and generate a Java implementation

Copyright Andrew Tridgell 2011
Released under GNU GPL version 3 or later
'''

import sys, textwrap, os, time
import mavparse, mavtemplate

t = mavtemplate.MAVTemplate()

def generate_version_h(directory, xml):
    '''generate version.h'''
    f = open(os.path.join(directory, "version.h"), mode='w')
    t.write(f,'''
/** @file
 *	@brief MAVLink comm protocol built from ${basename}.xml
 *	@see http://pixhawk.ethz.ch/software/mavlink
 */
#ifndef MAVLINK_VERSION_H
#define MAVLINK_VERSION_H

#define MAVLINK_BUILD_DATE "${parse_time}"
#define MAVLINK_WIRE_PROTOCOL_VERSION "${wire_protocol_version}"
#define MAVLINK_MAX_DIALECT_PAYLOAD_SIZE ${largest_payload}
 
#endif // MAVLINK_VERSION_H
''', xml)
    f.close()

def generate_mavlink_h(directory, xml):
    '''generate mavlink.h'''
    f = open(os.path.join(directory, "mavlink.h"), mode='w')
    t.write(f,'''
/** @file
 *	@brief MAVLink comm protocol built from ${basename}.xml
 *	@see http://pixhawk.ethz.ch/software/mavlink
 */
#ifndef MAVLINK_H
#define MAVLINK_H

#ifndef MAVLINK_STX
#define MAVLINK_STX ${protocol_marker}
#endif

#ifndef MAVLINK_ENDIAN
#define MAVLINK_ENDIAN ${mavlink_endian}
#endif

#ifndef MAVLINK_ALIGNED_FIELDS
#define MAVLINK_ALIGNED_FIELDS ${aligned_fields_define}
#endif

#ifndef MAVLINK_CRC_EXTRA
#define MAVLINK_CRC_EXTRA ${crc_extra_define}
#endif

#include "version.h"
#include "${basename}.h"

#endif // MAVLINK_H
''', xml)
    f.close()

def generate_CRC(directory, xml):
    # and message CRCs array
    xml.message_crcs_array = ''
    for crc in xml.message_crcs:
        xml.message_crcs_array += '%u, ' % crc
    xml.message_crcs_array = xml.message_crcs_array[:-2]
    
    f = open(os.path.join(directory, "CRC.java"), mode='w')
    t.write(f,'''
 package com.MAVLink.Messages;

/**
 * X.25 CRC calculation for MAVlink messages. The checksum must be initialized,
 * updated with witch field of the message, and then finished with the message
 * id.
 * 
 */
public class CRC {
	private final int[] MAVLINK_MESSAGE_CRCS = {${message_crcs_array}};
	private static final int CRC_INIT_VALUE = 0xffff;
	private int CRCvalue;	

	/**
	 * Accumulate the X.25 CRC by adding one char at a time.
	 * 
	 * The checksum function adds the hash of one char at a time to the 16 bit
	 * checksum (uint16_t).
	 * 
	 * @param data
	 *            new char to hash
	 * @param crcAccum
	 *            the already accumulated checksum
	 **/
	public  void update_checksum(int data) {
		int tmp;
		tmp = data ^ (CRCvalue & 0xff);
		tmp ^= (tmp << 4) & 0xff;
		CRCvalue = ((CRCvalue >> 8) & 0xff) ^ (tmp << 8) ^ (tmp << 3)
				^ ((tmp >> 4) & 0xf);
	}

	/**
	 * Finish the CRC calculation of a message, by running the CRC with the
	 * Magic Byte. This Magic byte has been defined in MAVlink v1.0.
	 * 
	 * @param msgid
	 *            The message id number
	 */
	public  void finish_checksum(int msgid) {
		update_checksum(MAVLINK_MESSAGE_CRCS[msgid]);
	}

	/**
	 * Initialize the buffer for the X.25 CRC
	 * 
	 */
	public void start_checksum() {
		CRCvalue = CRC_INIT_VALUE;
	}

	public int getMSB() {
		return ((CRCvalue >> 8) & 0xff);
	}

	public int getLSB() {
		return (CRCvalue & 0xff);
	}

	public CRC() {
		start_checksum();
	}

}
''',xml)

    f.close()
             

def generate_message_h(directory, m):
    '''generate per-message header for a XML file'''
    f = open(os.path.join(directory, 'msg_%s.java' % m.name_lower), mode='w')
    t.write(f, '''
// MESSAGE ${name} PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* ${description}
*/
public class msg_${name_lower} extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_${name} = ${id};
	public static final int MAVLINK_MSG_LENGTH = ${wire_length};

${{ordered_fields: 	/**
	*${description}
	*/
	public ${type} ${name}${array_suffix}; 
}}

/**
 * Decode a ${name_lower} message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
${{ordered_fields:	    ${unpackField}
}}    
    }

    public msg_${name_lower}(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_${name};
        unpack(payload);
        Log.d("MAVLink", "${name}");
    }
}
''', m)
    f.close()


def generate_MAVLinkMessage(directory, xml_list):
    f = open(os.path.join(directory, "MAVLinkPacket.Java"), mode='w')
    f.write('''package com.MAVLink.Messages;

import android.util.Log;

import com.MAVLink.Messages.ardupilotmega.*;

public class MAVLinkPacket{
	public int seq;
	public int len;
	public  int sysid;
	public int compid;
	public int msgid;		
	public MAVLinkPayload payload;
	public CRC crc;		
	
	public MAVLinkPacket(){
		payload = new MAVLinkPayload();
	}
	
	public boolean payloadIsFilled() {
		return (payload.size() == len);
	}
	
	public void generateCRC(){
		crc = new CRC();
		crc.update_checksum(len);
		crc.update_checksum(seq);
		crc.update_checksum(sysid);
		crc.update_checksum(compid);
		crc.update_checksum(msgid);
		payload.resetIndex();
		for (int i = 0; i < payload.size(); i++) {
			crc.update_checksum(payload.getByte());
		}
		crc.finish_checksum(msgid);
    }
	
	public MAVLinkMessage unpack() {
		switch (msgid) {
''')
    for xml in xml_list:
        t.write(f, '''
${{message:		case msg_${name_lower}.MAVLINK_MSG_ID_${name}:
			return  new msg_${name_lower}(payload);
}}''',xml)
    f.write('''
		default:
			Log.d("MAVLink", "UNKNOW MESSAGE - " + msgid);
			return null;
		}
	}

}
	
''')

    f.close()

def copy_fixed_headers(directory, xml):
    '''copy the fixed protocol headers to the target directory'''
    import shutil
    hlist = [ 'protocol.h', 'mavlink_helpers.h', 'mavlink_types.h', 'checksum.h', 'mavlink_protobuf_manager.hpp' ]
    basepath = os.path.dirname(os.path.realpath(__file__))
    srcpath = os.path.join(basepath, 'C/include_v%s' % xml.wire_protocol_version)
    print("Copying fixed headers")
    for h in hlist:
        if (not (h == 'mavlink_protobuf_manager.hpp' and xml.wire_protocol_version == '0.9')):
           src = os.path.realpath(os.path.join(srcpath, h))
           dest = os.path.realpath(os.path.join(directory, h))
           if src == dest:
               continue
           shutil.copy(src, dest)
    # XXX This is a hack - to be removed
    if (xml.basename == 'pixhawk' and xml.wire_protocol_version == '1.0'):
        h = 'pixhawk/pixhawk.pb.h'
        src = os.path.realpath(os.path.join(srcpath, h))
        dest = os.path.realpath(os.path.join(directory, h))
        if src != dest:
            shutil.copy(src, dest)
        
def copy_fixed_sources(directory, xml):
    # XXX This is a hack - to be removed
    import shutil
    basepath = os.path.dirname(os.path.realpath(__file__))
    srcpath = os.path.join(basepath, 'C/src_v%s' % xml.wire_protocol_version)
    if (xml.basename == 'pixhawk' and xml.wire_protocol_version == '1.0'):
        print("Copying fixed sources")
        src = os.path.realpath(os.path.join(srcpath, 'pixhawk/pixhawk.pb.cc'))
        dest = os.path.realpath(os.path.join(directory, '../../../share/mavlink/src/v%s/pixhawk/pixhawk.pb.cc' % xml.wire_protocol_version))
        destdir = os.path.realpath(os.path.join(directory, '../../../share/mavlink/src/v%s/pixhawk' % xml.wire_protocol_version))
        try:
           os.makedirs(destdir)
        except:
           print("Not re-creating directory")
        shutil.copy(src, dest)
        print("Copied to"),
        print(dest)

class mav_include(object):
    def __init__(self, base):
        self.base = base
	

def mavfmt(field):
    '''work out the struct format for a type'''
    map = {
        'float'    : 'float',
        'double'   : 'double',
        'char'     : 'byte',
        'int8_t'   : 'byte',
        'uint8_t'  : 'byte',
        'uint8_t_mavlink_version'  : 'byte',
        'int16_t'  : 'short',
        'uint16_t' : 'short',
        'int32_t'  : 'int',
        'uint32_t' : 'int',
        'int64_t'  : 'long',
        'uint64_t' : 'long',
        }

    return map[field.type]
	
def generate_one(basename, xml):
    '''generate headers for one XML file'''

    directory = os.path.join(basename, '''ardupilotmega''')

    print("Generating Java implementation in directory %s" % directory)
    mavparse.mkdir_p(directory)

    if xml.little_endian:
        xml.mavlink_endian = "MAVLINK_LITTLE_ENDIAN"
    else:
        xml.mavlink_endian = "MAVLINK_BIG_ENDIAN"

    if xml.crc_extra:
        xml.crc_extra_define = "1"
    else:
        xml.crc_extra_define = "0"

    if xml.sort_fields:
        xml.aligned_fields_define = "1"
    else:
        xml.aligned_fields_define = "0"

    # work out the included headers
    xml.include_list = []
    for i in xml.include:
        base = i[:-4]
        xml.include_list.append(mav_include(base))

    # form message lengths array
    xml.message_lengths_array = ''
    for mlen in xml.message_lengths:
        xml.message_lengths_array += '%u, ' % mlen
    xml.message_lengths_array = xml.message_lengths_array[:-2]



    # form message info array
    xml.message_info_array = ''
    for name in xml.message_names:
        if name is not None:
            xml.message_info_array += 'MAVLINK_MESSAGE_INFO_%s, ' % name
        else:
            # Several C compilers don't accept {NULL} for
            # multi-dimensional arrays and structs
            # feed the compiler a "filled" empty message
            xml.message_info_array += '{"EMPTY",0,{{"","",MAVLINK_TYPE_CHAR,0,0,0}}}, '
    xml.message_info_array = xml.message_info_array[:-2]

    # add some extra field attributes for convenience with arrays
    for m in xml.message:
        m.msg_name = m.name
        if xml.crc_extra:
            m.crc_extra_arg = ", %s" % m.crc_extra
        else:
            m.crc_extra_arg = ""
        for f in m.fields:
            if f.print_format is None:
                f.c_print_format = 'NULL'
            else:
                f.c_print_format = '"%s"' % f.print_format
            if f.array_length != 0:
                f.array_suffix = '[] = new %s[%u]' % (mavfmt(f),f.array_length)
                f.array_prefix = '*'
                f.array_tag = '_array'
                f.array_arg = ', %u' % f.array_length
                f.array_return_arg = '%s, %u, ' % (f.name, f.array_length)
                f.array_const = 'const '
                f.decode_left = ''
                f.decode_right = 'm.%s' % (f.name)
                
                f.unpackField = ''' for (int i = 0; i < %s.length; i++) {
			%s[i] = payload.get%s();
		}''' % (f.name, f.name, mavfmt(f).title() )
                f.return_type = 'uint16_t'
                f.get_arg = ', %s *%s' % (f.type, f.name)
                if f.type == 'char':
                    f.c_test_value = '"%s"' % f.test_value
                else:
                    test_strings = []
                    for v in f.test_value:
                        test_strings.append(str(v))
                    f.c_test_value = '{ %s }' % ', '.join(test_strings)
            else:
                f.array_suffix = ''
                f.array_prefix = ''
                f.array_tag = ''
                f.array_arg = ''
                f.array_return_arg = ''
                f.array_const = ''
                f.decode_left =  '%s' % (f.name)
                f.decode_right = ''
                f.unpackField = '%s = payload.get%s();' % (f.name, mavfmt(f).title())
                f.get_arg = ''
                f.return_type = f.type
                if f.type == 'char':
                    f.c_test_value = "'%s'" % f.test_value
                elif f.type == 'uint64_t':
                    f.c_test_value = "%sULL" % f.test_value                    
                elif f.type == 'int64_t':
                    f.c_test_value = "%sLL" % f.test_value                    
                else:
                    f.c_test_value = f.test_value

    # cope with uint8_t_mavlink_version
    for m in xml.message:
        m.arg_fields = []
        m.array_fields = []
        m.scalar_fields = []
        for f in m.ordered_fields:
            if f.array_length != 0:
                m.array_fields.append(f)
            else:
                m.scalar_fields.append(f)
        for f in m.fields:
            if not f.omit_arg:
                m.arg_fields.append(f)
                f.putname = f.name
            else:
                f.putname = f.const_value

    # fix types to java
    for m in xml.message:
        for f in m.ordered_fields:
                f.type = mavfmt(f)
            
    #generate_mavlink_h(directory, xml)
    #generate_version_h(directory, xml)
    
    for m in xml.message:
        generate_message_h(directory, m)


def generate(basename, xml_list):
    '''generate complete MAVLink Java implemenation'''

    for xml in xml_list:
        generate_one(basename, xml)
        
    generate_MAVLinkMessage(basename, xml_list)
    generate_CRC(basename, xml_list[0])
    #copy_fixed_headers(basename, xml_list[0])
    #copy_fixed_sources(basename, xml_list[0])
