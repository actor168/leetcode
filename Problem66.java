import java.util.Arrays;

class Problem66 {
    public static void main(String[] args) {
        int[] digits = {9};
        int[] res = new Problem66().plusOne(digits);
        System.out.println(Arrays.toString(res));
    }

    public int[] plusOne(int[] digits) {
        int pos = digits.length-1;
        if (digits[pos] != 9) {
                digits[pos] += 1;
                return digits;
        }

        while (digits[pos] + 1 == 10) {
            digits[pos] = 0;
            pos--;
            if (pos < 0) break;
        }

        if (pos >= 0 || (digits[0] != 0 && digits[0] +1 < 10)) {
            digits[pos] += 1;
            return digits;
        }

        int[] digits1 = new int[digits.length+1];
        digits1[0] = 1;
        for (int i = 1; i < digits1.length; i++) {
            digits1[i] = 0;
        }
        return digits1;
    }
}