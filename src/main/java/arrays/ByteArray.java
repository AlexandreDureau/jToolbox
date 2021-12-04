package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static arrays.Type.GREEDY;
import static arrays.Type.LAZY;

public class ByteArray {

    protected byte[] byteArray;

    // *****************************************************************************************************************
    //
    //  STATIC METHODS
    //
    // *****************************************************************************************************************

    /**
     * Append an element to buffer
     *
     * @param buffer buffer of bytes
     * @param element byte element
     * @return buffer + element
     */
    public static byte[] s_append(byte[] buffer, byte element) {
        return s_append(buffer, new byte[]{element});
    }


    /**
     * Append buffer_b to buffer_a and return the merged buffer
     *
     * @param buffer_a buffer of bytes
     * @param buffer_b buffer of bytes to append 'buffer_a'
     * @return buffer_a + buffer_b
     */
    public static byte[] s_append(byte[] buffer_a, byte[] buffer_b) {
        int full_size = buffer_a.length + buffer_b.length;
        byte[] full_buffer = Arrays.copyOf(buffer_a, full_size);

        int j = 0;
        for (int i = buffer_a.length; i < full_buffer.length; i++) {
            full_buffer[i] = buffer_b[j];
            j++;
        }

        return full_buffer;
    }


    /**
     * Insert an element at the given index of the buffer
     *
     * @param buffer buffer of bytes
     * @param element byte element
     * @return the buffer with the element inserted at the given index
     */
    public static byte[] s_insert(int index, byte[] buffer, byte element) {
        return s_insert(index, buffer, new byte[]{element});
    }


    /**
     * Insert 'buffer_b' at the given index of 'buffer_a'. If the index is negative or out of range, buffer_b is
     * appended to buffer_a
     *
     * @param index    index of 'buffer_a' Where insert 'buffer_b'
     * @param buffer_a buffer_a
     * @param buffer_b buffer_b
     * @return the processed buffer
     */
    public static byte[] s_insert(int index, byte[] buffer_a, byte[] buffer_b) {

        int full_size = buffer_a.length + buffer_b.length;
        byte[] full_buffer = new byte[full_size];

        if((index >=0) && index < buffer_a.length){

            // Copy of first part of buffer_a
            System.arraycopy(buffer_a, 0, full_buffer,0, index);

            // Copy of buffer_b
            System.arraycopy(buffer_b, 0, full_buffer, index, buffer_b.length);

            // Copy of second part of buffer_a
            System.arraycopy(buffer_a, index, full_buffer, index + buffer_b.length, buffer_a.length - index);
        }
        else if(index == 0){
            full_buffer = s_append(buffer_b, buffer_a);
        }
        else{
            full_buffer = s_append(buffer_a, buffer_b);
        }

        return full_buffer;
    }

    /**
     * Return the number of iterations of 'pattern' in buffer.
     *
     * @param buffer  the buffer
     * @param pattern the pattern
     * @return int
     */
    public static int s_count(byte[] buffer, byte[] pattern) {
        return s_beginningIndexesOf(buffer,pattern).size();
    }


    public static int s_count(byte[] buffer, byte key) {
        return s_count(buffer,new byte[]{key});
    }


    /**
     * Return the list of indexes in the buffer where the key is
     *
     * @param buffer the buffer
     * @param key    the key
     * @return list
     */
    public static List<Integer> s_indexesOf(byte[] buffer, byte key){
        return s_indexesOf(buffer, new byte[]{key});
    }


    /**
     * Return the list of indexes in the buffer where the pattern is
     *
     * @param buffer  buffer to process
     * @param pattern pattern to find in the buffer
     * @return the list of indexes in the buffer where the pattern is
     */
    public static List<Integer> s_indexesOf(byte[] buffer, byte[] pattern){

        List<Integer> indexList = new ArrayList<>();

        for(int i=0;i<(buffer.length - pattern.length + 1); i++){
            if(buffer[i] == pattern[0]){

                boolean found = true;
                for(int j=1; j<pattern.length; j++){
                    if(pattern[j] != buffer[i+j]){
                        found = false;
                        break;
                    }
                }

                if(found){
                    for (int j = i; j < (i + pattern.length); j++) {
                        if (!indexList.contains(j)) {
                            indexList.add(j);
                        }
                    }
                }
            }
        }

        return indexList;
    }

