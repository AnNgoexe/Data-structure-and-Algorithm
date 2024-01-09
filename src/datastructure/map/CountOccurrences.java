package datastructure.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOccurrences {
    public Map<Integer, Integer> count(int[] nums) {
        Map<Integer, Integer> occurrencesMap = new HashMap<>();
        for (int num : nums) {
            occurrencesMap.put(num, occurrencesMap.getOrDefault(num, 0) + 1);
        }
        return occurrencesMap;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 1, 2, 2, 3, 4, 5, 1};
        System.out.println("Array: " + Arrays.toString(numbers));
        CountOccurrences countOccurrences = new CountOccurrences();
        Map<Integer, Integer> occurrences = countOccurrences.count(numbers);

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            System.out.println("Number: " + entry.getKey() + ", Occurrences: " + entry.getValue());
        }
    }
}
