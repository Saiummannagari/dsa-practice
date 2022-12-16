package dsa.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    static class Graph {
        int numVertices;
        LinkedList<Integer>[] lists;

        public Graph(int num) {
            this.numVertices =  num;
            lists = new LinkedList[num];
            for(int i=0;i<numVertices;i++) {
                lists[i] = new LinkedList<>();
            }
        }
        public void addEdge(int i, int j) {
            lists[i].add(j);
        }

        public void removeEdge(int i, int j) {
            lists[i].remove((Object)j);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<lists.length;i++) {
                sb.append(i+"->");
                lists[i].forEach(value -> {
                    sb.append(value + " ");
                });
                sb.append("\n");
            }
            return sb.toString();
        }


        void bfs(int s) {
            boolean[] visited = new boolean[numVertices];
            visited[s] = true;
            LinkedList<Integer> stack = new LinkedList<>();
            stack.add(s);
            while(!stack.isEmpty()) {
                int ele = stack.poll();
                System.out.print(ele+ " ");
                //point to be noted
                Iterator<Integer> itr = lists[ele].listIterator();
                while (itr.hasNext()) {
                    int n = itr.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        stack.add(n);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(g);
        g.bfs(2);
    }
}