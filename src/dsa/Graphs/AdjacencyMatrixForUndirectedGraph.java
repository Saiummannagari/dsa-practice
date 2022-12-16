package dsa.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdjacencyMatrixForUndirectedGraph {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter number of vertices :: ");
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int n= Integer.parseInt(br.readLine());
        System.out.println(n);
        boolean [][] matrix = new boolean[n][n];
        addEdge(matrix, 0, 1);
        addEdge(matrix, 0, 2);
        addEdge(matrix, 1, 2);
        addEdge(matrix, 0, 3);
        addEdge(matrix, 0, 0);
        removeEdge(matrix, 0 , 0);
        System.out.println(printMatrix(matrix));
      //  printMatrix1(matrix);

    }

    static void addEdge(boolean[][] matrix, int i, int j) {
        if(matrix[i][j] && matrix[j][i]) {
            System.out.println("edge already added");
        } else {
            matrix[i][j] = true;
            matrix[j][i] = true;
        }
    }

    static void removeEdge(boolean[][] matrix, int i, int j) {
        if(!matrix[i][j] && !matrix[j][i]) {
            System.out.println("edge is not present");
        } else {
            matrix[i][j] = false;
            matrix[j][i] = false;
        }
    }

    static String printMatrix(boolean[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for(boolean[] arr: matrix) {
            for(boolean value: arr) {
                sb.append(value? 1 : 0);
                sb.append(" ");
            }
            sb.append("\n");   //not "/n"
        }
        return sb.toString();
    }

    static void printMatrix1(boolean[][] matrix) {
        for(boolean[] arr: matrix) {
            for(boolean value: arr) {
                System.out.print(value? 1 : 0);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}