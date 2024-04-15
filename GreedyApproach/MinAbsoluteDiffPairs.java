package GreedyApproach;

import java.util.Arrays;

public class MinAbsoluteDiffPairs {
    public static void main(String[] args) {//O(nlogn)
        int[] A = {1,2,3};
        int[] B = {2,1,3};
        Arrays.sort(A);
        Arrays.sort(B);
        int ans = 0;
        for(int i=0; i<A.length; i++){
            ans += Math.abs(A[i]-B[i]);
        }
        System.out.println(ans);
    }
}
