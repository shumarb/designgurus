// Question:

public class Factorial {
    public static int calculateFactorial(int number) {
        if (number <= 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        helper(list, 2, number);
        return list.get(list.size() - 1);
    }

    private static void helper(List<Integer> list, int current, int number) {
        if (list.size() == number) {
            return;
        }
        list.add(current * list.get(list.size() - 1));
        helper(list, current + 1, number);
    }
}
