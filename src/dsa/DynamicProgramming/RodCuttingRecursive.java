package dsa.DynamicProgramming;

/*
Rod Cutting is another term for Unbounded Knapsack

Cut the rod with highest profit
 */
class RodCutting {
    public static void main(String[] args) {
       int price[] = { 1,5, 8, 9};
       int length[] = {1, 2, 3, 4};
       int l = 4;
       int res = ubk(price, length, 4, 0, 0, " ");
       System.out.println("Highest profit :: "+res);
    }
    static int max = Integer.MIN_VALUE;
    static int ubk(int[] price, int[] length, int maxlen, int j, int sum, String path) {
        if(j==price.length || maxlen == 0 ) {
            System.out.println(path+"->"+sum);
            return sum;
        }
        if(length[j]>maxlen) {
            return 0;
        }
        for(int i=0;i<length.length;i++) {
            sum = sum+price[i];
            max = Math.max(ubk(price, length, maxlen-length[i],i, sum, path+" "+length[i]), max);
            sum = sum-price[i];
        }
        return max;
    }
}