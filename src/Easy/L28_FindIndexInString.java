package Easy;

public class L28_FindIndexInString {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
    public static int strStr(String haystack, String needle) {
        for(int i = 0;  i < (haystack.length() - needle.length() + 1); i++) {
            String sub = haystack.substring(i, i + needle.length());
            System.out.println(sub);

            if (sub.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
