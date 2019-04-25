class Problem125 {
    public static void main(String[] args) {
        String test = ".s...a";
        System.out.println(new Problem125().isPalindrome(test));
    }

    public boolean isPalindrome(String s) {
        // 从两端开始往中间找
        int i = 0, j = s.length()-1;
        while (i < j) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if (isAlphanumeric(l) && isAlphanumeric(r)) {
                if (Character.isUpperCase(l)) l = Character.toLowerCase(l);
                if (Character.isUpperCase(r)) r = Character.toLowerCase(r);
                if (l-'0' != r-'0') {
                    break;
                }
                j--;
                i++;
            } else {
                if (!isAlphanumeric(l)) i++;
                if (!isAlphanumeric(r)) j--;
            }
        }
        return i==j || i == j+1;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}