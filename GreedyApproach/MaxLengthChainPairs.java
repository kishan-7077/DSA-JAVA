package GreedyApproach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainPairs {
    public static void main(String[] args) {        //O(nlogn)
        int[] first = {5,39,5,27,50};
        int[] second = {24,60,28,40,90};

        int[][] pairs = new int[second.length][3];

        for(int i = 0; i< pairs.length; i++){
            pairs[i][0] = i;           // first column
            pairs[i][1] = first[i];    // second column
            pairs[i][2] = second[i];   // third column
        }

        // lambda function short form
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> ans = new ArrayList<>();
        int lastEnd = pairs[0][2];
        int maxPair = 1;
        ans.add(pairs[0][0]);


        for(int i = 1; i<pairs.length; i++){
            if (lastEnd <= pairs[i][1]){
                maxPair++;
                lastEnd = pairs[i][2];
                ans.add(pairs[i][0]);
            }
        }

        System.out.println("Max Chain of Pairs : " + maxPair);
        System.out.println("Indexes of Pairs : " + ans);

    }

}
