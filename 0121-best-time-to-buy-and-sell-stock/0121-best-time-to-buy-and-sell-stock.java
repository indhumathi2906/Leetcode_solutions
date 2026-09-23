/**
 * 121. Best Time to Buy and Sell Stock
 *
 * Time Complexity: O(N) single pass over price list.
 * Space Complexity: O(1) constant auxiliary space.
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        // Single pass update
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
