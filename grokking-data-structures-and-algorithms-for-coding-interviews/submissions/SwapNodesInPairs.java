// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-5-swap-nodes-in-pairs-medium

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        boolean isTest = true;
        if (isTest) {
            display("initial list: ", head);
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode previous = dummy;
        if (isTest) {
            display("dummy list: ", dummy);
        }

        while (head != null && head.next != null) {
            // 1. Identify pairs to be swapped
            ListNode first = head;
            ListNode second = head.next;

            // 2. Change its pointers accordingly
            first.next = second.next;
            second.next = first;
            previous.next = second;

            // 3. Move to next pair
            head = first.next;
            previous = first;
            if (isTest) {
                display("dummy list so far: ", dummy);
            }
        }
        if (isTest) {
            display("final dummy list: ", dummy);
        }

        return dummy.next;
    }

    private void display(String str, ListNode head) {
        System.out.print(str);
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            if (current.next == null) {
                System.out.println("null");
            }
            current = current.next;
        }
    }
}
