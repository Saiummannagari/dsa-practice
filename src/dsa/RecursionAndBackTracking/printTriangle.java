package dsa.RecursionAndBackTracking;

public class printTriangle {

    public static void main(String[] args) {
        printTriangle(4, 0);
        printTriangleReverse(4, 0);
    }

    static void printTriangle(int row, int col) {
        if(row==0) {
            return;
        }
        if(col<row) {
            System.out.print("* ");
            printTriangle(row, col+1);
        } else {
            System.out.println();
            printTriangle(row-1, 0);
        }
    }


    static void printTriangleReverse(int row, int col) {
        if(row==0) {
            return;
        }
        if(col<row) {
            printTriangleReverse(row, col+1);
            System.out.print("* ");
        } else {
            printTriangleReverse(row-1, 0);
            System.out.println();
        }
    }
}