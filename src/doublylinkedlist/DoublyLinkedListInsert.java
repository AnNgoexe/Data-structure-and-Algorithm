package doublylinkedlist;

public class DoublyLinkedListInsert {
    public DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        DoublyLinkedListNode current = head;
        while (current.next != null && current.data < data) {
            current = current.next;
        }

        if (current.next == null && data > current.data) {
            current.next = newNode;
            newNode.prev = current;
            return head;
        }

        DoublyLinkedListNode previous = current.prev;
        newNode.next = current;
        newNode.prev = previous;
        previous.next = newNode;
        current.prev = newNode;

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
        head.next = new DoublyLinkedListNode(3);
        head.next.prev = head;

        DoublyLinkedListInsert linkedListInsert = new DoublyLinkedListInsert();
        int dataToInsert = 2;
        head = linkedListInsert.sortedInsert(head, dataToInsert);

        linkedListInsert.printDoublyLinkedList(head);
    }
}
