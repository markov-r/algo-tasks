public class Main {

    /** Find on which index the needle is met in the haystack. */
    public static void main(String[] args) {
//        System.out.println(strStr("barbalen", "bal"));
        System.out.println(strStr("xabananananasan", "ananas"));
    }


    /** The matching is done using the partial match table (PMT), see below function.
     *  In the naive algorithm when we don't find a match we have to revert
     *  back to the beginning of the small "needle" string.
     *  In this case, using the partial match table we revert only as much as
     *  needed and not more. */
    
    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() <= haystack.length()) {
            int[] pmt = partialMatchTable(needle.toCharArray());
            int i = 0, j = 0;
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {   //if match => advance in both strings
                    i++; j++;
                    if (j == needle.length())
                        return i - j;
                }
                else if (j > 0)     //if no match and not at start, move according to PMT
                    j = pmt[j];     //the key of the algorithm
                else                
                    i++;
            }
        }
        return -1;
    }

    /** Partial Match Table PMT (a.k.a. failure function)
     *  Each index of the array represents the string up to this index.
     *  The PMT for each index shows from all possible prefixes and suffixes
     *  up to the current index, which is the longest common one.
     *  E.g. for "alabala" all possible prefixes are:
     *  "alabal", "alaba", "alab", "ala", "al", "a".
     *  All possible suffixes are:
     *  "labala", "abala", "bala", "ala", "la", "a".
     *  So the longest common string is "ala" 
     *  and we write len=3 in the array. */

    private static int[] partialMatchTable(char[] str) {
        int[] pmt = new int[str.length + 1];
        for (int i = 2; i < pmt.length; i++) {
            int j = pmt[i - 1];
            while (j > 0 && str[j] != str[i-1]) 
                j = pmt[j];
            if (j > 0 || str[j] == str[i-1]) 
                pmt[i] = j + 1;
        }
        return pmt;
    }
}