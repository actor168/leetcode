class Problem338 {
	public static void main(String[] args) {
		System.out.println(new Problem338().countBits(2));
	}

	public int[] countBits(int num) {
        int[] dp = new int[num+1];
        
        for(int i = 0; i < dp.length; i++) {
            dp[i] = dp[i >> 1] + i % 2;
        }
        
        return dp;
    }
}