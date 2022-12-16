package dsa.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class StringSubset {
    public static void main(String[] args) {
        subset("abc", "");
        System.out.println(subsetList("abc", "").toString());
    }

    static void subset(String up, String p) {
        if(up.isEmpty()) {
            if(p.isEmpty()) {
                return;
            }
            System.out.println(p);
            return;
        }

        char c = up.charAt(0);
        subset(up.substring(1), p);
        subset(up.substring(1), p + c);
    }

    static ArrayList<String> subsetList(String up, String p) {
        if(up.isEmpty()) {
            if(p.isEmpty()) {
                return new ArrayList<>();
            }
            return new ArrayList<>(){{add(p);}};
        }
        char c = up.charAt(0);
        ArrayList<String> withCharacter = subsetList(up.substring(1), p);
        ArrayList<String> withoutCharacter = subsetList(up.substring(1), p + c);
        withCharacter.addAll(withoutCharacter);
        return withCharacter;
    }
}