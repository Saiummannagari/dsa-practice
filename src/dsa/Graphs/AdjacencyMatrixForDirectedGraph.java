package dsa.Graphs;

public class AdjacencyMatrixForDirectedGraph {
    public static class Graph {
        private boolean matrix[][];

        private int numVertices;

        //initialize the matrix
        public Graph(int numVertices) {
            this.numVertices = numVertices;
            matrix = new boolean[numVertices][numVertices];
        }

        public void addEdge(int i, int j) {
            matrix[i][j] = true;
        }

        public void removeEdge(int i, int j) {
            matrix[i][j] = false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(boolean[] arr: matrix) {
                for(boolean value : arr) {
                    sb.append(value?1:0);
                    sb.append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) {
       Graph g = new Graph(4);
       g.addEdge(0,1);
       g.addEdge(0,2);
       g.addEdge(0,3);
       g.addEdge(2,3);
       g.addEdge(1,3);
       g.addEdge(3,3);
       System.out.println(g);
       g.removeEdge(3,3);
       System.out.println(g);

    }
}