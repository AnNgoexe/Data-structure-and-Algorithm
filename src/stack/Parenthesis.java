package stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/balanced-brackets/problem?isFullScreen=false

public class Parenthesis {
    public boolean isValidParenthesis(String brackets)
    {
        Stack<Character>ch = new Stack<>();
        for(char i: brackets.toCharArray()) {
            if (i == '{' || i == '(' || i == '[') {
                ch.push(i);
            } else if (i == ')') {
                if (ch.empty() || ch.peek() != '(') {
                    return false;
                }
                ch.pop();
            } else if (i == '}') {
                if (ch.empty() || ch.peek() != '{') {
                    return false;
                }
                ch.pop();
            } else if (i == ']') {
                if (ch.empty() || ch.peek() != '[') {
                    return false;
                }
                ch.pop();
            }
        }
        return ch.empty();
    }

    public static void main(String[] args) throws IOException {
        Parenthesis p = new Parenthesis();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String brackets = scanner.nextLine();
        scanner.close();
        if (p.isValidParenthesis(brackets)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}
