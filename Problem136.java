class Problem136 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4, 3};
        System.out.println(new Problem136().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = nums[i] ^ res;
        }
        return res;
    }
}