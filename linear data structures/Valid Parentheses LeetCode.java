import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(isValid("["));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '{') {
                stack.push(current);
            }
            if (current == '(') {
                stack.push(current);
            }
            if (current == '[') {
                stack.push(current);
            }
            if (current == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char prev = stack.pop();
                    if (prev != '{') {
                        return false;
                    }
                }
            }
            if (current == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char prev = stack.pop();
                    if (prev != '(') {
                        return false;
                    }
                }
            }
            if (current == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char prev = stack.pop();
                    if (prev != '[') {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
