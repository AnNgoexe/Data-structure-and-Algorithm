package datastructure.singlylinkedlist.operation;

import datastructure.singlylinkedlist.setting.SinglyLinkedListNode;

public class LinkedListGetNode {
    public int getNodeFromHead(SinglyLinkedListNode head, int positionFromHead) {
        SinglyLinkedListNode temp = head;
        for (int i = 0; i < positionFromHead && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return -1;
        }
        return temp.data;
    }

    public int getNodeFromTail(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        for (int i = 0; i < positionFromTail; i++) {
            if (fast == null) {
                return -1;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
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
        LinkedListGetNode linkedListGetNode = new LinkedListGetNode();
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);
        head.next.next.next = new SinglyLinkedListNode(4);
        head.next.next.next.next = new SinglyLinkedListNode(5);

        System.out.println("Linked List:");
        linkedListGetNode.printLinkedList(head);

        int positionFromHead = 2;
        int resultHead = linkedListGetNode.getNodeFromHead(head, positionFromHead);
        System.out.println("Data of node " + positionFromHead + " from the head: " + resultHead);

        int positionFromTail = 2;
        int result = linkedListGetNode.getNodeFromTail(head, positionFromTail);
        System.out.println("Data of node " + positionFromTail + " from the end: " + result);
    }
}
