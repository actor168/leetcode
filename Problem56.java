class Problem56 {
	public static void main(String[] args) {
		int[][] intervals = new int[][]{{1,4}, {2,3}, {8,10}, {10,18}};
		int[][] res = new Problem56().merge(intervals);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
					System.out.print(res[i][j] + ",");
			}
			System.out.println();
		}
	}

	public int[][] merge(int[][] intervals) {
        // sort arr
		sort(intervals, 0, intervals.length-1);
        // merge
        int[][] res = merge2(intervals);
        return res;
    }

    public int[][] merge2(int[][] intervals) {
    	if (intervals.length <= 1) return intervals;
    	int k = 0;
    	int i = 1; 
    	while (i < intervals.length) {
    		if (intervals[k][1] >= intervals[i][0]) { // merge
    			intervals[k][1]  = Math.max(intervals[i][1], intervals[k][1]);
    		} else {
    			//
    			k++;
				intervals[k][0] = intervals[i][0];
    			intervals[k][1]  = intervals[i][1];
    		}
    		i++;
    	}
    	k++;
    	int[][] res = new int[k][2];
    	for (int j = 0; j < k; j++) {
    		res[j][0] = intervals[j][0];
    		res[j][1] = intervals[j][1];
    	}
    	return res;
    }

    public void sort(int[][] intervals, int l, int r) {
    	if (l == r || l >= intervals.length-1) return;
    	int p0 = intervals[l][0];
    	int p1 = intervals[l][1];
    	int i = l, j = r;
    	while (i < j) {
    		while (i < j && intervals[j][0] >= p0) {
				if (intervals[j][0] == p0 && intervals[j][1] < p1) {
					break;
				}
				j--;
			}
			intervals[i][0] = intervals[j][0];
			intervals[i][1] = intervals[j][1];


			while (i < j && intervals[i][0] <= p0) {
				if (intervals[i][0] == p0 && intervals[i][1] > p1) {
					break;
				}
				i++;
			}
			intervals[j][0] = intervals[i][0];
			intervals[j][1] = intervals[i][1];
			
		}

		intervals[i][0] = p0;
		intervals[i][1] = p1;
		sort(intervals, l, i);
		sort(intervals, j+1, r);
    }
}