class Problem26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 4};
        nums = new int[]{1,2,3};
        nums = new int[]{1,2,2,3};
        nums = new int[]{1,2,2,2};
        int len = new Problem26().removeDuplicates(nums);
        System.out.println(len);
    }

    public int removeDuplicates(int[] nums) {
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[cur-1]) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }
}