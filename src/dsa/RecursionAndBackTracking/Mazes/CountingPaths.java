package dsa.RecursionAndBackTracking.Mazes;

public class CountingPaths {

    public static void main(String[] args) {
        System.out.println(countPaths2(3,3,0));
        System.out.println(countPaths(3,3));
    }

    static int countPaths(int row, int col) {
        if(row == 1 || col ==1) {
            return 1;
        }

        int count1 = countPaths(row-1, col);
        int count2 = countPaths(row, col-1);

        return count1+count2;
    }

    static int countPaths2(int row, int col, int count) {
        if(row == 1 || col ==1) {
            return count+1;
        }
       // int counter =0;
        count = count + countPaths2(row-1, col, count) + countPaths2(row, col-1, count);
//        int count1 = countPaths2(row-1, col, count);
//        int count2 = countPaths2(row, col-1, count);

        return count;
    }
}