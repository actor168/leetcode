package leetcode.editor.cn;
//
// The demons had captured the princess (P) and imprisoned her in the bottom-rig
//ht corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D gri
//d. Our valiant knight (K) was initially positioned in the top-left room and must
// fight his way through the dungeon to rescue the princess. 
//
// The knight has an initial health point represented by a positive integer. If 
//at any point his health point drops to 0 or below, he dies immediately. 
//
// Some of the rooms are guarded by demons, so the knight loses health (negative
// integers) upon entering these rooms; other rooms are either empty (0's) or cont
//ain magic orbs that increase the knight's health (positive integers). 
//
// In order to reach the princess as quickly as possible, the knight decides to 
//move only rightward or downward in each step. 
//
// 
//
// Write a function to determine the knight's minimum initial health so that he 
//is able to rescue the princess. 
//
// For example, given the dungeon below, the initial health of the knight must b
//e at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN. 
//
// 
// 
// 
// -2 (K) 
// -3 
// 3 
// 
// 
// -5 
// -10 
// 1 
// 
// 
// 10 
// 30 
// -5 (P) 
// 
// 
// 
//
// 
//
// Note: 
//
// 
// The knight's health has no upper bound. 
// Any room can contain threats or power-ups, even the first room the knight ent
//ers and the bottom-right room where the princess is imprisoned. 
// 
// Related Topics 二分查找 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * DP 最优子结构是：
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;

        int[][] res = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (j == N - 1 && i == M - 1) { // P位置
                    res[i][j] = 1 - dungeon[i][j] <= 0 ? 1 : 1 - dungeon[i][j];
                } else if (j == N - 1) {
                    int v = res[i + 1][j] - dungeon[i][j];
                    res[i][j] = Math.max(v, 1);
                } else if (i == M - 1) {
                    int v = res[i][j + 1] - dungeon[i][j];
                    res[i][j] = Math.max(v, 1);
                } else {
                    int v = Math.min(res[i][j + 1], res[i + 1][j]) - dungeon[i][j];
                    res[i][j] = Math.max(v, 1);
                }
            }
        }

        return res[0][0] <= 0 ? 1 : res[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Test174 {

    public static void main(String[] args) {
        int[][] dungun = new int[][]{{1, -4, 5, -99}, {2, -2, -2, -1}};
        int res = new Solution().calculateMinimumHP(dungun);
        System.out.println(res);
    }
}