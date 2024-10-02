package Blind75;

import DataStructures.Node;
import Helper.L133;

import java.util.*;

public class L133_Clone_Graph {
    public static void main(String[] args) {
        Node node = L133.tc1();
        cloneGraph(node);
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        queue.add(node);
        Node res = null;
        Node copyNode;

        while (!queue.isEmpty()) {
            node = queue.remove();
            if (res == null) {
                copyNode = new Node(node.val);
                map.put(copyNode.val, copyNode);
                res = copyNode;
            } else {
                copyNode = map.get(node.val);
            }

            List<Node> neighbors = node.neighbors;
            for (Node neighbor : neighbors) {
                if (map.get(neighbor.val) == null) {
                    System.out.println("neighbor.val = " + neighbor.val);
                    Node newNode = new Node(neighbor.val);
                    queue.add(neighbor);
                    map.put(newNode.val, newNode);
                    copyNode.neighbors.add(newNode);
                } else {
                    Node existingNode = map.get(neighbor.val);
                    copyNode.neighbors.add(existingNode);
                }
            }
        }
        System.out.println(res);
        return res;
    }
}
