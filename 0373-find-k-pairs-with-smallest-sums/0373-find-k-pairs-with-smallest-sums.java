import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        // Min Heap → [sum, i, j]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Step 1: initialize heap
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Step 2: extract k pairs
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[1];
            int j = cur[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // push next pair
            if (j + 1 < nums2.length) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return result;
    }
}