class Problem748 {
	public static void main(String[] args) {
		int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(new Problem748().minCostClimbingStairs(cost));
	}

	public int minCostClimbingStairs(int[] cost) {
        // f(n) = cost[n] + min(f(n-1), f(n-2))
        // f(0) = cost[0]
        // f(1) = cost[1]
		int[] sums = new int[cost.length];
		sums[0] = cost[0];
		sums[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
        	sums[i] = cost[i] + Math.min(sums[i-1], sums[i-2]);
        }

        return Math.min(sums[cost.length-1], sums[cost.length-2]);
    }
}