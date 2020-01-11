class Problem69 {
    public static void main(String[] args) {
        int x = 2147395599;
        int res = new Problem69().mySqrt(x);
        System.out.println(res);
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int pos = guess(0, x, x);
        return pos;
    }

    int guess(int left, int right, int x) {
        int cur = (right+left)>>1;
        long half_sqr = (long)cur * cur;
        if (half_sqr == x) return cur;
        if (left == right || cur == left) return left;
        if (half_sqr < x) {
            return guess(cur, right, x);
        }
        if (half_sqr > x) {
            return guess(left, cur, x); // 8 4 2 3 
        }
        return 0;
    }

}