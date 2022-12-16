package dsa.Graphs;/*
Time complexity O(E+V)
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Tarjans {
    static class Graph {
        LinkedList<Integer>[] list;

        public Graph(int n) {
            list = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new LinkedList<>();
            }
        }

        public void add_edge(int i, int j) {
            list[i].add(j);
        }

        public LinkedList<Integer>[] returnList() {
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
        tarjansAlgo(list, n);
    }

    private static void tarjansAlgo(LinkedList<Integer>[] list, int n) {
        int[] desc =  new int[n];
        Arrays.fill(desc, -1);

        int[] low =  new int[n];
        Arrays.fill(low, -1);

        boolean[] isPresentInStack = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        int time=0;
        for(int i=0;i<n;i++) {
            if(desc[i]==-1) {
                dfs(list, i, desc, low, stack, isPresentInStack, time);
            }
        }
    }

    private static void dfs(LinkedList<Integer>[] list,
                            int i, int[] desc, int[] low,
                            Stack<Integer> stack, boolean[] isPresentInStack, int time) {
        desc[i] = low[i] = time;
        time = time+1;
        stack.push(i);
        isPresentInStack[i]= true;
        Iterator<Integer> itr = list[i].listIterator();
        while(itr.hasNext()) {
            int j = itr.next();
            if(desc[j]==-1) {
                dfs(list, j, desc, low, stack, isPresentInStack, time);
                low[i] = Math.min(low[i], low[j]);
            }

            //differentiation back-edge and cross-edge
            else if(isPresentInStack[j]) {
                low[i] = Math.min(low[i], desc[j]);
            }
        }

        if(low[i]==desc[i])	//If u is head node of SCC
        {
            System.out.println("SCC is :: ");
            //popping till head node
            while(stack.peek()!=i)
            {
                System.out.print(stack.peek()+" ");
                isPresentInStack[stack.peek()] = false;
                stack.pop();
            }
            //popping head node
            System.out.println(stack.peek());
            isPresentInStack[stack.peek()] = false;
            stack.pop();
        }

    }
}