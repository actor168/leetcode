class Problem665 {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,4,5,3};
		System.out.println(new Problem665().checkPossibility(nums));
	}

	public boolean checkPossibility(int[] nums) {
		if (nums.length <= 1) return true;
		int c = 0;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] < nums[i-1]) {
        		if (i-2 >= 0) {
        			if (nums[i-2] > nums[i]) {
        				if (i+1 < nums.length) {
        					if (nums[i-1] > nums[i+1]) return false;
        				}
					}
        		}
        		c++;
        	}
        }
        return c <= 1;
    }
}