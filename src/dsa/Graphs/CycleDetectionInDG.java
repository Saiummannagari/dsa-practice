package dsa.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class CycleDetectionInDG {
    static class Graph {
        int numVertices;
        LinkedList<Integer>[] lists;
        int[] visited;

        public Graph(int num) {
            this.numVertices = num;
            lists = new LinkedList[num];
            for (int i = 0; i < numVertices; i++) {
                lists[i] = new LinkedList<>();
            }
            visited = new int[num];
        }

        public void addEdge(int i, int j) {
            lists[i].add(j);
        }

        boolean isCyclic() {
            boolean[] visited = new boolean[numVertices];
            for(int i=0;i<numVertices;i++) {
                visited[i] = true;
                Iterator<Integer> itr = lists[i].listIterator();
                while(itr.hasNext()) {
                    if(isCyclicUtil(visited, itr.next())){
                        return true;
                    }
                }
                visited[i] = false;
            }
            return false;
        }

        boolean isCyclicUtil(boolean[] visited, int node) {
            if(visited[node] == true) {
                return true;
            }
            visited[node] = true;
            Iterator<Integer> itr = lists[node].listIterator();
            while(itr.hasNext()) {
                if(isCyclicUtil(visited, itr.next())) {
                    return true;
                }
            }
            visited[node] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0,1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        //    g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
    //    g.addEdge(3,1);

        System.out.println(g);
        System.out.println(g.isCyclic());
    }
}