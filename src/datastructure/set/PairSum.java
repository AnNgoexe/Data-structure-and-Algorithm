package datastructure.set;

import java.util.HashSet;
import java.util.Set;

public class PairSum {
    private Set<Integer> seenNumbers;

    public PairSum() {
        this.seenNumbers = new HashSet<>();
    }

    public void findPairsWithSum(int[] array, int targetSum) {
        if (array == null || array.length < 2) {
            System.out.println("Not enough elements in the array to form pairs.");
            return;
        }
        for (int num : array) {
            int complement = targetSum - num;
            if (seenNumbers.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
            }
            seenNumbers.add(num);
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 6, 5, 8, 2, 7};
        int targetSum = 10;

        PairSum pairSum = new PairSum();
        System.out.println("Pairs with sum " + targetSum + ":");
        pairSum.findPairsWithSum(array, targetSum);
    }
}
