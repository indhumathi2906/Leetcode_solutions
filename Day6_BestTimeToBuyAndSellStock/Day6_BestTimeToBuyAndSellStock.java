/**
 * Day 6: 121. Best Time to Buy and Sell Stock (LeetCode #121)
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class Day6_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
