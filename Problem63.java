class Problem63 {
	public static void main(String[] args) {
		int[][] obstacleGrid = new int[][]{{0,0,1,0}, {0,0,0,0}, {0,1,0,0}, {0,0,0,0}};
		System.out.println(new Problem63().uniquePathsWithObstacles(obstacleGrid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		// 创建 dp数组 存储 历史情况
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					// calc
					if (i == 0 && j == 0) {
						dp[0][0] = 1;
					} else if (i == 0) {
						dp[i][j] = dp[i][j-1];
					} else if (j == 0) {
						dp[i][j] = dp[i-1][j];	
					} else {
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}		
				}
			}
		}
        return dp[m-1][n-1];
    }
}