class Problem58 {
    public static void main(String[] args) {
        System.out.println(new Problem58().lengthOfLastWord("   s  SA "));
    }

    public int lengthOfLastWord(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        char[] cArr = s.toCharArray();
        int pos = cArr.length-1;
        int count = 0;
        while(pos>=0){
            if (cArr[pos] != ' ') count++;
            if (count > 0 && cArr[pos] == ' ') break;
            pos--;
        }
        return count;
    }
}