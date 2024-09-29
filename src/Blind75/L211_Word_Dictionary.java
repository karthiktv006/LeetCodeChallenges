package Blind75;

import DataStructures.TrieNode;

// Timed out for very large dictionary due to large number of nodes (we are creating dummy . nodes for all children)
// this increases the number of path and hence timed out.
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        System.out.println(word);
        insert(word, this.root, 0);
        System.out.println();
    }

    public void insert(String word, TrieNode root, int i) {
        if (i < word.length()) {
            char c = word.charAt(i);
            if (root.arr[c - 97] == null) {
                TrieNode node1 = new TrieNode(c);
                root.arr[c - 97] = node1;
            }
            if (root.arr[26] == null) {
                TrieNode node2 = new TrieNode('.');
                root.arr[26] = node2;
            }

            insert(word, root.arr[c - 97], i + 1);
            insert(word, root.arr[26], i + 1);
        } else {
            root.lastChar = true;
        }
    }

    public boolean search(String word) {
        System.out.println(word);
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.' && curr.arr[26] != null) {
                curr = curr.arr[26];
            } else if (c != '.' && curr.arr[c - 97] != null) {
                curr = curr.arr[c - 97];
            } else {
                return false;
            }
        }
        return curr.lastChar;
    }

    public boolean startsWith(String prefix) {
        System.out.println(prefix);
        TrieNode curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (curr.arr[c - 97] != null) {
                curr = curr.arr[c - 97];
            } else {
                return false;
            }
        }
        return true;
    }
}

public class L211_Word_Dictionary {
    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.insert("a");
        dict.insert("ab");
//        System.out.println(dict.search("."));
        System.out.println(dict.search("a"));
//        System.out.println(dict.search("a"));
//        System.out.println(dict.search(".a"));
        System.out.println(dict.search("a."));

    }
}
