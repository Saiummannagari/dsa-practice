package dsa.DynamicProgramming;

/*
Pattern Matching

ex:
String a= "aab";
String b= "abbabb";
output:: true

ex:
String a= "aab";
String b= "abbba";
output:: false
 */
class PatternMatching {
    public static void main(String[] args) {
        String a="aab";
        String b="abbabb";
        System.out.println("Pattern matched :: "+isMatching(a,b));

        String a1="aab";
        String b1="abbba";
        System.out.println("Pattern matched :: "+isMatching(a1,b1));
    }

    private static boolean isMatching(String a, String b) {
        String[][] dp = new String[a.length()+1][b.length()+1];
        for(int i=0;i<a.length()+1;i++) {
            for(int j=0;j<b.length()+1;j++) {
                if(i==0||j==0) {
                    dp[i][j]="";
                }
                else if(a.charAt(i-1)== b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+a.charAt(i-1);
                } else {
                    dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        String res = dp[a.length()][b.length()];
        if(a.length() == res.length() || b.length() == res.length()) {
            return true;
        }
        return false;
    }
}