package datastructure.singlylinkedlist.operation;

import datastructure.singlylinkedlist.setting.SinglyLinkedListNode;

public class LinkedListReverse {
    public SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode follow = null;

        while (current != null) {
            follow = current.next;
            current.next = prev;
            prev = current;
            current = follow;
        }

        head = prev;
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
        LinkedListReverse linkedListReverse = new LinkedListReverse();
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);
        head.next.next.next = new SinglyLinkedListNode(4);
        head.next.next.next.next = new SinglyLinkedListNode(5);

        System.out.println("Original Linked List:");
        linkedListReverse.printLinkedList(head);

        head = linkedListReverse.reverse(head);

        System.out.println("Reversed Linked List:");
        linkedListReverse.printLinkedList(head);
    }
}

