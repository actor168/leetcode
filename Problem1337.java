class Problem1337{
	public static void main(String[] args) {
		int[][] mat = new int[][]{{1,0,0,0}, {1,1,1,1}, {1,0,0,0}, {1,0,0,0}};
		int k = 2;
		int[] res = new Problem1337().kWeakestRows(mat, 2);
		for (int i = 0; i < k; i++) {
			System.out.print(res[i] + ",");
		}
	}

    public int[] kWeakestRows(int[][] mat, int k) {
    	int[] mp = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
        	int cnt = 0;
        	for (int j = 0; j < mat[0].length; j++) {
        		if(mat[i][j] != 1) {
        			mp[i] = cnt;
     				break;
        		} else if (j == mat[0].length-1) mp[i] = ++cnt;
        	    else cnt++;
        	}
        }

        int[] res = new int[k];
        int j = 0;
        while (j < k) {
        	int min = 0;
        	for (int i = 0; i < mp.length; i++) {
        		if (mp[i] < mp[min]) {
        			min = i;
        		} // find max
        	}
        	mp[min] = 101;
        	res[j] = min;
        	j++;
        }
        return res;
    }
}