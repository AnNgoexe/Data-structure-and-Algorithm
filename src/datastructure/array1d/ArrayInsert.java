package datastructure.array1d;

import java.util.Arrays;

public class ArrayInsert {
    public int[] insertElement(int[] array, int element, int index) {
        if (index >= 0 && index <= array.length) {
            int[] newArray = new int[array.length + 1];

            for (int i = 0, j = 0; i < newArray.length; i++) {
                if (i != index) {
                    newArray[i] = array[j++];
                } else {
                    newArray[i] = element;
                }
            }

            return newArray;
        } else {
            System.out.println("Invalid index to insert");
            return array;
        }
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int elementToInsert = 6;
        int indexToInsert = 2;

        ArrayInsert arrayInsert = new ArrayInsert();
        int[] newArray = arrayInsert.insertElement(originalArray, elementToInsert, indexToInsert);
        System.out.print("Original array: " + Arrays.toString(originalArray));
        System.out.print("\nArray after insertion: " + Arrays.toString(newArray));
    }
}
