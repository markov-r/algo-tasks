import java.io.*;
import java.util.*;

import javafx.util.Pair;

public class Main
{
    public static void main (String[] args) // throws IOException
    {

//      INPUT

//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String nNm[] = in.readLine().split(" ");
//        final int n = Integer.parseInt(nNm[0]);
//        final int m = Integer.parseInt(nNm[1]);

        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        final int n = reader.readInt();
        final int m = reader.readInt();
        int matrix [][] = new int [n][m];
        for (int i = 0; i < n; i++)
        {
//            String [] strIn = in.readLine().split(" ");
            for (int j = 0; j < m; j++)
            {
//                matrix[i][j] = Integer.parseInt(strIn[j]);
                matrix[i][j] = reader.readInt();
            }
        }

        boolean visited[][] = new boolean[n][m];

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
//        List<Pair<Integer, Integer>> queue = new ArrayList<>();
        int [] dx = {-1, 1,  0, 0};
        int [] dy = { 0, 0, -1, 1};
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                int value = matrix[i][j];
                int count = 0;

                if (visited[i][j])
                    {
                    continue;
                    }
                else
                    {
                    visited[i][j] = true;
//                    queue.add(new Pair<>(i, j));
                    stack.push(new Pair <>(i, j));
                    count ++;
                    }

                while (!stack.isEmpty())
//                while (!queue.isEmpty())
                {
                    Pair<Integer, Integer> pair = stack.pop();
//                    Pair<Integer, Integer> pair = queue.get(queue.size() - 1);
//                    queue.remove(queue.size() - 1);
                    for (int k = 0; k < 4; k++)
                    {
                        if (pair.getKey() + dx[k] >= 0 && pair.getKey() + dx[k] < n && pair.getValue() + dy[k] >= 0 && pair.getValue() + dy[k] < m)
                        {
                            if (!visited[pair.getKey() + dx[k]][pair.getValue() + dy[k]])
                            {
                                if (matrix[pair.getKey() + dx[k]][pair.getValue() + dy[k]] == value)
                                {
                                    stack.push(new Pair<>(pair.getKey() + dx[k], pair.getValue() + dy[k]));
//                                    queue.add(new Pair<>(pair.getKey() + dx[k], pair.getValue() + dy[k]));
                                    visited[pair.getKey() + dx[k]][pair.getValue() + dy[k]] = true;
                                    System.out.println(Arrays.deepToString(visited).replace("], ", "]\n"));
                                    count ++;
                                }
                            }
                        }
                    }
                }
                if (count > maxCount)
                {
                    maxCount = count;
                }
            }
        }

//        System.out.println(maxCount);
        writer.print(maxCount);
        writer.close();

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
            return  c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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
