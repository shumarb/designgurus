// Questions: https://www.designgurus.io/course-play/grokking-recursion/doc/12-merge-sort

import java.util.Arrays;

public class MergeSort {
    private static void merge(int[] arr, int left, int mid, int right) {
        // 1. Find sizes of subarrays to be merged.
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 2. Create two temporary arrays for the respective subarrays.
        int[] firstPart = new int[n1];
        int[] secondPart = new int[n2];

        // 3. Copy elements into those subarrays.
        for (int i = 0; i < n1; ++i) {
            firstPart[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            secondPart[j] = arr[mid + 1 + j];
        }

        // 4. Merge the temp arrays into arr.
        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (firstPart[i] <= secondPart[j]) {
                arr[k++] = firstPart[i++];
            } else {
                arr[k++] = secondPart[j++];
            }
        }

        // 5. If there are remaining elements, copy it to arr, first from first array, then from second array
        while (i < n1) {
            arr[k++] = firstPart[i++];
        }

        while (j < n2) {
            arr[k++] = secondPart[j++];
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static int[] mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }
}
