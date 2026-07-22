public class program {
    public int longestValidParentheses(String s) {
        int maxLen = 0;

        // Left to right
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

       
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLen;
    }


    public int longestValidParenthesesStack(String s) {
        int maxLen = 0;
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
        stack.push(-1); 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // new base for future invalid position
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        program solver = new program();

        String[] inputs = {"(()", ")()())", "", "()(()", "()(())", "(((((", ")))))", "()()()"};
        int[] expected = {2, 4, 0, 2, 6, 0, 0, 6};

        for (int i = 0; i < inputs.length; i++) {
            int result = solver.longestValidParentheses(inputs[i]);
            String status = (result == expected[i]) ? "PASS" : "FAIL";
            System.out.printf("%s: input=%-10s expected=%-3d got=%d%n",
                    status, "\"" + inputs[i] + "\"", expected[i], result);
        }
    }
}