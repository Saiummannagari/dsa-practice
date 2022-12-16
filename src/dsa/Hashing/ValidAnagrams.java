package dsa.Hashing;/*
Check whether two strings are anagram of each other

Write a function to check whether two given strings are anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, “abcd” and “dabc” are an anagram of each other.

ex: LISTEN SILENT
ex: TRIANGLE INTEGRAL
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class ValidAnagrams {

    //using array sorting
    //Arrays.sort() takes time complexity of O(nlogn)
    //space complexity O(1)
    static boolean isValid(String str1, String str2) {
        char[] s1= str1.toLowerCase().toCharArray();
        Arrays.sort(s1);
        char[] s2= str2.toLowerCase().toCharArray();
        Arrays.sort(s2);
        return Arrays.equals(s1,s2);
    }

    //using hashing
    //time complexity O(n)
    //space complexity O(n)
    static boolean isValidAnagrams(String str1, String str2) {
        char[] s1= str1.toLowerCase().toCharArray();
        char[] s2= str2.toLowerCase().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        if(s1.length != s2.length) {
            return false;
        }
        //storing the number of occurances of a character in to hashmap
        for(int i=0;i<s1.length; i++) {
            if(map.containsKey(s1[i])) {
                map.put(s1[i], map.get(s1[i])+1);
            } else {
                map.put(s1[i], 1);
            }
        }

        //reducing the number of occurances of a character in to hashmap
        for(int i=0;i<s2.length;i++) {
            if(map.containsKey(s2[i])) {
                map.put(s2[i], map.get(s2[i])-1);
            } else {
                return false;
            }
        }
        //checking if the characters count are 0
        Set<Character> keys = map.keySet();
        for(Character key: keys) {
            if(map.get(key)!=0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
       String str1="silent";
       String str2="listen";
       System.out.println("silent and listen are anagrams by sorting(yes/no)? :: "+ isValid(str1, str2));
       System.out.println("silent and listen are anagrams by hashing(yes/no)? :: "+ isValidAnagrams(str1, str2));
        String str3="silent";
        String str4="liste";
        System.out.println("silent and liste are anagrams by sorting(yes/no)? :: "+ isValid(str3, str4));
        System.out.println("silent and liste are anagrams by hashing(yes/no)? :: "+ isValidAnagrams(str3, str4));
    }
}