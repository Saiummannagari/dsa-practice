package dsa.RecursionAndBackTracking;

import java.util.ArrayList;

public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        permutations("12", "");
        System.out.println(permutations2("12", ""));
        System.out.println(permutationsCount("12", ""));
    }

    //using no return type
    static void permutations(String up, String p) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        for(int i=(digit-1)*3;i<digit*3;i++) {
            permutations(up.substring(1), (char) (i + 'a') + p);
        }
    }

    //using Arraylist data type
    static ArrayList<String> permutations2(String up, String p) {
        if(up.isEmpty()) {

            return new ArrayList<>(){{
                add(p);
            }};
        }
        ArrayList<String> list = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        for(int i=(digit-1)*3;i<digit*3;i++) {
            list.addAll(permutations2(up.substring(1), (char) (i + 'a') + p));
        }
        return list;
    }

    //gives the count
    static int permutationsCount(String up, String p) {
        if(up.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';
        for(int i=(digit-1)*3;i<digit*3;i++) {
            count = count + permutationsCount(up.substring(1), (char) (i + 'a') + p);
        }
        return count;
    }

}