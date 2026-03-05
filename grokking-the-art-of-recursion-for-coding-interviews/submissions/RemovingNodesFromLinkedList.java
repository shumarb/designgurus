// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/15-removing-nodes-from-linked-list

/*class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}*/

import java.util.ArrayList;
import java.util.List;

public class RemovingNodesFromLinkedList {
    private static void populate(List<ListNode> list, ListNode head, int target) {
        if (head == null) {
            return;
        }

        if (head.val != target) {
            list.add(head);
        }

        populate(list, head.next, target);
    }

    public static ListNode removeNodes(ListNode head, int target) {
        List<ListNode> list = new ArrayList<>();
        boolean isTest = false;

        populate(list, head, target);
        if (isTest) {
            System.out.print("list: ");
            for (ListNode e: list) {
                System.out.print(e.val + " ");
            }
            System.out.println();
        }

        if (list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        head = list.get(0);
        list.get(list.size() - 1).next = null;

        return head;
    }
}
