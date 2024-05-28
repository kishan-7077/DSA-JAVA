package DP;

import java.util.Arrays;

public class CatalanNumbers {

    public static int catalanRec(int n){
        if(n==1 || n==0){
            return 1;
        }

        int ans = 0; // Cn
        for(int i=0; i<n; i++){
            ans += catalanRec(i) * catalanRec(n-i-1);
        }

        return ans;
    }

    public static int catalanMemo(int n,int[] dp){
        if(n==1 || n==0){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += catalanMemo(i,dp) * catalanMemo(n-i-1,dp);
        }

        return dp[n] = ans;
    }

    public static int catalanTab(int n){
        int[] dp = new int[n+1];
        // initialization
        dp[1] = 1;
        dp[0] = 1;
        // meaning

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catalanRec(n));
        System.out.println(catalanMemo(n,dp));
        System.out.println(catalanTab(n));
    }
}
