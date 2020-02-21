class Problem286 {
	public static void main(String[] args) {
		int[] nums = new int[]{};
		new Problem286().moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}

	public void moveZeroes(int[] nums) {
		int j = 0;
        for (int i = 0; i < nums.length && j < nums.length;) {
        	if (nums[i] != 0) {
        		nums[j] = nums[i];
        		i++;
        		j++;
        	} else {
        		i++;
        	}
        }

        for (int k = j; k < nums.length; k++) {
        	nums[k] = 0;
        }
    }
}