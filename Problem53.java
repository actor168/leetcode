class Problem53 {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Problem53().maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = dp[i-1] + nums[i];
            dp[i] = val > nums[i] ? val : nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}