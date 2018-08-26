import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static List<Integer> numbers = new ArrayList<>();


//    static void fakeInput() {
//        String test = "2{z10{xy}}";
////        String test = "a3{cd2{a}f}ef";
//        System.setIn(new ByteArrayInputStream(test.getBytes()));
//    }

    public static void main(String[] args) throws IOException {
//        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String initialSequence = in.readLine();

        String sequenceNoBracketsO = initialSequence.replaceAll("\\{", "");
        String seqNoBracks = sequenceNoBracketsO.replaceAll("\\}", "");      // "a3cd2afef"
        seqNoBracks = seqNoBracks.replaceAll("(?<=[A-Z])(?=[A-Z])|(?<=[a-z])(?=[A-Z])|(?<=\\D)$", "");
        Pattern p = Pattern.compile("[a-z]+|\\d+");
        Matcher m = p.matcher(seqNoBracks);
        ArrayList<String> allMatches = new ArrayList<>();
        while (m.find()) {
            allMatches.add(m.group());
        }

        for (int i = 0; i < allMatches.size(); i++) {
            if (isInteger(allMatches.get(i))) {
                numbers.add(Integer.parseInt(allMatches.get(i)));
            }
        }
        String sequence = initialSequence.replaceAll("\\d", "");
//        System.out.println(sequence);
//        System.out.println(Arrays.toString(allMatches.toArray()));
//        System.out.println(Arrays.toString(numbers.toArray()));
//        System.out.println(Arrays.toString(bracketIndexes.toArray()));


        while (true) {

            int opening = Integer.MIN_VALUE;
            int closing = Integer.MIN_VALUE;
            int index = -1;
            List<Integer> bracketIndexes = new ArrayList<>();
            for (int i = 0; i < sequence.length(); i++) {
                if (sequence.charAt(i) == '{') {
                    bracketIndexes.add(i);
                }
            }
            for (int i = 0; i < sequence.length(); i++) {

                if (sequence.charAt(i) == '}') {
                    closing = i;
                    opening = findItsOpening(sequence, i);
                    index = findIndexInNumbers(opening, numbers, bracketIndexes, sequence);
                    break;
                }
            }
            if (closing == Integer.MIN_VALUE) {
                break;
            }

            StringBuilder newSeqSB = new StringBuilder();
            newSeqSB.append(sequence, 0, opening);
            String inBrackets = sequence.substring(opening + 1, closing);
            String multiplied = concatStrings(numbers.get(index), inBrackets);
            numbers.remove(index);
            newSeqSB.append(multiplied);
            newSeqSB.append(sequence, closing + 1, sequence.length());
            sequence = newSeqSB.toString();
            if (numbers.isEmpty()) {
                break;
            }
        }
        System.out.println(sequence);
    }

    private static int findIndexInNumbers(int opening, List<Integer> numbers, List<Integer> brackets, String sequence) {
        for (int i = 0; i < brackets.size(); i++) {
            if (opening == brackets.get(i)) {
                return i;
            }
        }
        return -1;
    }

    private static String concatStrings(int times, String bla) {
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i < times; i++) {
            concat.append(bla);
        }
        return concat.toString();
    }

    private static int findItsOpening(String sequence, int i) {
        for (int c = i; c > -1; c--) {
            if (sequence.charAt(c) == '{') {
                return c;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}