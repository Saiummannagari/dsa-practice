package dsa.RecursionAndBackTracking;

import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        permutations("abc", "");
        System.out.println(permutationsCount("abc", ""));
        System.out.println(permutations2("abca", ""));
        System.out.println(permutationsCount("abca", ""));
    }

    static void permutations(String up, String p) {
        if(up.isEmpty()) {
            if(!p.isEmpty()) {
                System.out.println(p+ " ");
            }
            return;
        }

        char c = up.charAt(0);
        for(int i=0;i<=p.length();i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            permutations(up.substring(1), f+c+s);
        }
    }


    //Using arraylists by permutations
    static ArrayList<String> permutations2(String up, String p) {
        if(up.isEmpty()) {
            if(!p.isEmpty()) {
               return new ArrayList<>() {{add(p);}};
            }
            return new ArrayList<>();
        }
        ArrayList<String> list = new ArrayList<>();
        char c = up.charAt(0);
        for(int i=0;i<=p.length();i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            ArrayList<String> list2 = permutations2(up.substring(1), f+c+s);
            list.addAll(list2);
        }
        return list;
    }

   //return count of permutations
    static int permutationsCount(String up, String p) {
        if(up.isEmpty()) {
            if(!p.isEmpty()) {
                return 1;
            }
            return 0;
        }
        int count=0;
        char c = up.charAt(0);
        for(int i=0;i<=p.length();i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            count = count+ permutationsCount(up.substring(1), f+c+s);
        }
        return count;
    }
}