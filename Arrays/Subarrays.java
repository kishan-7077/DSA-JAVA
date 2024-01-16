public class Subarrays {

    public static void print_subarrays(int arr[]){
        int ts=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k]+" ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Subarrays : "+ts);
    }

    public static int max_Subarray_sum_brute_force(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int sum=0;
                for(int k=i; k<=j; k++){
                    sum+=arr[k];
                }
                System.out.println(sum);
                if(sum>max){
                    max=sum;
                }
            }
        }
        return max;
    }

    public static int max_Subarray_sum_prefix_sum(int arr[]){
        int pre_sum[]=new int[arr.length];
        // calc prefix sum 
        pre_sum[0]=arr[0];
        for(int i=1; i<pre_sum.length; i++){
            pre_sum[i]=pre_sum[i-1] + arr[i];
        }
        // calc max sum
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int currSum=0;
            for(int j=i; j<arr.length; j++){
                currSum = i==0 ? pre_sum[j] : pre_sum[j]-pre_sum[i-1];
            }
            if(currSum>max){
                max=currSum;
            }
        }
        return max;
    }

    public static int max_Subarray_sum_kadane_algo(int arr[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            currSum+=arr[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int arr[]={1,-2,6,-1,3};
        // print_subarrays(arr);
        System.out.println("Max Subarray Sum Using Brute force is : "+max_Subarray_sum_brute_force(arr));
        System.out.println("Max Subarray Sum Using Prefix sum is : "+max_Subarray_sum_prefix_sum(arr));
        System.out.println("Max Subarray Sum Using Kadane is : "+max_Subarray_sum_kadane_algo(arr));
    }
}
