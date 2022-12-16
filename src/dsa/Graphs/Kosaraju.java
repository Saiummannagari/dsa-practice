package dsa.Graphs;/*
Kosaraju algorithm is used for finding strongly connected graphs

Kosaraju's algorithm runs in linear time i.e. 3*O(V+E) i.e. O(E+V)
 */

import java.util.*;

class Kosaraju {

    static class Graph {
        LinkedList<Integer>[] list;
        public Graph(int n) {
            list = new LinkedList[n];
            for(int i=0;i<n;i++) {
                list[i] = new LinkedList<>();
            }
        }

        public void add_edge(int i, int j) {
          list[i].add(j);
        }

       public LinkedList<Integer>[] returnList(){
            return list;
       }
    }
    public static void main(String[] args) {
        int n=8;
        Graph g = new Graph(n);
        g.add_edge(0, 1);
        g.add_edge(1, 2);
        g.add_edge(2, 3);
        g.add_edge(2, 4);
        g.add_edge(3, 0);
        g.add_edge(4, 5);
        g.add_edge(5, 6);
        g.add_edge(6, 4);
        g.add_edge(6, 7);
        LinkedList<Integer>[] list = g.returnList();
        kosarajuAlgo(list, n);
    }

    public static void kosarajuAlgo(LinkedList<Integer>[] list, int n) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfsUtil1(list, visited, stack, i);
            }
        }
        LinkedList<Integer>[] list1 = Transpose(n, list);
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        while (stack.empty() == false) {
            int s = stack.pop();

            if (!visited[s]) {
                dfsUtil2(list1,visited,s);
                System.out.println();
            }
        }

    }

    private static void dfsUtil2(LinkedList<Integer>[] list,
                          boolean[] visited,
                          int i) {
        visited[i] = true;
        System.out.print(i + " ");
        Iterator<Integer> itr = list[i].listIterator();
        while(itr.hasNext()) {
            int k = itr.next();
            if(!visited[k]) {
                dfsUtil2(list, visited,k);
            }
        }
    }

    static LinkedList[] Transpose(int n, LinkedList[] list) {
        LinkedList[] list1 = new LinkedList[n];
        for(int i=0;i<n;i++) {
            list1[i] = new LinkedList<>();
        }
        for (int s = 0; s < n; s++) {
            Iterator<Integer> i = list[s].listIterator();
            while (i.hasNext())
                list1[i.next()].add(s);
        }
        return list1;
    }
    private static void dfsUtil1(LinkedList<Integer>[] list,
                         boolean[] visited,
                         Stack stack, int i) {
        visited[i] = true;
        Iterator<Integer> itr = list[i].listIterator();
        while(itr.hasNext()) {
              int k = itr.next();
              if(!visited[k]) {
                  dfsUtil1(list, visited, stack,k);
              }
        }
        stack.push(i);
    }
}