package my_practice.leet_code.LinkedList;

// Problem: https://leetcode.com/problems/linked-list-cycle/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // Test case 1: List with a cycle
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Creates a cycle
        System.out.println("Test case 1 (should be true): " + solution.hasCycle(head1));

        // Test case 2: List without a cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Test case 2 (should be false): " + solution.hasCycle(head2));

        // Test case 3: Single node without a cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Test case 3 (should be false): " + solution.hasCycle(head3));

        // Test case 4: Empty list
        ListNode head4 = null;
        System.out.println("Test case 4 (should be false): " + solution.hasCycle(head4));
    }
}
