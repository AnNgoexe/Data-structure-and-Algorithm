package singlylinkedlist;

public class LinkedListCycle {
    public boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
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
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);
        head.next.next.next = new SinglyLinkedListNode(4);
        head.next.next.next.next = head.next;

        boolean hasCycle = linkedListCycle.hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + hasCycle);
    }
}