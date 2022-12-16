package dsa.Graphs;/*
Clone graph using BFS

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors
 */

import java.util.*;

public class GraphCloneUsingDFS {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        Map<Node, Node> map = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node == null) {
                return null;
            }
            map.put(node, new Node(node.val, new ArrayList<>()));

            for(Node neighbor: node.neighbors){
                if(map.containsKey(neighbor)) {
                    map.get(node).neighbors.add(map.get(neighbor));
                } else {
                    map.get(node).neighbors.add(cloneGraph(neighbor));
                }
            }
            return map.get(node);
        }
    }

    public static void main(String[] args) {
//        Node node1 = new Node(1, new ArrayList<>(){{add(new Node(3));}});
//        Node node2 = new Node(2, new ArrayList<>(){{add(new Node(4));}});
//        Node node3 = new Node(3, new ArrayList<>(){{add(new Node(1));}});
//        Node node4 = new Node(4, new ArrayList<>(){{add(new Node(2));}});
//        Node adjList = {{2,4},{1,3},{2,4},{1,3}};
//
//
//        Node node = new Node(1, new ArrayList<>(){{add(
//                    new Node(2, new ArrayList<>(){{add(
//                    new Node(3,new ArrayList<>(){{add(
//                    new Node(4, new ArrayList)
//                    )}});}}));}});

    }
}