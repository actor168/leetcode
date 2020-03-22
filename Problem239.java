class Problem239 {
	public static void main(String[] args) {
		int[] nums = {};
		int k = 0;
		int[] res = new Problem239().maxSlidingWindow(nums, k);

		for (int i = 0; i < res.length; i++) {
			System.out.printf("%d, ", res[i]);
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k <= 0 || nums.length <= 0) return new int[]{}; 
        
        int[] res = new int[nums.length-k+1];

        res[0] = nums[0];
        for (int i = 0; i < k; i++) {
        	if(res[0] < nums[i]) res[0] = nums[i]; 
        }

        int count = 1;
        for (int j = k; j < nums.length; j++) {
        	if (nums[j] > res[count-1]) {
        		res[count] = nums[j];
        	} else {
        		// 判断时候移出
        		if (nums[j-k] == res[count-1]) {
        			// 循环查找
        			int p = j-k+1;
        			int max = nums[p];
        			while(p <= j) {
        				max = max < nums[p] ? nums[p] : max;
        				p++;
        			}
        			res[count] = max;
        		} else {
        			res[count] = res[count-1];
        		}
        	}
        	count++;
        }

        return res;
    }
}