import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> result = new ArrayList<>();
        fillGraySB(new StringBuilder(), n, result);
        System.out.println(result);
    }

    static void fillGraySB(StringBuilder sb, int n, List<String> result) {
        if (sb.length() == n) {
//            result.add(sb.toString());
            System.out.println(sb.toString());
            return;
        }

        StringBuilder sb1 = new StringBuilder(sb);
        sb1.append("0");
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append("1");
        fillGraySB(sb1, n, result);
        fillGraySB(sb2, n, result);
    }

}
