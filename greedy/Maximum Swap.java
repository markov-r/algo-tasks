
public class Main {

    public static void main (String args[]) {
//        int num = 0;
//        int num = 9;
//        int num = 1234;
//        int num = 2736;
//        int num = 1231;
//        int num = 1000;
//        int num = 7397;
//        int num = 3142;
//        int num = 43211;
//        int num = 27367;
//        int num = 543126;
        int num = 7397361;
        System.out.println(maximumSwap(num));
    }

    /** Find the first increasing sequence and its biggest, rightmost member. 
     Otherwise said find the biggest element that has a smaller digit left of it (call it right).
     E.g. in 98712 it is the digit 2's index.
     Find the first digit left of max smaller than max (call it left) and swap left and right.*/
    
    private static int maximumSwap(int num) {
        char[] maxNum = ("" + num).toCharArray();
        int right = -1;                                //right index to swap
        boolean hasIncreasing = false;
        for (int i = 0; i < maxNum.length; i++) {
            if (i < maxNum.length - 1 && maxNum[i] < maxNum[i+1] && !hasIncreasing) {
                hasIncreasing = true;
                right = i + 1;
            }
            if (hasIncreasing && maxNum[i] >= maxNum[right]) {      // >= -> in 27367 swap indices 0 and 4, NOT 0 and 1
                right = i;
            }
        }
        if (!hasIncreasing) return num;                       //if all decreasing (321, 322)
        int left = -1;                                        //left index to swap
        for (int i = 0; i < right; i++) {
            if (maxNum[i] < maxNum[right]) {
                left = i;
                break;
            }
        }
        char prevMax = maxNum[right];
        maxNum[right] = maxNum[left];
        maxNum[left] = prevMax;
        return Integer.parseInt(new String(maxNum));
    }
}
