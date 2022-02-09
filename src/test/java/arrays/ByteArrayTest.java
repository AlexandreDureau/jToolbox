package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ByteArrayTest {

    // *****************************************************************************************************************
    //
    //  STATIC METHODS TESTS
    //
    // *****************************************************************************************************************

    @Test
    public void static_method_indexesOf_shall_return_the_list_of_indexes_where_pattern_is_present_in_the_buffer(){
        // Given:
        byte[] buffer = {'c','a','b','a','b','a','b','a','c','d','a','b','a',0};
        byte[] pattern = {'a','b','a'};

        // When:
        List<Integer> indexList = ByteArray.s_indexesOf(buffer,pattern);

        // Then:
        Assertions.assertEquals(10,indexList.size());
        Assertions.assertEquals(1,indexList.get(0));
        Assertions.assertEquals(2,indexList.get(1));
        Assertions.assertEquals(3,indexList.get(2));
        Assertions.assertEquals(4,indexList.get(3));
        Assertions.assertEquals(5,indexList.get(4));
        Assertions.assertEquals(6,indexList.get(5));
        Assertions.assertEquals(7,indexList.get(6));
        Assertions.assertEquals(10,indexList.get(7));
        Assertions.assertEquals(11,indexList.get(8));
        Assertions.assertEquals(12,indexList.get(9));
    }


    @Test
    public void static_method_indexesOf_shall_return_the_list_of_indexes_where_key_is_present_in_the_buffer(){
        // Given:
        byte[] buffer = {'c','a','b','a','b','a','b','a','c','d','a','b','a'};
        byte  key = 'a';

        // When:
        List<Integer> indexList = ByteArray.s_indexesOf(buffer,key);

        // Then:
        Assertions.assertEquals(6,indexList.size());
        Assertions.assertEquals(1,indexList.get(0));
        Assertions.assertEquals(3,indexList.get(1));
        Assertions.assertEquals(5,indexList.get(2));
        Assertions.assertEquals(7,indexList.get(3));
        Assertions.assertEquals(10,indexList.get(4));
        Assertions.assertEquals(12,indexList.get(5));
    }


    @Test
    public void static_method_beginningIndexesOf_shall_return_the_list_of_indexes_where_pattern_begins_in_the_buffer(){
        // Given:
        byte[] buffer = {'c','a','b','a','b','a','b','a','c','d','a','b','a',0};
        byte[] pattern = {'a','b','a'};

        // When:
        List<Integer> indexList = ByteArray.s_beginningIndexesOf(buffer,pattern);

        // Then:
        Assertions.assertEquals(4,indexList.size());
        Assertions.assertEquals(1,indexList.get(0));
        Assertions.assertEquals(3,indexList.get(1));
        Assertions.assertEquals(5,indexList.get(2));
        Assertions.assertEquals(10,indexList.get(3));
    }


    @Test
    public void static_method_endIndexesOf_shall_return_the_list_of_indexes_where_pattern_ends_in_the_buffer(){
        // Given:
        byte[] buffer = {'c','a','b','a','b','a','b','a','c','d','a','b','a',0};
        byte[] pattern = {'a','b','a'};

        // When:
        List<Integer> indexList = ByteArray.s_endIndexesOf(buffer,pattern);

        // Then:
        Assertions.assertEquals(4,indexList.size());
        Assertions.assertEquals(3,indexList.get(0));
        Assertions.assertEquals(5,indexList.get(1));
        Assertions.assertEquals(7,indexList.get(2));
        Assertions.assertEquals(12,indexList.get(3));
    }


    @Test
    public void static_method_firstIndexOf_shall_return_the_index_of_the_first_occurence_of_key_in_the_buffer(){
        // Given:
        byte[] buffer = {'c','a','b','a','b','a','b','a','c','d','a','b','a',0};
        byte key = 'b';

        // When:
        int index = ByteArray.s_firstIndexOf(buffer,key);

        // Then:
        Assertions.assertEquals(2,index);
    }


    @Test
    public void static_method_lastIndexOf_shall_return_the_index_of_the_last_occurence_of_key_in_the_buffer(){
        // Given:
        byte[] buffer = {'c','a','b','a','b','a','b','a','c','d','a','b','a',0};
        byte key = 'b';

        // When:
        int index = ByteArray.s_lastIndexOf(buffer,key);

        // Then:
        Assertions.assertEquals(11,index);
    }


    @Test
    public void static_method_remove_shall_remove_from_the_given_buffer_the_bytes_between_start_and_last_index_if_end_is_out_of_range(){
        // Given:
        byte[] buffer_in = {'c','a','b','a','b','a','b','a','c','d','e','k','l'};
        byte[] expected_buffer = {'c','a','b','a'};

        // When:
        byte[] buffer_out = ByteArray.s_remove(buffer_in,4, 41);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer_out);
    }


    @Test
    public void static_method_count_shall_count_the_number_of_occurences_of_key_in_a_buffer(){
        // Given:
        byte[] buffer = {'c','a','b','a','b','a','b','a','c','d','e','k','l'};
        byte key = 'a';

        // When
        // Then:
        Assertions.assertEquals(4, ByteArray.s_count(buffer,key));
    }


    @Test
    public void static_method_count_shall_count_the_number_of_occurences_of_pattern_in_a_buffer(){
        // Given:
        byte[] buffer = {'c','a','b','a','b','a','b','a','c','d','e', 'a', 'b', 'a', 'k','l'};
        byte[] pattern   = {'a','b','a'};

        // When:
        // Then:
        Assertions.assertEquals(4, ByteArray.s_count(buffer, pattern));
    }


    @Test
    public void static_method_removeFirst_shall_remove_explicitly_the_first_given_number_of_patterns_from_a_buffer(){

        // Given:
        byte[] buffer_a = {'c','a','b','a','b','a','b','a','c','d','e','k','l'};
        byte[] pattern = {'a','b','a'};
        byte[] expected_buffer = {'c','b','a','c', 'd', 'e', 'k','l'};

        // When:
        byte[] buffer = ByteArray.s_removeFirst(buffer_a,pattern, 2);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }


    @Test
    public void static_method_removeLast_shall_remove_the_last_given_number_of_patterns_from_a_buffer(){

        // Given:
        byte[] buffer_a = {'c','a','b','a','b','a','b','a','c','a','b','a','l'};
        byte[] pattern = {'a','b','a'};
        byte[] expected_buffer = {'c','a','b','c', 'l'};

        // When:
        byte[] buffer = ByteArray.s_removeLast(buffer_a,pattern, 3);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }

    @Test
    public void static_method_removeAt_shall_remove_from_the_buffer_the_element_at_the_given_index(){

        // Given:
        byte[] buffer_a = {'c','a','b','a','b','a','b','a','c','a','b','a','l'};

        // When:
        byte[] buffer1 = ByteArray.s_removeAt(buffer_a, 6);
        byte[] buffer2 = ByteArray.s_removeAt(buffer_a, 0);
        byte[] buffer3 = ByteArray.s_removeAt(buffer_a, buffer_a.length-1);

        // Then:
        byte[] expected_buffer1 = {'c','a','b','a','b','a','a','c','a','b','a','l'};
        byte[] expected_buffer2 = {'a','b','a','b','a','b','a','c','a','b','a','l'};
        byte[] expected_buffer3 = {'c','a','b','a','b','a','b','a','c','a','b','a'};

        Assertions.assertArrayEquals(expected_buffer1, buffer1);
        Assertions.assertArrayEquals(expected_buffer2, buffer2);
        Assertions.assertArrayEquals(expected_buffer3, buffer3);
    }

    @Test
    public void static_method_remove_shall_remove_a_pattern_from_a_buffer(){

        // Given:
        byte[] buffer_a = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        byte[] buffer_b = {'d','e','f'};
        byte[] expected_buffer = {'a','b','c','g','h','i','j','k','l'};

        // When:
        byte[] buffer = ByteArray.s_remove(buffer_a,buffer_b);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }

    @Test
    public void static_method_remove_shall_remove_all_patterns_from_a_buffer(){

        // Given:
        byte[] buffer_a = {'a','b','c','d','e','f','g','c','d','e','k','l'};
        byte[] pattern = {'c','d','e'};
        byte[] expected_buffer = {'a','b','f','g', 'k','l'};

        // When:
        byte[] buffer = ByteArray.s_remove(buffer_a,pattern);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }


    @Test
    public void static_method_remove_shall_remove_all_nested_patterns_from_a_buffer(){

        // Given:
        byte[] buffer_a = {'c','a','b','a','b','a','b','a','c','d','e','k','l'};
        byte[] pattern = {'a','b','a'};
        byte[] expected_buffer = {'c','c', 'd', 'e', 'k','l'};

        // When:
        byte[] buffer = ByteArray.s_remove(buffer_a,pattern);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }


    @Test
    public void static_method_remove_shall_remove_implicitly_the_first_given_number_of_patterns_from_a_buffer(){

        // Given:
        byte[] buffer_a = {'c','a','b','a','b','a','b','a','c','d','e','k','l'};
        byte[] pattern = {'a','b','a'};
        byte[] expected_buffer = {'c','b','a','c', 'd', 'e', 'k','l'};

        // When:
        byte[] buffer = ByteArray.s_remove(buffer_a,pattern, 2);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }


    @Test
    public void method_remove_shall_remove_from_the_given_buffer_the_bytes_between_start_and_end_indexes(){
        // Given:
        byte[] buffer_in = {'c','a','b','a','b','a','b','a','c','d','e','k','l'};
        byte[] expected_buffer = {'c','a','b', 'e', 'k','l'};

        // When:
        byte[] buffer_out = ByteArray.s_remove(buffer_in,3, 9);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer_out);
    }


    @Test
    public void method_remove_shall_remove_from_the_given_buffer_the_bytes_between_start_and_end_with_start_greater_than_end(){
        // Given:
        byte[] buffer_in = {'c','a','b','a','b','a','b','a','c','d','e','k','l'};
        byte[] expected_buffer = {'c','a','b', 'e', 'k','l'};

        // When:
        byte[] buffer_out = ByteArray.s_remove(buffer_in,9, 3);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer_out);
    }


    @Test
    public void method_remove_shall_remove_from_the_given_buffer_the_bytes_between_index0_and_end_if_start_negative(){
        // Given:
        byte[] buffer_in = {'c','a','b','a','b','a','b','a','c','d','e','k','l'};
        byte[] expected_buffer = {'a','c','d','e','k','l'};

        // When:
        byte[] buffer_out = ByteArray.s_remove(buffer_in,-1, 6);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer_out);
    }


    @Test
    public void method_remove_shall_remove_from_the_given_buffer_the_bytes_between_start_and_last_index_if_end_is_negative(){
        // Given:
        byte[] buffer_in = {'c','a','b','a','b','a','b','a','c','d','e','k','l'};
        byte[] expected_buffer = {'c','a','b','a'};

        // When:
        byte[] buffer_out = ByteArray.s_remove(buffer_in,4, -1);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer_out);
    }


    @Test
    public void static_method_append_shall_append_a_buffer_to_another_buffer() {

        // Given:
        byte[] buffer_a = {0,1,2,3,4};
        byte[] buffer_b = {5,6,7};
        byte[] expected_buffer = {0,1,2,3,4,5,6,7};

        // When:
        byte[] buffer = ByteArray.s_append(buffer_a,buffer_b);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }


    @Test
    public void static_method_insert_shall_insert_a_buffer_at_the_given_index_of_the_buffer(){

        // Given:
        byte[] buffer_a = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        byte[] buffer_b = {'1','2','3','4','5','6'};
        int index       = 6;
        byte[] expected_buffer = {'a','b','c','d','e','f','1','2','3','4','5','6','g', 'h','i','j','k','l'};

        // When:
        byte[] buffer = ByteArray.s_insert(index, buffer_a,buffer_b);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }


    @Test
    public void static_method_insert_shall_prepend_a_buffer_if_the_index_is_zero(){

        // Given:
        byte[] buffer_a = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        byte[] buffer_b = {'1','2','3','4','5','6'};
        int index       = 0;
        byte[] expected_buffer = {'1','2','3','4','5','6','a','b','c','d','e','f','g','h','i','j','k','l'};

        // When:
        byte[] buffer = ByteArray.s_insert(index, buffer_a,buffer_b);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }


    @Test
    public void static_method_insert_shall_append_a_buffer_if_the_index_is_negative(){

        // Given:
        byte[] buffer_a = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        byte[] buffer_b = {'1','2','3','4','5','6'};
        int index       = -1;
        byte[] expected_buffer = {'a','b','c','d','e','f','g','h','i','j','k','l','1','2','3','4','5','6'};

        // When:
        byte[] buffer = ByteArray.s_insert(index, buffer_a,buffer_b);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }


    @Test
    public void static_method_insert_shall_append_a_buffer_if_the_index_is_out_of_range(){

        // Given:
        byte[] buffer_a = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        byte[] buffer_b = {'1','2','3','4','5','6'};
        int index       = 25;
        byte[] expected_buffer = {'a','b','c','d','e','f','g','h','i','j','k','l','1','2','3','4','5','6'};

        // When:
        byte[] buffer = ByteArray.s_insert(index, buffer_a,buffer_b);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }

    @Test
    public void static_method_copy_shall_copy_a_buffer_from_start_to_end_indexes(){

        // Given:
        byte[] buffer = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        int start     = 3;
        int end       = 8;
        byte[] expected_buffer = {'d','e','f','g','h','i'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start, end);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, result_buffer);
    }


    @Test
    public void static_method_copy_shall_copy_a_buffer_from_0_to_end_index_if_start_index_is_negative(){

        // Given:
        byte[] buffer = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        int start     = -1;
        int end       = 8;
        byte[] expected_buffer = {'a','b','c','d','e','f','g','h','i'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start, end);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, result_buffer);
    }

    @Test
    public void static_method_copy_shall_copy_a_buffer_from_start_index_to_end_of_the_buffer_if_end_index_is_negative(){

        // Given:
        byte[] buffer = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        int start     = 7;
        int end       = -1;
        byte[] expected_buffer = {'h','i','j','k','l'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start, end);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, result_buffer);
    }


    @Test
    public void static_method_copy_shall_copy_a_buffer_from_start_index_to_end_of_the_buffer_if_end_index_is_out_of_range(){

        // Given:
        byte[] buffer = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        int start     = 7;
        int end       = 13;
        byte[] expected_buffer = {'h','i','j','k','l'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start, end);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, result_buffer);
    }


    @Test
    public void static_method_copy_shall_copy_a_buffer_from_start_key_to_end_key_if_start_key_is_before_end_key_and_in_a_greedy_way(){

        // Given:
        byte[] buffer = {'a','b','c','d','b', 'e','f', 'g', 'g','h', 'u', 'h','i','j','k','l'};
        byte start_key  = 'b';
        byte end_key    = 'h';
        byte[] expected_buffer = {'b','c','d','b', 'e','f', 'g', 'g','h', 'u', 'h'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_key, end_key);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, result_buffer);
    }


    @Test
    public void static_method_copy_shall_copy_a_buffer_from_start_key_to_end_key_if_start_key_is_before_end_key_and_in_an_explicit_greedy_way(){

        // Given:
        byte[] buffer = {'a','b','c','d','b', 'e','f', 'g', 'g','h', 'u', 'h','i','j','k','l'};
        byte start_key  = 'b';
        byte end_key    = 'h';
        byte[] expected_buffer = {'b','c','d','b', 'e','f', 'g', 'g','h', 'u', 'h'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_key, end_key, Type.GREEDY);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, result_buffer);
    }


    @Test
    public void static_method_copy_shall_copy_a_buffer_from_start_key_to_end_key_if_start_key_is_before_end_key_and_in_an_explicit_lazy_way(){

        // Given:
        byte[] buffer = {'a','b','c','d','b', 'e','f','g','g','h','u','h','i','j','k','l'};
        byte start_key  = 'b';
        byte end_key    = 'h';
        byte[] expected_buffer = {'b','c','d','b','e','f','g','g','h'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_key, end_key, Type.LAZY);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, result_buffer);
    }


    @Test
    public void static_method_copy_shall_return_null_if_start_key_does_not_exist(){

        // Given:
        byte[] buffer = {'a','b','c','d','b', 'e','f', 'g', 'g','h', 'u', 'h','i','j','k','l'};
        byte start_key  = 'm';
        byte end_key    = 'h';

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_key, end_key);

        // Then:
        Assertions.assertNull(result_buffer);
    }

    @Test
    public void static_method_copy_shall_return_null_if_end_key_does_not_exist(){

        // Given:
        byte[] buffer = {'a','b','c','d','b', 'e','f', 'g', 'g','h', 'u', 'h','i','j','k','l'};
        byte start_key  = 'f';
        byte end_key    = 'z';

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_key, end_key);

        // Then:
        Assertions.assertNull(result_buffer);
    }

    @Test
    public void static_method_copy_shall_return_null_if_start_pattern_does_not_exist(){

        // Given:
        byte[] buffer = {'a','b','c','d','b', 'e','u', 'h', 'g','h', 'u', 'h','i','j','k','l'};
        byte[] start_pattern  = {'c','b'};
        byte[] end_pattern  = {'u','h'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_pattern, end_pattern);

        // Then:
        Assertions.assertNull(result_buffer);
    }


    @Test
    public void static_method_copy_shall_copy_a_buffer_from_start_pattern_to_end_pattern_if_start_pattern_is_before_end_pattern_and_in_an_explicit_greedy_way(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','b','c','g','h','u','i','j','b','c','h','i','j','k','l'};
        byte[] start_pattern = {'e','f'};
        byte[] end_pattern = {'i','j'};
        byte[] expected_buffer = {'e','f','g','i','j','b','c','g','h','u','i','j','b','c','h','i','j'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_pattern, end_pattern, Type.GREEDY);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, result_buffer);
    }


    @Test
    public void static_method_copy_shall_copy_a_buffer_from_start_pattern_to_end_pattern_if_start_pattern_is_before_end_pattern_and_in_an_explicit_lazy_way(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','b','c','i','j','b','c','g','h','u','i','j','b','c','h','i','j','k','l'};
        byte[] start_pattern = {'b','c'};
        byte[] end_pattern = {'i','j'};
        byte[] expected_buffer = {'b','c','d','b','e','b','c','i','j'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_pattern, end_pattern, Type.LAZY);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, result_buffer);
    }


    @Test
    public void static_method_copy_shall_return_null_if_start_pattern_is_after_any_end_pattern_in_greedy_search(){

        // Given:
        byte[] buffer = {'a','b','c','d','b', 'e','f', 'g', 'i','j', 'b','c',  'g','h', 'u', 'i','j', 'b','c', 'h','i','j','k','l'};
        byte[] start_pattern = {'k','l'};
        byte[] end_pattern = {'i','j'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_pattern, end_pattern, Type.LAZY);

        // Then:
        Assertions.assertNull(result_buffer);
    }

    @Test
    public void static_method_copy_shall_return_null_if_start_pattern_is_after_any_end_pattern_in_lazy_search(){

        // Given:
        byte[] buffer = {'a','b','c','d','b', 'e','f', 'g', 'i','j', 'b','c',  'g','h', 'u', 'i','j', 'b','c', 'h','i','j','k','l'};
        byte[] start_pattern = {'k','l'};
        byte[] end_pattern = {'i','j'};

        // When:
        byte[] result_buffer = ByteArray.s_copy(buffer, start_pattern, end_pattern, Type.LAZY);

        // Then:
        Assertions.assertNull(result_buffer);
    }


    @Test
    public void static_method_split_shall_return_the_parts_of_the_given_buffer_splitted_by_the_separator_byte(){

        // Given:
        byte[] buffer = {'a','b','c','d','b', 'e','f', 'g', 'i','j', 'b','c',  'g','h', 'u', 'i','j', 'b','c', 'h','i','j','k','l'};
        byte   separator = 'i';

        // When:
        List<ByteArray> parts = ByteArray.s_split(buffer, separator);

        // Then:
        byte[] expectedPart1 = {'a','b','c','d','b', 'e','f', 'g'};
        byte[] expectedPart2 = {'j', 'b','c',  'g','h', 'u'};
        byte[] expectedPart3 = {'j', 'b','c', 'h'};
        byte[] expectedPart4 = {'j','k','l'};

        Assertions.assertEquals(4, parts.size());
        Assertions.assertArrayEquals(expectedPart1, parts.get(0).getBytes());
        Assertions.assertArrayEquals(expectedPart2, parts.get(1).getBytes());
        Assertions.assertArrayEquals(expectedPart3, parts.get(2).getBytes());
        Assertions.assertArrayEquals(expectedPart4, parts.get(3).getBytes());
    }


    @Test
    public void static_method_split_shall_return_the_parts_of_the_given_buffer_splitted_by_the_separator_pattern(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','b','c','g','h','u','i','j','b','c','h','i','j','k','l'};
        byte[] separator = {'i','j'};

        // When:
        List<ByteArray> parts = ByteArray.s_split(buffer, separator);

        // Then:
        byte[] expectedPart1 = {'a','b','c','d','b','e','f','g'};
        byte[] expectedPart2 = {'b','c','g','h','u'};
        byte[] expectedPart3 = {'b','c','h'};
        byte[] expectedPart4 = {'k','l'};

        Assertions.assertEquals(4, parts.size());
        Assertions.assertArrayEquals(expectedPart1, parts.get(0).getBytes());
        Assertions.assertArrayEquals(expectedPart2, parts.get(1).getBytes());
        Assertions.assertArrayEquals(expectedPart3, parts.get(2).getBytes());
        Assertions.assertArrayEquals(expectedPart4, parts.get(3).getBytes());
    }


    @Test
    public void static_method_extract_shall_extract_the_parts_from_the_buffer_(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','b','c','g','h','u','i','j','b','c','h','i','j','k','l'};
        byte[] start_pattern = {'b','c'};
        byte[] end_pattern   = {'i','j'};
        // When:
        List<ByteArray> parts = ByteArray.s_extract(buffer, start_pattern, end_pattern, true, -1);

        // Then:
        byte[] expectedPart1 = {'b','c','d','b','e','f','g','i','j'};
        byte[] expectedPart2 = {'b','c','g','h','u','i','j'};
        byte[] expectedPart3 = {'b','c','h','i','j'};

        Assertions.assertEquals(3, parts.size());
        Assertions.assertArrayEquals(expectedPart1, parts.get(0).getBytes());
        Assertions.assertArrayEquals(expectedPart2, parts.get(1).getBytes());
        Assertions.assertArrayEquals(expectedPart3, parts.get(2).getBytes());
    }



    @Test
    public void static_method_split_shall_split_a_buffer_given_start_and_end_patterns(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','0','1','2','b','c','g','h','u','i','j','b','c','4','i','j','k','l'};
        byte[] start_pattern = {'b','c'};
        byte[] end_pattern   = {'i','j'};
        // When:
        List<ByteArray> parts = ByteArray.s_split(buffer, start_pattern, end_pattern, -1);

        // Then:
        byte[] expectedPart1 = {'a'};
        byte[] expectedPart2 = {'b','c','d','b','e','f','g','i','j'};
        byte[] expectedPart3 = {'0','1','2'};
        byte[] expectedPart4 = {'b','c','g','h','u','i','j'};
        byte[] expectedPart5 = {'b','c','4','i','j'};
        byte[] expectedPart6 = {'k','l'};

        Assertions.assertEquals(6, parts.size());
        Assertions.assertArrayEquals(expectedPart1, parts.get(0).getBytes());
        Assertions.assertArrayEquals(expectedPart2, parts.get(1).getBytes());
        Assertions.assertArrayEquals(expectedPart3, parts.get(2).getBytes());
        Assertions.assertArrayEquals(expectedPart4, parts.get(3).getBytes());
        Assertions.assertArrayEquals(expectedPart5, parts.get(4).getBytes());
        Assertions.assertArrayEquals(expectedPart6, parts.get(5).getBytes());
    }


    @Test
    public void static_method_split_shall_split_a_buffer_in_the_given_number_of_parts_according_start_and_end_patterns(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','0','1','2','b','c','g','h','u','i','j','b','c','4','i','j','k','l'};
        byte[] start_pattern = {'b','c'};
        byte[] end_pattern   = {'i','j'};

        // When:
        List<ByteArray> parts = ByteArray.s_split(buffer, start_pattern, end_pattern, 3);

        // Then:
        Assertions.assertEquals(3, parts.size());
        Assertions.assertArrayEquals(new byte[] {'a'}, parts.get(0).getBytes());
        Assertions.assertArrayEquals(new byte[] {'b','c','d','b','e','f','g','i','j'}, parts.get(1).getBytes());
        Assertions.assertArrayEquals(new byte[] {'0','1','2','b','c','g','h','u','i','j','b','c','4','i','j','k','l'}, parts.get(2).getBytes());
    }

    @Test
    public void static_method_split_shall_return_the_entire_buffer_if_given_number_of_parts_is_set_to_one(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','0','1','2','b','c','g','h','u','i','j','b','c','4','i','j','k','l'};
        byte[] start_pattern = {'b','c'};
        byte[] end_pattern   = {'i','j'};

        // When:
        List<ByteArray> parts = ByteArray.s_split(buffer, start_pattern, end_pattern, 1);

        // Then:
        Assertions.assertEquals(1, parts.size());
        Assertions.assertArrayEquals(buffer, parts.get(0).getBytes());
    }

    @Test
    public void static_method_split_shall_return_the_entire_buffer_if_the_start_pattern_is_not_found(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','0','1','2','b','c','g','h','u','i','j','b','c','4','i','j','k','l'};
        byte[] start_pattern = {'0','c'};
        byte[] end_pattern   = {'i','j'};

        // When:
        List<ByteArray> parts = ByteArray.s_split(buffer, start_pattern, end_pattern, -1);

        // Then:
        Assertions.assertEquals(1, parts.size());
        Assertions.assertArrayEquals(buffer, parts.get(0).getBytes());
    }

    @Test
    public void static_method_split_shall_return_the_entire_buffer_if_the_end_pattern_is_not_found(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','0','1','2','b','c','g','h','u','i','j','b','c','4','i','j','k','l'};
        byte[] start_pattern = {'b','c'};
        byte[] end_pattern   = {'z','j'};

        // When:
        List<ByteArray> parts = ByteArray.s_split(buffer, start_pattern, end_pattern, -1);

        // Then:
        Assertions.assertEquals(1, parts.size());
        Assertions.assertArrayEquals(buffer, parts.get(0).getBytes());
    }

    @Test
    public void static_method_split_shall_return_the_entire_buffer_if_the_end_pattern_is_always_before_the_start_pattern(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','0','1','2','b','c','g','h','u','i','j','b','c','4','i','j','k','l'};
        byte[] start_pattern = {'4','i'};
        byte[] end_pattern   = {'b','c'};

        // When:
        List<ByteArray> parts = ByteArray.s_split(buffer, start_pattern, end_pattern, -1);

        // Then:
        Assertions.assertEquals(1, parts.size());
        Assertions.assertArrayEquals(buffer, parts.get(0).getBytes());
    }

    @Test
    public void static_method_split_shall_split_properly_a_buffer_when_the_last_part_starts_with_the_given_pattern_but_the_end_pattern_does_not_exist(){

        // Given:
        byte[] buffer = {'a','b','c','d','b','e','f','g','i','j','0','1','2','b','c','g','h','u','i','j','v','b','c','4','k','l'};
        byte[] start_pattern = {'b','c'};
        byte[] end_pattern   = {'i','j'};

        // When:
        List<ByteArray> parts = ByteArray.s_split(buffer, start_pattern, end_pattern, -1);

        // Then:
        Assertions.assertEquals(5, parts.size());
        Assertions.assertArrayEquals(new byte[] {'a'}, parts.get(0).getBytes());
        Assertions.assertArrayEquals(new byte[] {'b','c','d','b','e','f','g','i','j'}, parts.get(1).getBytes());
        Assertions.assertArrayEquals(new byte[] {'0','1','2'}, parts.get(2).getBytes());
        Assertions.assertArrayEquals(new byte[] {'b','c','g','h','u','i','j'}, parts.get(3).getBytes());
        Assertions.assertArrayEquals(new byte[] {'v','b','c','4','k','l'}, parts.get(4).getBytes());
    }

    // *****************************************************************************************************************
    //
    //  METHODS TESTS
    //
    // *****************************************************************************************************************


    @Test
    public void method_clear_shall_make_the_ByteArray_empty(){
        // Given
        ByteArray byteArray = new ByteArray(new byte[] {'a','b','c','d','e','f','g','h','i','j','k','l'});

        // When:
        byteArray.clear();

        // Then:
        byte[] expected_bytes = {};
        Assertions.assertArrayEquals(expected_bytes, byteArray.getBytes());

    }


    @Test
    public void method_getBytes_shall_return_the_bytes_of_a_ByteArray(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[] {'a','b','c','d','e','f','g','h','i','j','k','l'});
        byte[] expected_bytes = {'a','b','c','d','e','f','g','h','i','j','k','l'};

        // When:
        // Then:
        Assertions.assertArrayEquals(expected_bytes, byteArray.getBytes());
    }

    @Test
    public void method_set_shall_set_bytes_of_a_ByteArray(){

        // Given
        ByteArray byteArray = new ByteArray();
        byte[] bytes = {'a','b','c','d','e','f','g','h','i','j','k','l'};
        byte[] expected_bytes = {'a','b','c','d','e','f','g','h','i','j','k','l'};

        // When:
        byteArray.set(bytes);

        // Then:
        Assertions.assertArrayEquals(expected_bytes, byteArray.getBytes());
    }


    @Test
    public void method_append_shall_append_bytes_to_a_ByteArray(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'a','b','c','d','e','f','g','h','i','j','k','l'});
        byte[] bytes = {'m','n', 'o', 'p'};
        byte[] expected_bytes = {'a','b','c','d','e','f','g','h','i','j','k','l', 'm','n', 'o', 'p'};

        // When:
        byteArray.append(bytes);

        // Then:
        Assertions.assertArrayEquals(expected_bytes, byteArray.getBytes());
    }


    @Test
    public void method_insert_shall_insert_bytes_at_the_given_index_of_a_ByteArray(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'a','b','c','d','e','f','g','h','i','j','k','l'});
        byte[] bytes = {'m','n', 'o', 'p'};
        byte[] expected_bytes = {'a','b','c','d','e','m','n', 'o','p','f','g','h','i','j','k','l'};

        // When:
        byteArray.insert(5, bytes);

        // Then:
        Assertions.assertArrayEquals(expected_bytes, byteArray.getBytes());
    }


    @Test
    public void method_remove_shall_remove_pattern_from_a_ByteArrayand_return_the_nb_of_remove(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte[] pattern = {'a','b','a'};
        byte[] expected_bytes = {'c','c','d','e', 'k', 'l'};

        // When:
        int nb_of_remove = byteArray.remove(pattern);

        // Then:
        Assertions.assertEquals(3, nb_of_remove);
        Assertions.assertArrayEquals(expected_bytes, byteArray.getBytes());
    }


    @Test
    public void method_removeFirst_shall_remove_the_first_given_number_of_patterns_from_a_ByteArray_and_return_the_nb_of_remove(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte[] pattern = {'a','b','a'};
        byte[] expected_bytes = {'c','b','a', 'c','d','e', 'k', 'l'};

        // When:
        int nb_of_remove = byteArray.removeFirst(pattern, 2);

        // Then:
        Assertions.assertEquals(2, nb_of_remove);
        Assertions.assertArrayEquals(expected_bytes, byteArray.getBytes());
    }


    @Test
    public void method_removeLast_shall_remove_the_last_given_number_of_patterns_from_a_ByteArray_and_return_the_nb_of_remove(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte[] pattern = {'a','b','a'};
        byte[] expected_bytes = {'c','b','a', 'c','d','e', 'k', 'l'};

        // When:
        int nb_of_remove = byteArray.removeFirst(pattern, 2);

        // Then:
        Assertions.assertEquals(2, nb_of_remove);
        Assertions.assertArrayEquals(expected_bytes, byteArray.getBytes());
    }

    @Test
    public void method_removeAt_shall_remove_the_element_at_the_given_index_from_the_buffer(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','r','b','a','t','n','m','s','c','d','e','k','l'});

        // When:
        byte element1 = byteArray.removeAt(7);

        // Then:
        byte[] expected_bytes = {'c','r','b','a','t','n','m','c','d','e','k','l'};
        Assertions.assertEquals('s', element1);
        Assertions.assertArrayEquals(expected_bytes, byteArray.getBytes());
    }


    @Test
    public void method_firstIndexOf_shall_return_the_index_of_the_first_occurrence_of_pattern_in_a_ByteArray(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte key = 'b';

        // When:
        // Then:
        Assertions.assertEquals(2, byteArray.firstIndexOf(key));
    }


    @Test
    public void method_lastIndexOf_shall_return_the_index_of_the_last_occurence_of_pattern_in_a_ByteArray(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte key = 'a';

        // When:
        // Then:
        Assertions.assertEquals(7, byteArray.lastIndexOf(key));
    }

    @Test
    public void method_beginningIndexesOf_shall_return_the_list_of_indexes_where_pattern_begins_in_a_buffer(){

        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte[] pattern = {'a','b','a'};

        // When:
        List<Integer> indexes = byteArray.beginningIndexesOf(pattern);

        // Then:
        Assertions.assertEquals(3, indexes.size());
        Assertions.assertEquals(1, indexes.get(0));
        Assertions.assertEquals(3, indexes.get(1));
        Assertions.assertEquals(5, indexes.get(2));
    }

    @Test
    public void method_endIndexesOf_shall_return_the_list_of_indexes_where_pattern_ends_in_a_buffer(){
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte[] pattern = {'a','b','a'};

        // When:
        List<Integer> indexes = byteArray.endIndexesOf(pattern);

        // Then:
        Assertions.assertEquals(3, indexes.size());
        Assertions.assertEquals(3, indexes.get(0));
        Assertions.assertEquals(5, indexes.get(1));
        Assertions.assertEquals(7, indexes.get(2));
    }

    @Test
    public void method_indexesOf_shall_return_the_list_of_indexes_where_pattern_is() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte[] pattern = {'a','b','a'};

        // When:
        List<Integer> indexes = byteArray.indexesOf(pattern);

        // Then:
        Assertions.assertEquals(7, indexes.size());
        Assertions.assertEquals(1, indexes.get(0));
        Assertions.assertEquals(2, indexes.get(1));
        Assertions.assertEquals(3, indexes.get(2));
        Assertions.assertEquals(4, indexes.get(3));
        Assertions.assertEquals(5, indexes.get(4));
        Assertions.assertEquals(6, indexes.get(5));
        Assertions.assertEquals(7, indexes.get(6));
    }

    @Test
    public void method_indexesOf_shall_return_the_list_of_indexes_where_key_is() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','b','l'});
        byte key = 'b';

        // When:
        List<Integer> indexes = byteArray.indexesOf(key);

        // Then:
        Assertions.assertEquals(4, indexes.size());
        Assertions.assertEquals(2, indexes.get(0));
        Assertions.assertEquals(4, indexes.get(1));
        Assertions.assertEquals(6, indexes.get(2));
        Assertions.assertEquals(11, indexes.get(3));
    }


    @Test
    public void method_startsWith_shall_return_true_if_the_instance_starts_with_the_given_key() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','b','l'});

        // When:
        // Then:
        Assertions.assertTrue(byteArray.startsWith((byte)'c'));
    }


    @Test
    public void method_startsWith_shall_return_false_if_the_instance_does_not_start_with_the_given_key() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','b','l'});

        // When:
        // Then:
        Assertions.assertFalse(byteArray.startsWith((byte)'d'));
    }


    @Test
    public void method_startsWith_shall_return_true_if_the_instance_starts_with_the_given_pattern() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte[] pattern = {'c','a','b'};

        // When:
        // Then:
        Assertions.assertTrue(byteArray.startsWith(pattern));
    }


    @Test
    public void method_startsWith_shall_return_false_if_the_instance_does_not_start_with_the_given_pattern() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','k','l'});
        byte[] pattern = {'a','b','a'};

        // When:
        // Then:
        Assertions.assertFalse(byteArray.startsWith(pattern));
    }


    @Test
    public void method_endsWith_shall_return_true_if_the_instance_ends_with_the_given_key() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','b','l'});

        // When:
        // Then:
        Assertions.assertTrue(byteArray.endsWith((byte)'l'));
    }


    @Test
    public void method_endsWith_shall_return_false_if_the_instance_does_not_end_with_the_given_key() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','b','l'});

        // When:
        // Then:
        Assertions.assertFalse(byteArray.endsWith((byte)'b'));
    }


    @Test
    public void method_endsWith_shall_return_true_if_the_instance_ends_with_the_given_pattern() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','b','l'});
        byte[] pattern = {'e','b','l'};
        // When:
        // Then:
        Assertions.assertTrue(byteArray.endsWith(pattern));
    }


    @Test
    public void method_endsWith_shall_return_false_if_the_instance_does_not_end_with_the_given_pattern() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','b','l'});
        byte[] pattern = {'c','a','b'};
        // When:
        // Then:
        Assertions.assertFalse(byteArray.endsWith(pattern));
    }


    @Test
    public void method_count_shall_return_the_number_of_occurrences_of_the_given_key_in_the_ByteArray() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','b','l'});

        // When:
        // Then:
        Assertions.assertEquals(4, byteArray.count((byte)'b'));
        Assertions.assertEquals(2, byteArray.count((byte)'c'));
        Assertions.assertEquals(0, byteArray.count((byte)'z'));
    }


    @Test
    public void method_count_shall_return_the_number_of_occurrences_of_the_given_pattern_in_the_ByteArray() {
        // Given
        ByteArray byteArray = new ByteArray(new byte[]{'c','a','b','a','b','a','b','a','c','d','e','b','l'});
        byte[] pattern1 = {'a','b','a'};
        byte[] pattern2 = {'a','c'};
        byte[] pattern3 = {'a','f','a'};

        // Then:
        Assertions.assertEquals(3, byteArray.count(pattern1));
        Assertions.assertEquals(1, byteArray.count(pattern2));
        Assertions.assertEquals(0, byteArray.count(pattern3));
    }
}
