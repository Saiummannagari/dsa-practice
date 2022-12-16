package dsa.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class UndirectedGraphRepresentationUsingMap {

    public static class Graph {
        private int numVertices;
        private Map<Integer, LinkedList<Integer>> map;

        public Graph(int vertices) {
            this.numVertices = vertices;
            map = new HashMap<Integer, LinkedList<Integer>>();
            for(int i=0;i<vertices;i++) {
                map.put(i, new LinkedList<>());
            }
        }

        public void addEdge(int i, int j) {
            if(!map.get(i).contains(j)) {
                map.get(i).add(j);
            }
            if(!map.get(j).contains(i)) {
                map.get(j).add(i);
            }
        }

        public void removeEdge(int i, int j) {
            map.get(i).remove((Object)j);
            map.get(j).remove((Object)i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            map.entrySet().forEach(entry -> {
                sb.append(entry.getKey()+"-->");
                entry.getValue().forEach(value ->sb.append(value+" "));
                sb.append("\n");});
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,3);
        g.addEdge(3,0);
        g.addEdge(3,2);
        g.addEdge(2,0);
        g.addEdge(1,0);
        System.out.println(g);
        g.removeEdge(0,1);
        System.out.println(g);
    }
}
