package DP;

public class CoinChange {

    public static int coinChange(int[] val, int sum){
        int n = val.length;
        int[][] dp = new int[n+1][sum+1];

        for(int i=0; i<dp.length; i++){     // for rows
            // for sum -> 0 there is one way to get ans i.e., null set
            dp[i][0] = 1;
        }
        for(int j=1; j<dp[0].length; j++){  // for cols
            // if there are 0 elements and sum >=1 then the ans is not feasible
            dp[0][j] = 0;
        }

        // tabulation
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                int v = val[i-1];
                if(v<=j){ //valid case
                    int inc = dp[i][j-v];
                    int exc = dp[i-1][j];
                    dp[i][j] = inc + exc;
                }else {     // not a valid case
                     dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] coins = {2,5,3,6};
        int sum = 10;
        System.out.println(coinChange(coins,sum));
    }
}
