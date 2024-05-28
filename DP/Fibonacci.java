package DP;

public class Fibonacci {

    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int fibMemoization(int n,int[] vis){
        if(n==0 || n==1){
            return n;
        }
        if(vis[n] != 0){ // already calculated
            return vis[n];
        }

        vis[n] = fibMemoization(n-1,vis) + fibMemoization(n-2,vis);
        return vis[n];
    }

    public static int fibTabulation(int n){
        if (n==0 || n==1){
            return n;
        }
        int[] arr = new int[n+1];

        // initialization
        arr[0] = 0;
        arr[1] = 1;

        // meaning
        for(int i=2; i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] vis = new int[n+1];
        System.out.println(fib(n));
        System.out.println(fibMemoization(n,vis));
        System.out.println(fibTabulation(n));
    }
}
