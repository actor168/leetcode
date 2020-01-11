class Problem29 {
    public static void main(String[] args) {
        new Problem29().divide(-5, 3);
    }

    public int divide(int dividend, int divisor) {
        //实现除法器 // 111 
        int flag = 1;

        if (dividend < 0) {
            flag = -1;
            dividend = - dividend;
        }
        if (divisor < 0) {
            if (flag == -1) {
                flag = 1;
            }
            divisor = - divisor;
        }

        // StringBuffer str = new StringBuffer();
        // while (dividend != 0) {
        //     int res = dividend & 1;
        //     dividend = dividend >> 1;
        //     str.append(res);
        // }
        // int dividendStr = Integer.valueOf(str.reverse().toString());
        
        // str = new StringBuffer();

        // while (divisor != 0) {
        //     int res = divisor & 1;
        //     divisor = divisor >> 1;
        //     str.append(res);
        // }
        // int divisorStr = Integer.valueOf(str.reverse().toString());

        int dividendStr = Integer.valueOf(Integer.toBinaryString(dividend));
        int divisorStr = Integer.valueOf(Integer.toBinaryString(divisor));

        System.out.println(dividendStr);
        System.out.println(divisorStr);

        //进行除法模拟  
        return 0;
    }
}