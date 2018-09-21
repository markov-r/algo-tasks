//DONCHO'S SOLUTION - SLOW AND 2 WRONG ANSWERS
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int numOfBluzi = Integer.parseInt(in.readLine());
//        String poliStr = in.readLine();
//        char[] poliArr = poliStr.toCharArray();
//        Arrays.sort(poliArr);
//        String poli = new String(poliArr);
//        int numOfGirls = Integer.parseInt(in.readLine());
//
//        List<List<Integer>> bluziCombos = new ArrayList<>();
//        getNumCombinations(0, 0, numOfGirls, numOfBluzi, new Integer[numOfGirls], bluziCombos);
//        List<List<Character>> poliCombos = new ArrayList<>();
//        getStrVariations(0, poli, numOfGirls, new Character[numOfGirls], poliCombos, new HashSet<>());
//        List<String> output = combineAll(bluziCombos, poliCombos, numOfGirls);
//        System.out.println(output.size());
//        output.sort(String::compareTo);
//        for (String s : output) {
//            System.out.println(s);
//        }
//    }
//
//    private static void getNumCombinations(int next, int index, int numOfGirls, int numOfBluzi, Integer[] combination, List<List<Integer>> bluziCombos) {
//        if (index == numOfGirls) {
//            List<Integer> list = new ArrayList<>(Arrays.asList(combination));
//            bluziCombos.add(list);
//            return;
//        }
//        for (int i = next; i < numOfBluzi; i++) {
//            combination[index] = i;
//            getNumCombinations(i + 1,index + 1, numOfGirls, numOfBluzi, combination, bluziCombos);
//        }
//    }
//
//    private static void getStrVariations(int index, String skirts, int k, Character[] variation, List<List<Character>> poliCombos, HashSet<Integer> used) {
//        if (index == k) {
//            poliCombos.add(new ArrayList<>(Arrays.asList(variation)));
//            return;
//        }
//
//        for (int i = 0; i < skirts.length(); i++) {
//            if (used.contains(i) ||
//                    (variation[index] != null &&
//                            variation[index].equals(skirts.charAt(i)))) {
//                continue;
//            }
//            variation[index] = skirts.charAt(i);
//            used.add(i);
//            getStrVariations(index + 1, skirts, k, variation, poliCombos, used);
//            used.remove(i);
//        }
//    }
//
//    private static List<String> combineAll(List<List<Integer>> bluziCombos, List<List<Character>> poliCombos, int numOfGirls) {
//        List<String> output = new ArrayList<>();
//        for (List<Integer> bluza : bluziCombos) {
//            for (List<Character> pola : poliCombos) {
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < numOfGirls; i++) {
//                    sb.append(bluza.get(i));
//                    sb.append(pola.get(i));
//                    sb.append("-");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                output.add(sb.toString());
//            }
//        }
//        return output;
//    }
//}


//KRASI SOLUTION - FAST AND WORKING

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();

        int k = reader.readInt();
        String symbols = reader.readLine();
        int girls = reader.readInt();

        char[] letters = new char[symbols.length()];
        for (int i = 0; i < symbols.length(); i++) {
            letters[i] = symbols.charAt(i);
        }

        Arrays.sort(letters);

        ArrayList<StringBuilder> combinations = new ArrayList<>(girls);
        for (int i = 0; i < girls; i++) {
            combinations.add(new StringBuilder());
        }

        generateWays(k, letters, girls, combinations, 0, new HashSet<>(), 0, new StringBuilder(), new StringBuilder());

        writer.printLine(set.size());
        for (String combination :
                set) {
            writer.printLine(combination);
        }

        writer.close();
    }

    private static TreeSet<String> set = new TreeSet<>();

    private static void generateWays(int k, char[] letters, int girls, ArrayList<StringBuilder> combinations, int index, HashSet<Integer> indexUsed, int s, StringBuilder dress, StringBuilder result) {
        if (index == girls) {
            for (int i = 0; i < combinations.size() - 1; i++) {
                result.append(combinations.get(i)).append('-');
            }
            result.append(combinations.get(combinations.size() - 1));
            set.add(result.toString());
            return;
        }

        for (int i = s; i < k; i++) {
            dress.append(i);
            for (int j = 0; j < letters.length; j++) {
                if (indexUsed.contains(j)) {
                    continue;
                }
                dress.append(letters[j]);
                indexUsed.add(j);
                combinations.set(index, dress);

                generateWays(k, letters, girls, combinations, index + 1, indexUsed, s + 1, new StringBuilder(), new StringBuilder());

                indexUsed.remove(j);
                dress.deleteCharAt(dress.length() - 1);
            }
            dress.deleteCharAt(dress.length() - 1);
            s++;
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.' && c != ',') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.' || c == ',') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
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