package datastructure.hashtable.seperatechaining;

import datastructure.hashtable.DataItem;
import java.util.LinkedList;

public class HashTable {
    private LinkedList<DataItem>[] table;
    private int size;

    public HashTable(int capacity) {
        this.table = new LinkedList[capacity];
        this.size = 0;
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void add(int key, int value) {
        int index = this.hash(key);
        if (this.table[index] == null) {
            this.table[index] = new LinkedList<>();
        }
        table[index].add(new DataItem(key, value));
        size++;
    }

    public int search(int key) {
        int index = this.hash(key);
        if (this.table[index] != null) {
            for (DataItem data : table[index]) {
                if (data.getKey() == key) {
                    return data.getData();
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = this.hash(key);
        if (table[index] != null) {
            table[index].removeIf(item -> item.getKey() == key);
            size--;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);

        hashTable.add(1, 10);
        hashTable.add(2, 20);
        hashTable.add(3, 30);

        System.out.println("Size: " + hashTable.size());

        System.out.println("Value for key 2: " + hashTable.search(2));

        hashTable.remove(1);

        System.out.println("Size after removing key 1: " + hashTable.size());
    }
}
