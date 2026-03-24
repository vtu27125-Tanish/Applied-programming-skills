class Solution {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        // Step 1: remove invalid ')'
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
                sb.append(ch);
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                    sb.append(ch);
                }
            } else {
                sb.append(ch); // letters
            }
        }

        // Step 2: remove extra '(' from right
        StringBuilder result = new StringBuilder();
        int extraOpen = open;

        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);

            if (ch == '(' && extraOpen > 0) {
                extraOpen--; // skip it
            } else {
                result.append(ch);
            }
        }

        return result.reverse().toString();
    }
}