public class Sorting {

    public static void bubble_sort(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selection_sort(int arr[]){
        for(int i=0; i<arr.length; i++){
            int minPos=i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void insertion_sort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int curr=arr[i];
            int prev = i-1;
            // for correct position
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev+1] = curr;
        }
    }


    public static void count_sort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        // sorting
        int j=0;
        for(int i=0; i<count.length; i++){
            while (count[i]>0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }


    public static void print_arr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,4,1,2,3};

        // bubble_sort(arr);

        // selection_sort(arr);

        // insertion_sort(arr);

        count_sort(arr);

        print_arr(arr);
    }
}
