package dsa.Graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/*
Tarjan's algorithm for finding articulation points
Naive approach: O(V*(V+E))
Time complexity: O(V+E)
 */
public class TarjansArticulationPoints {

    static class Graph {
        LinkedList<Integer>[] list;

        public Graph(int n) {
            list = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new LinkedList<>();
            }
        }

        //undirected graph
        public void add_edge(int i, int j) {
            list[i].add(j);
            list[j].add(i);
        }

        public LinkedList<Integer>[] returnList() {
            return list;
        }
    }

    public static void main(String[] args) {
        int n=5;
        Graph g = new Graph(n);
        g.add_edge(0,2);
        g.add_edge(0,3);
        g.add_edge(1,0);
        g.add_edge(1,2);
        g.add_edge(3,4);
        LinkedList<Integer>[]  list = g.returnList();
        tarjansAlgo(n, list);

    }

    public static void tarjansAlgo(int n, LinkedList[] list) {
        int[] parent = new int[n];

        //maintaining discovery and low times
        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        //storing articulation points
        boolean[] ap = new boolean[n];

        //intializing timer
        int counter=0;
        for(int i=0;i<n;i++) {
            if(disc[i]==-1) {
                dfs(i, counter, n, list, ap, low, disc, parent);
            }
        }

        for(int i=0;i<n;i++) {
            if(ap[i]) {
                System.out.print(i+" ");
            }
        }

    }

    public static void dfs(int i, int counter, int n, LinkedList[] list, boolean[] ap, int[] low, int[] disc, int[] parent) {
        int children =0;
        low[i]= disc[i] = counter;
        counter=counter+1;
        Iterator<Integer> itr = list[i].listIterator();
        while(itr.hasNext()) {
            int j = itr.next();
              if(disc[j]==-1) {
                  children= children+1;
                  parent[j] = i;
                  dfs(j, counter, n, list, ap, low, disc, parent);
                  low[i] = Math.min(low[i], low[j]);

                  if(parent[i]==-1 && children>1)	//Case-1: U is root
                  {
                      ap[i] = true;
                  }
                  if(parent[i]!=-1 && low[j]>=disc[i])	//Case-2: Atleast 1 component will get separated
                  {
                      ap[i] = true;
                  }
              }

              else if(j!=parent[i]) { //Ignore child to parent edge
                  //back edge
                      low[i] = Math.min(low[i],disc[j]);
              }
        }

    }
}