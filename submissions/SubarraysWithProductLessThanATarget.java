// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-6-subarrays-with-product-less-than-a-target-medium

import java.util.*;

class SubarraysWithProductLessThanATarget {
    public List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        int left = 0;
        int n = arr.length;
        long product = 1;

        if (target <= 1) {
            return result;
        }

        for (int right = 0; right < n; right++) {
            int incoming = arr[right];
            product *= incoming;

            while (product >= target) {
                product /= arr[left++];
            }
            if (isTest) {
                System.out.println("------------------------------------------------\n * index range: [" + left + ", " + right + "]"
                        + " | subarray: " + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
            }

            // 1. Generate all valid substrings ending at right.
            List<Integer> subarray = new ArrayList<>();
            for (int i = right; i >= left; i--) {
                subarray.add(0, arr[i]);
                if (isTest) {
                    System.out.println(" ** valid subarray: " + subarray);
                }
                result.add(new ArrayList<>(subarray));
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------------\nresult:");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }
}
