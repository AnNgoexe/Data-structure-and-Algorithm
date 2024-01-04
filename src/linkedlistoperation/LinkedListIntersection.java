package linkedlistoperation;

import linkedlist.SinglyLinkedListNode;

public class LinkedListIntersection {
    public int findMergeNode(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
        SinglyLinkedListNode pA = headA;
        SinglyLinkedListNode pB = headB;

        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }

        return pA.data;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode commonNode = new SinglyLinkedListNode(8);

        SinglyLinkedListNode headA = new SinglyLinkedListNode(4);
        headA.next = new SinglyLinkedListNode(1);
        headA.next.next = commonNode;

        SinglyLinkedListNode headB = new SinglyLinkedListNode(5);
        headB.next = new SinglyLinkedListNode(6);
        headB.next.next = new SinglyLinkedListNode(1);
        headB.next.next.next = commonNode;

        LinkedListIntersection linkedListIntersection = new LinkedListIntersection();
        int result = linkedListIntersection.findMergeNode(headA, headB);
        System.out.println("Intersection Node Value: " + result);
    }

}
