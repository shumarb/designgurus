// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/7-number-frequency

public class NumberFrequency {
    public static int countOccurrences(int[] arr, int key) {
        arr = sort(arr);

        int leftMost = findLeftMost(arr, key, 0, arr.length - 1, -1);
        int rightMost = findRightMost(arr, key, 0, arr.length - 1, -1);

        return leftMost == -1 || rightMost == -1 ? 0 : rightMost - leftMost + 1;
    }

    private static int findLeftMost(int[] arr, int key, int low, int high, int index) {
        if (low > high) {
            return index;
        }

        int mid = low + (high - low) / 2;

        if (key <= arr[mid]) {
            if (key == arr[mid]) {
                index = mid;
            }
            return findLeftMost(arr, key, low, mid - 1, index);
        }

        return findLeftMost(arr, key, mid + 1, high, index);
    }

    private static int findRightMost(int[] arr, int key, int low, int high, int index) {
        if (low > high) {
            return index;
        }

        int mid = low + (high - low) / 2;

        if (key >= arr[mid]) {
            if (key == arr[mid]) {
                index = mid;
            }
            return findRightMost(arr, key, mid + 1, high, index);
        }

        return findRightMost(arr, key, low, mid - 1, index);
    }

    private static int[] sort(int[] arr) {
        int[] count;
        int j = 0;
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            largest = Math.max(arr[i], largest);
        }
        count = new int[largest + 1];
        for (int number: arr) {
            count[number]++;
        }

        for (int i = 0; i <= largest; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }
}
