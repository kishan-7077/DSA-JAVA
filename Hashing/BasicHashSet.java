package Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class BasicHashSet {

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);

        hs.remove(4);
//        hs.clear();
        System.out.println(hs);
//
//        System.out.println(hs.contains(2));
//        System.out.println(hs.size());

        // Using Iterators
//        Iterator<Integer> itr = hs.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }

        // Using Enhanced for loop
        for(Integer h : hs){
            System.out.println(h);
        }

        // Order is maintained based on insertion in LinkedHashSet
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");
        System.out.println(lhs);

        // Sorted in ascending order -> internally implemented using red-black trees
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(5);
        treeSet.add(4);
        System.out.println(treeSet);
    }
}
