package Blind75;

import DataStructures.Trie;

public class L206_Trie {
    public static void main(String[] args) {
        Trie t = new Trie();
        System.out.println(t);
        t.insert("apple");
        System.out.println(t.search("applet"));
        System.out.println(t.startsWith("ap"));
    }
}
