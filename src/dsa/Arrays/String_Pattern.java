package dsa.Arrays;/*

Given two strings string1 and string2 , return the minimum window in string1 which will contain all the characters in string2 in Time Complexity O(n) and Space Complexity O(1) Asked-in: WalmartLabs, Facebook

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Hint1: Think of HashMap Ascii 256 method , Every character can have ascii value of 1 to 255

 */

public class String_Pattern
{
    static final int no_of_chars = 256;

    static String findMinWindow(String str, String pat)
    {
        //Practise Yourself : Write your code Here
        int str_length = str.length();
        int pat_length = pat.length();
        int count=0;
        int start=0, start_index=-1,min_len=Integer.MAX_VALUE;

        int[] str_array = new int[no_of_chars];
        int[] pat_array = new int[no_of_chars];

        for(int i=0; i<pat_length; i++) {
            pat_array[pat.charAt(i)]++;
        }

        for(int i=0; i<str_length; i++) {
            str_array[str.charAt(i)]++;

            if(pat_array[str.charAt(i)] !=0 && pat_array[str.charAt(i)] >= str_array[str.charAt(i)]) {
                count++;
            }
            if(count == pat_length) {

                while(str_array[str.charAt(start)] > pat_array[str.charAt(start)] || pat_array[str.charAt(start)] ==0) {
                    if(str_array[str.charAt(start)] > pat_array[str.charAt(start)]) {
                        str_array[str.charAt(start)]--;
                    }
                    start++;
                }

                int len_window = i-start+1;
                if(min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }

            }
        }

        if(start_index == -1) {
            System.out.println("window does not exists");
            return "";
        }


        return str.substring(start_index, start_index+min_len);
    }

    public static void main(String[] args)
    {
        String str = "ADOBECODEBANC";
        String pat = "ABC";

        System.out.print("Smallest window is :\n " +
                findMinWindow(str, pat));
    }
}

/* Try more Inputs
case 1:
actual = findMinWindow("a","a")
expected = Smallest window is : a

case2:
 actual = findMinWindow("zaaskzaa", "zsk")
 expected = Smallest window is : skz

case3:
actual = findMinWindow("tutorial","oti")
expected = Smallest window is : tori


*/