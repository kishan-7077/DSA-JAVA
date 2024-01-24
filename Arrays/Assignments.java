import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Assignments {

    public static boolean rep(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean rep_optimized(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            if(set.contains(arr[i])){
                return true;
            }
            else{
                set.add(arr[i]);
            }
        }
        return false;
    }

    /* ------->>>>  Alog for search in rotated Sorted Array.   <<<<-----------
        1. First initialize integers start with 0 and end with length-1.
	    2. Create a while loop that runs until start<=end.
	    3. Inside loop initialize mid=(start+end)/2.To give middle element.
	    4. Check if the arr[mid]==target.If so return mid.
	    5. Else, if arr[start]<=arr[mid]i.e the element lies in left sorted array. Then check if the key lies between arr[s] and arr[mid]. If so then do end=mid-1; else do s=mid+1;
	    6. Else the target lies in right sorted array. Check if the target value lies between arr[mid] and arr[end].if so then do s=mid+1; Else do e=mid-1;
        7. Finally if the element is not found in the array return -1 
    */

    public static int search_in_rotated_sorted_array(int arr[],int key){
        int s=0,e=arr.length-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(key==arr[mid]){
                return mid;
            }
            // for left sorted array
            else if(arr[s]<=arr[mid]){
                if(key>=arr[s] && key<arr[mid]){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
            // for right sorted array
            else{
                if(key<=arr[e] && key>arr[mid]){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
        }
        return -1;
    }

    public static int binary_search(int arr[],int target){
        int s=0,e=arr.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return -1;
    }


    public static int maxProfit(int prices[]){
        int buy = prices[0];
        int maxProfit=0;
        for(int i=1; i<prices.length; i++){
            if(buy<prices[i]){
                maxProfit=Math.max(maxProfit, prices[i]-buy);
            }
            else{
                buy=prices[i];
            }
        }
        return maxProfit;
    }


    /* int trapWater = (waterLevel-height)*width; */
    /* waterLevel=min(leftMax and rightMax) */
    public static int TrappingRainwater(int height[]){
        int width=1;
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        // for leftMax
        leftMax[0]=height[0];
        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        // for rightMax (Start from behind)
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        // for trapped water
        int sumtrap=0;
        for(int i=0; i<height.length; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            int h = height[i];
            int trapWater = (waterLevel-h)*width;
            sumtrap+=trapWater;
        }
        return sumtrap;
    }

    public List<List<Integer>> print_triplets_with_sum_zero(int arr[]){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> triplet = new ArrayList<Integer>();
                            triplet.add(arr[i]);
                            triplet.add(arr[k]);
                            triplet.add(arr[k]);
                            Collections.sort(triplet);
                            result.add(triplet);
                    }
                }
            }
        }
        result = new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(result));
        return result;
    }


    public static int number_of_7s_in_2d_array(int matrix[][]){
        int count=0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==7){
                    count ++;
                }
            }
        }

        return count;
    }

    public static int[][] transpose_of_matrix(int matrix[][]){
        int transpose[][] = new int[matrix[0].length][matrix.length];
        // int row=0; int col=0;
        // while (row<matrix.length && col<matrix[0].length) {
        //     if(row!=col){
        //         matrix[row][col]=transpose[col][row];
        //     }
        // }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                transpose[j][i] = matrix[i][j];
            }
            System.out.println();
        }

        return transpose;
    }

    public static void print_2D_arr(int arr[][]){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        // int nums[] = {-1, 0,  1, 2, -1, -4};
        // System.out.println(rep(nums));
        // System.out.println(rep_optimized(nums));

        // System.out.println(search_in_rotated_sorted_array(nums, 7));
        // System.out.println(binary_search(nums, 0));


        // System.out.println(maxProfit(nums));

        // System.out.println(TrappingRainwater(nums));

        // print_triplets_with_sum_zero(nums);



        int arr[][] = {{4,7,8},{8,8,7}};

        // System.out.println(number_of_7s_in_2d_array(arr));

        int transpose[][] = transpose_of_matrix(arr);
        print_2D_arr(transpose);
    }
}
