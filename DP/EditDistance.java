package DP;

public class EditDistance {

    public static int minOperations(String str1,String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        // initialize
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }
            }
        }


        // tabulation
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(add,Math.min(del,replace));
                }
            }
        }

        print(dp);
        return dp[n][m];
    }

    private static void print(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";

        System.out.println(minOperations(str1,str2));
    }
}
