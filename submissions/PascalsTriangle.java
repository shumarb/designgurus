import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    private static void helper(List<List<Integer>> triangle, int numRows) {
        if (triangle.size() == numRows) {
            return;
        }

        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        List<Integer> newRow = new ArrayList<>();

        newRow.add(1);
        for (int i = 0; i < lastRow.size() - 1; i++) {
            newRow.add(lastRow.get(i) + lastRow.get(i + 1));
        }
        newRow.add(1);
        triangle.add(newRow);

        helper(triangle, numRows);
    }

    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;

        list.add(1);
        triangle.add(list);
        helper(triangle, numRows);
        if (isTest) {
            System.out.println("triangle:");
            for (List<Integer> e: triangle) {
                System.out.println(e);
            }
        }

        return triangle;
    }
}
