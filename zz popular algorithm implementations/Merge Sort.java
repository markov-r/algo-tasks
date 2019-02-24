import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 5, 1, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 7);
        List<Integer> tmp = Stream.generate(() -> 0)                // generate a list with 0's to use for filling
                .limit(list.size())
                .collect(Collectors.toList());
        int startIndex = 0;
        int endIndex = list.size();

        System.out.println(list);
        mergeSort(list, startIndex, endIndex, tmp);
        System.out.println(tmp);
    }

    private static void mergeSort(List<Integer> list, int startIndex, int endIndex, List<Integer> tmp) {
        if (endIndex - startIndex <= 1) {
            return;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        mergeSort(list, startIndex, middleIndex, tmp);              // split left side (until one element is left(which is sorted)),
                                                                    // then proceed recursively
        mergeSort(list, middleIndex, endIndex, tmp);                // split right side the same way
        merge(list, startIndex, middleIndex, endIndex, tmp);        // merge the two sorted sides
    }

    private static void merge(List<Integer> list, int startIndex, int middleIndex, int endIndex, List<Integer> tmp) {
        int left = startIndex;                                      // merge the two sorted arrays
        int right = middleIndex;
        int index = startIndex;
        while (left < middleIndex && right < endIndex) {
            if (list.get(left) < list.get(right)) {
                tmp.set(index, list.get(left));
                left++;
            } else {
                tmp.set(index, list.get(right));
                right++;
            }
            index++;
        }
        while (left < middleIndex) {                                // if left has leftover members, and right is finished
            tmp.set(index, list.get(left));
            left++;
            index++;
        }
        while (right < endIndex) {                                  // if right has leftover members
            tmp.set(index, list.get(right));
            right++;
            index++;
        }

        for (int i = startIndex; i < endIndex; i++) {               // write tmp to list to get the result
            list.set(i, tmp.get(i));
        }
    }
}