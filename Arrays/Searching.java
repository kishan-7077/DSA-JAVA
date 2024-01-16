import java.util.Scanner;

public class Searching {

    static void linear_Search(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                System.out.println("Element found at : "+i);
            }
        }
    }
    
    static int largest_in_Array(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public static int binary_search(int arr[],int key){
        int start=0, end=arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int key = sc.nextInt();
        sc.close();

        // linear_Search(arr,key);
        // System.out.println("Largest no. in array is : "+largest_in_Array(arr));
        System.out.println(binary_search(arr, key));
    }
}
