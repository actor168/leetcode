package leetcode.editor.cn;//Given a 32-bit signed integer, reverse digits of an integer.
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(-100));
        System.out.println(s.reverse(-1 * 0x80000000));
        System.out.println(s.reverse(0x80000000));
        System.out.println(s.reverse(123));
    }

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            res = 0;
        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
