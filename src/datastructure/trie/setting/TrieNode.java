package datastructure.trie.setting;

import java.util.Map;
import java.util.TreeMap;

public class TrieNode {
    private boolean isEndOfWord;
    private Map<Character, TrieNode> children;

    public TrieNode() {
        this.children = new TreeMap<>();
        this.isEndOfWord = false;
    }

    public TrieNode getChild(char ch) {
        return this.children.get(ch);
    }

    public Map<Character, TrieNode> getChildren() {
        return this.children;
    }

    public void setChild(char ch, TrieNode node) {
        this.children.put(ch, node);
    }

    public boolean isEndOfWord() {
        return this.isEndOfWord;
    }

    public void setEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }
}