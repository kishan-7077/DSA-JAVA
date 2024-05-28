package DP;

public class Knapsack {

    // W -> allowed capacity
    // n -> item no.
    public static int knapsack(int[] val,int[] wt,int W,int n){
        // base case
        if(n==0 || W == 0){
            return 0;
        }

        if(wt[n-1] <= W){ // valid case
            // include case
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1); // add self-value and decrease the self-weight and go for the next item
            // exclude case
            int ans2 = knapsack(val, wt, W, n-1); // don't update capacity(W) simply go to next item

            return Math.max(ans1,ans2); // return the max value from both cases
        }else { // not a valid case
            return knapsack(val, wt, W, n-1);
        }
    }

    public static int knapsackMemoization(int[] val, int[] wt, int W,int n,int[][] dp){
        if(n==0 || W==0){
            return 0;
        }

        if(dp[n][W] != -1){
            // max profit already calculated
            return dp[n][W];
        }

        if(wt[n-1] <= W){ // valid case
            // include
            int ans1 = val[n-1] + knapsackMemoization(val,wt,W-wt[n-1],n-1,dp);
            // exclude
            int ans2 = knapsackMemoization(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(ans1,ans2);
            return dp[n][W];
        }else { // not valid
            dp[n][W] = knapsackMemoization(val, wt, W, n-1, dp);
            return dp[n][W];
        }

    }

    public static int knapsackTabulation(int[] val,int[] wt,int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        // init dp array with a base case
        // where items -> 0 profit -> 0
        // W(capacity) -> 0 profit -> 0
        for(int i=0; i<dp.length; i++){ // ith row (items)
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){ // jth col (W->0)
            dp[0][j] = 0;
        }

        // filling
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j){ // valid
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit,excProfit);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        print(dp);
        return dp[n][W];
    }

    private static void print(int[][] dp) {
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;
        int[][] dp = new int[val.length+1][W+1];
        for(int i=0; i< dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(val,wt,W, val.length));
        System.out.println(knapsackMemoization(val,wt,W, val.length, dp));
        System.out.println(knapsackTabulation(val,wt,W));
    }
}
