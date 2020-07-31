//Given a binary matrix A, we want to flip the image horizontally, then invert i
//t, and return the resulting image. 
//
// To flip an image horizontally means that each row of the image is reversed. F
//or example, flipping [1, 1, 0] horizontally results in [0, 1, 1]. 
//
// To invert an image means that each 0 is replaced by 1, and each 1 is replaced
// by 0. For example, inverting [0, 1, 1] results in [1, 0, 0]. 
//
// Example 1: 
//
// 
//Input: [[1,1,0],[1,0,1],[0,0,0]]
//Output: [[1,0,0],[0,1,0],[1,1,1]]
//Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
// 
//
// Example 2: 
//
// 
//Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]
//.
//Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// 
//
// Notes: 
//
// 
// 1 <= A.length = A[0].length <= 20 
// 0 <= A[i][j] <= 1 
// 
// Related Topics 数组 
// 👍 175 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[][] flipAndInvertImage(int[][] A) {
        int M = A.length, N = A[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < (N + 1) / 2; j++) {
                int t0 = A[i][j];
                A[i][j] = 1 - A[i][N - 1 - j];
                A[i][N - 1 - j] = 1 - t0;
            }
        }

        return A;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
