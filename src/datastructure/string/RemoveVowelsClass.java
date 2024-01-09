package datastructure.string;

public class RemoveVowelsClass {
    private String input;

    public RemoveVowelsClass(String input) {
        this.input = input;
    }

    public String removeVowels() {
        return input.replaceAll("[aeiouAEIOU]", "");
    }

    public static void main(String[] args) {
        RemoveVowelsClass vowelsRemover = new RemoveVowelsClass("Hello World!");
        String withoutVowels = vowelsRemover.removeVowels();
        System.out.println("Without vowels: " + withoutVowels);
    }
}
