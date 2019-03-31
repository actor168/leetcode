class Problem38 {
    public static void main(String[] args) {
        Problem38 p = new Problem38();
        System.out.println(p.countAndSay(4));
    }

    public String countAndSay(int n) {
        String str = "1";
        if (n <= 1) {
            return str;
        }
        for (int i = 1; i < n; i++) {
            char pre = str.charAt(0);
            StringBuffer buffer = new StringBuffer();
            int count = 1;
            char c = pre;
            for (int j = 1; j < str.length(); j++) {
                c = str.charAt(j);
                if (c != pre) {
                    buffer.append(count);
                    buffer.append(pre);
                    count = 0;
                }
                count++;
                pre = c;
            }
            buffer.append(count);
            buffer.append(c);
            str = buffer.toString();
            //System.out.println(i+"--"+str);
        }
        return str;
    }
}