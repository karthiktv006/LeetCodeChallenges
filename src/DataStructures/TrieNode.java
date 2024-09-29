package DataStructures;

public class TrieNode {
    public TrieNode[] arr;
    public char val;
    public boolean lastChar;

    public TrieNode() {
        init();
    }

    public TrieNode(char val) {
        this.val = val;
        init();
    }

    private void init() {
        arr = new TrieNode[26];
    }

}
