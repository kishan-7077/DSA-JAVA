package DP;

public class RodCutting {

    public static int rodCutting(int[] price,int[] length,int maxL){
        int n = price.length;
        int[][] dp = new int[n+1][maxL+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] =0;
        }

        // tabulation
        for(int i=1; i<n+1; i++){
            for(int j=1; j<maxL+1; j++){
                int l = length[i-1];
                if(l<=j){ // valid case
                    int inc = price[i-1] + dp[i][j-l];   // since repetition is allowed, i.e., unbounded knapsack
                    int exc = dp[i-1][j];

                    dp[i][j] = Math.max(inc,exc);
                }else {     // not a valid case
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][maxL];
    }

    public static void main(String[] args) {
        int[] price = {1,5,8,9,10,17,17,20};
        int[] length = {1,2,3,4,5,6,7,8};
        int totRod = 8;

        System.out.println(rodCutting(price,length,totRod));
    }
}
