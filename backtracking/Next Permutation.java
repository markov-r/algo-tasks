import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String numbersStr[] = in.readLine().split(" ");
        List<Integer> permutation = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int currentMember = Integer.parseInt(numbersStr[i]);
            permutation.add(currentMember);
//            used.add(currentMember);
        }


//        List<Integer> permutation = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            permutation.add(0);
//        }
        permutate (n, 0, permutation, used);
    }

    private static void permutate (int n, int index, List<Integer> permutation, Set<Integer> used) {
        if (index == n) {
            printSequence(permutation);
            System.exit(0);
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
// PREVIOUS SOLUTION
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
//    private static int n;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(in.readLine());
//        String numbersStr[] = in.readLine().split(" ");
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(0);
//        for (int i = 1; i <= n; i++) {
//            numbers.add(Integer.parseInt(numbersStr[i-1]));
//        }
//
//        int first = Integer.MIN_VALUE;
//        int firstIndex = Integer.MIN_VALUE;
//        int second = Integer.MIN_VALUE;
//        boolean lastPermutationReached = true;
//
////      FIND FIRST and its index
//        for (int i = n - 1; i >= 1; i--) {
//            if (numbers.get(i).compareTo(numbers.get(i+1)) < 0) {
//                first = numbers.get(i);
//                firstIndex = i;
//                lastPermutationReached = false;
//                break;
//            }
//        }
//
////      IF NO FIRST -> the permutation end is reached
//        if (lastPermutationReached) {
//            PrintNumbers(numbers);
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
//        Swap (first, second, numbers);
//
////      SORT from first till the end of list
//        Collections.sort(numbers.subList(firstIndex + 1, n + 1));
//
////      PRINT the list
//        if (!lastPermutationReached) {
//            PrintNumbers(numbers);
//        }
//    }
//
//    private static void PrintNumbers(List<Integer> numbers) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            sb.append(numbers.get(i));
//            sb.append(" ");
//        }
//        System.out.println(sb.toString().trim());
//    }
//
//    public static void Swap (int a, int b, List<Integer> numbers) {
//        int iA = Integer.MIN_VALUE;
//        int iB = Integer.MIN_VALUE;
//        for (int i = 1; i <= n; i++) {
//            if (numbers.get(i) == a) {
//                iA = i;
//            }
//            if (numbers.get(i) == b) {
//                iB = i;
//            }
//        }
//        numbers.set(iA, b);
//        numbers.set(iB, a);
//    }
//
//}
