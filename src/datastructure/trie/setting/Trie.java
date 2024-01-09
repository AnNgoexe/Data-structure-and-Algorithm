package datastructure.trie.setting;

import java.util.ArrayList;
import java.util.List;
public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            TrieNode nextNode = node.getChild(c);
            if (nextNode == null) {
                nextNode = new TrieNode();
                node.setChild(c, nextNode);
            }
            node = nextNode;
        }
        node.setEndOfWord(true);
    }

    private void depthFirstSearch(TrieNode node, String prefix, List<String> words) {
        if (node.isEndOfWord()) {
            words.add(prefix);
        }
        for (char c : node.getChildren().keySet()) {
            this.depthFirstSearch(node.getChild(c), prefix + c, words);
        }
    }

    public List<String> getWordsStartingWith(String prefix) {
        List<String> words = new ArrayList<>();
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.getChild(c);
            if (node == null) {
                return new ArrayList<>();
            }
        }
        if (node != null) {
            this.depthFirstSearch(node, prefix, words);
        }
        return words;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.getChild(c);
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord();
    }

    private void delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (current.isEndOfWord()) {
                current.setEndOfWord(false);
            }
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChild(ch);
        if (node == null) {
            return;
        }
        this.delete(node, word, index + 1);
        if (node.getChildren().isEmpty() && !node.isEndOfWord()) {
            current.getChildren().remove(ch);
        }
    }

    public void delete(String word) {
        if (this.search(word)) {
            delete(root, word, 0);
        }
    }

    public void edit(String oldWord, String newWord) {
        this.delete(oldWord);
        this.insert(newWord);
    }
}