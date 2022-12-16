package dsa.RecursionAndBackTracking.Backtracking;

/*
Rat Maze Problem

Given a maze, NxN matrix.matrix[0][0] (left top corner)is the source and matrix[N-1][N-1](right bottom corner)
is destination.
There are few cells which are blocked, means rat cannot enter into those cells.
Rat can move in direction ( forward,down).
A rat has to find a path from source to destination Asked in : MakeMyTrip, Yatra, Expedia

Example:

Input 1:
A = [   [1, 0]
[1, 1] ]
Output
[   [1, 0]
[1, 1]
]
Hint : Backtracking(recursion)  techniques in a matrix to find correct path
*/
public class FindPathInMaze {

    static int N;
    public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 0 },
                { 1, 0, 0, 1, 0 }
        };

        N = matrix.length;
        findPath(matrix);
    }

    static boolean findPath(int matrix[][])
    {
        int[][] path = new int[N][N];
        if(!findPaths(path, matrix, 0, 0));
        {
            System.out.println("could not find path");
        }
        return true;
    }

    static boolean findPaths(int[][] path, int matrix[][], int row, int col) {
        if(row == N-1 && col == N-1 && matrix[row][col] !=1) {
            path[row][col] = 1;
            printPath(path);
            return true;
        }

        if(matrix[row][col] == 1) {
            return false;
        }
        //moving down
        path[row][col] = 1;
        if(row<N-1) {
             findPaths(path, matrix, row+1, col);
        }
        if(col<N-1) {
            findPaths(path, matrix, row, col+1);
        }
        path[row][col] = 0;
        return false;
    }


    //function to print solution matrix
    static void printPath(int path[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                        " " + path[i][j] + " ");
            System.out.println();
        }
    }


}