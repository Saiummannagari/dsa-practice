package dsa.Graphs;

/*
Time Complexity
There are three loops. Each loop has constant complexities. So, the time complexity of the Floyd-Warshall algorithm is O(n3).

Space Complexity
The space complexity of the Floyd-Warshall algorithm is O(n2).
 */
public class FloydWarshall {

    static void floydWarshall(int[][] graph, int n) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if(dist[i][j]> dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for(int i=0;i<n;i++) {
            if(dist[i][i]<0) {
                System.out.println("negative edge weight cycle is present");
                return;
            }
        }

        printMatrix(dist, n);
    }

    static void printMatrix(int[][] dist, int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(dist[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int graph[][] = { { 0, 3, max, 5 },
                          { 2, 0, max, 4 },
                          { max, 1, 0, max },
                          { max, max, 2, 0 } };
        floydWarshall(graph, 4);
    }
}
