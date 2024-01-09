package datastructure.heaptree.operation;

import datastructure.heaptree.setting.MinHeap;

public class MinHeapOperation {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(7);

        minHeap.enqueue(12);
        minHeap.enqueue(11);
        minHeap.enqueue(10);
        minHeap.enqueue(9);
        minHeap.enqueue(8);
        minHeap.enqueue(7);
        minHeap.enqueue(6);

        System.out.println("Min Heap with 7 Elements:");
        minHeap.print();

        System.out.print("Minimum element in the heap: " + minHeap.front());

        System.out.println("\nThe order of elements in the heap:");
        while(!minHeap.isEmpty()) {
            int front = minHeap.dequeue();
            System.out.print(front + " ");
        }

        System.out.println("\nIs the heap empty? " + minHeap.isEmpty());
    }
}
