import java.io.*;
import java.util.*;

public class Main {

//  input

    static int SIZE = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int [] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Integer.parseInt(in.readLine());
        }

//  convert to bin -> binMatrix

        List <Integer> bin = new ArrayList<>();
        int [][] binMatrix = new int [SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            while (numbers[i] > 0) {
                int remainder = numbers[i] % 2;
                bin.add(remainder);
                numbers[i] /= 2;
            }
            Collections.reverse(bin);

//  Fill bin to 8 bits with 0's

            String binStr = "";
            for (int j = 0; j < bin.size(); j++) {
            binStr = binStr + bin.get(j);
            }

            switch (bin.size()) {
                case 0: binStr = "00000000";         break;
                case 1: binStr = "0000000" + binStr; break;
                case 2: binStr = "000000"  + binStr; break;
                case 3: binStr = "00000"   + binStr; break;
                case 4: binStr = "0000"    + binStr; break;
                case 5: binStr = "000"     + binStr; break;
                case 6: binStr = "00"      + binStr; break;
                case 7: binStr = "0"       + binStr; break;
                case 8:                              break;
            }

            String [] temp = binStr.split("");
                for (int k = 0; k < SIZE; k++) {
                binMatrix[i][k] = Integer.parseInt(temp[k]);
                }
            bin.clear();
        }
//        System.out.println(Arrays.deepToString(binMatrix).replace("], ", "]\n"));
//        System.out.println();

//   FALL DOWN

//  vertical sums

        int [] vertSum = new int [SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
            vertSum[j] += binMatrix[i][j];
            }
        }
//        System.out.println(Arrays.toString(vertSum));
//        System.out.println();

//  find max values in vertSum

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < SIZE; i++) {
            if (vertSum[i] > max) {
              max = vertSum[i];
            }
        }

        int [][] outputMat = new int [max][SIZE];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < SIZE; j++) {
                outputMat[i][j] = 0;
            }
        }

//  find fall down bins

        int realMax = max;
        for (int i = 0; i < realMax; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (vertSum[j] == max) {
                    outputMat[i][j] = 1;
                    if (vertSum[j] > 0) {
                        vertSum[j]--;
                    }
                }
            }
            max--;
        }

//        System.out.println(Arrays.deepToString(output).replace("], ", "]\n"));
//        System.out.println();

//  convert bins to decimals

        int [] deciOut = new int [realMax];
        for (int i = 0; i < realMax; i++) {
            for (int j = 0; j < SIZE; j++) {
            deciOut[i] += outputMat[i][j] * ((int) Math.pow(2, SIZE - 1 - j));
            }
        }

//        System.out.println(Arrays.toString(deciOut));
//        System.out.println();

//  convert decimals to requested format

        int [] realOut = new int [SIZE];
        for (int i = 0; i < SIZE; i++) {
        realOut[i] = 0;
        }

        int count = 0;
        for (int i = SIZE - realMax; i < SIZE; i++) {
        realOut[i] = deciOut[count];
        count++;
        }

//        System.out.println(Arrays.toString(realOut));

        for (int i = 0; i < SIZE; i++) {
            System.out.println(realOut[i]);
        }
    }
}