package Easy;

import Common.Array;

public class L66_PlusOne {
    public static void main(String[] args) {
        Array arr = new Array();
        int[] tc1 = {1, 2, 3};
        int[] tc3 = { 9};
        arr.print1DArrayInteger(plusOne(tc1));
        arr.print1DArrayInteger(plusOne(tc3));
    }

    public static int[] plusOne(int[] digits) {

        int carryover = 0;
        int addendum = 1;
        int[] result = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + addendum + carryover;
            if (sum > 9) {
                carryover = 1;
                result[i] = 0;
            } else {
                carryover = 0;
                result[i] = sum;
            }

            addendum = 0;

        }

        if (carryover == 1) {
            int[] extraDigit = new int[digits.length + 1];
            extraDigit[0] = 1;
            for (int j = 1; j < extraDigit.length; j++) {
                extraDigit[j] = result[j - 1];
            }
            return extraDigit;
        } else {
            return result;
        }


    }
}
