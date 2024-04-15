package GreedyApproach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class IndianCoins {
    public static void main(String[] args) {
        int[] supply = {1,2,5,10,20,50,100,500,2000};
        int value = 590;
        int maxValue = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=supply.length-1; i>=0; i--){
            if(supply[i] <= value){
                while (supply[i] <= value){
                    maxValue++;
                    value -= supply[i];
                    ans.add(supply[i]);
                }
            }
        }


        System.out.println("Min coins/notes used is : " + maxValue);
        System.out.println(ans);

    }
}
