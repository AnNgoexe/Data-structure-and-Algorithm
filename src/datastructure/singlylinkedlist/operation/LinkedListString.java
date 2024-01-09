package datastructure.singlylinkedlist.operation;

import datastructure.singlylinkedlist.setting.SinglyLinkedListNode;

import java.util.Stack;

public class LinkedListString {
    private SinglyLinkedListNode singlyLinkedListNode;
    public LinkedListString(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.add(str.charAt(i));
        }
    }

    public void add(char c) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(c - '0');
        newNode.next = this.singlyLinkedListNode;
        this.singlyLinkedListNode = newNode;
    }

    public boolean isPalindrome() {
        Stack<Integer> stack = new Stack<>();
        SinglyLinkedListNode current = singlyLinkedListNode;

        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = singlyLinkedListNode;
        while (current != null) {
            if (current.data != stack.pop()) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedListString linkedList = new LinkedListString("1234321");
        System.out.println("Is Palindrome: " + linkedList.isPalindrome());
    }
}
