package dsa.Hashing;// Java program to calculate number
// of subarrays with distinct elements of size k
import java.util.*;
class GFG
{
    static int subarraysWithKDistinct(int A[], int K)
    {

        // declare a map for the frequency
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int begin = 0, end = 0, prefix = 0, cnt = 0;
        int res = 0;

        // traverse the array
        while (end < A.length)
        {

            // increase the frequency
            if(mapp.containsKey(A[end]))
            {
                mapp.put(A[end], mapp.get(A[end]) + 1);
            }
            else
            {
                mapp.put(A[end], 1);
            }
            if (mapp.get(A[end]) == 1)
            {
                cnt++;
            }
            end++;
            if (cnt > K)
            {
                if(mapp.containsKey(A[begin]))
                {
                    mapp.put(A[begin], mapp.get(A[begin]) - 1);
                }
                else
                {
                    mapp.put(A[begin], -1);
                }
                begin++;
                cnt--;
                prefix = 0;
            }

            // loop until mapp[A[begin]] > 1
            while (mapp.get(A[begin]) > 1)
            {
                if(mapp.containsKey(A[begin]))
                {
                    mapp.put(A[begin], mapp.get(A[begin]) - 1);
                }
                else
                {
                    mapp.put(A[begin], -1);
                }
                begin++;
                prefix++;
            }
            if (cnt == K)
            {
                res += prefix + 1;
            }
        }

        // return the final count
        return res;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 2, 1, 2, 1, 6 };
        int k = 2;

        // Function call
        System.out.println(subarraysWithKDistinct(arr, k));
    }
}

// This code is contributed by divyeshrabadiya07
