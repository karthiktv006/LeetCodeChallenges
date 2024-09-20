package Blind75;

public class L91_Decode_Ways {
    public static void main(String[] args) {
        String s = "123";
        decodeWays(s, 0);
    }

    public static int decodeWays(String s, int index) {
        if (s.length() == 0) {
            return 1;
        }
        int count = 0;
        System.out.println(s);
        System.out.println("count:" + count);
//        if (s.length() > 1) {
//            count += decodeWays(s.substring(index + 2), 0);
//        }
        return decodeWays(s.substring(index + 1), 0);
    }
}
