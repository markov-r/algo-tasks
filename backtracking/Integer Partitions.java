
// generate the integer partitions of a given number.
// e.g. for n = 3:
//   3
//   2 1
//   1 1 1


import java.io.*;

public class Main {

    private static void partition(int n, int max, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = Math.min(max, n); i > 0; i--) {
            partition(n - i, i, prefix + " " + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        partition(n, n, "");
    }
}



//// OLD SOLUTION -> HAS REPETITIVE COMBINATIONS
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        List<String> result = new ArrayList<>();
//        List<Integer> current = new ArrayList<>();
//        partition(n, current, result);
////        result.sort(String::compareTo);
////        Set<String> resultSet = new HashSet<>(result);
//        result.forEach(System.out::println);
//    }
//
//    private static void partition(int n, List<Integer> current, List<String> result) {
//        if (sum(current) == n) {
////            if (!isMet(result, current)) {
//                result.add(current.toString());
////            }
//            return;
//        }
//        if (sum(current) > n) {
//            return;
//        }
//
//        for (int i = n; i > 0; i--) {
//            current.add(i);
//            partition(n, current, result);
//            current.remove((Integer) i);           // -> to force using remove(Object)
//        }
//
//    }
//
//    private static int sum(List<Integer> current) {
//        int sum = 0;
//        for (Integer i : current) {
//            sum += i;
//        }
//        return sum;
//    }
//
////    private static boolean isMet(List<List<Integer>> result, List<Integer> current) {
////        for (List<Integer> temp : result) {
////            boolean sameListIsMet = false;
////            for (int i : temp) {
////                if (Collections.frequency(temp, i) == Collections.frequency(current, i)) {
////                    sameListIsMet = true;
////                }
////                if (sameListIsMet && i == temp.size() - 1) {
////                    return true;
////                }
////
////            }
////        }
////        return false;
////    }
//
//
//}
