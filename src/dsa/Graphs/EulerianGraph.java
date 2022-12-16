package dsa.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

/*
Time Complexity: O(V+E)
naive approach Time complexity: O(E(V+E))
 */
public class EulerianGraph {

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
        g.add_edge(0,1);
        g.add_edge(0,2);
        g.add_edge(2, 1);
        g.add_edge(0, 3);
        g.add_edge(3,4);
        LinkedList<Integer>[]  list = g.returnList();
        findEuler_Path_Cycle(n , list);
    }

    private static void findEuler_Path_Cycle(int n, LinkedList<Integer>[] list) {
        int ret = find_Euler(n, list);
        if(ret==0) {
            System.out.println("Graph is not a euler graph");
        }
        else if(ret == 1) {
            System.out.println("Graph is semi eulerian graph");
        } else {
            System.out.println("Graph is euler graph");
        }
    }

    private static int find_Euler(int n, LinkedList<Integer>[] list) {
    if(!connectedGraph(n, list)) {
        return 0;
    }
    int odd = 0;
    for(int i=0;i<n;i++) {
       // System.out.println(list[i]+ " "+list[i].size());
        if(list[i].size()%2!=0){
            odd=odd+1;
        }
    }
    if(odd > 2) //only start and end nodes have odd degree
        return 0;
    return (odd==0)?2:1; //1-> semi-eulerian graph
    }

    private static boolean connectedGraph(int n, LinkedList<Integer>[] list) {
        boolean[] visited = new boolean[n];
        int node=-1;
        for(int i=0;i<n;i++) {
            if(list[i].size()>0) {
                node = i; //found a node to start dfs
                break;
            }
        }
        if(node == -1) {//No start node was found-->No edges are present in graph
            return true;//It's always Eulerian
        }
        dfs(node, visited, list);
        for(int i=0;i<n;i++) {
            if(visited[i] == false && list[i].size()>0) {
                return false;	//We have edges in multi-component
            }
        }
        return true;
    }

    private static void dfs(int node, boolean[] visited, LinkedList[] list) {
        visited[node] = true;
        Iterator<Integer> itr = list[node].listIterator();
        while(itr.hasNext()) {
            int j=itr.next();
            if(!visited[j]) {
                dfs(j, visited, list);
            }
        }
    }
}