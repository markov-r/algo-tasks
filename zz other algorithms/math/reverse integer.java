public class Main {

    public static void main(String[] args) {
//        int x = 32010;
//        int x = 342341;
//        int x = 0;
//        int x = -32010;
//        int x = 1_534_236_469;
        int x = -2_147_483_648;

        int inverted = new Main().invertString(x);
        System.out.println(inverted);
    }

    public int invertString(int num) {
        String strX = String.valueOf(num);
        if ("0".equals(strX)) return 0;

        boolean isNegative = false;
        if (strX.charAt(0) == '-') {
            isNegative = true;
            strX = strX.substring(1);
        }

        boolean metNonZero = false;
        StringBuilder invertedStr = new StringBuilder();
        for (int i = strX.length() - 1; i >= 0; i--) {
            if (strX.charAt(i) != '0' && !metNonZero) {
                metNonZero = true;
            }
            if (metNonZero) {
                invertedStr.append(strX.charAt(i));
            }
        }
        String inverted = isNegative
            ? "-" + invertedStr
            : invertedStr.toString();
        long invertedLong = Long.parseLong(inverted);

        return invertedLong > Integer.MAX_VALUE || invertedLong < Integer.MIN_VALUE
            ? 0
            : Integer.parseInt(inverted);
    }
}