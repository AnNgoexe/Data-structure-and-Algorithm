package array1d;

import java.util.Arrays;

public class ReverseOperation {
    public void reverse(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseOperation reverseOperation = new ReverseOperation();
        int[] arrayToReverse = {1, 2, 3, 4, 5};

        System.out.println("Original array: " + Arrays.toString(arrayToReverse));
        reverseOperation.reverse(arrayToReverse);
        System.out.println("Reversed array: " + Arrays.toString(arrayToReverse));
    }
}
