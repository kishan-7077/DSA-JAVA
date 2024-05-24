package Practice;

import java.util.HashMap;
import java.util.Set;

public class TestStrings {

    public static String numPad(String str,String[] arr){
        StringBuilder ans = new StringBuilder();
        int n = str.length();

        for(int i=0; i<n; i++){
            if(str.charAt(i) == ' '){
                ans.append("0");
            }else {
                int pos = str.charAt(i) - 'A';
                ans.append(arr[pos]);
            }
        }

        return ans.toString();
    }


    public static void occurrence(String str){
        int n = str.length();
        if(n == 1){
            System.out.println("no duplicates");
            return;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char curr = str.charAt(i);
            if(!map.containsKey(curr)){
                map.put(curr,1);
            }else{
                map.put(curr, map.get(curr)+1);
            }
        }

        Set<Character> keys = map.keySet();
        for(Character k : keys){
            if(map.get(k)>=2){
                System.out.print(k.toString()+map.get(k)+" ");
            }

        }
    }




    public static void main(String[] args) {
        String[] str
                = { "2",    "22",  "222", "3",   "33", "333",
                "4",    "44",  "444", "5",   "55", "555",
                "6",    "66",  "666", "7",   "77", "777",
                "7777", "8",   "88",  "888", "9",  "99",
                "999",  "9999" };
        String input = "GEEKSFORGEEKS";
//        System.out.println(numPad(input,str));


        String s = "geeksforgeeks";
//        occurrence(s);

    }
}
