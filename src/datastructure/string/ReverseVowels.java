package datastructure.string;

public class ReverseVowels {
    private String input;

    public ReverseVowels(String input) {
        this.input = input;
    }

    public String reverseVowels() {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }

            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            if (left < right) {
                // Swap vowels
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        ReverseVowels vowelReverser = new ReverseVowels("Hello World!");
        String reversedVowels = vowelReverser.reverseVowels();
        System.out.println("Reversed vowels: " + reversedVowels);
    }
}
