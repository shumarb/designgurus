public class LeftAndRightSumDifferences {
    public int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int leftSum = 0;
        int rightSum = 0;

        for (int element: nums) {
            rightSum += element;
        }

        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            differenceArray[i] = Math.abs((leftSum - rightSum));
            leftSum += nums[i];
        }
        return differenceArray;
    }
}