package Stacks;

import java.util.Stack;

public class DuplicateParenthesis {
    public static void main(String[] args) {
        // Valid String
        String str1 = "((a+b))"; //true
        String str2 = "(a-b)"; //false

        System.out.println(isDuplicate(str1));
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            //Closing
            if (ch == ')'){
                int count = 0;
                while (s.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true; // duplicate
                }
            }else {
                //Opening
                s.push(ch);
            }
        }
        return false;
    }
}
