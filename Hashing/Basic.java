package Hashing;

import java.util.HashMap;
import java.util.Set;

public class Basic {


    public static void main(String[] args) {
        // Create
        HashMap<String,Integer> hm = new HashMap<>();

        // Insert
        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);

        System.out.println(hm);

        // Get
        int population = hm.get("India");
        System.out.println(population);

        // Contains Key
        System.out.println(hm.containsKey("India"));

        // Remove
//        System.out.println(hm.remove("China"));
//        System.out.println(hm);

        // Size
        System.out.println(hm.size());

        // isEmpty
//        hm.clear();
        System.out.println(hm.isEmpty());

        // Iterate
        // hm.entrySet()
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for(String i : keys){
            System.out.println("key = "+i+",value = "+hm.get(i));
        }
    }
}
