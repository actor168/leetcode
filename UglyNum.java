import java.util.HashSet;

class UglyNum {
    public static void main(String[] args) {
        System.out.println(new UglyNum().GetUglyNumber_Solution(1000));
    }

    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        int p2=0,p3=0,p5=0;
        int[] dp = new int[index];
        dp[0] = 1;
        int cnt = 1;
        while (cnt < index) {
            dp[cnt] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[cnt] == dp[p2] * 2) p2++;
            if (dp[cnt] == dp[p3] * 3) p3++;
            if (dp[cnt] == dp[p5] * 5) p5++;
            cnt++;
        }
        return dp[index-1];
    }
    
}
