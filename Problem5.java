class Problem5 {
	public static void main(String[] args) {
		String s = "baaaaabc";
		System.out.println(new Problem5().longestPalindrome(s));
	}

	public String longestPalindrome(String s) {
		String res = ""; 
		char tmp = '\0';
		int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(tmp == c) {
        		end++;
        	} else {
        		tmp = c;
        		start = i;
        		end = start;
        	}
        	int j = start, k = end;
        	for (; j>= 0 && k< s.length();) {
        		if (s.charAt(j) == s.charAt(k)) {
        			k++;
        			j--;
        		} else {
        			break;
        		}
        	}
        	//System.out.println(c + "  " + start + "  " + end + "   " + res);
        	if(k-j-1 >= res.length()) res = s.substring(j+1, k);
        }

        return res;
    }
}