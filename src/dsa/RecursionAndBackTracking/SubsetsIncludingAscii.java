package dsa.RecursionAndBackTracking;

import java.util.ArrayList;

public class SubsetsIncludingAscii {

    public static void main(String[] args) {
      printAscii("abc", "");
        System.out.println(printAsciiReturningArrayList("abc", ""));
    }

    static void printAscii(String up, String p) {
        if(up.isEmpty()) {
            if(p.isEmpty()) {
                return;
            }
            System.out.print(p + " ");
            return;
        }

        char ch = up.charAt(0);
        printAscii(up.substring(1),p);
        printAscii(up.substring(1),p+ch);
        printAscii(up.substring(1), p +(ch+0));
    }


    static ArrayList<String> printAsciiReturningArrayList(String up, String p) {
        if(up.isEmpty()) {
            if(p.isEmpty()) {
                return new ArrayList<>();
            }
           return new ArrayList<>(){{add(p);}};
        }

        char ch = up.charAt(0);
        ArrayList<String> list1 = printAsciiReturningArrayList(up.substring(1),p);
        ArrayList<String> list2 = printAsciiReturningArrayList(up.substring(1),p+ch);
        ArrayList<String> list3 = printAsciiReturningArrayList(up.substring(1), p +(ch+0));
        list1.addAll(list2);
        list1.addAll(list3);
        return list1;
    }
}