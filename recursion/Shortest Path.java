import java.io.*;
import java.util.*;

public class Main {

    static void fakeInput() {
        String test = "**";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    private static char[] msg;

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        msg = in.readLine().toCharArray();
        List<String> result = new ArrayList<>();
        fillTheStars(0, result);
        System.out.println(result.size());
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static void fillTheStars(int ind, List<String> result) {
        if (ind == msg.length) {
            result.add(new String(msg));
            return;
        }
        if (msg[ind] != '*') {
            fillTheStars(ind + 1, result);
        } else {
            msg[ind] = 'L';
            fillTheStars(ind + 1, result);
            msg[ind] = 'R';
            fillTheStars(ind + 1, result);
            msg[ind] = 'S';
            fillTheStars(ind + 1, result);
            msg[ind] = '*';
        }
    }
}