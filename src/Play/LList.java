package Play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LList {
    public static void main(String[] args) {

        String[][] hhgttg = {{"d", "o"}, {"n", "t"}, {"panic"}};
        Arrays.stream(hhgttg)
                .peek(p -> p.equals(new String[] {"panic"})) // operation for each item
                .flatMap(m -> Arrays.stream(m))
                .forEach(System.out::print);
    }
}
