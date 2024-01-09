package datastructure.string;

public class PalindromeChecker {
    private String input;

    public PalindromeChecker(String input) {
        this.input = input;
    }

    public boolean isPalindrome() {
        if (input == null) {
            return false;
        }
        String str = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String getInput() {
        return input;
    }

    public static void main(String[] args) {
        PalindromeChecker palindromeChecker1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker palindromeChecker2 = new PalindromeChecker("Hello World");

        System.out.println("Is \"" + palindromeChecker1.getInput() + "\" a palindrome? " + palindromeChecker1.isPalindrome());
        System.out.println("Is \"" + palindromeChecker2.getInput() + "\" a palindrome? " + palindromeChecker2.isPalindrome());
    }
}
