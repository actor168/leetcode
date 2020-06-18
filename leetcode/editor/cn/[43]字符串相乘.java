package leetcode.editor.cn;//Given two non-negative integers num1 and num2 represented as strings, return t
//he product of num1 and num2, also represented as a string. 
//
// Example 1: 
//
// 
//Input: num1 = "2", num2 = "3"
//Output: "6" 
//
// Example 2: 
//
// 
//Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
//
// Note: 
//
// 
// The length of both num1 and num2 is < 110. 
// Both num1 and num2 contain only digits 0-9. 
// Both num1 and num2 do not contain any leading zero, except the number 0 itsel
//f. 
// You must not use any built-in BigInteger library or convert the inputs to int
//eger directly. 
// 
// Related Topics 数学 字符串

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String multiply(String num1, String num2) {
        /**
         *  // calc by pos
         *  res[i] = res[i] != 0 ? res[i] : num1 * num2[i] * 10^(nums[length-1-i])
         *
         *  // calc by pos
         *
         *
         */
        int N = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "";
        StringBuilder tmp0 = new StringBuilder();
        String[] res = new String[N];
        for (int i = N - 1; i >= 0; i--) {
            if (res[i] == null) {
                // calc
                StringBuilder sb = new StringBuilder();
                int plus = 0;
                for (int j = num1.length() - 1; j >= 0; j--) {
                    int v1 = num1.charAt(j) - '0';
                    int v2 = num2.charAt(i) - '0';
                    if (v2 != 0) {
                        int v = (v1 * v2 + plus) % 10;
                        plus = (v1 * v2 + plus) / 10;
                        sb.append(v);
                    }
                }
                if (plus > 0) {
                    sb.append(plus);
                }
                res[i] = sb.toString();
            }
            result = add(result, tmp0 + res[i]);
            tmp0.append("0");
        }

        return reverse(result);
    }

    private String add(String result, String re) {
        StringBuilder sb = new StringBuilder();
        int plus = 0;
        int len = Math.max(result.length(), re.length());
        for (int i = 0; i < len; i++) {
            int v1 = 0, v2 = 0;
            if (i < result.length()) {
                v1 = result.charAt(i) - '0';
            }
            if (i < re.length()) {
                v2 = re.charAt(i) - '0';
            }
            int v = (v1 + v2 + plus) % 10;
            plus = (v1 + v2 + plus) / 10;
            sb.append(v);
        }
        if (plus > 0) {
            sb.append(plus);
        }
        return sb.toString();
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)