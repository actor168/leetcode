import java.util.ArrayList;
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};

        System.out.println(new PrintMatrix().printMatrix(matrix));
    }


    public ArrayList<Integer> printMatrix(int [][] matrix) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if (matrix.length <= 0) return res;

        int left = 0;
        int right = matrix[0].length-1;

        int top = 0;
        int bottom = matrix.length-1;

        if (right == 0 && bottom == 0) {
            res.add(matrix[0][0]);
            return res;
        }

        if (right == 0) {
            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]); // right
            return res;
        }
        // System.out.println(left + " " + right + " " + top + " " + bottom);
        
        while(left < right && top < bottom) { // 外圈嵌套
            // 循环一圈
            for(int i = left; i < right; i++) res.add(matrix[top][i]); // top
            for(int i = top; i < bottom; i++) res.add(matrix[i][right]); // right
            for(int i = right; i > left; i--) res.add(matrix[bottom][i]); //bottom
            for(int i = bottom; i > top; i--) res.add(matrix[i][left]);// left
            
            left++;
            right--;
            top++;
            bottom--;
        }

        //System.out.println(left + " " + right + " " + top + " " + bottom);


        if (left == right) {
            for(int i = top; i <= bottom; i++) res.add(matrix[i][left]); // right
        } else if (top == bottom) {
            for(int i = left; i <= right; i++) res.add(matrix[top][i]); // top
        }

        return res;
    }
}