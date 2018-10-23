import java.io.*;
import java.util.*;
import java.lang.Integer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if (frequencies.containsKey(currChar)) {
                frequencies.put(currChar, frequencies.get(currChar) + 1);
            } else {
                frequencies.put(currChar, 1);
            }
        }

        for (Character character : frequencies.keySet()) {
            System.out.println(character + " -> is met " + frequencies.get(character) + " times");
        }

        Queue<Pair<Integer, HuffmanTreeNode>> queue = new PriorityQueue<>();   //priority queue is backed by min heap by default (the natural order), otherwise (for e.g. max heap) we need to use a custom comparator and use it when initializing the PriorityQueue
        for (char c : frequencies.keySet()) {
            queue.offer(new Pair<>(frequencies.get(c), new HuffmanTreeNode(c)));
        }

        while (queue.size() > 1) {
            Pair x = queue.poll();
            Pair y = queue.poll();
            int newVal = (int) (x.getKey()) + (int) (y.getKey());
            HuffmanTreeNode treeOne = (HuffmanTreeNode) x.getValue();
            HuffmanTreeNode treeTwo = (HuffmanTreeNode) y.getValue();
            queue.offer(new Pair<>(newVal, new HuffmanTreeNode(treeOne, treeTwo)));
        }
        Pair root = queue.poll();
        HuffmanTreeNode htn = (HuffmanTreeNode) root.getValue();
        htn.dfs();
    }

    public static class HuffmanTreeNode {
        private HuffmanTreeNode left;
        private HuffmanTreeNode right;
        private char symbol;

        HuffmanTreeNode(char symbol) {
            this.symbol = symbol;
            this.left = null;
            this.right = null;
        }

        HuffmanTreeNode(HuffmanTreeNode left, HuffmanTreeNode right) {
            this.left = left;
            this.right = right;
        }

        void dfs() {
            this.dfs("");
        }

        private void dfs(String str) {
            if (this.symbol != '\u0000') {        // '\u0000' -> default value for char
                System.out.println(this.symbol + " -> " + str);
            } else {
                this.left.dfs(str + "0");
                this.right.dfs(str + "1");
            }
        }
    }

    public static class Pair<Integer,HuffmanTreeNode> implements Comparable{
        private Integer key;
        private HuffmanTreeNode value;

        Integer getKey() { return key; }
        HuffmanTreeNode getValue() { return value; }

        Pair(Integer key, HuffmanTreeNode value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            Integer fir = this.key;
            Pair o2 = (Pair) o;
            Integer sec = (Integer) o2.key;
            return java.lang.Integer.compare((int) fir, (int) sec);
        }
    }
}