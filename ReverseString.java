class ReverseString {
    public static void main(String[] args) {
        new ReverseString().method();
    }

    void method() {
        char[] arr = {'H','a','n','n','a','h', 'd'};
        exchange(arr, 0);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        
    }

    void exchange(char[] arr, int pos) {
        int right = arr.length-1-pos;
        if (pos < right) {
            char tmp = arr[right];
            arr[right] = arr[pos];
            arr[pos] = tmp;
            exchange(arr, pos+1);
        }
    }
}