    /**
     * Return the list of the indexes where the pattern begins
     *
     * @param buffer  buffer to process
     * @param pattern pattern to find in the buffer
     * @return the list of the indexes where the pattern begins
     */
    public static List<Integer> s_beginningIndexesOf(byte[] buffer, byte[] pattern){

        List<Integer> indexList = new ArrayList<>();

        for(int i=0;i<(buffer.length - pattern.length + 1); i++){
            if(buffer[i] == pattern[0]){

                boolean found = true;
                for(int j=1; j<pattern.length; j++){
                    if(pattern[j] != buffer[i+j]){
                        found = false;
                        break;
                    }
                }

                if(found){
                    indexList.add(i);
                }
            }
        }

        return indexList;
    }


    /**
     * Return the list of the indexes where the pattern ends
     *
     * @param buffer  buffer to process
     * @param pattern pattern to find in the buffer
     * @return the list of the indexes where the pattern ends
     */
    public static List<Integer> s_endIndexesOf(byte[] buffer, byte[] pattern){

        List<Integer> indexList = new ArrayList<>();

        for(int i=0;i<(buffer.length - pattern.length + 1); i++){
            if(buffer[i] == pattern[0]){

                boolean found = true;
                for(int j=1; j<pattern.length; j++){
                    if(pattern[j] != buffer[i+j]){
                        found = false;
                        break;
                    }
                }

                if(found){
                    indexList.add(i + pattern.length - 1);
                }
            }
        }

        return indexList;
    }


