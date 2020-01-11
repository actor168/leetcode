import java.util.*;

class Problem20 {
    public static void main(String[] args) {
        System.out.println(new Problem20().isValid("{}[(])"));
    }

    public boolean isValid(String s) {
        if (s.length() <= 0) return true;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        char cur = s.charAt(i);
        while(( cur = s.charAt(i) )!= '\0') {
            switch (cur) {
                case ']':
                    if (stack.isEmpty()) return false;
                    char c = stack.pop();
                    if (c != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty()) return false;
                    c = stack.pop();
                    if (c != '{') return false;
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    c = stack.pop();
                    if (c != '(') return false;
                    break;
                default:
                    stack.push(cur);
            } 
            ++i;
            if (i == s.length()) {
                break;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}