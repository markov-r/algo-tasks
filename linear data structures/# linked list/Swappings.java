import java.io.*;
import java.util.*;

public class Main {

    private static DoubleLinkedList dLL;
    private static OutputWriter writer = new OutputWriter();

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int numOfNums = reader.readInt();
        String swapsStr[] = reader.readLine().split(" ");
        int[] swaps = new int[swapsStr.length];
        for (int i = 0; i < swapsStr.length; i++) {
            swaps[i] = Integer.parseInt(swapsStr[i]);
        }
        dLL = new DoubleLinkedList(1);
        ArrayList<Node> initSequence = new ArrayList<>();
        initSequence.add(dLL.last);
        for (int i = 1; i < numOfNums; i++) {
            Node node = new Node(i + 1, dLL.last, null);
            node.prev.next = node;
            dLL.linkAtEnd(node);
            initSequence.add(dLL.last);
        }

        for (int num : swaps) {
            Node current = initSequence.get(num - 1);
            if (current == dLL.last) {
                makeLastFirst(current);
            } else if (current == dLL.first) {
                makeFirstLast(current);
            } else {
                swapAroundCurrent(current);
            }
        }
        printDLL();
        writer.close();
    }

    private static void swapAroundCurrent(Node current) {
        Node prevNode = current.prev;
        Node nextNode = current.next;
        Node oldFirst = dLL.first;

        dLL.detach(current);
        dLL.linkAtEnd(current);
        current.next = oldFirst;
        oldFirst.prev = current;
        dLL.first = nextNode;
        dLL.last = prevNode;
    }

    private static void makeFirstLast(Node current) {
        Node newFirst = current.next;
        newFirst.prev = null;
        current.next = null;
        dLL.first = newFirst;

        Node oldLast = dLL.last;
        oldLast.next = current;
        current.prev = oldLast;
        dLL.last = current;
    }

    private static void makeLastFirst(Node current) {
        Node newLast = current.prev;
        newLast.next = null;
        current.prev = null;
        dLL.last = newLast;

        Node oldFirst = dLL.first;
        oldFirst.prev = current;
        current.next = oldFirst;
        dLL.first = current;

    }

    private static void printDLL() {
        Node node = dLL.first;
        while (node.next != null) {
            writer.print(node.val + " ");
            node = node.next;
        }
        writer.print(node.val);
        writer.printLine();
    }

    public static class DoubleLinkedList {
        Node first;
        Node last;
        int size;

        DoubleLinkedList(int x) {
            Node node = new Node(x, null, null);
            first = node;
            last = node;
            size = 1;
        }

        void linkAtEnd(Node current) {
            Node prevLast = last;
            current.prev = prevLast;
            current.next = null;
            prevLast.next = current;
            last = current;
            size++;
        }

        void detach(Node current) {
            if (first == current) {
                first = current.next;
            }
            if (last == current) {
                last = current.prev;
            }
            Node prevNode = current.prev;
            Node nextNode = current.next;
            current.next = null;
            current.prev = null;
            if (prevNode != null) {
                prevNode.next = null;
            }
            if (nextNode != null) {
                nextNode.prev = null;
            }
            size--;
        }
    }

    public static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private static void printPrev(DoubleLinkedList list) {
        Node node = list.last;
        while (node.prev != null) {
            System.out.print(node.val + " ");
            node = node.prev;
        }
        System.out.print(node.val);
        System.out.println();
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
            return c == '\n' || c == '\r' /*|| c == ' '*/ || c == '\t' || c == -1;
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