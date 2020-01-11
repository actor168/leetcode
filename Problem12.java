class Problem12 {
	public static void main(String[] args) {
		System.out.println(new Problem12().intToRoman(1994));
	}

	public String intToRoman(int num) {
        // split 
        int[] nums = new int[4];
        int pos = 0;
        while(num != 0) {
        	int t = num % 10;
        	num = (num - t) / 10;
        	nums[pos++] = t;
        }

        if (pos > 0) pos--;

        StringBuffer sb = new StringBuffer();
        for (int i = pos; i >= 0; i--) {
        	sb.append(parse(nums[i], i));
        }
        return sb.toString();
    }

    public String parse(int v, int pos) {
    	StringBuffer res = new StringBuffer();
    	// 
    	char[][] arr = new char[4][2];

    	arr[0][0] = 'I';
    	arr[0][1] = 'V';
    	arr[1][0] = 'X';
    	arr[1][1] = 'L';
    	arr[2][0] = 'C';
    	arr[2][1] = 'D';
    	arr[3][0] = 'M';
    	
    	if (v < 4) {
    		for (int tmp = 1; tmp <= v; tmp++) res.append(arr[pos][0]);
    	}

    	if (v == 4) {
    		res.append(arr[pos][0]).append(arr[pos][1]);
    	}

    	if (v == 5) {
    		res.append(arr[pos][1]);
    	}

    	if (v > 5 && v < 9) {
    		res.append(arr[pos][1]);
    		for (int tmp = 1; tmp <= v-5; tmp++) res.append(arr[pos][0]);
    	}

    	if (v == 9) {
    		res.append(arr[pos][0]);
    		res.append(arr[pos+1][0]);
    	}
    	// 50 + 5 + 3 
    	// L VIII

    	// 1000 + 900 + 90 + 4
    	// 1000 + (1000-100) + (100-10) + (5-1)
 
    	return res.toString();
    }
}