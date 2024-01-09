package datastructure.array1d;

import java.util.Arrays;

public class ArrayDelete {
    public int[] deleteElement(int[] array, int index) {
        if (index >= 0 && index < array.length) {
            int[] newArray = new int[array.length - 1];
            for (int i = 0, j = 0; i < array.length; i++) {
                if (i != index) {
                    newArray[j++] = array[i];
                }
            }
            return newArray;
        } else {
            System.out.println("Invalid index to delete");
            return array;
        }
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int indexToDelete = 2;

        ArrayDelete arrayDelete = new ArrayDelete();
        int[] newArray = arrayDelete.deleteElement(originalArray, indexToDelete);

        System.out.print("Original array: " + Arrays.toString(originalArray));
        System.out.print("\nArray after deletion: " + Arrays.toString(newArray));
    }
}
