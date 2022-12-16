package dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
Check a graph is connected or not
check there is no cycle in the graph
 */
class CheckIfAGraphIsTree {

    public static class Graph {
        private int numVertices;
        private List<ArrayList<Integer>> list;

        public Graph(int vertices) {
            this.numVertices = vertices;
            list = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                list.add(new ArrayList<>());
            }
        }

        public void addEdge(int i, int j) {
            list.get(j).add(i);
            list.get(i).add(j);
        }

    }
        public static void main(String[] args) {
            int n = 4;
            Graph g = new Graph(n);
            g.addEdge(0, 1);
            g.addEdge(1, 3);
            g.addEdge(0, 2);
            System.out.println(checkGraphIsTree(g, n));
        }


    static boolean checkGraphIsTree(Graph g, int n) {
        //take int array as it is undirected graph
        int[] visited = new int[n];
        Arrays.fill(visited, 0);

        for(int i=0;i<n;i++) {


            Optional<Integer> k = g.list.get(i).stream().findFirst();
            if(k.isPresent()) {
                visited[i] = 1;
                if (cyclePresent(g, i, k.get(), visited)) {
                    return false;
                }
            }
                 for(int j=0;j<n;j++) {
               if(visited[j]==0) {
                return false;
            }
            }
        }
        return true;
    }

    static boolean cyclePresent(Graph g, int parent, int i, int[] visited) {
        if(visited[i] == 2) {
            return true;
        }
        visited[i] = 1;

        ArrayList<Integer> list = g.list.get(i);
        for(Integer j : list) {
            if(visited[j] == 1 && j!=parent) {
                visited[j] =2;
            }
            else {
                if(j!=parent && cyclePresent(g, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


}