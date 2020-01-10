import java.util.*;

class Problem16 {
	public static void main(String[] args) {
		int[] nums = new int[]{0, 1, 2};
		int target = 3;
		System.out.println(new Problem16().threeSumClosest(nums, target));
	}

	public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int s = 0;
        List<Integer> numsList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
        	numsList.add(nums[i]);
        }
        Collections.sort(numsList);

        for (int i = 0; i < nums.length-1; i++) {
        	int sum = target - numsList.get(i);
        	int k = nums.length - 1;
        	int j = i + 1;
        	while ( j < k) {
        		int tmp = numsList.get(j) + numsList.get(k);
        		if (tmp == sum) {
        			return 0;
        		}

        		if(tmp < sum) {
        			j++;
                    if (res > (sum-tmp)) {
                        res = sum-tmp;
                        s = tmp + numsList.get(i);
                    }
        		} else {
        			k--;
        			if (res > (tmp-sum)) {
                        res = tmp-sum;
                        s = tmp + numsList.get(i);
                    }
        		}
        	}
        }
        return s;
    }
}