import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
//        String test = "3\n" +
//                      "6\n" +
//                      "because can do must we what\n" +
//                      "wedowhatwemustbecausewecan\n" +
//                      "2\n" +
//                      "hello planet\n" +
//                      "helloworld\n" +
//                      "3\n" +
//                      "ab abcd cd\n" +
//                      "abcd";
//        String test = "1\n" +
//                "2\n" +
//                "ab abc\n" +
//                "abc";
//        String test = "3\n" +
//                "4\n" +
//                "ozkxyhkcst xvglh hpdnb zfzahm\n" +
//                "zfzahm\n" +
//                "4\n" +
//                "gurwgrb maqz holpkhqx aowypvopu\n" +
//                "gurwgrb\n" +
//                "10\n" +
//                "a aa aaa aaaa aaaaa aaaaaa aaaaaaa aaaaaaaa aaaaaaaaa aaaaaaaaaa\n" +
//                "aaaaaaaaaab";
//        String test = "1\n" +
//                      "3\n" +
//                      "we wedo code\n" +
//                      "wedocode";
        String test = "2\n" +
                "10\n" +
                "a b c ab bc abc ca cab bca ac\n" +
                "abcacababcababccacacbccabaacabcaacaccabbcacabaccacabcababcacccbcaaccababcabcacabbacbccabbcabcabcaabcabacaabcacababcabcbccabcaabccaacabcabbcabccabcbccabbcbcabacabbcacabcabcabcabbbcaccacabcaacccacabcacabcabcbcacabbcabccabcccabacababcacbcacaacbcabcabbbabcaccabcabcacababcaabccaabacbcbcabcacabacabcabcaabcaaccaabbcaabccabbabcacbcabcbcabaababcbcbcbccabcaabbcababcaccacbcabbcaabccabbcbbcaabcaccababcabbcabcaabbbcaaccabcabababbcacaabcbcabcabcaaccabcabcabcabaabaaccabcbcaabcacbccaacccbccabcababcbcbcabcbcaacabcabcaacbaabcbbabcaabcacabccacabcbcacacbcabccabcbcacacacacabcababbbaabbcaabacbaccaacababbcaaabccacabcaabccaccacababccaacbcacabcbcacacaccaaccabcababcbabcacacbbcacbacababcbcacababcbcaabccaccababccccaabcabccacacbcaabbcaabcaacbaccacabcbcbcacacabcaaabcacacbcababcbcabbcabbbccaacbccccabcbcbcabcaaccbcabcabcacabcaabbcaabababbcaabccabcabcaacacabcacabacaabababcababccaabcccaabcbcacabaccaabcbabcbcacababcacacbccabacabaccbcaababcabbcaacbabcbcaccabccabbcacacbcabcacababccababcabacaccabbcacabcabbcacacabaccacbcacababbbacaabccacabcabbcacabccabbcbcaabcbcaccaacacabccacbcaaccaacababababcabcabccabcabccacacaacacbcabcbaabcabbcabcacaabccacabcaaaccababcaccabbcaabcababbcaabcabacabcabbcacabbcbacaacbcabcaabcbcabcabcabbabbcaaaccabacacabcbcabcabbccacbcababcbcabbcbcabbbbcababcabcaabcbcacacbaccabcbcaabcabaccaccababccabccaabcabaccabbcacbcabacaabcaabcabacbcbabcbcbabcabcbcacbcaabbcaabcccccabaabbccaabcaababbcbcabaccabcabcbcaacacbccabcaabccabbabababbcaabcbabcacabcaababcabcaabcbbababcacabbcbabcabcaababccaabcacacacabcaabcabcababcacaabcabcabcccaacbabcccabbcaabcbcaaabcabaaabbcacccabbccabccbcbcabbcacaabcaacccabbbcaabbcccbcabcbcababccabbcaacbcababababcabacbcacacababcbcabcbcabcabcaabccbacaccaacabcacacabcaacabbbcbcaaccacabcababcabbccbabcaacabcababcabbcbbabaabcbcababccaabcbcccbcabcbcbcaabccabbcaabcacccababcabccabaccabccbcaabacbabccaabcaaabbccacaacabcbcaacabcacaabcaabcabbcacbaabcbcaabcabcacababbcacabacabcabcabcaacbbacabcaacbcabcaaabcabacaaccbcabcabaccabcaccabbabcbcabcabcabccaabccabcabcbcabcaabbcacababccac\n" +
                "10\n" +
                "a b c ab bc abc ca cab bca ac\n" +
                "bcabcaabccababccabcbabbcacbcbacabccabbcbccbcacaccaccabbcababccabbcaabbccabcabacbcabacabcaabacabcbaccabbabbcacabcacabbcaccbcbcabcacbcbcaaccaacabcaacbcabcbccacaabacacabccbabaacacbabbcabcbcaabccabababbcaacabcabcabbcacaaababcabbcacabaabcbbaabaabcabcbccbcacacacbcacbcabcaabacababbccababccabcabccaccbcabcbccabbcacaabcabcabcabcabcabcabcabcabcababcabcaababcbcaabcaacacbcaacbcacabcaacaabacabcaabbcacababbaaabcaabbbcaabcabacbaababcacbcbcabccaaccacaabaababcabacbcacacbacbccacaabcacabccabbbcabcabccabababaccbcbcbcacacabbcaabcacabcbcabacbcacabcabccababacacabccabcacaabcabcbcabacabcacbcabcabacbbcabcacabaabcccabacbaccaabcabcabccacacabccabbcbaacabcbcabcababbccabcbcabacabccabcaacabcabccbabcacacbcacbaabcabcbaccabcabcacacabcababcaacabcbcaabcbcaccababbcaaaccabbbcacabbcbcaabbcaabcabcabccabcbcaabccacabcccaacbababbabcccaacbcbccaacabbcabcabacaacccaacaababcabcbcacabbcabacaabcbabacaccaaacababcbcabcabcabbacbaacbcabccacabcacbcabcabbcbbacbabbcacabbcacabbabbcacabacabbcabcabcaabcacabcacabbcaabcaabcacccabcaabccbcaabcacabbcacabccacacaccabaabcabcababcbcabbcaacbcbcabcababcbcbcacababababcabbcabccabacabbcaacacabacbccabcabcabcabccaacaccaacaccaccaabcabcabbcacacababcaaccaacababcacabcaabccbcaacabcaabcbcacbccabcaabcabcaccbccababcaccaabcbccabccabcbcababcabcabbcbabcaacababbcbcaabcbcaccacaabcabaabccabbccaaababacabcababbccbcabcabbcabbabbabcbcabababaccababcbcbcaccacabcbababcabcabcaabacbabcbbbcacabcabbccabcabacabbcabcabacabcacacabaccabacacabccabcaababcaccaabccaabacacabbccabababcacababccabbcabcaacacabbcaaabbaabcacababccbabcababbcacbcaabcbcaabcacaacababcabbcabcabbabaccabccacacabccabbccabcacbcabbbcababbcaaccbcabcbaabababaaacccbccabacbcaabcbccabbcacaaacabcabcababcbcabaacabaccabcabbcacacababcabacbcabcabcbcaabcababcaccabacacbcaacabcaccabcbcabcabcabaccabacbcabcaacbcaaabccacbcabcababaababcbcaaaabccababcabbbccababaabcbcaccacbcabcbcabcabcabccabcbcccababccababcccbcacacaaaacbccaacbcbcacbcaccabbcacacabcabaacbcabcbcccabaccaabccabbcabacbcbcacaaccbcabcabbbbacaaacabccabba";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static boolean pswFound;
    private static List<String> output;

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        output = new ArrayList<>();
        for (int a = 0; a < t; a++) {
            pswFound = false;
            int n = Integer.parseInt(in.readLine());
            String[] passes = in.readLine().split(" ");
            String attempt = in.readLine();
            checkPassword(passes, attempt, new StringBuilder(), new HashSet<>());
            if (!pswFound) {
                output.add("WRONG PASSWORD");
            }
        }
        for (int i = 0; i < output.size() && i < t; i++) {
            System.out.println(output.get(i));
        }
    }

    private static void checkPassword(String[] passes, String attempt, StringBuilder current, Set<String> notFitting) {
        for (String pass : passes) {
            if (pass.length() <= attempt.length() &&
                    pass.equals(attempt.substring(0, pass.length()))
                    && !notFitting.contains(pass) ) {
                String newMessage = attempt.substring(pass.length());
                current.append(pass);
                current.append(" ");
                if (newMessage.equals("")) {
                    output.add(current.toString().trim());
                    pswFound = true;
                    return;
                }
                checkPassword(passes, newMessage, current, notFitting);
                current.delete(current.length() - 1 - pass.length(), current.length());
                notFitting.add(pass);
            }
        }
    }
}