class Problem151 {
	public static void main(String[] args) {
		String s = "easy it  hello";
		System.out.println("-" + new Problem151().reverseWords(s) + "-");
	}

	public String reverseWords(String s) {
        int i = 0, j = s.length()-1;
        char[] sarr = s.toCharArray();
        while (i < j) {
        	char c = sarr[i];
        	sarr[i] = sarr[j];
        	sarr[j] = c;
        	i++;
        	j--;
        }// reverse

        // reverse word 
        // cba 331
        int k = 0;
        int start = 0;
        while( k < sarr.length) {
        	if (sarr[k] == ' ' || k == sarr.length-1) {
        		// reverse 
        		if (start < k) {
        			int end = sarr[k] == ' ' ? k-1: k; 
        			while(start < end) {
        				char c = sarr[start];
        				sarr[start] = sarr[end];
        				sarr[end] = c;
        				start++;
        				end--;
        			}
        			start = ++k;
        		} else {
        			k++;
        		}
        	} else {
        		k++;
        	}
        }
        System.out.println("-" + new String(sarr) + "-");
        int m = 0;
        char pre = '\0';
        for (int l = 0; l < sarr.length; l++) {
        	if (sarr[l] == ' ') {
        		if (pre != ' ' && l != sarr.length-1) {
        			sarr[m] = sarr[l];
        			m++;
        		}
        	} else {
        		sarr[m] = sarr[l];
        		m++;
        	}
        	pre = sarr[l];
        }
        return new String(sarr, 0, m).trim();
    }
}