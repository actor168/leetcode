import java.util.*;

class Problem41 {
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,2,4};
		System.out.println(new Problem41().firstMissingPositive(nums));
	}

	public int firstMissingPositive(int[] nums) {
      	// 找出最大值，并将其作为数组的长度
      	int max = Integer.MIN_VALUE;
      	Set<Integer> s = new HashSet<>();

      	for (int i = 0; i < nums.length; i++) {
      		if (nums[i] > 0) s.add(nums[i]);
      		if (nums[i] > max) max = nums[i];
      	}

      	for (int j = 1; j <= max; j++) {
      		if (!s.contains(j)) {
      			return j;
      		}
      	}

      	return max <= 0 ? 1 : max+1;
    }
}