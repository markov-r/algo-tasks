import java.util.*;

public class Main {

    public static void main(String[] args) {
        for (String s_cobble : generateParenthesis(4)) {
            System.out.println(s_cobble);
        }
    }

    private static List<String> all;

    /** Standard backtracking solution
     *  Put an opening bracket when limit is not reached, 
     *  and put a closing bracket when there is an opened bracket that is not yet closed. */
    
    private static List<String> generateParenthesis(int n) {
        all = new ArrayList<>();
        if (n == 0) return all;
        bracketsGen(n, new StringBuilder("("), 1, 0); //1st char is always '('
        return all;
    }

    private static void bracketsGen(int n, StringBuilder sb, int opened, int closed) {
        if (sb.length() == 2 * n - 1) { //last char is always ')'
            sb.append(")");
            all.add(sb.toString());
            sb.setLength(sb.length() - 1);
            return;
        }
        if (opened < n) {   //opened limit not reached
            sb.append("(");
            bracketsGen(n, sb, opened + 1, closed);
            sb.setLength(sb.length() - 1);
        }
        if (closed < opened) {  //there is an open bracket that has not yet been closed
            sb.append(")");
            bracketsGen(n, sb, opened, closed + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}