import java.util.Scanner;

public class Searching {

    static void linear_Search(int arr[],int n,int key){
        for(int i=0;i<n;i++){
            if(arr[i]==key){
                System.out.println("Element found at : "+i);
            }
        }
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

        linear_Search(arr,n,key);
    }
}
