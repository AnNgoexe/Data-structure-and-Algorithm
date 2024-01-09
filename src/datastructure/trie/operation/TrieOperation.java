package datastructure.trie.operation;

import datastructure.trie.setting.Trie;

public class TrieOperation {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");
        trie.insert("bat");
        trie.insert("batman");

        System.out.println("Words starting with 'app': " + trie.getWordsStartingWith("app"));

        System.out.println("Search for 'batman': " + trie.search("batman"));
        System.out.println("Search for 'batwoman': " + trie.search("batwoman"));

        trie.delete("apple");
        System.out.println("After deleting 'apple', words starting with 'app': " + trie.getWordsStartingWith("app"));

        trie.edit("app", "application");
        System.out.println("After editing 'app' to 'application', words starting with 'app': " + trie.getWordsStartingWith("app"));
    }
}
