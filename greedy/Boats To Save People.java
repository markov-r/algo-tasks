import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] people = new int[] {1, 2, 2, 2};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

    /** Try to fit the heaviest and the lightest persons if possible
      * If they can't fit take the heaviest only and continue */
    private static int numRescueBoats(int[] people, int limit) {
        int left = 0, right = people.length - 1;
        int count = 0;
        Arrays.sort(people);
        while (left <= right) {
            count++;                                        // will fit something for sure
            if (people[left] + people[right] <= limit) {    // if heaviest and lightest can fit -> have them
                left++;
                right--;
            } else right--;                                 // else only the heaviest
        }
        return count;
    }
}
