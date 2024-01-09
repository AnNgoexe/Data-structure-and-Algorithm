package datastructure.map;

import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    private Map<String, String> wordMap;

    public Dictionary() {
        this.wordMap = new TreeMap<>();
    }

    public void printDictionary() {
        System.out.println("Dictionary:");
        for (Map.Entry<String, String> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    public void addWord(String word, String definition) {
        wordMap.put(word, definition);
        System.out.println("Word added: " + word + " - " + definition);
    }

    public void deleteWord(String word) {
        if (wordMap.containsKey(word)) {
            wordMap.remove(word);
            System.out.println("Word deleted: " + word);
        } else {
            System.out.println("Word not found: " + word);
        }
    }

    public void editDefinition(String word, String newDefinition) {
        if (wordMap.containsKey(word)) {
            wordMap.put(word, newDefinition);
            System.out.println("Definition updated for word: " + word);
        } else {
            System.out.println("Word not found: " + word);
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("apple", "a fruit with a red or green skin and a whitish interior");
        dictionary.addWord("book", "a set of written or printed pages, usually bound with a protective cover");
        dictionary.printDictionary();
        dictionary.deleteWord("apple");
        dictionary.printDictionary();
        dictionary.editDefinition("book", "a written or printed work consisting of pages glued or sewn together along one side");
        dictionary.printDictionary();
    }
}
