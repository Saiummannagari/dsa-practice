package dsa.RecursionAndBackTracking;

public class Permutations2 {


        public static void main (String[] args){
            String word = "ABC";
        int n = word.length();
        permutation(word, 0, n - 1);
    }

    private static void permutation(String word, int start, int end) {
        if (start == end)
            System.out.println(word);
        else {
            for (int i = start; i <= end; i++) {
                word = swap(word, start, i);
                permutation(word, start + 1, end);
                word = swap(word, start, i);
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char temp;
        char[] array = str.toCharArray();
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return String.valueOf(array);
    }

}