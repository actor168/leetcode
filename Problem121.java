class Problem121 {

    public static void main(String[] args) {
        Problem121 p = new Problem121();
        int[] nums = {1,4,2};
        System.out.println(p.maxProfit(nums));
    }

    public int maxProfit1(int[] prices) {
        int max = Integer.MIN_VALUE;
        for (int i = prices.length-1; i > 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                int profit = prices[i]-prices[j];
                max = profit > max ? profit: max;
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}