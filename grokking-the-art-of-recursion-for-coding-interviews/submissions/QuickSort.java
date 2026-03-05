// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/13-quick-sort

import java.util.List;

public class QuickSort {
    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int partition(List<Integer> list, int left, int right) {
        // 1. Select last element of the partition as the pivot.
        int pivot = list.get(right);

        // 2. Create 2 pointers for the left and right indices.
        int leftPointer = left;
        int rightPointer = right;

        while (leftPointer < rightPointer) {
            // 2a. For 2 while loops, 2nd part of condition is in case
            // leftPointer does not come across any element larger than pivot
            // and rightPointer does not come across any element smaller than pivot
            while (list.get(leftPointer) <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (list.get(rightPointer) >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            // 2b. Swap an element <= pivot with an element >= pivot
            // If condition in case leftPointer and rightPointer
            // do not encounter an element > pivot and <= pivot respectively
            if (leftPointer < rightPointer) {
                swap(list, leftPointer, rightPointer);
            }
        }

        // 3. Now, both leftPointer and rightPointer represents
        // correct index that pivot has to be and right represents current index of pivot
        // because at the start of program, the pivot is the last element of the partition at highIndex
        swap(list, leftPointer, right);

        // 4. Return index of pivot, which can be either leftPointer or rightPointer
        // because both pointers are pointing to the index of the partition
        return leftPointer;
    }

    private void quickSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right);
            quickSort(list, left, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, right);
        }
    }

    public List<Integer> sort(List<Integer> array) {
        quickSort(array, 0, array.size() - 1);
        return array;
    }

}
