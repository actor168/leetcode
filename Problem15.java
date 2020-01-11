import java.util.*;

class Problem15 {
	public static void main(String[] args) {
		int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		System.out.println(new Problem15().threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		if (nums.length == 0) {
            return new ArrayList<>();
        } 

		Set<List<Integer>> res = new HashSet<>();
		Arrays.sort(nums);

        for (int i = 0;  i < nums.length-2; i++) {

        	while (i > 0 && i < nums.length-2 && nums[i] == nums[i-1]) {
                i++;
            }
            if (i >= nums.length-2 || nums[i] > 0) {
                break;
            }

            int j = i+1;
            int k = nums.length-1;

            while(j < k) {
            	if (nums[k] + nums[j] == - nums[i]) {
            		res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            		while(j < k && nums[j] == nums[j+1]) {
	            		j++;
	            	}

	            	while(j < k && nums[k] == nums[k-1]) {
	            		k--;
	            	}

	            	j++;
	            	k--;
            	} else if (nums[k] + nums[j] < -nums[i]){
            		j++;
            	} else {
            		k--;
            	}
            }
        }
        return new ArrayList<>(res);
    }
}
