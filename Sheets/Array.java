import java.util.Arrays;
public class Array {

    static void minmax(int arr[]){
        Arrays.sort(arr);
        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);
    }

    public static void main(String[] args) {
        int arr[] = {3,4,5,1,10};
        minmax(arr);
    }
}
