import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone(); // Initialize with original prices
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // While the current price is a valid discount for a previous item
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                result[index] -= prices[i];
            }
            stack.push(i);
        }
        
        return result;
    }
}