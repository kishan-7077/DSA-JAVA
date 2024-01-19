import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
public class Array {

    static void minmax(int arr[]){
        Arrays.sort(arr);
        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);
    }

    static void reverse(int arr[]){
        int s=0,e=arr.length-1;
        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s=s+1;
            e=e-1;
        }
    }

    public static int maxSubArraySum_Using_Kadane(int arr[]){
        int currSum = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            currSum+=arr[i];
            if(currSum<0){
                currSum = 0;
            }
            max_sum = Math.max(currSum, max_sum);
        }
        return max_sum;
    }

    public static int maxSubArraySum_Using_On2_complexity(int arr[]){
        int pre_sum[] = new int[arr.length];
        int maxSum = Integer.MIN_VALUE;
        pre_sum[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            pre_sum[i] = pre_sum[i-1] + arr[i];
        }
        // for maxSum
        for(int i=0; i<arr.length; i++){
            int currSum=0;
            for(int j=i+1; j<arr.length; j++){
                currSum = i==0 ? pre_sum[j] : pre_sum[j] - pre_sum[i-1];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static boolean contains_duplicate(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            if(set.contains(arr[i])){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public static int Chocalate_distribution(int arr[], int no_of_pairs){
        int min_diff = Integer.MAX_VALUE,min_value=0,max_value=0;

        if (arr.length == 0 || no_of_pairs == 0) {
            return 0;
        }
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            if(i<=arr.length-no_of_pairs){
                min_value=arr[i];
            max_value=arr[i+no_of_pairs-1];
            min_diff = Math.min(max_value-min_value, min_diff);
            }
        }
        return min_diff;
    }


    public static int search_in_rotated_sorted_array(int arr[], int target){
        int s=0;int e=arr.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(target==arr[mid]){
                return mid;
            }
            // for right sorted array
            else if(arr[s]<=arr[mid]){
                if(arr[s]<=target && arr[mid]>target){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
            // for left sorted array
            else{
                if(target<=arr[e] && target>arr[mid]){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
        }
        return -1;
    }

    public static int maxProfit(int prices[]){
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(buy<prices[i]){
                profit = Math.max(profit, prices[i]-buy);
            }
            else{
                buy = prices[i];
            }
        }
        return profit;
    }


    public static void rep_and_missing_number_from_array(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        int rep=-1; int missing=-1;
        for(int i=0; i<arr.length; i++){
            if(set.contains(arr[i])){
                rep = arr[i];
            }
            else{
                set.add(arr[i]);
            }
            if(!set.contains(i)){
                missing = i;
            }
        }
        System.out.println("["+rep+","+missing+"]");
    }

    public static int kth_largest_element(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        int arr[] = {3,2,1,5,6,4};
        // minmax(arr);


        // reverse(arr);
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i]+" ");
        // }


        // System.out.println(maxSubArraySum_Using_Kadane(arr));
        // System.out.println(maxSubArraySum_Using_On2_complexity(arr));
        

        // System.out.println(contains_duplicate(arr));

        // System.out.println(Chocalate_distribution(arr, 5));

        // System.out.println(search_in_rotated_sorted_array(arr, 4));

        // rep_and_missing_number_from_array(arr);

        System.out.println(kth_largest_element(arr, 2));
    }
}
