package datastructure.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public Set<Integer> union(int[] arrayA, int[] arrayB) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int num : arrayA) {
            setA.add(num);
        }
        for (int num : arrayB) {
            setB.add(num);
        }
        Set<Integer> unionSet = new HashSet<>(setA);
        unionSet.addAll(setB);
        return unionSet;
    }

    public Set<Integer> intersection(int[] arrayA, int[] arrayB) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int num : arrayA) {
            setA.add(num);
        }
        for (int num : arrayB) {
            setB.add(num);
        }
        Set<Integer> intersectionSet = new HashSet<>(setA);
        intersectionSet.retainAll(setB);
        return intersectionSet;
    }

    public Set<Integer> getDifferenceAMinusB(int[] arrayA, int[] arrayB) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int num : arrayA) {
            setA.add(num);
        }
        for (int num : arrayB) {
            setB.add(num);
        }
        Set<Integer> differenceAMinusB = new HashSet<>(setA);
        differenceAMinusB.removeAll(setB);
        return differenceAMinusB;
    }

    public Set<Integer> getDifferenceBMinusA(int[] arrayA, int[] arrayB) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int num : arrayA) {
            setA.add(num);
        }
        for (int num : arrayB) {
            setB.add(num);
        }
        Set<Integer> differenceBMinusA = new HashSet<>(setB);
        differenceBMinusA.removeAll(setA);
        return differenceBMinusA;
    }

    public static void main(String[] args) {
        SetOperations setOperations = new SetOperations();
        int[] arrayA = {5, 3, 8, 2, 1, 7, 4, 6};
        int[] arrayB = {4, 6, 8, 10, 12};
        System.out.println("Array A:" + Arrays.toString(arrayA));
        System.out.println("Array B:" + Arrays.toString(arrayB));

        Set<Integer> unionSet = setOperations.union(arrayA, arrayB);
        System.out.println("Union of sets A and B: " + unionSet);

        Set<Integer> intersectionSet = setOperations.intersection(arrayA, arrayB);
        System.out.println("Intersection of sets A and B: " + intersectionSet);

        Set<Integer> differenceSetA = setOperations.getDifferenceAMinusB(arrayA, arrayB);
        System.out.println("Set difference A \\ B: " + differenceSetA);

        Set<Integer> differenceSetB = setOperations.getDifferenceBMinusA(arrayA, arrayB);
        System.out.println("Set difference B \\ A: " + differenceSetB);
    }
}
