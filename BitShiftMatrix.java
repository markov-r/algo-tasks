import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
//import java.util.Arrays;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(in.readLine());
        int col = Integer.parseInt(in.readLine());
        int numOfMoves = Integer.parseInt(in.readLine());
        String inputStr [] = in.readLine().split(" ");

//       MATRIX FILLING

        BigInteger [][] mat = new BigInteger[row][col];
        int k = 0;
        for (int i = row - 1; i >= 0 ; i--)
        {
            for (int j = 0; j <= col - 1; j++)
            {
                mat[i][j] = BigInteger.valueOf(2).pow(k + j);
            }
            k++;
        }

//        System.out.println(Arrays.deepToString(mat).replace("], ", "]\n"));

//      SUM THE PATHS OF THE PAWN

        BigInteger sum = BigInteger.valueOf(0);
        int coeff = Math.max(row, col);
        int currRow = row - 1;
        int currCol = 0;
        for (int i = 0; i < inputStr.length; i++)
        {
            int move =  Integer.parseInt(inputStr[i]);
            int rowToGo = move / coeff;
            int colToGo = move % coeff;

            int j, j2;
            for (j = currCol, j2 = currCol; j <= colToGo || j2 >= colToGo; j++, j2--)
            {
                if (currCol < colToGo)
                {
//                  sum += mat[currRow][j];
                  sum = sum.add(mat[currRow][j]);
                  mat[currRow][j] = BigInteger.valueOf(0);
                }
                else if (currCol > colToGo)
                {
//                  sum += mat[currRow][j2];
                  sum = sum.add(mat[currRow][j2]);
                  mat[currRow][j2] = BigInteger.valueOf(0);
                }
                else if (currCol == colToGo)
                {
                sum = sum.add(mat[currRow][currCol]);
                break;
                }
            }

            int p, p2;
            for (p = currRow, p2 = currRow; p <= rowToGo || p2 >= rowToGo; p++, p2--)
            {
               if (currRow < rowToGo)
               {
//               sum += mat[p][colToGo];
                 sum = sum.add(mat[p][colToGo]);
               mat[p][colToGo] = BigInteger.valueOf(0);
               }
               else if (currRow > rowToGo)
               {
//                sum += mat[p2][colToGo];
                sum = sum.add(mat[p2][colToGo]);
                mat[p2][colToGo] = BigInteger.valueOf(0);
               }
               else if (currRow == rowToGo)
               {
                sum = sum.add(mat[currRow][colToGo]);
                break;
               }
            }
         currRow = rowToGo;
         currCol = colToGo;
        }
        System.out.println(sum);
    }
}