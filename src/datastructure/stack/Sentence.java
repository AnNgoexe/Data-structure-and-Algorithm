package datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class Sentence {
    public String reverseIndividualWords(String sentence) {
        Stack<String> stack = new Stack<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            stack.push(word);
        }
        StringBuilder reversedSentence = new StringBuilder();
        while (!stack.empty()) {
            reversedSentence.append(stack.pop());
            reversedSentence.append(" ");
        }
        return reversedSentence.toString().trim();
    }

    public static void main(String[] args) {
        Sentence sentence = new Sentence();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        String reversedSentence = sentence.reverseIndividualWords(inputString);
        System.out.println("Reversed string: " + reversedSentence);
    }
}
