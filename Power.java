class Power {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        if (n==1) return x;
        if (n==-1) return 1/x;
        double d = myPow(x, n/2);
        if ( n%2 == 0) 
            return d * d;
        else 
            return d * d * myPow(x, n%2);
    }

    public static void main(String[] args) {
        System.out.println(new Power().myPow(1.00001, 123456));
    }
}