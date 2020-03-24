import java.util.Map;
import java.util.HashMap;

class Problem128 {
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(new Problem128().longestConsecutive(nums));
	}

	public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
        	if (map.getOrDefault(nums[i], 0) == 0) { // 之前不存在该key
        		int left = map.getOrDefault(nums[i]-1, 0);
        		int right = map.getOrDefault(nums[i]+1, 0);
        		map.put(nums[i], left + right + 1);
 				map.put(nums[i]-left, left+ right + 1);
 				map.put(nums[i]+right, left+right + 1);
 				max = max < (left+right + 1) ? left+right+1 : max;
        	} else {
        		map.put(nums[i], map.get(nums[i]));
        	}
        }
        return max;
    }
}