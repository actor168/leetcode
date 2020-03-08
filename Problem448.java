import java.util.*;

class Problem448 {
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(new Problem448().findDisappearedNumbers(nums));
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
        	int k = nums[i];
	        int tmp = 0;
	    	while (nums[k-1] != k) {
	    		tmp = nums[k-1];
	    		nums[k-1] = k;
	    		k = tmp;
	    	}
        }
        
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != i+1) {
        		list.add(i+1);
        	}
        }
        return list;
    }
}