package org.personal.DataStructures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    private final HashMap<Character, TrieNode> children;
    private boolean isEndOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }
    public boolean getIsEndOfWord(){
        return this.isEndOfWord;
    }
    public void setIsEndOfWord(boolean isWord){
        this.isEndOfWord = isWord;
    }
}
public class Trie {
    private TrieNode root = new TrieNode();

    // Constructors
    public Trie(String s){
        this.insert(s);
    }
    public Trie(String[] words){
        for(String word: words){
            this.insert(word);
        }
    }
    public Trie(List<String> words){
        for(String word: words){
            this.insert(word);
        }
    }

    // Methods
    public void insert(String key){
        TrieNode curr = this.root;
        for(char c: key.toCharArray()){
            if(!curr.getChildren().containsKey(c)){
                curr.getChildren().put(c, new TrieNode());
            }
            curr = curr.getChildren().get(c);
        }
        curr.setIsEndOfWord(true);
    }
    public boolean contains(String key){
        TrieNode curr = this.root;
        for(char c: key.toCharArray()){
            if(!curr.getChildren().containsKey(c)){
                return false;
            }
            curr = curr.getChildren().get(c);
        }
        return true;
    }
    public boolean containsWord(String key){
        TrieNode curr = this.root;
        for(char c: key.toCharArray()){
            if(!curr.getChildren().containsKey(c)){
                return false;
            }
            curr = curr.getChildren().get(c);
        }
        return curr.getIsEndOfWord();
    }

    
}
