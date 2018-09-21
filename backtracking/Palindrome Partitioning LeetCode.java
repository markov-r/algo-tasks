import java.io.*;
import java.util.*;

public class Main {

    private static void fakeInput() {
        String test = "aabaa";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        List<List<String>> result = Solution.partition(input);
        System.out.println(result.size());
        System.out.println(result);
    }

    public static class Solution {
        static List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return result;
            }
            backTrack(s, new ArrayList<>(), result);
            return result;
        }

        static void backTrack(String s, List<String> list, List<List<String>> result) {
            if (s == null || s.length() == 0) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                String newStr = s.substring(0, i + 1);
                if (isPalindrome(newStr)) {
                    list.add(newStr);
                    backTrack(s.substring(i+1), list, result);
                    list.remove(list.size() - 1);
                }
            }
        }

        private static boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            int left = 0;
            int right = s.length() - 1;
            while (left <= right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }


}
