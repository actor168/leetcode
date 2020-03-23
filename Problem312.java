import java.util.List;
import java.util.ArrayList;

class Problem312 {
	public static void main(String[] args) {
		int[] nums = {3,1,5,8};
		System.out.println(new Problem312().maxCoins(nums));
	}

	public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < nums.length; i++) {
        	list.add(nums[i]);
        }
        list.add(1);

        int[][] dp = new int[list.size()][list.size()];

        int sum = helper(list, 1, nums.length, dp);
       	return sum;
    }


   	int helper(List<Integer> list, int left, int right, int[][] dp) {
    	
      if (left > right) return 0;
      if (dp[left][right] > 0) return dp[left][right];

    	for (int i = left; i <= right; i++) {
        int l = helper(list, left, i-1, dp);
        int r = helper(list, i+1, right, dp);

    		int val = list.get(i) * list.get(left-1) * list.get(right+1);
    		dp[left][right] = Math.max(dp[left][right], val + l + r);
    	}
    	return dp[left][right];
    }
}