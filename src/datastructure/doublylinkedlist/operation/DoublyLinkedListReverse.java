package datastructure.doublylinkedlist.operation;

import datastructure.doublylinkedlist.setting.DoublyLinkedListNode;

public class DoublyLinkedListReverse {
    public DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode temp = null;

        while(current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        head = temp.prev;
        return head;
    }

    public void printDoublyLinkedList(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedListNode head = new DoublyLinkedListNode(1);
        head.next = new DoublyLinkedListNode(2);
        head.next.prev = head;
        head.next.next = new DoublyLinkedListNode(3);
        head.next.next.prev = head.next;
        DoublyLinkedListReverse linkedListReverse = new DoublyLinkedListReverse();

        linkedListReverse.printDoublyLinkedList(head);
        head = linkedListReverse.reverse(head);
        linkedListReverse.printDoublyLinkedList(head);
    }
}
