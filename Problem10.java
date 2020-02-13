class Problem10 {
	public static void main(String[] args) {
		String s = "ab";
		String p = ".*";
		System.out.println(new Problem10().isMatch(s, p));
	}

	public boolean isMatch(String text, String pattern) {
        System.out.println(text + "  " + pattern);
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
        /*if(s.length() == 0 && p.length() == 0) {
        	return true;
        }
        if (s.length() <= 0 || p.length() <= 0) return false; 

        char p_pos = p.charAt(0);
        char s_pos = s.charAt(0);

        if (p_pos == '.') {
        	p_pos = s.charAt(0);
        } 

        if (p_pos != s_pos) {
            // *
            if (p_pos == '*') return isMatch(s.substring(1), p.substring(1));
            if (p.length() >= 2) {
                // 如果下一个是 '*', p往后移2
                if (p.charAt(1) == '*') {
                    return isMatch(s, p.substring(2));
                }
            }    
            return false;        
        }

        if (p.length() >= 2) {
            // 如果下一个是 '*', p往后移2
            if (p.charAt(1) == '*') {// aa a*
                if (s.charAt(1) == s_pos) return isMatch(s.substring(1), p.substring(1)) || isMatch(s.substring(1), p.substring(2));
                else return isMatch(s, p.substring(2));
            }
        }

        return isMatch(s.substring(1), p.substring(1));*/
    }
}