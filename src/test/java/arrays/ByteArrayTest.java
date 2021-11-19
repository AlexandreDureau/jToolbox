package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class ByteArrayTest {

    @Test
    public void static_method_append_shall_append_a_buffer_to_another_and_return_the_merged_buffer() {

        // Given:
        byte[] buffer_a = {0,1,2,3,4};
        byte[] buffer_b = {5,6,7};
        byte[] expected_buffer = {0,1,2,3,4,5,6,7};

        // When:
        byte[] buffer = ByteArray.append(buffer_a,buffer_b);

        // Then:
        Assertions.assertArrayEquals(expected_buffer, buffer);
    }
}
