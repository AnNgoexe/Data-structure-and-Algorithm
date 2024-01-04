package linkedlistoperation;

import linkedlist.SinglyLinkedListNode;

public class LinkedListDeleteDuplicates {
    public SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        SinglyLinkedListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.data == tmp.next.data) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }

    public void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListDeleteDuplicates linkedListDeleteDuplicates = new LinkedListDeleteDuplicates();
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(1);
        head.next.next = new SinglyLinkedListNode(2);
        head.next.next.next = new SinglyLinkedListNode(3);
        head.next.next.next.next = new SinglyLinkedListNode(3);

        System.out.println("Original Linked List:");
        linkedListDeleteDuplicates.printLinkedList(head);

        head = linkedListDeleteDuplicates.removeDuplicates(head);

        System.out.println("Linked List after removing duplicates:");
        linkedListDeleteDuplicates.printLinkedList(head);
    }
}