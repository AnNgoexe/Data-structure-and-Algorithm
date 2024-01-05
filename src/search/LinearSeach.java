package search;

import java.util.Arrays;

public class LinearSeach {
    public int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 2, 1, 7, 4, 6};
        System.out.print("The array: ");
        System.out.println(Arrays.toString(array));
        LinearSeach linearSeach = new LinearSeach();

        int target = 4;
        int result = linearSeach.search(array, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}
