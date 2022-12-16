package dsa.DynamicProgramming;

/*
Problem : If a chain of matrices is given, we have to find the minimum number of the correct sequence of matrices to multiply.

The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
Note:no matter how we parenthesize the product, the result will be the same. For example, if we had four matrices A, B, C, and D, we would have:

(ABC)D = (AB)(CD) = A(BCD) = ....
However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency. For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,

(AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
Clearly the first parenthesization requires less number of operations.
 */
class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] matrix = {40,20,30,10,30};
        System.out.println("matrix chain multiplication :: "+matrixChainMultiplication(matrix,0, matrix.length-1));

        int[] matrix2 = { 10, 30, 5, 60 };
        System.out.println("matrix chain multiplication :: "+matrixChainMultiplication(matrix2,0, matrix2.length-1));
    }

    private static int matrixChainMultiplication(int[] matrix, int l, int r) {
        if(r<=l+1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int temp;
        for(int i=l+1;i<r;i++) {
            temp = matrixChainMultiplication(matrix, l,i)  //left
                    + matrixChainMultiplication(matrix,i, r)  //right
                    + matrix[l] * matrix[i] * matrix[r];
            min = Math.min(temp, min);
        }
        return min;
    }
}