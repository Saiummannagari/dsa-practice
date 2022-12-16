package dsa.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main
{


    static List<String> output = new ArrayList<String>();
    public static void findCombinations(List<List<Character>> keypad,
                                        int[] input, String res, int index)
    {
        if(index>=input.length) {
            output.add(res);
            return;
        }

        int num = input[index];
        System.out.println(num);
        List<Character> list = keypad.get(num);
        System.out.println(list);
            for(Character alphabet: list) {
                System.out.println(alphabet);
                findCombinations(keypad, input, res+alphabet, index + 1);
        }
    }



    public static void main(String[] args)
    {
        List<List<Character>> keypad = Arrays.asList(

                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList( 'A', 'B', 'C' ),
                Arrays.asList( 'D', 'E', 'F' ),
                Arrays.asList( 'G', 'H', 'I' ),
                Arrays.asList( 'J', 'K', 'L' ),
                Arrays.asList( 'M', 'N', 'O' ),
                Arrays.asList( 'P', 'Q', 'R', 'S'),
                Arrays.asList( 'T', 'U', 'V' ),
                Arrays.asList( 'W', 'X', 'Y', 'Z')
        );


        int[] input = { 2, 3, 4};


        findCombinations(keypad, input, "", 0);
        System.out.println(output);
    }
}