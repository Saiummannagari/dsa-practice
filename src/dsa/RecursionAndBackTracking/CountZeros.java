package dsa.RecursionAndBackTracking;/*
Count number of zeroes in the given number
 */

public class CountZeros {

    public static void main(String[] args) {
        System.out.println("number of zeroes ::"+countZeros(12306090,0));
    }

    static int countZeros(int num, int count) {
        if(num/10 == num) {
            return count;
        }
        int rem = num%10;
        if(rem == 0) {
        return  countZeros(num/10, count+1);
        }
        return countZeros(num/10, count);
    }
}