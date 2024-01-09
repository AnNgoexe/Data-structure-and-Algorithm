package datastructure.singlylinkedlist.operation;

import datastructure.singlylinkedlist.setting.SinglyLinkedListNode;

public class LinkedListMergeOperation {
    public SinglyLinkedListNode merge(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode mergedHead = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode current = mergedHead;
        SinglyLinkedListNode temp1 = head1;
        SinglyLinkedListNode temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                current.next = new SinglyLinkedListNode(temp1.data);
                temp1 = temp1.next;
            } else {
                current.next = new SinglyLinkedListNode(temp2.data);
                temp2 = temp2.next;
            }
            current = current.next;
        }

        while (temp1 != null) {
            current.next = new SinglyLinkedListNode(temp1.data);
            temp1 = temp1.next;
            current = current.next;
        }

        while (temp2 != null) {
            current.next = new SinglyLinkedListNode(temp2.data);
            temp2 = temp2.next;
            current = current.next;
        }

        return mergedHead.next;
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
        LinkedListMergeOperation mergeOperation = new LinkedListMergeOperation();

        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        head1.next = new SinglyLinkedListNode(3);
        head1.next.next = new SinglyLinkedListNode(10);

        SinglyLinkedListNode head2 = new SinglyLinkedListNode(2);
        head2.next = new SinglyLinkedListNode(4);
        head2.next.next = new SinglyLinkedListNode(6);
        head2.next.next.next = new SinglyLinkedListNode(9);

        SinglyLinkedListNode mergedHead = mergeOperation.merge(head1, head2);

        System.out.println("Original Linked List 1:");
        mergeOperation.printLinkedList(head1);

        System.out.println("Original Linked List 2:");
        mergeOperation.printLinkedList(head2);

        System.out.println("Merged Linked List:");
        mergeOperation.printLinkedList(mergedHead);
    }
}
