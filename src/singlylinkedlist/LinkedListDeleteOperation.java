package singlylinkedlist;

public class LinkedListDeleteOperation {
    public SinglyLinkedListNode deleteAtIndex(SinglyLinkedListNode head, int index) {
        if (head == null || index < 0) {
            return head;
        }
        if (index == 0) {
            return head.next;
        }
        SinglyLinkedListNode temp = head;
        for (int i = 0; i < index - 1; ++i) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
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
        LinkedListDeleteOperation linkedListDeleteOperation = new LinkedListDeleteOperation();
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);
        head.next.next.next = new SinglyLinkedListNode(4);
        int deleteIndex = 2;
        System.out.print("Original Linked List: ");
        linkedListDeleteOperation.printLinkedList(head);
        head = linkedListDeleteOperation.deleteAtIndex(head, deleteIndex);
        System.out.print("\nLinked List after deleting at index " + deleteIndex + ": ");
        linkedListDeleteOperation.printLinkedList(head);
    }

}
