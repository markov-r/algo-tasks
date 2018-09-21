import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        OutputWriter writer = new OutputWriter();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String words[] = in.readLine().split(" ");
            String slogan = in.readLine();
            StringBuilder result = new StringBuilder();
            checkIfValid(words, slogan, new StringBuilder(), new HashSet<>(), result);
            if (result.length() == 0) {
                writer.printLine("NOT VALID");
            } else {
                writer.printLine(result);
            }
        }
        writer.close();
    }

    private static void checkIfValid(String[] words, String slogan, StringBuilder current, Set<String> faultyChecked, StringBuilder result) {
        if (slogan.length() == 0) {
            result.append(current);
            return;
        }

        for (String word : words) {
            if (faultyChecked.contains(slogan)) {
                continue;
            }
            if (!slogan.startsWith(word)) {
                continue;
            }
            String newMsg = slogan.substring(word.length());
            current.append(word).append(" ");
            checkIfValid(words, newMsg, current, faultyChecked, result);
            int wordLen = word.length() + 1;
            current.setLength(current.length() - wordLen);      // backtrack
        }
        faultyChecked.add(slogan);
    }

    static class OutputWriter {
        private final PrintWriter writer;

        OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        void close() {
            writer.close();
        }
    }
}


//import java.io.*;
//import java.util.*;
//import java.util.stream.*;
//
//public class Main {
//
//    private static List<String> result;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(in.readLine());
//        for (int i = 0; i < n; i++) {
//
//            String words[] = in.readLine().split(" ");
//            String slogan = in.readLine();
//
//            result = new ArrayList<>();
//            List<String> current = new LinkedList<>();
//            checkIfValid(slogan, words, current, new HashSet<>());
//
//            if (result.size() == 0) {
//                System.out.println("NOT VALID");
//            } else {
//                System.out.println(
//                        result.stream()
//                                .collect(Collectors.joining(" "))
//                );
//            }
//        }
//    }
//
//
//    private static void checkIfValid(String slogan, String[] words, List<String> current, Set<String> faultyChecked) {
//        if (slogan.length() == 0) {
//            result.addAll(current);
//            return;
//        }
//
//        for (String word : words) {
//            if (!slogan.startsWith(word)) {
//                continue;
//            }
//            if (faultyChecked.contains(slogan)) {
//                continue;
//            }
//            String newMsg = slogan.substring(word.length());
//            current.add(word);
//            checkIfValid(newMsg, words, current, faultyChecked);
//            current.remove(current.size() - 1);
//        }
//        faultyChecked.add(slogan);
//    }
//}