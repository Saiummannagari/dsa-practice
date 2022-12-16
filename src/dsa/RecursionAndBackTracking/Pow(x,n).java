package dsa.RecursionAndBackTracking;

class Main {

    static double power(float x, int y)
    {
        //Practise Yourself : Write your code Here
    /*    if(y == 0) {
            return 1;
        }
        int result = power(x, y/2);
        if(y%2 == 0) {
            return result*result;
        } else {
            return (int) (x*result*result);
        } */
        if (y == 0) {
            return 1;
        }
        if (y < 0) {
            return 1 / x * power(1 / x, -1 * (y + 1));
        }
        return y % 2 == 0 ? power(x * x, y / 2) : x * power(x * x, y/ 2);
    }


    public static void main(String[] args)
    {
        float x = 2;
        int y = 10;
        System.out.print(power(x, y));
    }
}
