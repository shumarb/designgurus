import java.util.Arrays;

class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        boolean isTest = false;
        for (int[] currentCustomer: accounts) {
            if (isTest) {
                System.out.println("current customer: " + Arrays.toString(currentCustomer));
            }
            maxWealth = Math.max(maxWealth, computeCurrentCustomerWealth(currentCustomer));
        }
        return maxWealth;
    }

    private static int computeCurrentCustomerWealth(int[] arr) {
        int sum = 0;
        for (int element: arr) {
            sum += element;
        }
        return sum;
    }
}
