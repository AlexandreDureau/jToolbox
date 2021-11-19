package computing;

import arrays.ByteArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class SumTest {

    @Test
    public void sumBytesOnByte_methods_shall_compute_the_sum_of_bytes_in_an_array_of_bytes_and_give_the_result_casted_on_byte() {

        verify_sumBytesOnByte(new byte[] {1,2,3,4,5,6,7,8,9,10}, 55);
        verify_sumBytesOnByte(new byte[] {10,20,30,40,50,60,70}, 24);
        verify_sumBytesOnByte("Le", -79);
        verify_sumBytesOnByte("Le petit train dans la montagne", 97);
    }

    @Test
    public void sumBytesOnShort_methods_shall_compute_the_sum_of_bytes_in_an_array_of_bytes_and_give_the_result_casted_on_short() {

        String shortText = "Le petit train dans la montagne";
        verify_sumBytesOnShort(shortText.getBytes(), 2913);
        verify_sumBytesOnShort(shortText, 2913);

        String veryLongText =
                "Le petit train dans la montagne n'a pas fini de monter, monter, monter et encore monter. " +
                        "On ne l'arrete plus. Quand redescendra - t - il? Peut etre quand le test sera fini et certainement pas avant. " +
                        "Pour etre honnete, si j'avais pu faire rouler ce train en Belgique, sur un quelconque terrain plat, " +
                        "je ne m'en serais pas prive. " +
                        "Oui mais voila, on ne fait pas toujours ce qu'on veut. " +
                        "Avoir une phrase d'une longueur suffisante n'est pas chose facile.";

        verify_sumBytesOnShort(veryLongText.getBytes(), -24780);
        verify_sumBytesOnShort(veryLongText, -24780);
    }

    @Test
    public void sumBytesOnInteger_methods_shall_compute_the_sum_of_bytes_in_an_array_of_bytes_and_give_the_result_casted_on_integer() {

        verify_sumBytesOnByte(new byte[] {1,2,3,4,5,6,7,8,9,10}, 55);
        verify_sumBytesOnByte(new byte[] {10,20,30,40,50,60,70}, 24);
        verify_sumBytesOnByte("Le", -79);
        verify_sumBytesOnByte("Le petit train dans la montagne", 97);
    }

    private void verify_sumBytesOnByte(byte[] buffer, int expectedSum){
        int sum = Sum.sumBytesOnByte(buffer);
        Assertions.assertEquals(expectedSum, sum);
    }

    private void verify_sumBytesOnByte(String text, int expectedSum){
        int sum = Sum.sumBytesOnByte(text);
        Assertions.assertEquals(expectedSum, sum);
    }

    private void verify_sumBytesOnShort(byte[] buffer, int expectedSum){
        int sum = Sum.sumBytesOnShort(buffer);
        Assertions.assertEquals(expectedSum, sum);
    }

    private void verify_sumBytesOnShort(String text, int expectedSum){
        int sum = Sum.sumBytesOnShort(text);
        Assertions.assertEquals(expectedSum, sum);
    }

    private void verify_sumBytesOnInteger(byte[] buffer, int expectedSum){
        int sum = Sum.sumBytesOnInteger(buffer);
        Assertions.assertEquals(expectedSum, sum);
    }
}
