package dsa.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class CycleDetectionInUG {

        static class Graph {
            int numVertices;
            LinkedList<Integer>[] lists;
            int[] visited;

            public Graph(int num) {
                this.numVertices =  num;
                lists = new LinkedList[num];
                for(int i=0;i<numVertices;i++) {
                    lists[i] = new LinkedList<>();
                }
                visited = new int[num];
            }
            public void addEdge(int i, int j) {
                lists[i].add(j);
                lists[j].add(i);
            }

         boolean isCyclic() {
                int[] visited = new int[numVertices];
                for(int i=0;i<numVertices;i++) {
                    visited[i] = 1;
                    Iterator<Integer> itr = lists[i].listIterator();
                    while(itr.hasNext()) {
                        if(isCyclicUtil(visited, i, itr.next())) {
                            return true;
                        }
                    }
                    visited[i] = 0;
                }
                return false;
            }

         boolean isCyclicUtil(int[] visited, int parent, int node) {
                if(visited[node]== 2) {
                    return true;
                }

                visited[node] = 1;
                Iterator<Integer> itr = lists[node].listIterator();
                while(itr.hasNext()) {
                       int node1 = itr.next();
                       if(visited[node1] == 1 && node1!=parent) {
                           visited[node1] = 2;
                       }
                       else {
                           if(node1!=parent && isCyclicUtil(visited,node, node1)) {
                               return true;
                           }
                       }

                }
             visited[node] = 0;
             return false;
         }
        }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
     //   g.addEdge(3,2);
    //    g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
//        g.addEdge(3,1);

        System.out.println(g);
        System.out.println(g.isCyclic());
    }
}