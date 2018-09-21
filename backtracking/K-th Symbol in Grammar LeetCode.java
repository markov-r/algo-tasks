import java.io.*;
import java.util.*;

public class Main {

    public static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        result.add("0");
        System.out.println(kthGrammar(k, n));

    }

    public static int kthGrammar(int k, int n) {
        if (result.size() == n) {
            String lastRow = result.get(result.size() - 1);
            return lastRow.charAt(k-1);
        }
        String current = result.get(result.size() - 1);
        int len = current.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (current.charAt(i) == '0') {
                sb.append("01");
            }
            if (current.charAt(i) == '1') {
                sb.append("10");
            }
        }
        result.add(sb.toString());
        kthGrammar(k, n);
        String lastRow = result.get(result.size() - 1);
        return lastRow.charAt(k-1);
    }
}
