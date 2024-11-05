package Play;

public class BBit {
    public static void main(String[] args) {
        int a = 3;
        int b = 6;
        int result = (~a & b) | (a & ~b);
        System.out.println(result);
        System.out.println(~b);
    }
}
