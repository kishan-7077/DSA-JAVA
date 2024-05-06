package Hashing;

import java.util.HashSet;

public class UnionAndIntersection {

    public static void main(String[] args) {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};

        HashSet<Integer> union = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        // for union
        for (Integer i : arr1){
            union.add(i);
            intersection.add(i);
        }
        int count = 0;
        for (Integer i : arr2){
            union.add(i);
            if(intersection.contains(i)){
                count++;
                intersection.remove(i);
            }
        }

        System.out.println("Union is : "+union);
        System.out.println(union.size());
        System.out.println("Intersection is : "+intersection);
        System.out.println(count);
    }
}
