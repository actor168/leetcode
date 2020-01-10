class Problem13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int len = new Problem13().romanToInt(s);
        System.out.println(len);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I': cur = 1; break;
                case 'V': cur = 5; break;
                case 'X': cur = 10; break;
                case 'L': cur = 50; break;
                case 'C': cur = 100; break;
                case 'D': cur = 500; break;
                case 'M': cur = 1000; break;
            }

            if (pre > 0 && pre < cur) {
                sum = sum - 2 * pre + cur;
            } else {
                sum += cur;
            }
            pre = cur;
        }
        return sum;
    }
}