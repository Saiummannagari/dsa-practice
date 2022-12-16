package dsa.RecursionAndBackTracking;

public class Palindrome {

    public static void main(String[] args) {
        if(rev(12321) == 12321) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }

        if(rev2(1232) == 1232) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }
    }

    //approach 1
    static int sum =0;
    static int rev(int num) {
        if(num== 0) {
            return sum;
        }
        int rem = num%10;
        sum = sum*10 + rem;
        return rev(num/10);
    }


    //approach 2
    static int rev2(int num) {
        //counting number of digits in number
        int n= (int)(Math.log10(num))+1;
        return helper(num, n);
    }

    static int helper(int num, int n) {
        if(num%10 == num) {
            return num;
        }
        int rem = num%10;
        return rem*(int)Math.pow(10,(n-1)) + helper(num/10, (n-1));
    }
}