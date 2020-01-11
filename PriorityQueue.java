
public class PriorityQueue {

    /**
     * 优先级队列：用于共享计算机系统中的作业调度
     * 主要方法：
     * （1）Insert
     * （2）Maximum
     * （3）Extract-Max
     * （4）Increase-Key
     */
    private int LEN = 0;

    private int[] arr;

    public PriorityQueue(int[] a) {
        if (a.length > 0 ) {
            arr = a;
            LEN = arr.length;
        } else {
            arr = new int[8];
        }
        
    }

    public int length() {
        return LEN;
    }

    public boolean insert(int value) {
        if (arr.length == LEN) {
            int[] arr_tmp = new int[ 2 * arr.length ];
            int pos = 0;
            for (int var : arr) {
                arr_tmp[pos++] = var;
            }
            arr = arr_tmp;
        }
        if (LEN == 0) {
            arr[0] = value;
        } else {
            int tmp = arr[0];
            arr[0] = value;
            arr[LEN] = tmp;

            adjust(arr, 0);
        }
        LEN++;
        return true;
    }

    public int maximum() {
        return arr[0];
    }

    public int extractMax() {
        if (this.LEN <= 0) {
            return -1;
        }
        int max = arr[0];
        arr[0] = arr[LEN-1];
        LEN--;
        adjust(arr, 0);
        return max;
    }

    public boolean increaseKey(int pos, int value) {
        if ( pos > LEN ) {
            return false;
        }
        arr[pos] = value;
        int parent = pos / 2; 
        while ( (pos != parent) && (arr[pos] > arr [parent])) {
            int tmp = arr[pos];
            arr[pos] = arr[parent];
            arr[parent] = tmp;
            pos = parent;
            parent = parent /2;
        }
        return true;
    }

    private void adjust(int[] arr, int pos) {
        
        int left = 2 * pos + 1;
        int right = 2 * (pos + 1);

        int large = pos;

        if (left < LEN && arr[left] > arr[pos]) {
            large = left;
        }

        if (right < LEN && arr[right] > arr[large]) {
            large = right;
        }

        if (large != pos) {
            int tmp = arr[large];
            arr[large] = arr[pos];
            arr[pos] = tmp;
            adjust(arr, large);
        }
    }

    public static void main(String[] args) {
        int[] a = {};
        PriorityQueue queue = new PriorityQueue(a);
        queue.insert(8);
        queue.insert(5);
        queue.insert(4);
        queue.increaseKey(2, 10);
        System.out.println(queue.extractMax());
        System.out.println(queue.maximum());
    }
}