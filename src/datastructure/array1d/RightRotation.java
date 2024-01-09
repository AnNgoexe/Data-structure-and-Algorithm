package datastructure.array1d;

import java.util.Arrays;

public class RightRotation {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        k = k % n;

        this.reverse(nums, 0, n - 1);
        this.reverse(nums, 0, k - 1);
        this.reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arrayToRotate = {1, 2, 3, 4, 5};
        int rotationSteps = 2;
        RightRotation rightRotation = new RightRotation();

        System.out.println("Original array: " + Arrays.toString(arrayToRotate));
        rightRotation.rotate(arrayToRotate, rotationSteps);
        System.out.println("Array after " + rotationSteps + " right rotation: " + Arrays.toString(arrayToRotate));
    }
}
