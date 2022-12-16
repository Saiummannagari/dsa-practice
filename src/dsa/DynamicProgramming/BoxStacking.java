package dsa.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/*
Maximum Height by Stacking Cuboids

Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed). Choose a subset of cuboids and place them on each other.

You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj. You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.

Return the maximum height of the stacked cuboids.

Example 1:
Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
Output: 190
Explanation:
Cuboid 1 is placed on the bottom with the 53x37 side facing down with height 95.
Cuboid 0 is placed next with the 45x20 side facing down with height 50.
Cuboid 2 is placed next with the 23x12 side facing down with height 45.
The total height is 95 + 50 + 45 = 190.

Example 2:

Input: cuboids = [[38,25,45],[76,35,3]]
Output: 76
Explanation:
You can't place any of the cuboids on the other.
We choose cuboid 1 and rotate it so that the 35x3 side is facing down and its height is 76.
Example 3:

Input: cuboids = [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
Output: 102
Explanation:
After rearranging the cuboids, you can see that all cuboids have the same dimension.
You can place the 11x7 side down on all cuboids so their heights are 17.
The maximum height of stacked cuboids is 6 * 17 = 102.
 */
class BoxStacking {
    static class Box {
    int h;
    int l;
    int w;
    Box(int w, int l, int h) {
        this.w = w;
        this.l = l;
        this.h = h;
    }

    }

    //wrong solution
    public static void main(String[] args) {
        int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12}};
        System.out.println("Maximum height :: " + maxHeight(cuboids));
    }

    //w, l, h
    private static int maxHeight(int[][] cuboids) {
        Box[] arr = new Box[3* cuboids.length];
        int k=0;
        int index=0;
        int h=0,w=0,l=0;
        for(int i=0;i<cuboids.length;i++) {
            h = cuboids[i][1];
            w = Math.max(cuboids[i][0], cuboids[i][2]);
            l = Math.min(cuboids[i][0], cuboids[i][2]);
            arr[index] = new Box(w, l, h);
            index= index+1;

            h = cuboids[i][0];
            w = Math.max(cuboids[i][1], cuboids[i][2]);
            l = Math.min(cuboids[i][1], cuboids[i][2]);
            arr[index] = new Box(w, l, h);
            index= index+1;

            h = cuboids[i][2];
            w = Math.max(cuboids[i][0], cuboids[i][1]);
            l = Math.min(cuboids[i][0], cuboids[i][1]);
            arr[index] = new Box(w, l, h);
            index= index+1;
        }
        Arrays.sort(arr,(a,b) -> (b.l*b.w - a.l*a.w));

        int lis[] = new int[3* cuboids.length];
        for(int i=0;i<3*cuboids.length;i++) {
           lis[i] = arr[i].h;
            System.out.print(lis[i]+" ");
        }

        for(int i=0;i<3*cuboids.length;i++) {
            int val=0;
            for(int j=0;j<i;j++) {
                if((arr[i].w < arr[j].w) && (arr[i].l < arr[j].l))
                    val = Math.max(val, lis[j]);
            }
            lis[i] = lis[i]+val;
        }
        int max=0;
        index =0;
        System.out.println();
        for(int i=0;i<3*cuboids.length;i++) {
            if(max<lis[i]) {
                max=lis[i];
                index=i;
            }

            System.out.print(lis[i]+" ");
        }
        System.out.println("i :: "+index);
        return max;
    }
}