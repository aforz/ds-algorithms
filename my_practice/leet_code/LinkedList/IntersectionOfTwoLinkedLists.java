package my_practice.leet_code.LinkedList;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Step 1: Find the lengths
        int lenA = 0, lenB = 0;
        ListNode currA = headA, currB = headB;
        while (currA != null) {
            lenA++;
            currA = currA.next;
        }
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }

        // Step 2: Advance the longer list
        currA = headA;
        currB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) currA = currA.next;
        } else {
            for (int i = 0; i < lenB - lenA; i++) currB = currB.next;
        }

        // Step 3: Move together until intersection (or end)
        while (currA != null && currB != null) {
            if (currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
