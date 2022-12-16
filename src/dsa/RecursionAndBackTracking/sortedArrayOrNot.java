package dsa.RecursionAndBackTracking;

public class sortedArrayOrNot {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,9};
        System.out.println(sortedArrayOrNot(arr, 0));
        int [] arr2 = {1,2,3,9,4};
        System.out.println(sortedArrayOrNot(arr2, 0));
    }

    static boolean sortedArrayOrNot(int[] arr, int index) {
        if(index == arr.length-1) {
            return true;
        }

      return arr[index] < arr[index+1] && sortedArrayOrNot(arr, index+1);
    }
}