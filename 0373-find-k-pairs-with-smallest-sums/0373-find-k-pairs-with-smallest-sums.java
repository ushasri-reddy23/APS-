import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0) return result;

        // Min heap based on sum
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

        // Initialize heap with first column pairs
        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !heap.isEmpty()) {
            int[] current = heap.poll();
            int u = current[0];
            int v = current[1];
            int j = current[2];

            result.add(Arrays.asList(u, v));

            // Move to next element in nums2
            if (j + 1 < nums2.length) {
                heap.offer(new int[]{u, nums2[j + 1], j + 1});
            }
        }

        return result;
    }
}