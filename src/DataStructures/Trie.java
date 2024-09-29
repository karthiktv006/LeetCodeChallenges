package DataStructures;

public class Trie {

    TrieNode root;

    public Trie() {
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

    public boolean search(String word) {
        System.out.println(word);
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.arr[c - 97] != null) {
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
