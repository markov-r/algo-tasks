import java.io.*;

public class Main {
    static void fakeInput() {
        String test = "3\n" +
                "6\n" +
                "100\n" +
                "200\n" +
                "300";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numOfTubes = Integer.parseInt(in.readLine());
        int friends = Integer.parseInt(in.readLine());
        int[] inputTubes = new int[numOfTubes];
        int maxTube = 0;
        for (int i = 0; i < numOfTubes; i++) {
            inputTubes[i] = Integer.parseInt(in.readLine());
            if (maxTube < inputTubes[i]) {
                maxTube = inputTubes[i];
            }
        }
        System.out.println(findMaxFit(1, maxTube, inputTubes, friends));
    }

    private static int findMaxFit(int left, int right, int[] inputTubes, int friends) {
        int middle = (left + right) / 2;
        if (middle == left || middle == right) {
            return findMaxFitting(left, right, friends, inputTubes);
        }
        if (tubeCutsPossible(middle, friends, inputTubes)) {
            return findMaxFit(middle, right, inputTubes, friends);
        } else {
            return findMaxFit(left, middle, inputTubes, friends);
        }
    }

    private static int findMaxFitting(int left, int right, int friends, int[] inputTubes) {
        boolean leftTrue = false;
        boolean rightTrue = false;
        if (tubeCutsPossible(left, friends, inputTubes)) {
            leftTrue = true;
        }
        if (tubeCutsPossible(right, friends, inputTubes)) {
            rightTrue = true;
        }
        if (leftTrue && !rightTrue) {
            return left;
        }
        if (!leftTrue && rightTrue) {
            return right;
        }
        if (leftTrue && rightTrue) {
            return Math.max(left, right);
        }
        return Integer.MIN_VALUE;
    }

    private static boolean tubeCutsPossible(int checkSize, int friends, int[] inputTubes) {
        int count = 0;
        for (int inputTube : inputTubes) {
            count += inputTube / checkSize;
            if (count >= friends) {
                return true;
            }
        }
        return false;
    }
}