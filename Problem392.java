class Problem392 {
	public static void main(String[] args) {
		String s = "a";
		String t = "";
		System.out.println(new Problem392().isSubsequence(s, t));
	}

	public boolean isSubsequence(String s, String t) {
		int j = 0, i = 0;
        for (; j < s.length() && i < t.length(); i++) {
        	if (s.charAt(j) == t.charAt(i)) {
        		j++;
        	} 
        }
       	
        if(j == s.length()) return true;
        return false; 
    }
}