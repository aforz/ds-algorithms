package my_practice.leet_code.LinkedList;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) cur.next = list1;
        else cur.next = list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // Test case 1
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        System.out.print("Merged List 1: ");
        printList(mergedList); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4

        // Test case 2
        ListNode list3 = null;
        ListNode list4 = null;

        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        System.out.print("Merged List 2: ");
        printList(mergedList2); // Expected: (empty)

        // Test case 3
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);

        ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        System.out.print("Merged List 3: ");
        printList(mergedList3); // Expected: 0
    }

    private static void printList(ListNode mergedList) {
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
