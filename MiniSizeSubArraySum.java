/**
 * 求解满足指定和的最小连续数字个数  LeetCode 209
 * 
 * S[0] = 4    2 3 1 2 
 * S[1] = 4      3 1 2 4
 * S[2] = 3        1 2 4 
 * S[3] = 3          2 4 3
 * S[4] = 2            4 3
 * S[5] = 0
 * 
 * 
 */

class MiniSizeSubArraySum {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        int len = new MiniSizeSubArraySum().minSubArrayLen(s, nums);
        System.out.println(len);
    }

    /**
     * 
     * @param s
     * @param nums
     * @return len 长度
     */
    public int minSubArrayLen(int s, int[] nums) {
        int right = 0;
        int min = nums.length + 1 ;
        
        if (min <= 1) {
            return 0;
        }

        if (nums[0] >= s ) {
            return 1;
        }

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //减掉左侧的1个，判断是否符合要求，如不符合，一直往后加，记住右侧的位置
            while (sum < s && right < nums.length-1) {
                sum += nums[++right];
            }
            min = ((s <= sum) && (right-i+2) < min) ? right-i+2 : min;
            sum -= nums[i-1];
        }

        if (min == nums.length + 1 ) {
            return 0;
        }
        return min;
    }
}