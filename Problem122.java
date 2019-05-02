class Problem122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = new Problem122().maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int buy_pos = 0;
        int sale_pos = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[sale_pos]) {
                //递增趋势
                sale_pos = i;
            } else { //递减趋势
                if (sale_pos > buy_pos) { 
                    profit += (prices[sale_pos] - prices[buy_pos]);
                }
                buy_pos = i;
                sale_pos = i;
            }
        }

        if (sale_pos > buy_pos) {
            profit += (prices[sale_pos] - prices[buy_pos]);
        } 
        return profit;
    }
}