package my_practice.leet_code.LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Initialize heap with the head node of, each list
        for (ListNode node : lists) {
            if (node != null) minHeap.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) minHeap.offer(node.next);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists merger = new MergeKSortedLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode mergedHead = merger.mergeKLists(lists);

        // Print merged list
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " -> ");
            mergedHead = mergedHead.next;
        }
        System.out.println("null");
    }
}
