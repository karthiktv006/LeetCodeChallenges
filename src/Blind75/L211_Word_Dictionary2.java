package Blind75;

import DataStructures.TrieNode;

class WordDictionary2 {
    TrieNode root;

    public WordDictionary2() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        System.out.println(word);
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.arr[c - 97] == null) {
                TrieNode node = new TrieNode(c);
                curr.arr[c - 97] = node;
            }
            curr = curr.arr[c - 97];
        }
        curr.lastChar = true;
    }

    public boolean search(String word, TrieNode curr, int i) {
        for (int index = i; index < word.length(); index++) {
            char c = word.charAt(index);

            // read this if and else to make sure every case is covered
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.arr[j] != null) {
                        if (search(word, curr.arr[j], index + 1)) {
                            return true;
                        }
                    }
                }
                return false; // this was missed in initial solution
            } else {
                if (curr.arr[c - 97] == null) {
                    return false;
                }
                curr = curr.arr[c - 97];

            }
        }
        return curr.lastChar;
    }

    public boolean search(String word) {
        System.out.println(word);
        return search(word, this.root, 0);
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

public class L211_Word_Dictionary2 {
    public static void main(String[] args) {
        WordDictionary2 dict = new WordDictionary2();
        dict.insert("a");
        dict.insert("ab");
        System.out.println(dict.search("."));
        System.out.println(dict.search("a"));
        System.out.println(dict.search("ab"));
        System.out.println(dict.search("a"));
        System.out.println(dict.search(".a"));
        System.out.println(dict.search("a."));
        System.out.println(dict.search(".b"));
        System.out.println(dict.search("a.."));

    }
}
