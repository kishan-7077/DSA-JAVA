public class TrappingRainwater {

    public static int trappedRainWater(int arr[]){
        int width=1;
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        leftMax[0]=arr[0];
        for(int i=1; i<arr.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }
        rightMax[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }
        int sumtrap=0;
        for(int i=0; i<arr.length; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            int height = arr[i]; 
            int trapWater = (waterLevel-height)*width;
            sumtrap+=trapWater;
        }
        return sumtrap;
    }


    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println("Total Trapped Water is : "+trappedRainWater(height));
    }
}
