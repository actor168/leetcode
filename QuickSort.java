public class QuickSort {

    private int[] arr;

    public QuickSort(int[] a) {
        arr = a;
    }

    public int partition(int left, int right) {
        int i = left, j=right;
        while (i < j) {
            while (arr[i]<arr[j]) {
                i++;
            }
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;

            while (arr[j] > arr[i]) {
                j--;
            }

            tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
        
        return i;
    }

    public void quickSort(int left, int right) {
        if (left < right) {
            int pos = partition(left, right);
            quickSort(left, pos-1);
            quickSort(pos+1, right);
        }
    }

    public void sortString() {
        quickSort(0, arr.length-1);
        for (int var : arr) {
            System.out.print(var + ",");
        }
    }

    public static void main(String[] args) {
        int[] a = {9,8,3,5,4,2,7};
        QuickSort sort = new QuickSort(a);
        sort.sortString();
    }
}