package datastructure.singlylinkedlist.operation;

import datastructure.singlylinkedlist.setting.SinglyLinkedListNode;

import java.util.Scanner;

public class LinkedListInsertOperation {
    public SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) {
            return newNode;
        }

        SinglyLinkedListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public SinglyLinkedListNode insertNodeAtIndex(SinglyLinkedListNode head, int data, int index) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (index == 0) {
            newNode.next = head;
            return newNode;
        }
        SinglyLinkedListNode temp = head;
        for (int i = 0; i < index - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return head;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedListInsertOperation linkedListInsertOperation = new LinkedListInsertOperation();
        Scanner scanner = new Scanner(System.in);

        SinglyLinkedListNode head = null;

        System.out.print("Enter data to insert at the head: ");
        int dataAtHead = scanner.nextInt();
        head = linkedListInsertOperation.insertNodeAtHead(head, dataAtHead);

        System.out.print("Enter data to insert at the tail: ");
        int dataAtTail = scanner.nextInt();
        head = linkedListInsertOperation.insertNodeAtTail(head, dataAtTail);

        System.out.print("Enter data to insert at a specific index: ");
        int dataAtIndex = scanner.nextInt();
        System.out.print("Enter the index: ");
        int insertIndex = scanner.nextInt();
        head = linkedListInsertOperation.insertNodeAtIndex(head, dataAtIndex, insertIndex);

        System.out.print("Linked List after inserting at the head, tail, and a specific index:");
        linkedListInsertOperation.printLinkedList(head);
        scanner.close();
    }
}
