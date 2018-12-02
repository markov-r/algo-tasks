import java.util.Arrays;

class Main {
    public static void main(String[] args) {
//        int[] tokens = new int[]{};
        int[] tokens = new int[]{1, 2, 3, 4/*, 5, 6, 7, 8*/};
        int power = 2;
        System.out.println(bagOfTokensScore(tokens, power));
    }
    /** Eat as many tokens as possible with the initial power.
       Then if > 1 tokens are left (cause of points deduction)
       get the last (biggest) token to power up and continue eating. */

    private static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        if (tokens.length == 0 || power < tokens[0]) return 0;
        int left = 0, right = tokens.length - 1, points = 0;
        while (left <= right) {
            if (power >= tokens[left]) {
                points++;
                power -= tokens[left];
                left++;
            } else {
                if (right - left > 1) {
                    power += tokens[right];
                    right--;
                    points--;
                } else break;
            }
        }
        return points;
    }
}