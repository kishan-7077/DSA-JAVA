import java.util.Scanner;
public class BitManipulation {

    static int binToDec(int binNum){
        int ans = 0;
        int pow = 0;
        
        while(binNum>0){
            int lastDigit = binNum%10;
            ans = ans + (lastDigit * (int)Math.pow(2, pow));
            pow++;
            binNum=binNum/10;
        }

        return ans;
    }

    static int decToBinary(int decNum){
        int ans=0;
        int pow=0;

        while(decNum > 0){
            int rem = decNum % 2;
            ans = ans + (rem * (int)Math.pow(10, pow));
            pow++;
            decNum = decNum / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        // System.out.println("binary "+n+" to decimal is : "+binToDec(n));
        System.out.println("decimal "+n+" to binary is : "+decToBinary(n));
    }
}
