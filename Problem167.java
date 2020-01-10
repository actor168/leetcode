public class Problem167 {

	public static void main(String[] args) {
		int[] numbers = new int[]{12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
		int target = 542;

		int[] res = twoSum(numbers, target);
		System.out.println(res[0] + ":" + res[1]);

		System.out.println(numbers[res[0]] + ":" + numbers[res[1]]);
	}

	public static int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1 ;

		while (left < right  && (numbers[left] + numbers[right] != target)) {
			int j = left;
			for (; (target - numbers[j]) > numbers[right];) j++;
			left = j;

			int k = right;
			for (; (target - numbers[k]) < numbers[left];) k--;
			right = k;
		}


		left++;
		right++;

		if (left > right) {
			int tmp = right;
			right = left;
			left = tmp;
		}

		
		return new int[]{left, right};

        // target <= max 

			/*
			 二分法找到大致位置 log.n
			 子问题，查找
			*/
        // target >= max 

			/*
			同子问题查找 


			ex. 18

			2+15 < target 
			7+15 > target 
			7+11 = target 
			
			ex. 13

			2 + 11 = 13


			ex. 26

			2+15 < target
			7+ 15 < target 

			11+ 15 = target



			*/ 

    }
}