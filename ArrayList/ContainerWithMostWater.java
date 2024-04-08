import java.util.ArrayList;
import java.util.Scanner;

public class ContainerWithMostWater {

    public static int storeWater(ArrayList<Integer> height) {
        int maxW = 0;
        //brute force
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wt = j - i;
                int currWater = ht * wt;
                maxW = Math.max(maxW, currWater);
            }
        }
        return maxW;
    }

    public static int storeWaterTwoPointer(ArrayList<Integer> height) {
        int maxW = 0;
        int lp = 0, rp = height.size() - 1;
        while (lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int wt = rp - lp;
            int currW = ht * wt;
            maxW = Math.max(maxW, currW);

            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxW;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> height = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            height.add(sc.nextInt());
        }
        sc.close();

        System.out.println(storeWaterTwoPointer(height));
    }
}
