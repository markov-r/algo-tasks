public class Main {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{ 1,  3,  5,  7},
                                                    {10, 11, 16, 20},
                                                    {23, 30, 34, 50},
                                                    {54, 58, 62, 66}},
                                                      1));
//                                                      2));
//                                                     63));
//                                                     66));
//                                                     54));
//                                                     23));
//                                                     21));
//                                                     55));
//        System.out.println(searchMatrix(new int[][]{{}}, 0));
//        System.out.println(searchMatrix(new int[][]{}, 0));
    }

    /** Do a binary search first to find the right row,
     * then another binary search within the row.
     *
     * Could be done with only one binary search if the matrix
     * is treated as a sorted list, but the time complexity
     * is the same - O(log(n * m)), just the code is a bit shorter.
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if (target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) return false;
        int m = matrix.length; int n = matrix[0].length;

        //find the right row
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; //or (high + low) / 2, but can overflow
            if (matrix[mid][0] > target) high = mid - 1;
            else if (matrix[mid][0] < target) low = mid + 1;
            else return true;                 //target found
        }
        int row = high;

//old code - working, but longer
//            if (matrix[mid][0] <= target) {
//                if ((mid < m - 1
//                        && matrix[mid+1][0] > target)
//                        || mid == m - 1) {
//                    row = mid;
//                    break;
//                }
//                if (mid < m - 1
//                        && matrix[mid+1][0] <= target) {
//                    low = mid + 1;
//                }
//            } else {
//                high = mid - 1;
//            }

        //search within the row
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}