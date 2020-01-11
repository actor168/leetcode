import java.util.*;

class Problem46 {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4};
		System.out.println(new Problem46().permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, nums, 0);
        return list;
    }

    public void permute(List<List<Integer>> list, int[] nums, int start) {
    	List<Integer> res = new ArrayList<>();
    	if(start == nums.length-1) {
    		return;
    	} else {
    		permute(list, nums, start++);
    		if (list.size() > 0) {
    			for (int i =0; i < list.size(); i++) {
    				list.get(i).add(nums[start]);
    			}
    		}
    	}
    }
}