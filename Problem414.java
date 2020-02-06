class Problem414 {
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,1};
		System.out.println(new Problem414().thirdMax(nums));
	}

	public int thirdMax(int[] nums) {
        int c = 0;
        int k = 0;
        while (k < 2) {
        	if (c >= nums.length) break;
        	for (int i = c; i < nums.length; i++) {
        		if(nums[i] > nums[c]) {
        			int tmp = nums[c];
        			nums[c] = nums[i];
        			nums[i] = tmp;
        		}
        	}
        	if (c > 0 && nums[c] != nums[c-1]) k++;   
        	c++;
        }
        if (k < 2) return nums[0];
        return nums[c-1];
    }
}