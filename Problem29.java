class Problem29 {
    public static void main(String[] args) {
        Problem29 p = new Problem29();
        System.out.println(p.divide(2147483647, 2));
    }

    public int divide(int dividend, int divisor) {
        boolean flag = true;

        if (dividend <= Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        if (dividend < 0) {
            flag = false;
            dividend = - dividend;
            
        }

        if (divisor < 0) {
            if (!flag) flag = true;
            else flag = false;
            divisor = - divisor;
        }

        if (divisor == 1) {
            return flag ? dividend : -dividend;
        }
        //String dividendStr = Integer.toBinaryString(dividend);
        //String divisorStr = Integer.toBinaryString(divisor);

        /*
        System.out.println(dividendStr);
        System.out.println(divisorStr);
        boolean flagF = true;
        long dividendStrLong = Long.parseLong(dividendStr);
        long divisorLong = Long.parseLong(divisorStr);
        StringBuffer buffer = new StringBuffer();
        */
        long res = 0;
        int divis = divisor;
        while ( dividend > 0) {
            int q = 1;
            while (dividend > (divisor << 1)) {
                divisor = divisor << 1;
                q = q << 1;
            }

            if (dividend < divisor) {
                dividend = 0;
                q = 0;
            } else {
                dividend = dividend - divisor;
                divisor = divis;
            }
            res += q;
        }
        
        res = flag ? res : -res;
        if (res >= Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        } 
        if (res <= Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        } 
        return (int)res;
    }
}