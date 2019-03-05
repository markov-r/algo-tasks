import java.io.*;
import java.util.Arrays;

public class Main {

    private static void fakeInput() {
        String test = "0110\n" +
                "1101001";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        String output = in.readLine();
        double[][] mat = new double[input.length() + 1][output.length() + 1];
        mat[0][0] = 0;
        for (int i = 1; i < output.length() + 1; i++) {
            double nextMember = mat[0][i - 1] + getInsertCost(output.charAt(i - 1));    //from "" to output only by inserting a char
            mat[0][i] = (double) Math.round(nextMember * 10d) / 10d;
        }
        for (int i = 1; i < input.length() + 1; i++) {              //from input to "" only by deleting a char
            double nextMember = mat[i - 1][0] + getDeletionCost(input.charAt(i - 1));
            mat[i][0] = (double) Math.round(nextMember * 10d) / 10d;
        }

        for (int i = 1; i < input.length() + 1; i++) {
            for (int j = 1; j < output.length() + 1; j++) {
                double changeCost = mat[i - 1][j - 1];                      //горен ляв диагонал + cost-a за промяна на цифрата
                if (input.charAt(i - 1) != output.charAt(j - 1)) {
                    changeCost += 1;
                }

                double insertCost = getInsertCost(output.charAt(j - 1));   //лявото + цената за добавяне на цифра
                insertCost += mat[i][j - 1];

                double deletionCost = getDeletionCost(input.charAt(i - 1));   //горното + цената за триене на цифра
                deletionCost += mat[i - 1][j];
                double lowestCost = Math.min(deletionCost, Math.min(insertCost, changeCost));
                mat[i][j] = (double) Math.round(lowestCost * 10d) / 10d;
            }
        }
        
        double conversionTime = mat[input.length()][output.length()];
        if (conversionTime % 1 == 0) {
            System.out.println((int) conversionTime);
        } else {
            System.out.println(conversionTime);
        }
//        System.out.println(Arrays.deepToString(mat).replace("], ", "]\n"));
    }

    private static double getDeletionCost(char c) {
        if (c == '0') {
            return 0.9;
        } else {
            return 0.8;
        }
    }

    private static double getInsertCost(char c) {
        if (c == '0') {
            return 1.1;
        } else {
            return 1.2;
        }
    }
}
