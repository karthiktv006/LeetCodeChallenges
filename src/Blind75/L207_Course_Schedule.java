package Blind75;

import Helper.L207;

import java.util.*;

class Node {
    int val;
    List<Node> prereq;

    Node() {
        this.val = 0;
        this.prereq = new ArrayList<>();
    }

    Node(int val) {
        this.val = val;
        this.prereq = new ArrayList<>();
    }

    Node(int val, List<Node> prereq) {
        this.val = val;
        this.prereq = prereq;
    }
}

public class L207_Course_Schedule {
    public static void main(String[] args) {
        int[][] prerequisites = L207.tc5();

        System.out.println(canFinish(8, prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;

        HashMap<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            Node node = new Node(i);
            map.put(i, node);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int courseNum = prerequisites[i][0];
            int prereqNum = prerequisites[i][1];
            Node node = map.get(courseNum);
            Node preNode = map.get(prereqNum);
            node.prereq.add(preNode);
        }

        System.out.println("test 1 " + checkCycle(map.get(1)));

        for (Node pre: map.get(1).prereq) {
            System.out.println("pre.val = " + pre.val);
        }

        for (int i = 0; i < numCourses; i++) {
            Node node = map.get(i);
            if (!checkCycle(node)) {
                System.out.println(i);
                return false;
            }
        }

        return true;
    }

    public static boolean checkCycle(Node node) {
        return dfs(node, null);
    }

    public static boolean checkCycleBfs(Node node) {
        return bfs(node);
    }

    // Time limit exceed on 2000 courses
    public static boolean dfs(Node node, Stack<Integer> stack) {
        if (node.prereq.isEmpty()) return true;
        boolean check = true;
        if (stack == null) {
            stack = new Stack<Integer>();
        } else {
            if (stack.contains(node.val)) return false;
        }
        stack.push(node.val);

        for (Node pre : node.prereq) {
            System.out.println(pre.val);
            if (!dfs(pre, stack)) {
                return false;
            }
            if (!stack.isEmpty()) stack.pop();
        }

        return check;

    }

    public static boolean bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            stack.push(node);
            for (Node pre : node.prereq) {
                if (stack.contains(pre)) return false;
                queue.add(pre);
            }
            stack.pop();
        }
        return true;
    }
}
