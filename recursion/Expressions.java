//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.io.*;
import java.util.*;
import static java.lang.Character.isDigit;

public class Main {
    static final int NUM_OF_SIGNS = 4;
    static void fakeInput() {
        String test = "123\n" +
                      "6";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String number = in.readLine();
        int checkSum = Integer.parseInt(in.readLine());
        int[] numbers = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            numbers[i] = Integer.parseInt(number.charAt(i) + "");
        }

        String[] signs = new String[NUM_OF_SIGNS];
        signs[0] = "!";   signs[1] = "*";   signs[2] = "+";   signs[3] = "-";
        int r = numbers.length - 1;
        List<String> combination = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            combination.add("x");
        }
        List<String> signCombos = new ArrayList<>();
        getVariations(r, signs, 0, combination, signCombos);

        int count = 0;
        for (int i = 0; i < signCombos.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(numbers[0]);
            for (int j = 1; j < numbers.length; j++) {
                char currSign = signCombos.get(i).charAt(j-1);
                sb.append(currSign);
                sb.append(numbers[j]);
            }
            for (int k = 0; k < sb.length(); k++) {      // replace '!' back to ""
                if (sb.charAt(k) == '!') {
                    sb.deleteCharAt(k);
                }
            }
            if (!discardZeroStarting(sb)) {
                continue;
            }
            List<Integer> currNumbers = extractNumbersNew(sb.toString());
            List<Character> operations = extractOperations(sb.toString());
            if (calculate(operations, currNumbers) == checkSum) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void getVariations(int r, String[] signs, int index, List<String> combination, List<String> signCombos) {
        if (index == r) {
            signCombos.add(concatList(combination));
            return;
        }
        for (String s : signs) {
            combination.set(index, s);
            getVariations(r, signs, index + 1, combination, signCombos);
        }
    }

    private static List<Character> extractOperations(String s) {
        List<Character> operations = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) {
                operations.add(s.charAt(i));
            }
        }
        return operations;
    }

    private static String concatList(List<String> combinations) {
        StringBuilder sb = new StringBuilder();
        for (String s : combinations) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static List<Integer> extractNumbersNew(String str) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
            else {
                numbers.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            numbers.add(Integer.parseInt(sb.toString()));
        }
        return numbers;
    }

    private static boolean discardZeroStarting(StringBuilder sb) {
        StringBuilder sbNext = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (isDigit(sb.charAt(i))) {
                sbNext.append(sb.charAt(i));
            }
            else {
                sbNext.setLength(0);
            }
            if (sbNext.length() > 1 && sbNext.charAt(0) == '0') {
                return false;
            }
        }
       return true;
    }

    private static long calculate(List<Character> operations, List<Integer> numbers) {
        long result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (operations.get(i-1) == '*') {
                result *= numbers.get(i);
            }
            if (operations.get(i-1) == '-') {
                result -= numbers.get(i);
            }
            if (operations.get(i-1) == '+') {
                result += numbers.get(i);
            }
        }
        return result;
    }

//    private static boolean isInteger(String s) {
//        try {
//            Integer.parseInt(s);
//        } catch(NumberFormatException e) {
//            return false;
//        }
//        // only got here if we didn't return false
//        return true;
//    }

//    private static List<Integer> extractNumbersOld(String str) {
//        List<Integer> numbers = new ArrayList<>();
//        str = str.replaceAll("(?<=[A-Z])(?=[A-Z])|(?<=[a-z])(?=[A-Z])|(?<=\\D)$", "");
//        Pattern p = Pattern.compile("[a-z]+|\\d+");
//        Matcher m = p.matcher(str);
//        ArrayList<String> allMatches = new ArrayList<>();
//        while (m.find()) {
//            allMatches.add(m.group());
//        }
//
//        for (int i = 0; i < allMatches.size(); i++) {
//            if (isInteger(allMatches.get(i))) {
//                numbers.add(Integer.parseInt(allMatches.get(i)));
//            }
//        }
//        return numbers;
//    }
}