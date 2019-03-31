class Problem70 {
    public static void main(String[] args) {
        Problem70 p = new Problem70();
        System.out.println(p.climbStairs(1));
    }

    public long climbStairs(int n) {
        if (n <= 2) return n;
        int n1 = 1;
        int n2 = 2;
        int pos = 3;
        int res = 0;
        while ( pos <= n) {
            res = n1 + n2;
            n1 = n2;
            n2 = res;
            pos++;
        }
        return res;
    }
}