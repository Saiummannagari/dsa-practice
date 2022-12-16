package dsa.Graphs;/*
Time Complexity: O(V+E)
naive approach Time complexity: O(E(V+E))
 */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TarjansCutVertex {

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

    static class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
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

    static void tarjansAlgo(int n, LinkedList[] list) {
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        int timer =0;
        ArrayList<Pair> pair = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(disc[i]==-1) {
            dfs(i, n, list, low, parent, disc, timer, pair);
            }
        }

        //printing edges
        for(int i=0;i<pair.size();i++) {
            System.out.println(pair.get(i).start + " "+ pair.get(i).end);
        }

    }

    private static void dfs(int i, int n, LinkedList[] list, int[] low, int[] parent, int[] disc, int timer, ArrayList<Pair> pair) {
        disc[i] = low[i] = timer;
        timer++;
        Iterator<Integer> itr = list[i].listIterator();
        while(itr.hasNext()) {
            int j=itr.next();
            if(disc[j] == -1) {
                parent[j]= i;
                dfs(j, n, list, low, parent, disc, timer, pair);
                low[i] = Math.min(low[i], low[j]);

                if(low[j]>disc[i]) {
                    pair.add(new Pair(i, j));
                }
            }
            else if(j!=parent[i]) {
                low[i] = Math.min(low[i], disc[j]);
            }
        }
    }
}