    /**
     * Give the index of the first occurrence of 'key' in buffer. Return -1 if not found
     *
     * @param buffer buffer to parse
     * @param key    key to search
     * @return index of the first iteration of 'key' in buffer; -1 if 'key' is not found
     */
    public static int s_firstIndexOf(byte[] buffer, byte key) {
        int index = -1;

        if (buffer.length > 0) {
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] == key) {
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
     * @param key    key to search
     * @return index of the last iteration of 'key' in buffer; -1 if 'key' is not found
     */
    public static int s_lastIndexOf(byte[] buffer, byte key) {
        int index = -1;

        if (buffer.length > 0) {
            for (int i = buffer.length - 1; i >= 0; i--) {
                if (buffer[i] == key) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }


    /**
     * Remove the first 'nb_patterns' found from the ByteArray.
     *
     * @param buffer      the buffer
     * @param pattern     Pattern to remove from the ByteArray
     * @param nb_patterns Maximum number of pattern to remove
     * @return The number of patterns really removed
     */
    public static byte[] s_remove(byte[] buffer, byte[] pattern, int nb_patterns) {
        return ByteArray.s_removeFirst(buffer, pattern, nb_patterns);
    }

    /**
     * S remove byte [ ].
     *
     * @param buffer  the buffer
     * @param pattern the pattern
     * @return byte [ ]
     */
    public static byte[] s_remove(byte[] buffer, byte[] pattern){

        if (pattern.length <= buffer.length) {

            List<Integer> pattern_indexes = s_indexesOf(buffer, pattern);

            if (!pattern_indexes.isEmpty()) {

                byte[] result_buffer = Arrays.copyOf(buffer, buffer.length);
                int k = 0;
                for (int i = 0; i < (result_buffer.length); i++) {

                    if (!pattern_indexes.contains(i)) {
                        result_buffer[k] = result_buffer[i];
                        k++;
                    }
                }

                return Arrays.copyOf(result_buffer, k);
            }
        }

        return buffer;
    }


    /**
     * S remove last byte [ ].
     *
     * @param buffer      the buffer
     * @param pattern     the pattern
     * @param nb_patterns the nb patterns
     * @return byte [ ]
     */
    public static byte[] s_removeLast(byte[] buffer, byte[] pattern, int nb_patterns){

        if (pattern.length <= buffer.length) {
            int nb_patterns_removed = 0;
            byte[] result_buffer = Arrays.copyOf(buffer, buffer.length);
            List<Integer> pattern_indexes = s_endIndexesOf(buffer, pattern);

            while(nb_patterns_removed < nb_patterns){

                if(! pattern_indexes.isEmpty()){

                    for(int i = pattern_indexes.size() -1; i>=0; i--){
                        int end = pattern_indexes.get(i);
                        int start = end - pattern.length + 1;
                        nb_patterns_removed++;
                        while((i>0) && (nb_patterns_removed < nb_patterns)){
                            int next_end = pattern_indexes.get(i-1);

                            if(next_end >= start){
                                start = next_end - pattern.length + 1;
                                nb_patterns_removed++;
                            }
                            else{
                                break;
                            }
                        }
                        result_buffer = s_remove(result_buffer, start, end);

                        if(nb_patterns_removed >= nb_patterns){
                            break;
                        }
                    }
                }
                else{
                    break;
                }
            }

            return result_buffer;
        }
        else {
            return buffer;
        }
    }


    /**
     * Remove the first number of pattern found in the buffer.
     *
     * @param buffer      the buffer
     * @param pattern     the pattern
     * @param nb_patterns the nb patterns
     * @return the buffer from Which the firs nb patterns have been removed
     */
    public static byte[] s_removeFirst(byte[] buffer, byte[] pattern, int nb_patterns){

        if (pattern.length <= buffer.length) {
            int nb_patterns_removed = 0;
            byte[] result_buffer = Arrays.copyOf(buffer, buffer.length);

            while(nb_patterns_removed < nb_patterns){
                List<Integer> pattern_indexes = s_beginningIndexesOf(result_buffer, pattern);

                if (pattern_indexes.isEmpty()) {
                    break;
                }

                int k = 0;

                for (int i = 0; i < (result_buffer.length); i++) {

                    int pattern_end = pattern_indexes.get(nb_patterns_removed) + pattern.length - 1;
                    if (!isPattern(i, pattern_indexes, pattern.length) || (nb_patterns_removed >= nb_patterns)) {
                        result_buffer[k] = result_buffer[i];
                        k++;
                    }
                    else if (i >= pattern_end){
                        nb_patterns_removed++;
                    }
                }

                result_buffer = Arrays.copyOf(result_buffer, k);
            }

            return result_buffer;
        }
        else {
            return buffer;
        }
    }


    /**
     * Remove from a buffer the bytes between 'start' and 'end'
     *
     * @param buffer the buffer
     * @param start  the start
     * @param end    the end
     * @return the computed buffer
     */
    public static byte[] s_remove(byte[] buffer, int start, int end){

        start = (start < 0 ) ? 0 : start;
        end   = (end < 0 || end >= buffer.length) ? buffer.length-1 : end;

        if(start > end){
            int dummy = start;
            start = end;
            end = dummy;
        }

        byte[] result_buffer = new byte[buffer.length - (end - start + 1)];

        if((start > 0) && (end < buffer.length-1)){
            System.arraycopy(buffer,0,result_buffer,0,start);
            System.arraycopy(buffer,end + 1,result_buffer,start,buffer.length - end - 1);
        }
        else if(end < buffer.length-1){
            System.arraycopy(buffer,end + 1,result_buffer,0,end);
        }
        else{
            System.arraycopy(buffer,0, result_buffer, 0, result_buffer.length);
        }

        return result_buffer;
    }


    /**
     * Split a buffer of bytes in a list of ByteArray instances, given a separator
     *
     * @param buffer    buffer to split
     * @param separator separator byte
     * @return parts extracted from buffer. If no separator has been found, the list contains only one element which is the buffer itself
     */
    public static List<ByteArray> s_split(byte[] buffer, byte separator) {
        return s_split(buffer,separator,Integer.MAX_VALUE);
    }


    /**
     * Split a buffer of bytes in a list of ByteArray instances, given a separator.
     *
     * @param buffer  buffer to split
     * @param separator separator pattern
     * @return parts extracted from buffer. If no separator has been found, the list contains only one element which is the buffer itself
     */
    public static List<ByteArray> s_split(byte[] buffer, byte[] separator) {
        return s_split(buffer,separator,Integer.MAX_VALUE);
    }


    /**
     * Split a buffer of bytes in a list of ByteArray instances, given a separator. a maximum of parts can be defined
     *
     * @param buffer  buffer to split
     * @param separator separator byte
     * @param max_parts maximum number of slices
     * @return parts extracted from buffer. If no separator has been found, the list contains only one element which is the buffer itself
     */
    public static List<ByteArray> s_split(byte[] buffer, byte separator, int max_parts) {
        return s_split(buffer, new byte[]{separator} ,max_parts);
    }


    /**
     * Split a buffer of bytes in a list of ByteArray instances, given a separator. a maximum of parts can be defined
     *
     * @param buffer  buffer to split
     * @param separator separator pattern
     * @param max_parts maximum number of parts
     * @return parts extracted from buffer. If no separator has been found, the list contains only one element which is the buffer itself
     */
    public static List<ByteArray> s_split(byte[] buffer, byte[] separator, int max_parts) {
        List<ByteArray> byte_table = new ArrayList<>();

        List<Integer> separators_indexes = s_beginningIndexesOf(buffer,separator);
        List<Integer> parts_indexes;

        if(separators_indexes.size() >= max_parts ){
            parts_indexes = separators_indexes.subList(0, max_parts-1);
        }
        else{
            parts_indexes = separators_indexes;
        }

        int part_beginning = 0;
        int nb_parts = 0;
        for(Integer part_end : parts_indexes){
            byte[] byte_array = Arrays.copyOfRange(buffer, part_beginning, part_end);
            byte_table.add(new ByteArray(byte_array));
            nb_parts++;
            part_beginning = part_end + separator.length;
            if(nb_parts >= max_parts){
                break;
            }
        }

        if(parts_indexes.get(parts_indexes.size() -1) < buffer.length-1){
            if(nb_parts >= max_parts){
                byte_table.get(byte_table.size()-1).append(Arrays.copyOfRange(buffer, part_beginning, buffer.length));
            }

            else {
                byte[] byte_array = Arrays.copyOfRange(buffer, part_beginning, buffer.length);
                byte_table.add(new ByteArray(byte_array));
            }
        }

        return byte_table;
    }

    /**
     * From a given buffer of bytes, extract parts starting and ending with given keys. The number of parts can be
     * limited
     *
     * @param buffer       buffer
     * @param start_key    key byte indicating the beginning of a part
     * @param end_key      key byte indicating the end of a part
     * @param include_keys if 'true', the keys are included to the extracted parts, if 'false', they are not.
     * @param max_parts    maximum number of parts to extract (-1 to extract all parts)
     * @return parts extracted from buffer. If start and end keys have not been found, the list contains only one element which is the buffer itself
     */
    public static List<ByteArray> s_split(byte[] buffer, byte start_key, byte end_key, boolean include_keys, int max_parts) {
        return s_split(buffer,new byte[]{start_key},new byte[]{end_key}, include_keys, max_parts);
    }


    /**
     * From a given buffer of bytes, extract parts starting and ending with given keys. The number of parts can be
     * limited
     *
     * @param buffer          buffer
     * @param start_pattern   pattern indicating the beginning of a part
     * @param end_pattern     pattern indicating the end of a part
     * @param include_keys    if 'true', the keys are included to the extracted parts, if 'false', they are not.
     * @param max_parts       maximum number of parts to extract (-1 to extract all parts)
     * @return parts extracted from buffer. If start and end patterns have not been found, the list contains only one element which is the buffer itself
     */
    public static List<ByteArray> s_split(byte[] buffer, byte[] start_pattern, byte[] end_pattern, boolean include_keys, int max_parts) {
        List<ByteArray> byte_table = new ArrayList<ByteArray>();

        // TODO
        return byte_table;
    }

    public static byte[] s_copy(byte[] buffer, int start, int end){

        // *** Sanitize 'start' and 'end' ***
        start = Math.max(start, 0);
        end   = (end < 0 || end >= buffer.length) ? buffer.length-1 : end;

        if(start > end){
            int dummy = start;
            start = end;
            end = dummy;
        }

        byte[] result_buffer = new byte[end-start + 1];
        System.arraycopy(buffer,start,result_buffer,0,(end - start) +1);
        return result_buffer;
    }


    public static byte[] s_copy(byte[] buffer,  byte begin_key, byte end_key){
        return  s_copy(buffer, begin_key,end_key,GREEDY);
    }


    public static byte[] s_copy(byte[] buffer,  byte begin_key, byte end_key, Type type){

        List<Integer> begin_indexes = s_indexesOf(buffer,begin_key);
        List<Integer> end_indexes = s_indexesOf(buffer,end_key);
        byte[] result_buffer = null;

        if(LAZY == type){
            if((!begin_indexes.isEmpty()) && (!end_indexes.isEmpty())){
                int begin_index = begin_indexes.get(0);
                int end_index   = end_indexes.get(0);

                if(begin_index <= end_index){
                    result_buffer = s_copy(buffer,begin_index, end_index);
                }
                else{
                    boolean found = false;
                    for(int i=0; i< end_indexes.size()-1; i++){
                        end_index = end_indexes.get(i);
                        if(begin_index <= end_index){
                            found = true;
                            break;
                        }
                    }

                    if(found){
                        result_buffer = s_copy(buffer,begin_index, end_index);
                    }
                }
            }
        }

        // GREEDY
        else {
            if((!begin_indexes.isEmpty()) && (!end_indexes.isEmpty())){
                int begin_index = begin_indexes.get(0);
                int end_index = end_indexes.get(end_indexes.size()-1);

                if(begin_index <= end_index){
                    result_buffer = s_copy(buffer,begin_index, end_index);
                }
            }
        }

        return result_buffer;
    }


    public static byte[] s_copy(byte[] buffer,  byte[] begin_pattern, byte[] end_pattern){
        return  s_copy(buffer, begin_pattern, end_pattern,GREEDY);
    }

    public static byte[] s_copy(byte[] buffer,  byte[] begin_pattern, byte[] end_pattern, Type type){
        List<Integer> begin_indexes = s_beginningIndexesOf(buffer,begin_pattern);
        List<Integer> end_indexes = s_beginningIndexesOf(buffer,end_pattern);
        byte[] result_buffer = null;

        if(LAZY == type){
            if((!begin_indexes.isEmpty()) && (!end_indexes.isEmpty())){
                int begin_index = begin_indexes.get(0);
                int end_index   = end_indexes.get(0) + end_pattern.length - 1;

                if(begin_index <= end_index){
                    result_buffer = s_copy(buffer,begin_index, end_index);
                }
                else{
                    boolean found = false;
                    for(int i=0; i< end_indexes.size()-1; i++){
                        end_index = end_indexes.get(i);
                        if(begin_index <= end_index){
                            found = true;
                            break;
                        }
                    }

                    if(found){
                        result_buffer = s_copy(buffer,begin_index, end_index);
                    }
                }
            }
        }

        // GREEDY
        else {
            if((!begin_indexes.isEmpty()) && (!end_indexes.isEmpty())){
                int begin_index = begin_indexes.get(0);
                int end_index = end_indexes.get(end_indexes.size()-1) + end_pattern.length - 1;

                if(begin_index <= end_index){
                    result_buffer = s_copy(buffer,begin_index, end_index);
                }
            }
        }

        return result_buffer;
    }


    private static boolean isPattern(int index, List<Integer> pattern_indexes, int pattern_length){

        boolean is_pattern = false;
        for (int pattern_begin : pattern_indexes) {
            int pattern_end = pattern_begin + pattern_length;
            if (index >= pattern_begin && index < pattern_end) {
                is_pattern = true;
                break;
            }
        }

        return is_pattern;
    }


    // *****************************************************************************************************************
    //
    //  METHODS
    //
    // *****************************************************************************************************************

    /**
     * Instantiates a new Byte array.
     */
    public ByteArray() {
    }


    /**
     * Instantiates a new Byte array.
     *
     * @param buffer the buffer
     */
    public ByteArray(byte[] buffer) {

        this.set(buffer);
    }

    /**
     * Set a ByteArray with the given buffer
     *
     * @param buffer buffer used to set the ByteArray
     */
    public void set(byte[] buffer) {

        byteArray = Arrays.copyOf(buffer, buffer.length);
    }


    /**
     * Return the array of bytes
     *
     * @return the array of bytes
     */
    public byte[] getBytes() {

        return byteArray;
    }


    /**
     * Append the given element to the instance
     *
     * @param element element to be appended
     */
    public void append(byte element) {
        byteArray = s_append(byteArray, element);
    }


    /**
     * Append the given buffer to the instance
     *
     * @param buffer buffer to be appended
     */
    public void append(byte[] buffer) {
        byteArray = s_append(byteArray, buffer);
    }



    /**
     * Insert the given element at the given index. If the index is negative or out of range, the element is appended to
     * the instance
     *
     * @param index  index of the instance Where to insert element
     * @param element element to insert
     */
    public void insert(int index, byte element) {
        byteArray = s_insert(index, byteArray, element);
    }

    /**
     * Insert the given buffer at the given index. If the index is negative or out of range, the buffer is appended to
     * the instance
     *
     * @param index  the index
     * @param buffer the buffer
     */
    public void insert(int index, byte[] buffer) {
        byteArray = s_insert(index, byteArray, buffer);
    }


    /**
     * Remove all 'pattern' from the ByteArray
     *
     * @param pattern pattern to remove from the ByteArray
     * @return The number of patterns really removed
     */
    public int remove(byte[] pattern) {

        int nb_patterns_removed = this.count(pattern);
        byteArray = s_remove(byteArray, pattern);
        return nb_patterns_removed;
    }


    /**
     * Remove the first 'nb_patterns' found from the ByteArray.
     *
     * @param pattern     Pattern to remove from the ByteArray
     * @param nb_patterns Maximum number of pattern to remove
     * @return The number of patterns really removed
     */
    public int removeFirst(byte[] pattern, int nb_patterns) {

        int patterns_count = this.count(pattern);
        int nb_patterns_removed = Math.min(nb_patterns, patterns_count);

        byteArray = s_removeFirst(byteArray, pattern, nb_patterns);

        return nb_patterns_removed;
    }

    /**
     * Remove the last 'nb_patterns' found from the ByteArray.
     *
     * @param pattern     Pattern to remove from the ByteArray
     * @param nb_patterns Maximum number of pattern to remove
     * @return The number of patterns really removed
     */
    public int removeLast(byte[] pattern, int nb_patterns) {

        int patterns_count = this.count(pattern);
        int nb_patterns_removed = Math.min(nb_patterns, patterns_count);

        byteArray = s_removeLast(byteArray, pattern, nb_patterns);

        return nb_patterns_removed;
    }


    /**
     * Count the number of occurrences of key in the instance
     *
     * @param key key
     * @return the number of occurrences of key in the instance
     */
    public int count(byte key) {
        return s_count(byteArray, key);
    }


    /**
     * Count the number of occurrences of pattern in the instance
     *
     * @param pattern pattern
     * @return the number of occurrences of pattern in the instance
     */
    public int count(byte[] pattern) {
        return s_count(byteArray, pattern);
    }


    /**
     * Indicates if the instance starts with the given byte
     *
     * @param key key byte
     * @return 'true' if the instance starts with 'key', else return false
     */
    public boolean startsWith(byte key) {
        if (byteArray.length > 0) {
            return byteArray[0] == key;
        }
        else {
            return false;
        }
    }


    /**
     * Indicates if the instance starts with the given pattern
     *
     * @param pattern key byte
     * @return 'true' if the instance starts with 'pattern', else return false
     */
    public boolean startsWith(byte[] pattern) {

        List<Integer> indexes = this.beginningIndexesOf(pattern);

        if(!indexes.isEmpty() && indexes.get(0) == 0){
            return  true;
        }
        else{
            return false;
        }
    }


    /**
     * Indicates if the instance ends with the given byte
     *
     * @param key key byte
     * @return 'true' if the instance ends with 'key', else return false
     */
    public boolean endsWith(byte key) {
        if (byteArray.length > 0) {
            return (byteArray[byteArray.length - 1] == key) ? true : false;
        }
        else {
            return false;
        }
    }


    /**
     * Indicates if the instance ends with the given pattern
     *
     * @param pattern key byte
     * @return 'true' if the instance ends with 'pattern', else return false
     */
    public boolean endsWith(byte[] pattern) {

        List<Integer> indexes = this.endIndexesOf(pattern);

        if(!indexes.isEmpty() && indexes.get(indexes.size()-1) == byteArray.length-1){
            return  true;
        }
        else{
            return false;
        }
    }


    /**
     * Split list.
     *
     * @param separator the separator
     * @return the list
     */
    public List<ByteArray> split(byte separator) {
        return s_split(byteArray, separator);
    }


    /**
     * Split the instance in parts starting and ending with respective keys. The number of parts can be
     * limited
     *
     * @param begin_key    key byte indicating the beginning of a part
     * @param end_key      key byte indicating the end of a part
     * @param include_keys if 'true', the keys are included to the extracted parts, if 'false', they are not.
     * @param max_parts    maximum number of parts to extract (-1 to extract all parts)
     * @return list
     */
    public List<ByteArray> split(byte begin_key, byte end_key, boolean include_keys, int max_parts) {
        return s_split(byteArray, begin_key, end_key, include_keys, max_parts);
    }


    /**
     * Give the index of the first iteration of 'key' in buffer. Return -1 if not found
     *
     * @param key key byte
     * @return the index of the first iteration of 'key' in buffer. Return -1 if not found
     */
    public int firstIndexOf(byte key) {
        return s_firstIndexOf(byteArray, key);
    }


    /**
     * Give the index of the last iteration of 'key' in buffer. Return -1 if not found
     *
     * @param key key byte
     * @return the index of the last iteration of 'key' in buffer. Return -1 if not found
     */
    public int lastIndexOf(byte key) {
        return s_lastIndexOf(byteArray, key);
    }


    /**
     * Return the list of indexes in the ByteArray where the pattern begins
     *
     * @param pattern pattern to find in the buffer
     * @return the list of indexes in the buffer where the pattern is
     */
    public List<Integer> beginningIndexesOf(byte[] pattern){
        return s_beginningIndexesOf(byteArray, pattern);
    }


    /**
     * Return the list of indexes in the ByteArray where the pattern ends
     *
     * @param pattern pattern to find in the buffer
     * @return the list of indexes in the buffer where the pattern is
     */
    public List<Integer> endIndexesOf(byte[] pattern){
        return s_endIndexesOf(byteArray, pattern);
    }


    /**
     * Return the list of indexes in the ByteArray where the pattern is
     *
     * @param pattern pattern to find in the buffer
     * @return the list of indexes in the buffer where the pattern is
     */
    public List<Integer> indexesOf(byte[] pattern) {
        return s_indexesOf(byteArray, pattern);
    }


    /**
     * Return the list of indexes in the ByteArray where the key is
     *
     * @param key    the key
     * @return list
     */
    public List<Integer> indexesOf(byte key) {
        return s_indexesOf(byteArray, key);
    }
}
