class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;

        // First pass → remove extra ')'
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
                result.append(ch);
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                    result.append(ch);
                }
            } else {
                result.append(ch);
            }
        }

        // Second pass → remove extra '('
        StringBuilder finalResult = new StringBuilder();
        for (int i = result.length() - 1; i >= 0; i--) {
            char ch = result.charAt(i);
            if (ch == '(' && open-- > 0) {
                continue;
            }
            finalResult.append(ch);
        }

        return finalResult.reverse().toString();
    }
}