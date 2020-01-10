class Problem27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        nums = new int[]{3,2,2,3};
        //nums = new int[]{3};
        int value = 2;
        
        int len = new Problem27().removeElement(nums, value);
        System.out.println(len);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        while (i < nums.length && nums[i] != val) {
            i++;
        }
        int j = i;
        while (j < nums.length && nums[j] == val){
            j++;
        }
        while ( j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                nums[j] = val;
                while (nums[i] != val) {
                    i++;
                }
            }
            j++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return i;
    }
}