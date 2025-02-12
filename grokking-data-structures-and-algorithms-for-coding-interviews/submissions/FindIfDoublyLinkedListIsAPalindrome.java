// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-4-find-if-doubly-linked-list-is-a-palindrome-easy

// class DLNode {
//     int val;
//     DLNode next, prev;
//     DLNode(int val) { this.val = val; }
// }

class FindIfDoublyLinkedListIsAPalindrome {
    // 1. Edge case: no elements in list or list with only 1 element
        if (head == null || head.next == null) {
        return true;
    }
        
    public boolean isPalindrome(DLNode head) {
        DLNode headPointer = head;
        DLNode tailPointer = head;
        boolean isTest = false;

        while (headPointer != null) {
            if (isTest) {
                System.out.print(headPointer.val + " -> ");
            }
            if (headPointer.next == null) {
                tailPointer = headPointer;
            }
            headPointer = headPointer.next;
        }
        if (isTest) {
            System.out.println("null | tailPointer: " + tailPointer.val);
        }

        headPointer = head;
        while (headPointer != tailPointer) {
            if (headPointer.val != tailPointer.val) {
                return false;
            }
            headPointer = headPointer.next;
            tailPointer = tailPointer.prev;
        }
        return true;
    }
}
