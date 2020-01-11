class Problem35 {
    public static void main(String[] args) {
        int[] arr = {1,7};
        System.out.println(new Problem35().searchInsert(arr, 8));
    }

    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }

        if (target == nums[nums.length-1]) {
            return nums.length-1;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] <=target && nums[i+1] > target) {
                return nums[i] != target ? i+1 : i;
            }
        }
        return nums.length;
    }
}