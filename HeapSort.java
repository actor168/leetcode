public class HeapSort {
    private static int size = 0;
    public static void main(String[] args) {
        int arr[] = {1,3,10,4,2,6,7,5,9,8};
        size = arr.length -1;
        heapSort(arr);
        for (int var : arr) {
             System.out.print(var + ",");
        }
        System.out.println();
    }

    static void buildMaxHeap(int[] arr, int pos) {
        for (int i = pos / 2; i >= 0; i--) {
            adjust(arr, i);
        }
    }

    static void adjust(int[] arr, int pos) {
        int left = 2 * pos + 1;
        int right = 2 * (pos + 1);

        int large = pos;

        if ((left <= size ) && (arr[left] > arr[pos])) {
            large = left;
        }

        if ((right <= size ) && (arr[right] > arr[large])) {
            large = right;
        }

        if (pos != large) {
            int tmp = arr[large];
            arr[large] = arr[pos];
            arr[pos] = tmp;
            adjust(arr, large);
        }
    }

    static void heapSort(int[] arr) {
        buildMaxHeap(arr, arr.length - 1);
       
        for (int i = arr.length - 1; i >= 0 ; i--) {
             int tmp  = arr[0];
             arr[0] = arr[i];
             arr[i] = tmp;
             size--;
             adjust(arr, 0);
         }
    }
}