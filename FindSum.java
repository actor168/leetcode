class NumArray {

    private int[] arr;
    
    public NumArray(int[] nums) {
        arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            arr[i] = arr[i-1] + nums[i];        
        }
    }
    
    public int sumRange(int i, int j) {
        int left = 0;
        if (j < 0) {
            return 0;
        } 
        if ( i < 1) {
            left = 0;
        } else {
            left = arr[i-1];
        }
        return arr[j] - left;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}


public class FindSum{
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};

        NumArray obj = new NumArray(nums);

        obj.print();

        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(0,5));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,0));
        System.out.println(obj.sumRange(2,2));
        System.out.println(obj.sumRange(2,3));
        System.out.println(obj.sumRange(0,-1));
    }
}
