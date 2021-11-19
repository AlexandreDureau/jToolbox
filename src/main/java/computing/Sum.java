package computing;

public class Sum {

    public static byte sumBytesOnByte(byte[] data){

        byte sum = 0;
        for (byte b : data) {
            sum += b;
        }
        return sum;
    }

    public static byte sumBytesOnByte(String text){
        return sumBytesOnByte(text.getBytes());
    }


    public static short sumBytesOnShort(byte[] data){
        short sum = 0;
        int i = 0;
        boolean flag = false;
        for(byte b : data){
            sum += b;
            i++;

            if(sum >= 32300 && !flag){
                flag=true;
            }
        }
        return sum;
    }


    public static short sumBytesOnShort(String text){
        return sumBytesOnShort(text.getBytes());
    }


    public static int sumBytesOnInteger(byte[] data){
        int sum = 0;
        for (byte b : data) {
            sum += b;
        }
        return sum;
    }


    public static int sumBytesOnInteger(String text){
        return sumBytesOnInteger(text.getBytes());
    }
}
