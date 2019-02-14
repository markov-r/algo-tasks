public class Main {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("anarhia i hrana"));
//        System.out.println(isPalindrome("анархия и храна 3"));
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("kup e puk"));
//        System.out.println(isPalindrome("1k"));
//        System.out.println(isPalindrome("cacak"));
//        System.out.println(isPalindrome("race 1e car"));
//        System.out.println(isPalindrome("cak"));
//        System.out.println(isPalindrome(" "));
//        System.out.println(isPalindrome("  "));
        System.out.println(isPalindrome("{}"));
        System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome(" -"));
    }


    /** Start from both ends of the string and check for equal characters.
     *  When char is neither letter nor a digit shift pointers accordingly.
     *  Corner cases are a bit tricky. */

    private static boolean isPalindrome(String str) {
        if (str.length() < 2) return true;
        int n = str.length();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            while (left < n - 1 && !Character.isLetterOrDigit(str.charAt(left))) { //first clause to avoid index out of bounds
                left++;
            }
            while (right > 0 && !Character.isLetterOrDigit(str.charAt(right))) {   //same as above comment
                right--;
            }
            if (Character.isLetterOrDigit(str.charAt(left)) &&          //for cases like "(%" or ".,"
                    Character.isLetterOrDigit(str.charAt(right)) &&
                    Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}