// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/4-converting-decimal-to-binary

public class ConvertingDecimalToBinary {
    private static StringBuilder result;

    public static String decimalToBinary(int number) {
        result = new StringBuilder();
        helper(number);
        return result.reverse().toString();
    }

    private static void helper(int number) {
        if (number == 0) {
            return;
        }

        result.append(number % 2);
        helper(number / 2);
    }
}
