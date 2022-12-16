package dsa.Arrays;/*

Given a matrix of M x N elements (M rows, N columns), Print all elements of the matrix in diagonal order in Time Complexity O(m*n) and Space Complexity O(1)

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,4,2,7,5,3,6,8,9]

 */


public class PrintingMatrixSpirally {

    public static int m,n;

    private static void diagonalPrint(int matrix [][]) {

        //Write your code here
        int m = matrix.length; //rows
        int n= matrix[0].length; //columns
        for (int i=0;i<m;i++) {
            int j = 0;
            int k = i;
            while(k>=0) {
              //  System.out.println("k:" + k +" j:"+j);
                System.out.println(matrix[k][j]);
                k--;
                j++;
            }
        }

        for (int j=1;j<n;j++) {
            int k = m-1;
            int l = j;
            while(l<=n-1) {
                //  System.out.println("k:" + k +" j:"+j);
                System.out.println(matrix[k][l]);
                k--;
                l++;
            }
        }
    }


    public static void main(String[] args)
    {
        int matrix[][] = {{1, 2, 3, 4,5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},};

        m=matrix.length;
        n=matrix[0].length;

        diagonalPrint(matrix);
    }
} 
/*
Expected Output 

        1 
        6 2 
        11 7 3 
        16 12 8 4 
        17 13 9 5 
        18 14 10 
        19 15 
        20  
*/

