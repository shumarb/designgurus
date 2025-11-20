// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/9-binary-search

public class Solution {
    private static boolean binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return false;
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return binarySearch(nums, left, mid - 1, target);
        }
    }

    public static boolean binarySearch(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}