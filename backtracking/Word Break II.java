import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();

//        String str = "pineapplepenapple";
//        wordDict.add("apple");
//        wordDict.add("pen");
//        wordDict.add("applepen");
//        wordDict.add("pine");
//        wordDict.add("pineapple");

//        wordDict.add("cat"); wordDict.add("cats");
//        wordDict.add("and"); wordDict.add("sand");
//        wordDict.add("dog");
//        String str = "catsanddog";

//        String str = "alabala";
//        wordDict.add("al");
//        wordDict.add("abal");
//        wordDict.add("a");
//        wordDict.add("labal");

        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
                        wordDict.add("a");
                        wordDict.add("aa");
                        wordDict.add("aaa");
                        wordDict.add("aaaa");
                        wordDict.add("aaaaa");
                        wordDict.add("aaaaaa");
                        wordDict.add("aaaaaaa");
                        wordDict.add("aaaaaaaa");
                        wordDict.add("aaaaaaaaa");
                        wordDict.add("aaaaaaaaaa");


        List<String> cour = wordBreak(str, wordDict);
        for (String s : cour)
            System.out.println(s);
    }

    /** Basic backtracking with memoization
     *  The check if a split is possible is needed for the last test case,
     *  as otherwise memory and time limit error is met .*/

    private static List<String> sentences;
    private static Set<String> deadEnds;

    /** Solution to "Word Break" problem used to indicate if there is an available solution at all */
    
    private static boolean canBeMade(String str, List<String> wordDict, Set<String> deadEnds) {
        if (deadEnds.contains(str))
            return false;
        if (str.equals(""))
            return true;
        boolean canCutWord = false;
        for (String word : wordDict) {
            if (str.startsWith(word))
                canCutWord = canCutWord || canBeMade(str.substring(word.length()), wordDict, deadEnds);
        }
        deadEnds.add(str);
        return canCutWord;
    }

    private static List<String> wordBreak(String str, List<String> wordDict) {
        if (!canBeMade(str, wordDict, new HashSet<>()))
            return new ArrayList<>();
        sentences = new ArrayList<>();
        deadEnds = new HashSet<>();
        wordBreakRec(str, wordDict, new StringBuilder());
        return sentences;
    }

    private static void wordBreakRec(String str, List<String> wordDict, StringBuilder sb) {
        if (str.equals("")) {
            sentences.add(sb.toString().substring(0, sb.length() - 1));     //delete trailing " "
            return;
        }
        if (deadEnds.contains(str))
            return;
        for (String word : wordDict) {
            if (str.startsWith(word)) {
                sb.append(word).append(" ");
                wordBreakRec(str.substring(word.length()), wordDict, sb);
                sb.setLength(sb.length() - word.length() - 1);           //backtrack
            }
        }
        deadEnds.add(sb.toString());
    }
}