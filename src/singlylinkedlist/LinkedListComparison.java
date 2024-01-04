package singlylinkedlist;

public class LinkedListComparison {
    public boolean compareTo(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode temp1 = head1;
        SinglyLinkedListNode temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1 == null && temp2 == null;
    }

    public static void main(String[] args) {
        LinkedListComparison linkedListComparison = new LinkedListComparison();
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        head1.next = new SinglyLinkedListNode(2);
        head1.next.next = new SinglyLinkedListNode(3);

        SinglyLinkedListNode head2 = new SinglyLinkedListNode(1);
        head2.next = new SinglyLinkedListNode(2);
        head2.next.next = new SinglyLinkedListNode(3);

        boolean isEqual = linkedListComparison.compareTo(head1, head2);
        System.out.println("Are the linked lists equal? " + isEqual);
    }
}
