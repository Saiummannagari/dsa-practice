package dsa.RecursionAndBackTracking;

import java.util.ArrayList;

public class LinearSearch {

    public static void main(String[] args) {
        int [] arr = {1,9,0,6,8};
        System.out.println(linearSearch(arr, 8, 0));
        System.out.println(linearSearch(arr, 10, 0));
        System.out.println(elementFound(arr, 8, 0));
        System.out.println(elementFound(arr, 10, 0));
        int [] arr2 = {1,9,0,6,8,9};
        findIndexes(arr2, 9, 0);
        System.out.println(list);
        int [] arr3 = {1,9,0,6,8,9,9};
        System.out.println(findIndexesByReturningArrayList(arr3, 9, 0, new ArrayList<>()));
        int [] arr4 = {1,9,0,6,8,9,9,9};
        System.out.println(findIndexesWithoutListAsParameter(arr4, 9, 0));

    }

    //return only one index if the element is found
    static int linearSearch(int[] arr, int target, int index) {
        if(index == arr.length) {
            return -1;
        }
        if(arr[index] == target) {
            return index;
        }  else {
            return linearSearch(arr, target, index+1);
          }
        }

        //return true if the element is found
    static boolean elementFound(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || elementFound(arr, target, index+1);
    }

    //return multiple indexes of the target
    static ArrayList<Integer> list = new ArrayList<>();
    static void findIndexes(int[] arr, int target, int index) {
        if(index == arr.length) {
            return;
        }
        if(arr[index] == target) {
            list.add(index);
        }
        findIndexes(arr, target, index+1);
    }


    //return arraylist by passing arrayList as parameter
    static ArrayList<Integer> findIndexesByReturningArrayList(int[] arr, int target, int index, ArrayList<Integer> list) {
        if(index == arr.length) {
            return  list;
        }
        if(arr[index] == target) {
            list.add(index);
        }
        return findIndexesByReturningArrayList(arr, target, index+1, list);
    }

    static ArrayList<Integer> findIndexesWithoutListAsParameter(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length) {
            return list;
        }
        if(arr[index] == target) {
           list.add(index);
        }
        //contains answers from below function calls
        ArrayList<Integer> answersFromBelowCalls = findIndexesWithoutListAsParameter(arr, target, index+1);
        list.addAll(answersFromBelowCalls);
        return list;
    }

}