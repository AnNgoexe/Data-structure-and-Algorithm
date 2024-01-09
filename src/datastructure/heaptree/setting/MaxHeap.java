package datastructure.heaptree.setting;

public class MaxHeap {
    private int[] heap;
    private int currentSize;
    private int maxSize;
    private final int FRONT = 1;

    public MaxHeap(int size) {
        this.maxSize = size;
        this.currentSize = 0;
        this.heap = new int[this.maxSize + 1];
        this.heap[0] = Integer.MAX_VALUE;
    }

    private int getParent(int pos) {
        return pos / 2;
    }

    private int getLeftChild(int pos) {
        return (2 * pos);
    }

    private int getRightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (this.currentSize / 2);
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (!this.isLeaf(pos)) {
            int swapPos;
            if (this.getRightChild(pos) <= currentSize) {
                if (heap[this.getLeftChild(pos)] > heap[this.getRightChild(pos)]) {
                    swapPos = this.getLeftChild(pos);
                } else {
                    swapPos = this.getRightChild(pos);
                }
            } else {
                swapPos = this.getLeftChild(pos);
            }
            if (heap[pos] < heap[this.getLeftChild(pos)] || heap[pos] < heap[this.getRightChild(pos)]) {
                this.swap(pos, swapPos);
                this.maxHeapify(swapPos);
            }
        }
    }

    public void enqueue(int element) {
        if (this.currentSize >= maxSize) {
            return;
        }
        heap[++currentSize] = element;
        int current = currentSize;
        while (heap[current] > heap[this.getParent(current)]) {
            this.swap(current, this.getParent(current));
            current = this.getParent(current);
        }
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public void print() {
        for(int i = 1; i <= currentSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public int dequeue() {
        int front = heap[FRONT];
        heap[FRONT] = heap[currentSize--];
        this.maxHeapify(FRONT);
        return front;
    }

    public int front() {
        if(!this.isEmpty()) {
            return heap[FRONT];
        }
        return heap[0];
    }
}
