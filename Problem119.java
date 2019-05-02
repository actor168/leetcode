import java.util.ArrayList;
import java.util.List;

class Problem119 {
    public static void main(String[] args) {
        List<Integer> res = new Problem119().getRow(3);
        System.out.println(res);
    }

    public List<Integer> getRow(int rowIndex) {

        int[][] nums = new int[34][34];

        for (int i = 0; i <= rowIndex; i++) {
            nums[i][0] = 1;
            for (int j = 0; j < i; j++) {
                nums[i][j] = nums[i-1][j-1] + nums[i-1][j];
            }
            nums[i][i] = 1;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            res.add(nums[rowIndex][i]);
        }
        return res;
    }
}

/**
 * 
 * 1 
 * 1 1
 * 1 2 1
 * 1 3 3 1  
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 * 1 6 15 20 15 6 1
 * 
 * 1 n-1+1 n-1+n-1+1 
 * 
 */