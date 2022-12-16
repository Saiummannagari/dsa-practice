package dsa.Arrays;/*String is given as input that contains only lowercase letters, remove duplicate letters so that every letter appears once In O(n) Time Complexity and O(1) Space Complexity

        Example:

        Input: "bcabc"
        Input: "cbacdcbc"
        Output: "bca"
        Output: "cbad"
        Hint : Try using ascii[256] array for storing ascii value of the character


 */

public class DuplicateLowerCaseLetters {

    static String removeDuplicatesFromString(String str1)
    {
        //Write your code Here
        int [] ascii = new int[256];
        char[] str = str1.toCharArray();
        for(int i=0;i<str.length;i++) {

            if(ascii[str[i]] == -1) {
                str[i]='\0';
            }
           /*order of if loops matters here */
            if(ascii[str[i]] == 0) {
                ascii[str[i]] = -1;
            }
        }

        return String.valueOf(str).replaceAll("\0","");
    }

    public static void main(String[] args)
    {
        String str = "abdeeb";
        System.out.println(removeDuplicatesFromString(str));
    }
}

/* Try more Inputs
case1:
actual = removeDuplicatesFromString('bcabc')
expected = 'bca'

case2:
actual = removeDuplicatesFromString('cbacdcbc')
expected = 'cbad'

case3:
actual = removeDuplicatesFromString('aabbccdef')
expected = 'abcdef'

*/