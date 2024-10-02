package Helper;

import DataStructures.Node;

import java.util.ArrayList;
import java.util.List;

public class L133 {
    public static Node tc1() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        List<Node> l1 = new ArrayList<>(){{add(n2); add(n4);}};
        List<Node> l2 = new ArrayList<>(){{add(n1); add(n3);}};
        List<Node> l3 = new ArrayList<>(){{add(n2); add(n4);}};
        List<Node> l4 = new ArrayList<>(){{add(n1); add(n3);}};
        n1.neighbors = l1;
        n2.neighbors = l2;
        n3.neighbors = l3;
        n4.neighbors = l4;

        return n1;
    }
}
