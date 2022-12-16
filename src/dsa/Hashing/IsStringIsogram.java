package dsa.Hashing;/*
Given a word or phrase, check if it is isogram or not. An Isogram is a word in which no letter occurs more than once.

Examples:

Input : Machine
Output : True
"Machine" does not have any character repeating,
it is an Isogram

Input : Geek
Output : False
"Geek" has 'e' as repeating character,
it is not an Isogram
 */

import java.util.Arrays;

public class IsStringIsogram {

    //by hashing
    static boolean isIsogramByHashing(String str) {
        char[] strArr = str.toLowerCase().toCharArray();
        int[] arr = new int[26];
        for(int i=0;i< strArr.length;i++) {
            arr[strArr[i]-'a']++;

            if(arr[strArr[i]-'a'] >1) {
                return false;
            }
        }
        return true;
    }

    //by array sorting
    static boolean isIsogramBySorting(String str) {
        char[] strArr = str.toLowerCase().toCharArray();
        Arrays.sort(strArr);
        for(int i=0;i< strArr.length-1;i++) {
            if(strArr[i] == strArr[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "hashing";
        String str2 = "sorting";
        System.out.println("hashing is an isogram(yes/no)? :: " + isIsogramByHashing(str));
        System.out.println("sorting is an isogram(yes/no)? :: " + isIsogramByHashing(str2));
        System.out.println("hashing is an isogram(yes/no)? :: " + isIsogramBySorting(str));
        System.out.println("sorting is an isogram(yes/no)? :: " + isIsogramBySorting(str2));
    }
}