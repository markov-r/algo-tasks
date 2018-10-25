import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
//        String test = "1 2 3\n" +
//                "1 1";
//        String test = "1 2\n" +
//                "1 2 3";
//        String test = "1 2 3 4 5\n" +
//                "1 1 1 1 3";
        String test = "5 3\n" +
                "2 3 4 100";  //1 1 1 1 1 1 1 2 3 4 1 1 1 2 3 4 1
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] gg = in.readLine().split(" ");
        String[] ss = in.readLine().split(" ");
        int[] g = new int[gg.length];
        int[] s = new int[ss.length];
        for (int i = 0; i < gg.length; i++) {
            g[i] = Integer.parseInt(gg[i]);
        }
        for (int i = 0; i < ss.length; i++) {
            s[i] = Integer.parseInt(ss[i]);
        }
        System.out.println(findContentChildren(g, s));
    }

    private static int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int count = 0;
        for (int child : g) {
            if (j >= s.length) {
                return count;
            }
            if (child <= s[j]) {
                count++;
                j++;
            } else {
                int k;
                for (k = j; k < s.length; k++) {
                    if (child <= s[k]) {
                        count++;
                        break;
                    }
                }
                j = k + 1;
            }
        }
        return count;
    }
}