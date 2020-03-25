class Problem31 {
	public static void main(String[] args) {
		int[] nums = {1,2,3,5,4};
		new Problem31().nextPermutation(nums);

		for (int i : nums) {
			System.out.printf("%d,", i);
		}
	}

	public void nextPermutation(int[] nums) {
        // 1, 4, 3, 2 ,  2,1,3,4
        int i = nums.length - 2;
        while (i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
        	int j = nums.length-1;
        	while(j > 0 && nums[i] >= nums[j]) { // 后边比前边大
        		j--;
    		}
    		swap(nums, i, j);
        }
		reverse(nums, i+1);
    }

    void reverse(int[] nums, int pos) {
    	int i = nums.length-1;

    	for (int j = pos; j < i; j++, i--) {
    		swap(nums, j, i);
    	}
    }

    void swap(int[] nums, int p, int q) {
    	int t = nums[p];
    	nums[p] = nums[q];
    	nums[q] = t;
    }
}