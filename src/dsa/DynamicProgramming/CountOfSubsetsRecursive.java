package dsa.DynamicProgramming;

class CountOfSubsets {
    public static void main(String[] args) {
        int a[] = {1,4,3,2};
        int n= 4;
        int sum=6;
        System.out.println("Total Number of subsets :: "
                + findNoOfSubsets(a, n, 0, sum));
    }

    private static int findNoOfSubsets(int[] a, int n, int  i,int sum) {
        if(sum == 0) {
            return 1;
        }
        if(n==0) {
            return 0;
        }
        else if(sum<a[i]) {
            return findNoOfSubsets(a, n-1, i+1, sum);
        }
        else {
            return findNoOfSubsets(a, n-1, i+1, sum-a[i]) + findNoOfSubsets(a, n-1, i+1, sum);
        }
    }

}