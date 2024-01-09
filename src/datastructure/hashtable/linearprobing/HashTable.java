package datastructure.hashtable.linearprobing;

import datastructure.hashtable.DataItem;

public class HashTable {
    private DataItem[] hashArray;
    private int size;

    public HashTable(int size){
        this.size = size;
        this.hashArray = new DataItem[size];
    }

    public int hashCode(int key){
        return key % size;
    }

    public void insert(DataItem item){
        int key = item.getKey();
        int hashIndex = this.hashCode(key);
        while(this.hashArray[hashIndex] != null){
            ++hashIndex;
            hashIndex %= size;
        }
        this.hashArray[hashIndex] = item;
    }

    public void display(){
        for(int i = 0; i < this.size; i++) {
            if(this.hashArray[i] != null) {
                System.out.print(" ("
                        + hashArray[i].getKey() + ","
                        + hashArray[i].getData() + ") ");
            } else {
                System.out.print(" ~~ ");
            }
        }
        System.out.println("");
    }

    public DataItem search(int key){
        int hashIndex = hashCode(key);
        while(hashArray[hashIndex] != null) {
            if(hashArray[hashIndex].getKey() == key) {
                return hashArray[hashIndex];
            }
            ++hashIndex;
            hashIndex %= size;
        }
        return null;
    }

    public DataItem delete(DataItem item){
        int key = item.getKey();
        int hashIndex = hashCode(key);
        while(this.hashArray[hashIndex] != null) {
            if(this.hashArray[hashIndex].getKey() == key) {
                DataItem temp = hashArray[hashIndex];
                hashArray[hashIndex] = new DataItem(-1,-1);
                return temp;
            }
            ++hashIndex;
            hashIndex %= size;
        }
        return null;
    }

    public static void main(String[] args){
        HashTable hashTable = new HashTable(20);

        hashTable.insert(new DataItem(1, 20));
        hashTable.insert(new DataItem(2, 70));
        hashTable.insert(new DataItem(42, 80));
        hashTable.insert(new DataItem(4, 25));
        hashTable.insert(new DataItem(12, 44));
        hashTable.insert(new DataItem(14, 32));
        hashTable.insert(new DataItem(17, 11));
        hashTable.insert(new DataItem(13, 78));
        hashTable.insert(new DataItem(37, 97));

        hashTable.display();

        DataItem item = hashTable.search(37);

        if(item != null) {
            System.out.println("Element found: "+ item.getData());
        } else {
            System.out.println("Element not found");
        }

        hashTable.delete(item);
        item = hashTable.search(37);
        if (item != null) {
            System.out.println("Element found: "+ item.getData());
        } else {
            System.out.println("Element not found");
        }
    }
}
