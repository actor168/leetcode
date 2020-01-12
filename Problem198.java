class Problem198 {
	public static void main(String[] args) {
		int[] nums = new int[]{2,1,1,2};
		System.out.println(new Problem198().rob(nums));
	}

	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		int[] sum = new int[nums.length];
		
		sum[0] = nums[0];
		sum[1] = nums[1];

		// 1 2 9 7 2 1
		for (int i = 2; i < nums.length; i++) {
			for (int j = 0; j < i-1; j++) {
				sum[i] = Math.max(nums[i] + sum[j], sum[i]);
			}
			
		}

		int max = sum[0];
		for (int i = 1; i < sum.length; i++) {
			max = Math.max(max, sum[i]);
		}
        return max;
    } 
}