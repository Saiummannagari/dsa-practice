package dsa.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
Interleaving String

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m non-empty substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...

Example 1::
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 */
class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println("Interleaving strings :: "+areInterleavingStrings(s1,s2,s3));


        String s4 = "aabcc";
        String s5 = "dbbca";
        String s6 = "aadbbbaccc";
        System.out.println("Interleaving strings :: "+areInterleavingStrings(s4,s5,s6));


        String s7 = "";
        String s8 = "";
        String s9 = "";
        System.out.println("Interleaving strings :: "+areInterleavingStrings(s7,s8,s9));
    }

    private static boolean areInterleavingStrings(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if(len3!=len1+len2) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        return areInterleavingStrings(s1,s2,s3,0,0,0, map);
    }

    private static boolean areInterleavingStrings(String s1, String s2, String s3, int p1, int p2, int p3, Map<String,Boolean> map) {
        if(s1.length() == p1 && s2.length() == p2) {
            return true;
        }
        if(s1.length() == p1) {
            return s2.charAt(p2) == s3.charAt(p3)?areInterleavingStrings(s1,s2,s3,p1,p2+1,p3+1,map):false;
        }
        if(s2.length() == p2) {
            return s1.charAt(p1) == s3.charAt(p3)?areInterleavingStrings(s1,s2,s3,p1+1,p2,p3+1,map):false;
        }
        String key = p1+"*"+p2+"*"+p3;
        if(!map.containsKey(key)) {
            boolean one = false;
            boolean two = false;
            if (s1.charAt(p1) == s3.charAt((p3))) {
                one = areInterleavingStrings(s1, s2, s3, p1 + 1, p2, p3 + 1,map);
            }
            if (s2.charAt(p2) == s3.charAt((p3))) {
                two = areInterleavingStrings(s1, s2, s3, p1, p2 + 1, p3 + 1,map);
            }
            map.put(key, one || two);
            return one || two;
        } else {
            return map.get(key);
        }
    }
}