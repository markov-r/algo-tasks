import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        String digitsStr[] = input.split("");
        LinkedList<Integer> nums = new LinkedList<>();
        List<Integer> nums2 = new ArrayList<>();
        for (String aDigitsStr : digitsStr) {
            nums.add(Integer.parseInt(aDigitsStr));
        }
        int result [] = new int [10];
        numerologize(nums, result);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static void numerologize (LinkedList<Integer> nums, int[] result) {
        if (nums.size() == 1) {
            result[nums.get(0)]++;
            return;
        }
        for (int i = 1; i < nums.size(); i++) {
            int a = nums.get(i-1);
            int b = nums.get(i);
            nums.remove(i);
            nums.set(i-1, calculate(a,b));
            numerologize(nums, result);
            nums.set(i-1, a);
            nums.add(i, b);
        }
    }

    private static int calculate(int a, int b) {
        return (a + b) * (a ^ b) % 10;
    }
}