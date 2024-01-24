public class Strings {

    public static boolean check_palindrome(String str){
        int start = 0, end = str.length()-1;
        while (start<=end) {
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        } 

        // Alternate method
        for(int i=0; i<str.length()/2; i++){
            int n= str.length();
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }

        return true;
    }

    public static double shortest_path(String path, int initial_x,int initial_y){
        for(int i=0; i<path.length(); i++){
            switch (path.charAt(i)) {
                case 'N':
                    initial_y++;
                    break;
                case 'S':
                    initial_y--;
                    break;
                case 'E':
                    initial_x++;
                    break;
                case 'W':
                    initial_x--;
                    break;    
                
                default:
                    break;
            }
            
        }
        double distance = Math.sqrt(Math.pow(initial_x, 2)+Math.pow(initial_y, 2));
        return distance;
    }


    public static String string_compression(String str){
        String newstr = "";
        for(int i=0; i<str.length(); i++){
            Integer count =1;
            while( i<str.length()-1 && str.charAt(i) == str.charAt(i+1) ){
                count++;
                i++;
            }
            newstr += str.charAt(i);
            if(count>1){
                newstr += count.toString();
            }
        }
        return newstr;
    }


    public static void main(String[] args) {
        // String str = "racecar";
        // System.out.println(check_palindrome(str));

        // System.out.println(shortest_path("WNEENESENNN", 0, 0));

        System.out.println(string_compression("aaabbbccc"));
    }
}
