class Problem14 {
    public static void main(String[] args) {
        Problem14 p = new Problem14();
        String[] list = {""};
        System.out.println(p.longestCommonPrefix(list));
    }

    public String longestCommonPrefix(String[] strs) {
        int pos = 0;
        boolean flag = true;
        String prefix = "";
        if (strs.length <= 0) {
            return prefix;
        }
        while (pos >= 0 && pos < strs[0].length()){
            prefix = strs[0].substring(0, pos+1);
            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            pos++;
        }
        if (pos <= 0) {
            return "";
        }
        return strs[0].substring(0, pos);
    }
}