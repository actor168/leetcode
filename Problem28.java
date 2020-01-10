class Problem28 {
    public static void main(String[] args) {
        Problem28 p = new Problem28();
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(p.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() <= 0) {
            return -1;
        }
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length()) {
                    return i-j+1;
                }
            } else {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }
}