package my_practice.leet_code.LinkedList;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            // Swapping nodes
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move prev to the end of the swapped pair
            prev = first;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapper = new SwapNodesInPairs();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode swappedHead = swapper.swapPairs(head);

        // Print swapped list
        while (swappedHead != null) {
            System.out.print(swappedHead.val + " -> ");
            swappedHead = swappedHead.next;
        }
        System.out.println("null");
    }
}
