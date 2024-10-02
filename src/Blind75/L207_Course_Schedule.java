package Blind75;

import java.util.List;

class Node {
    int val;
    List<Node> prereq;

    Node() {
        this.val = 0;
        this.prereq = null;
    }

    Node(int val) {
        this.val = val;
        this.prereq = null;
    }

    Node(int val, List<Node> prereq) {
        this.val = val;
        this.prereq = prereq;
    }
}
public class L207_Course_Schedule {
}
