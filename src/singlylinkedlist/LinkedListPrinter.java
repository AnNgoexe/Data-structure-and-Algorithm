package singlylinkedlist;

public class LinkedListPrinter {
    public void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void printLinkedListInReverse(SinglyLinkedListNode head) {
        if (head == null) {
            return;
        }
        printLinkedListInReverse(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);

        LinkedListPrinter linkedListPrinter = new LinkedListPrinter();

        System.out.println("Original Linked List:");
        linkedListPrinter.printLinkedList(head);

        System.out.println("\nReverse Print:");
        linkedListPrinter.printLinkedListInReverse(head);
    }
}
