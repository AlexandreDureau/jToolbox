package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteArray 
{
	protected byte[] byteArray;


	/**
	 * Append buffer_b to buffer_a and return the merged buffer
	 * 
	 * @param buffer_a buffer of bytes
	 * @param buffer_b buffer of bytes to append 'buffer_a'
	 * @return buffer_a + buffer_b
	 */
	public static byte[] append(byte[] buffer_a,  byte[] buffer_b) {
		int full_size = buffer_a.length + buffer_b.length;
		byte[] full_buffer = Arrays.copyOf(buffer_a, full_size);
		
		int j=0;
		for(int i=buffer_a.length; i< full_buffer.length; i++) {
			full_buffer[i] = buffer_b[j];
			j++;
		}
		
		return full_buffer;
	}


	/**
	 * Split a buffer of bytes in a list of ByteArray, given a separator
	 *
	 * @param buffer buffer to split
	 * @param separator separator byte
	 * @return parts extracted from buffer. If no separator has been found, the list contains only one element which is
	 * the buffer itself
	 */
	public static List<ByteArray> split(byte[] buffer, byte separator) {
		List<ByteArray> byte_table = new ArrayList<>();
		
		int first_index = 0;
		int last_index = -1;
		
		for(int i=0; i<buffer.length;i++) {
			if(buffer[i] == separator)
			{
				last_index = i;
				byte[] byte_array = Arrays.copyOfRange(buffer, first_index, last_index);
				byte_table.add(new ByteArray(byte_array));
				first_index = i+1;
			}
		}
		
		if(last_index != (buffer.length - 1)) {
			byte[] byte_array = Arrays.copyOfRange(buffer, first_index, buffer.length-1);
			byte_table.add(new ByteArray(byte_array));
		}
		
		return byte_table;
	}


	/**
	 * 	From a given buffer of bytes, extract parts starting and ending with given keys. The number of parts can be
	 * 	limited
	 *
	 * @param buffer buffer
	 * @param begin_key key byte indicating the beginning of a part
	 * @param end_key key byte indicating the end of a part
	 * @param include_keys if 'true', the keys are included to the extracted parts, if 'false', they are not.
	 * @param max_parts maximum number of parts to extract (-1 to extract all parts)
	 * @return
	 */
	public static List<ByteArray> split(byte[] buffer, byte begin_key, byte end_key, boolean include_keys, int max_parts)
	{
		List<ByteArray> byte_table = new ArrayList<ByteArray>();
		
		// TODO
		return byte_table;
	}


	/**
	 * Give the index of the first iteration of 'key' in buffer. Return -1 if not found
	 * 
	 * @param buffer buffer to parse
	 * @param key  key to search
	 * @return index of the first iteration of 'key' in buffer; -1 if 'key' is not found
	 */
	public static int firstIndexOf(byte[] buffer, byte key)
	{
		int index = -1;
		
		if(buffer.length > 0) {
			for(int i=0; i< buffer.length; i++) {
				if(buffer[i] == key) {
					index = i;
					break;
				}
			}	
		}
			
		return index;
	}


	/**
	 * Give the index of the last iteration of 'key' in buffer. Return -1 if not found
	 *
	 * @param buffer buffer to parse
	 * @param key  key to search
	 * @return index of the last iteration of 'key' in buffer; -1 if 'key' is not found
	 */
	public static int lastIndexOf(byte[] buffer, byte key)
	{
		int index = -1;

		if(buffer.length > 0) {
			for(int i=buffer.length -1; i>=0 ; i--) {
				if(buffer[i] == key) {
					index = i;
					break;
				}
			}
		}

		return index;
	}
	

	public ByteArray() {
	}


	public ByteArray(byte[] buffer) {

		this.set(buffer);
	}


	public void set(byte[] buffer) {

		byteArray = Arrays.copyOf(buffer, buffer.length);
	}


	public byte[] getBytes() {

		return byteArray;
	}


	/**
	 *
	 * @param key key byte
	 * @return 'true' if the instance starts with 'key', else return false
	 */
	public boolean startsWith(byte key) {
		if(byteArray.length > 0) {
			return (byteArray[0] == key) ? true : false;
		}
		
		else {
			return false;
		}
	}


	/**
	 *
	 * @param key key byte
	 * @return 'true' if the instance ends with 'key', else return false
	 */
	public boolean endsWith(byte key) {
		if(byteArray.length > 0) {
			return (byteArray[byteArray.length -1] == key) ? true : false;
		}
		
		else {
			return false;
		}
	}


	/**
	 * Give the index of the first iteration of 'key' in buffer. Return -1 if not found
	 * @param key key byte
	 * @return the index of the first iteration of 'key' in buffer. Return -1 if not found
	 */
	public int firstIndexOf(byte key) {
		int index = -1;
		
		if(byteArray.length > 0) {
			for(int i = 0; i< byteArray.length; i++) {
				if(byteArray[i] == key) {
					index = i;
					break;
				}
			}	
		}
			
		return index;
	}


	/**
	 * Give the index of the last iteration of 'key' in buffer. Return -1 if not found
	 * @param key key byte
	 * @return the index of the last iteration of 'key' in buffer. Return -1 if not found
	 */
	public int lastIndexOf(byte key) {
		int index = -1;

		if(byteArray.length > 0) {
			for(int i = byteArray.length -1; i>=0 ; i--) {
				if(byteArray[i] == key) {
					index = i;
					break;
				}
			}
		}

		return index;
	}
}
