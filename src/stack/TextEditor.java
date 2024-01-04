package stack;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    private Stack<String> stack;
    private String currentText;

    public TextEditor() {
        this.stack = new Stack<>();
        this.currentText = "";
    }

    public void appendText(String newText) {
        this.currentText = this.currentText.concat(newText);
        stack.push(this.currentText);
    }

    public void eraseText(int number) {
        this.currentText = this.currentText.substring(0, this.currentText.length() - number);
        this.stack.push(this.currentText);
    }

    public void printCharacter(int index) {
        System.out.println(this.currentText.charAt(index - 1));
    }

    public void undo() {
        this.stack.pop();
        if (!this.stack.isEmpty()) {
            this.currentText = this.stack.peek();
        } else {
            this.currentText = "";
        }
    }

    public String getCurrentText() {
        return this.currentText;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of edits: ");
        int numberOfEdits = scanner.nextInt();
        scanner.nextLine();

        TextEditor textEditor = new TextEditor();

        while (numberOfEdits-- > 0) {
            System.out.print("Enter the type of operation: ");
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.print("Enter the text you want to append: ");
                    String text = scanner.next();
                    textEditor.appendText(text);
                    System.out.print("The current text: " + textEditor.getCurrentText());
                    break;
                case 2:
                    System.out.print("Enter the index of character you want to see: ");
                    int index = scanner.nextInt();
                    textEditor.eraseText(index);
                    System.out.print("The current text: " + textEditor.getCurrentText());
                    break;
                case 3:
                    textEditor.printCharacter(scanner.nextInt());
                    break;
                case 4:
                    textEditor.undo();
                    System.out.print("The current text: " + textEditor.getCurrentText());
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}

