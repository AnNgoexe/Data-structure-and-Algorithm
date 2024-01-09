package datastructure.set;

import java.util.Set;
import java.util.TreeSet;

public class KthLargestElement {
    public int find(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > k) {
                set.remove(set.iterator().next());
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {3, 1, 4, 6, 5, 8, 2, 7};
        int k = 3;

        int result = kthLargestElement.find(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

}
