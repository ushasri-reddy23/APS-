import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Square each element
        for (int i = 0; i < n; i++) {
            result[i] = nums[i] * nums[i];
        }

        // Step 2: Sort the squared array
        Arrays.sort(result);

        return result;
    }
}