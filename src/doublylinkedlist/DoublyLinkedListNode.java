package doublylinkedlist;

public class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode prev;
    public DoublyLinkedListNode next;

    public DoublyLinkedListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
