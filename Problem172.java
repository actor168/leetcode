class Problem172 {
    public static void main(String[] args) {
        System.out.println(new Problem172().trailingZeroes(25));
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while(n != 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}