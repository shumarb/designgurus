// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/maximum-sum-subarray-of-size-k-easy

public class MaximumSumSubarrayOfSizeK {
    public int findMaxSumSubArray(int k, int[] arr) {
        int currentKSum = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            currentKSum += arr[i];
        }
        result = currentKSum;

        for (int i = k; i < arr.length; i++) {
            currentKSum -= arr[i - k];
            currentKSum += arr[i];
            result = Math.max(currentKSum, result);
        }

        return result;
    }
}
