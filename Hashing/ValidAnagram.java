package Hashing;

import java.util.HashMap;

public class ValidAnagram {

    public static boolean isValidAnagram(String s, String t){           //O(n)

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        System.out.println(map);

        for(int i=0; i<t.length(); i++){
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                System.out.println(map);
                if (map.containsValue(0)){
                    map.remove(t.charAt(i));
                }
            }else {
                return false;
            }

        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "tulip";
        String t = "lipid";

        System.out.println(isValidAnagram(s,t));
    }
}
