package DP;

public class ClimbingStairs {

    public static int ways(int n){
        if(n<0){
            return 0;
        }
        if (n == 0){
            return 1;
        }

        return ways(n-1)+ways(n-2);
    }

    public static int waysMemoization(int n,int[] vis){
        if(n<0){
            return 0;
        }
        if (n==0){
            return 1;
        }
        if(vis[n] != 0){
            return vis[n];
        }
        vis[n] = waysMemoization(n-1,vis)+waysMemoization(n-2,vis);
        return vis[n];
    }

    public static int waysTabulation(int n){
        if(n==-1){
            return 0;
        }
        if(n==0){
            return 1;
        }
        int[] arr = new int[n+1];
        // initialization
        arr[0] = 1;
        arr[1] = 1;
        // meaning
        for(int i=2;i<arr.length; i++){
            arr[i] = waysTabulation(n-1) + waysTabulation(n-2);
        }
        return arr[n];
    }

    public static void main(String[] args) {
        // if jump to 1 and 2 stairs are allowed
        // (n-1) + (n-2)
        // if jump to 1,2,3 are allowed
        // (n-1) + (n-2) + (n-3)
        int n = 5;
        int[] vis = new int[n+1];
        System.out.println(ways(n));
        System.out.println(waysMemoization(n,vis));
        System.out.println(waysTabulation(n));
    }
}
