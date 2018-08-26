import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        List<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            permutation.add(0);
        }
        permutate (n, 0, permutation, new HashSet<>());
    }

    private static void permutate (int n, int index, List<Integer> permutation, HashSet<Integer> used) {
        if (index == n) {
            printSequence(permutation);
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (used.contains(i)) {
                continue;
            }
            used.add(i);
            permutation.set(index, i);
            permutate(n, index + 1, permutation, used);
            used.remove(i);
        }
    }

    private static void printSequence (List<Integer> permutation) {
        permutation.forEach(number -> System.out.print(number + " "));
        System.out.println();
    }
}



//
//   PERMUTATIONS OF A STRING
//
//
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Main {
//
//    //Steps to generate the next higher permutation:
//    //
//    //1. Take the previously printed permutation and find the rightmost character in it, which is smaller than its next character.
//    //Let us call this character as ‘first character’.
//    //
//    //2. Now find the ceiling of the ‘first character’. Ceiling is the smallest character on right of ‘first character’, which is greater than ‘first character’.
//    // Let us call the ceil character as ‘second character’.
//    //
//    //3. Swap the two characters found in above 2 steps.
//    //
//    //4. Sort the substring (in non-decreasing order) after the original index of ‘first character’.
//    //
//    //Let us consider the string “ABCDEF”. Let previously printed permutation be “DCFEBA”. The next permutation in sorted order should be “DEABCF”.
//    // Let us understand above steps to find next permutation. The ‘first character’ will be ‘C’. The ‘second character’ will be ‘E’.
//    // After swapping these two, we get “DEFCBA”. The final step is to sort the substring after the character original index of ‘first character’. Finally, we get “DEABCF”.
//    //
//    //https://www.geeksforgeeks.org/lexicographic-permutations-of-string/
//
//    static void Permutate (List<Integer> numbers, int n) {
//        int first = Integer.MIN_VALUE;
//        int firstIndex = Integer.MIN_VALUE;
//        int second = Integer.MIN_VALUE;
//        boolean lastPermutationReached = true;
//
////      FIND FIRST and its index
//        for (int i = n - 1; i >= 1; i--) {
//            if (numbers.get(i) < numbers.get(i+1)) {
//                first = numbers.get(i);
//                firstIndex = i;
//                lastPermutationReached = false;
//                break;
//            }
//        }
//
////      IF NO FIRST -> the permutation end is reached
//        if (lastPermutationReached) {
//            return;
//        }
//
////      FIND SECOND
//        List<Integer> list = new ArrayList<>();
//        for (int j = firstIndex + 1; j <= n; j++) {
//            if (numbers.get(j) > first) {
//                list.add(numbers.get(j));
//            }
//        }
//
//        Collections.sort(list);
//        second = list.get(0);
//        list.clear();
//
//
////      SWAP first and second in the list
//        Swap (first, second, numbers, n);
//
////      SORT from first till the end of list
//        Collections.sort(numbers.subList(firstIndex + 1, n + 1));
//
////      PRINT the list
//        PrintNumbers(numbers, n);
//
////      RECURSIVELY PROCEED WITH THE NEXT PERMUTATION
//        Permutate (numbers, n);
//
//    }
//
//        public static void main(String[] args) throws IOException {
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            int n = Integer.parseInt(in.readLine());
//            List<Integer> numbers = new ArrayList<>();
//            for (int i = 0; i <= n; i++) {
//            numbers.add(i);
//            }
//
//            PrintNumbers(numbers, n);
//            Permutate (numbers, n);
//        }
//
//        private static void PrintNumbers(List<Integer> numbers, int n) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 1; i <= n; i++) {
//             sb.append(numbers.get(i));
//             sb.append(" ");
//            }
//            System.out.println(sb.toString().trim());
//        }
//
//        public static void Swap (int a, int b, List<Integer> numbers, int n) {
//            int iA = Integer.MIN_VALUE;
//            int iB = Integer.MIN_VALUE;
//            for (int i = 1; i <= n; i++) {
//                 if (numbers.get(i) == a) {
//                 iA = i;
//                 }
//                if (numbers.get(i) == b) {
//                 iB = i;
//                }
//            }
//         numbers.set(iA, b);
//         numbers.set(iB, a);
//        }
//    }
