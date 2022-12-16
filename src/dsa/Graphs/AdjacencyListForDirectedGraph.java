package dsa.Graphs;

import java.util.*;

public class AdjacencyListForDirectedGraph {

    public static class Graph {
        private int numVertices;
        private List<ArrayList<Integer>> list;

        public Graph(int vertices) {
            this.numVertices = vertices;
            list = new ArrayList<>();
            for(int i=0;i<vertices;i++) {
                list.add(new ArrayList<>());
            }
        }

        public void addEdge(int i, int j) {
            list.get(i).add(j);
        }

        public void removeEdge(int i, int j) {
            list.get(i).remove((Object)j);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            final int[] i = {0};
            list.forEach(entry -> {
                sb.append(i[0] +"-->");
                entry.forEach(value ->sb.append(value+" "));
                sb.append("\n");
            i[0]++;});
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
