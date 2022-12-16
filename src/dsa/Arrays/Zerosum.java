package dsa.Arrays;/*Array of both positive and negative numbers, the task is to find out the sub array whose sum is Zero in Time Complexity O(n) and Space Complexity O(n)

Example:

Input = [6, 3, -1, -3, 4, -2, 2,4, 6, -12, -7]

[Efficiently it can be implemented using Hashing]
[ This problem is based on the array but the most efficient approach to solving this problem can be hashing, Please attempt this problem if you already done with Hashing topic or try to solve it without using Hashing techniques]
Output:
Subarray found from Index 2 to 4
Subarray found from Index 2 to 6
Subarray found from Index 5 to 6
Subarray found from Index 6 to 9
Subarray found from Index 0 to 10

 */


import java.io.*;
import java.util.*;

class SubArray
{
    int first, second;
    SubArray(int a, int b)
    {
        first = a;
        second = b;
    }
}

public class Zerosum
{
    static ArrayList<SubArray> findSubArrays(int[] array, int n)
    {
        //Write your Code here
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<SubArray> result = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum=sum+array[i];
            if(sum ==0) {
                result.add(new SubArray(0,i));
            }
            ArrayList<Integer> list = new ArrayList<>();
            if(map.containsKey(sum)) {
                list=map.get(sum);
                for(int j=0;j<list.size();j++) {
                    result.add(new SubArray(list.get(j)+1, i));
                }
            }
            list.add(i);
            map.put(sum,list);
        }
        return result;
    }


    public static void main(String args[])
    {
        int[] array = {6, 3, -2, -5, -3, 7, 2, -6, -1, 4};
        int n = array.length;

        ArrayList<SubArray> out = findSubArrays(array, n);
        for(int i=0;i<out.size();i++) {
            System.out.println("Subarray found from Index "+out.get(i).first+" to "+out.get(i).second);
        }

    }
}  

/* Try more Inputs
case1:
actual = findSubArrays([4, 2, -3, 1, 6],5)
expected = True

case2:
actual = findSubArrays([4,2,0,1,6],5)
expected = True

actual = findSubArrays([-3,2,3,1,6],5)
expected = False

actual = findSubArrays([1,2],2)
 expected = False

*/