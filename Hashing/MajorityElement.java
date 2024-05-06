package Hashing;

import java.util.HashMap;
import java.util.Set;

public class MajorityElement {

    public static void main(String[] args) {
       int[] nums = {1,3,2,5,1,3,1,5,1};
       int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for (int num : nums) {
//            int num = nums[i];
//            if(hm.containsKey(num)){
//                hm.put(num,hm.get(num)+1);
//            }else {
//                hm.put(num,1);
//            }

            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        System.out.println(hm);

//        Set<Integer> keySet = hm.keySet();
        for(Integer key : hm.keySet()){
            if(hm.get(key) > (n/3)){
                System.out.println(key);
            }
        }
    }
}
