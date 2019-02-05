import java.util.*;
public class Main {

    public static void main(String[] args) {
//        System.out.println(reorganizeString("aaabc"));
//        System.out.println(reorganizeString("datigotura"));
//        System.out.println(reorganizeString("aaaabc"));
//        System.out.println(reorganizeString("aaaabbbc"));
//        System.out.println(reorganizeString("aaaaabbbc"));
//        System.out.println(reorganizeString("aaabbbccc"));
//        System.out.println(reorganizeString("aaabcccc"));
//        System.out.println(reorganizeString("aabb"));
//        System.out.println(reorganizeString("aaabccc"));
//        System.out.println(reorganizeString("aaabcccc"));
//        System.out.println(reorganizeString("aac"));
//        System.out.println(reorganizeString("aaaacccb"));
//        System.out.println(reorganizeString("babati"));
//        System.out.println(reorganizeString("a"));
//        System.out.println(reorganizeString("aa"));
        System.out.println(reorganizeString("aaa"));
//        System.out.println(reorganizeString("baa"));
    }

    /** Fill a map with all characters in the string and their count
     *  Check if most frequent char is not too frequent - e.g. "aaab" is NOT OK, "aab" is OK
     *  Add all characters and their count in a binary heap (Priority Queue)
     *  Then start popping the items with max count from the top of the heap
     *  and when there is no duplication of consecutive characters add them
     *  to the resulting string */

    private static String reorganizeString(String str) {
        if (str.equals("")) return "";
        int len = str.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(str.charAt(i))) map.put(str.charAt(i), 1);
            else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                max = Math.max(max, map.get(str.charAt(i)));
            }
        }

        int addition = len % 2 == 0 ? 0 : 1;
        if (max > (len + addition) / 2) return "";      //max count check

        Queue<CharCount> heap = new PriorityQueue<>(new IntComparator());
        for (Character c : map.keySet()) {
            heap.add(new CharCount(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        CharCount ccFirst = heap.poll();        //get the char with max count first
        sb.append(ccFirst.character);
        if (ccFirst.count > 1)
            heap.add(new CharCount(ccFirst.character, ccFirst.count - 1));

        while (heap.size() > 0) {
            CharCount cc = heap.poll();
            if (cc.character == sb.charAt(sb.length() - 1) && heap.size() > 0) {  //if last char is the same as the current
                    CharCount cc2 = heap.poll();                                  //pop next char
                    sb.append(cc2.character);
                    if (cc2.count > 1) heap.add(new CharCount(cc2.character,cc2.count - 1));
                    heap.add(cc);
                    continue;
            }
            sb.append(cc.character);
            if (cc.count > 1) heap.add(new CharCount(cc.character, cc.count - 1));
        }
        return sb.toString();
    }

    private static class CharCount {
        char character;
        int count;

        CharCount(char c, int count) {
            this.character = c;
            this.count = count;
        }
    }

    private static class IntComparator implements Comparator<CharCount> {
        @Override
        public int compare(CharCount c1, CharCount c2) {
            return Integer.compare(c2.count, c1.count);
        }
    }
}
