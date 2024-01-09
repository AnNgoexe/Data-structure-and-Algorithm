package datastructure.heaptree.operation;

import datastructure.heaptree.setting.MaxHeap;

public class MaxHeapOperation {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(7);

        maxHeap.enqueue(1);
        maxHeap.enqueue(2);
        maxHeap.enqueue(3);
        maxHeap.enqueue(4);
        maxHeap.enqueue(5);
        maxHeap.enqueue(6);
        maxHeap.enqueue(7);

        System.out.println("Max Heap with 7 Elements:");
        maxHeap.print();

        System.out.print("Maximum element in the heap: " + maxHeap.front());

        System.out.println("\nThe order of elements in the heap:");
        while(!maxHeap.isEmpty()) {
            int front = maxHeap.dequeue();
            System.out.print(front + " ");
        }

        System.out.println("\nIs the heap empty? " + maxHeap.isEmpty());
    }
}
