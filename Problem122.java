class Problem121 {

    public static void main(String[] args) {
        Problem121 p = new Problem121();
        int[] nums = {1,4,2};
        System.out.println(p.maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        int minprice = prices[0];
        int buyer = minprice;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minprice > prices[i]) {
                profit += minprice-buyer;
                minprice = prices[i];
                buyer = minprice;
            } else {

            }
        }
        return profit;
    }
}