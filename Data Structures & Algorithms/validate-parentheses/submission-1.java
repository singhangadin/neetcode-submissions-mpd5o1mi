class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);

            switch(alpha) {
                case '{':   stack.push(alpha);
                            break;

                case '[':   stack.push(alpha);
                            break;

                case '(':   stack.push(alpha);
                            break;

                case '}':   if (stack.empty()) {
                                return false;
                            }
                            if (stack.peek() == '{') {
                                stack.pop();
                            } else {
                                return false;
                            }
                            break;

                case ']':   if (stack.empty()) {
                                return false;
                            }
                            if (stack.peek() == '[') {
                                stack.pop();
                            } else {
                                return false;
                            }
                            break;

                case ')':   if (stack.empty()) {
                                return false;
                            }
                            if (stack.peek() == '(') {
                                stack.pop();
                            } else {
                                return false;
                            }
                            break;
                
                default: return false;
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
