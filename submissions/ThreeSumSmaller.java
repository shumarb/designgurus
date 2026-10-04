// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/triplets-with-smaller-sum-medium

import java.util.*;

class ThreeSumSmaller {
    public int searchTriplets(int[] arr, int target) {
        boolean isTest = false;
        int n = arr.length;
        int result = 0;

        sort(arr);
        if (isTest) {
            System.out.println("target: " + target + "\nsorted arr: " + Arrays.toString(arr));
            System.out.println("-----------------------------------------------------------");
        }
        for (int i = 0; i <= n - 3; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum >= target) {
                    k--;

                } else {
                    // 1. All pairs from indices [j, k], combined with i-th element,
                    // all form triplets < target, so for each i-th element,
                    // add all possible triplets from elements [j, k] starting from index i.
                    int[] triplet = new int[] {arr[i], arr[j], arr[k]};
                    if (isTest) {
                        System.out.println(" * indices: [" + i + ", " + j + ", " + k + "] | triplet: " + Arrays.toString(triplet));
                    }

                    // 2. Since j < k, all triplets (i, j, k), (i, j + 1, k)... (i, k - 1, k) are valid triplets < target.
                    result += k - j++;
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private void sort(int[] arr) {
        int[] count = new int[201];
        int j = 0;
        int offset = 100;

        for (int e: arr) {
            count[e + offset]++;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i - offset;
            }
        }
    }
}
