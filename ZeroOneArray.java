/**
 * 输出最长连续0-1子数组
 * 
 * 给定一个二进制数组，输出最长序列长度
 */
class ZeroOneArray {

    public static void main(String[] args) {
        int[] arr =  {0,1,0,1,0,0,1,1,0,1};
        System.out.println(getLength(arr));
    }

    public static int getLength(int[] arr) {
        //动态规划法求解最长子数组
        /*
         * 循环子问题：
         * dp[0] = 0
         * dp[1] = {0,1} = 2
         * dp[2] = {1,0} = 2
         */
         int[] dp = new int[500001];
         dp[0] = 0;

         int max = dp[0];

         for (int i = 1; i < arr.length; i++) {
            int res = arr[i] - arr[i-1];
            for (int j = i; j >= 1; j-=2) {
                if (res != arr[j] - arr[j-1]) {
                    break;
                } else {
                    dp[i] += 2;
                }
            }
            max = max < dp[i] ? dp[i] : max;
         }
        return max;
    }
}