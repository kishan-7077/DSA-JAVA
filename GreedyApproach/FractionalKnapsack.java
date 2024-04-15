package GreedyApproach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.sort;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] value = {60,100,120};
        int[] weight = {10,20,30};
        int capacity = 40;
        int finalValue = 0;
        double[] ratio = new double[weight.length];

        for(int i=0; i<ratio.length; i++){
            ratio[i] = (double) value[i] /weight[i];
        }

        for (int i=0; i< ratio.length; i++){
            if(capacity >= weight[i]){
                finalValue+=value[i];
                capacity-=weight[i];
            }else {
                //include fractional part and make capacity as 0
                finalValue += (int) (ratio[i]*capacity);
                break;
            }
        }
        System.out.println(finalValue);
    }
}
