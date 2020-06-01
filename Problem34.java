class Problem34 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = new Problem34().searchRange(nums, target);
        System.out.printf("%s,%s\n",res[0], res[1]);    
    }

    public int[] searchRange(int[] nums, int target) {
        return binary(nums, target, 0, nums.length-1);
    }

    int[] binary(int[] nums, int target, int l, int r) {
        boolean find = true;
        if (l > r) {
            find = false;
        }
        if (l == r) {
            if (target != nums[l]) find = false;
            else return new int[]{l, l};
        } 

        if (!find) return new int[]{-1,-1};

        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            System.out.println(mid);
            int i = 0, j = 0;
            for(i=mid; i>l && nums[--i] == target;){}
            for(j=mid; j<r && nums[++j] == target;){}
            if (nums[i] != target) i++;
            if (nums[j] != target) j--;
            return new int[]{i, j};
        } else if (nums[mid] < target){
            l = mid+1;
        } else {
            r = mid-1;
        }
        return binary(nums, target, l, r);
    }
}