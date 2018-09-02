import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String[] arr = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(arr));
    }

    public static int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack<>();
        for (String str: ops) {
            switch (str) {
                case "+":
                    int top = stack.pop();
                    int secondTop = stack.pop();
                    stack.push(secondTop);
                    stack.push(top);
                    stack.push(top + secondTop);
                    break;
                case "D":
                    int previous = stack.peek();
                    stack.push(2 * previous);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(str));
            }
        }
        int sum = 0;
        for (Integer i : stack) {
            sum += i;
        }
    return sum;
    }
}
