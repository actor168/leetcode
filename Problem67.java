class Problem67 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1";
        String res = new Problem67().addBinary(a, b);
        System.out.println(res);
    }

    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int pre = 0;
        int val = 0;
        int c = 0;
        int d = 0;
        StringBuffer sBuffer = new StringBuffer();
        while(i >=0 && j>=0) {
            c = a.charAt(i) - '0';
            d = b.charAt(j) - '0';
            val = (c+d+pre) % 2; // 1+1 = 10 1+0 = 1 0+1 = 1 
            pre = (c+d+pre) >> 1;
            sBuffer.append(val);
            i--;
            j--;
        }

        while (i>=0) {
            c = a.charAt(i) - '0';
            val = (c+pre) % 2; // 1+1 = 10 1+0 = 1 0+1 = 1 
            pre = (c+pre) >> 1;
            sBuffer.append(val);
            i--;
        }

        while (j>=0) {
            d = b.charAt(j) - '0';
            val = (d+pre) % 2; // 1+1 = 10 1+0 = 1 0+1 = 1 
            pre = (d+pre) >> 1;
            sBuffer.append(val);
            j--;
        }

        if (pre>0) {
            sBuffer.append(pre);
        }

        return sBuffer.reverse().toString();
    }
}