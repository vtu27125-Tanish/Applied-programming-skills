import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        int n = names.length;

        // Step 1: Store (height, name) pairs
        List<int[]> indexList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexList.add(new int[]{heights[i], i});
        }

        // Step 2: Sort by height descending
        Collections.sort(indexList, (a, b) -> b[0] - a[0]);

        // Step 3: Build result using sorted indices
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[indexList.get(i)[1]];
        }

        return result;
    }
}
