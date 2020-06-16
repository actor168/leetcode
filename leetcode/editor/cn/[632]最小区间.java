package leetcode.editor.cn;
//You have k lists of sorted integers in ascending order. Find the smallest rang
//e that includes at least one number from each of the k lists. 
//
// We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c i
//f b-a == d-c. 
//
// 
//
// Example 1: 
//
// 
//Input: [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//Output: [20,24]
//Explanation: 
//List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
//List 2: [0, 9, 12, 20], 20 is in range [20,24].
//List 3: [5, 18, 22, 30], 22 is in range [20,24].
// 
//
// 
//
// Note: 
//
// 
// The given list may contain duplicates, so ascending order means >= here. 
// 1 <= k <= 3500 
// -105 <= value of elements <= 105. 
// 
// Related Topics 哈希表 双指针 字符串


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        // 从每个数组中的最小值开始，建立k个指针，分别指向当前的最小指所构成的区间

        // 需要先排序，将k个数组的每个元素按照从小到大排列
        int[] mins = new int[nums.size()];

        List<Pair> arr = new ArrayList<>();
        int p = 0;
        for (List<Integer> l : nums) {
            for (int v : l) {
                arr.add(new Pair(p, v));
            }
            p++;
        }
        arr.sort(Comparator.comparingInt(o -> o.val));

        int x = 0;
        int y = 0;

        int max = Integer.MAX_VALUE;

        int[] res = new int[2];
        int diff = 0;
        while (y < arr.size()) {
            diff += mins[arr.get(y).pos]++ == 0 ? 1 : 0;
            while (diff == nums.size() && x <= y) {
                int i = arr.get(x).val, j = arr.get(y).val;
                if (j - i < max) {
                    max = j - i;
                    res = new int[]{i, j};
                }

                if (--mins[arr.get(x).pos] == 0) {
                    --diff;
                }
                ++x;
            }
            y++;
        }

        // 找到mins中最大和最小的差
        return res;
    }

    class Pair {

        int pos;
        int val;

        Pair(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
