package Play;

public class SString {
    public static void main(String[] args) {
        java.lang.String str = "abc";
        java.lang.String sub = str.substring(0, 3);
        System.out.println(sub);

        StringBuilder res = new StringBuilder();

        res.append("sdf");

        int n = 121;
        String m = String.valueOf(n);
        System.out.println(m.charAt(1));

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        if (str1 == str3) {
            System.out.println("true");
        }

        int big = 1234567890;
        float approx = big;
        float f = Float.MAX_VALUE;
        System.out.println("big = " + big);
        System.out.println("approx = " + approx);
        System.out.println("f = " + f);
        System.out.println(big - (int)approx);

    }
}
