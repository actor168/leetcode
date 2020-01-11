class Problem8 {
    public static void main(String[] args) {
        System.out.println(new Problem8().myAtoi("0-1"));
    }

    public int myAtoi(String str) {

        // tranfer to char[], if starts with space, continue, else if is digits, start ++
        char[] arr = str.toCharArray();

        int pos = 0;
        boolean begin = false;
        int flag = 1;
        long res = 0;
        while (pos < arr.length) {
            // if 
            if (!begin && arr[pos] == ' ') {
                pos++;
                continue;
            } else if (!begin && arr[pos] == '+') {
                begin = true;
            } else if (!begin && arr[pos] == '-') {
                begin = true;
                flag = -1;
            } else if (arr[pos] >= '0' && arr[pos] <= '9') {
                begin = true;
                res += (arr[pos] - '0');
                res *= 10;
                if ((res/10 > Integer.MAX_VALUE  || -res/10 < Integer.MIN_VALUE)) break;
            } else {
                break;
            }
            pos++;
        }
        res = res / 10  * flag;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)res;
    }
}