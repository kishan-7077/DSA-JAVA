import java.util.*;
public class Patterns {

    static void star(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void invertedStar(int n){
        for(int i=n;i>0;i--){
            for(int j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void halfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void charPattern(int n){
        char ch ='A';
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }

    static void hollow_Rectangle(int totRow,int totCol){

        for(int i=0;i<totRow;i++){
            for(int j=0; j<totCol; j++){
                if(i==0||i==totRow-1||j==0||j==totCol-1){
                    System.out.print("* ");
                }
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void rotated_and_inverted_HalfPyramid(int n){
        for(int i=1; i<=n; i++){ 

            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int j=1; j<=i; j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void inverted_halfPyramid_with_numbers(int n){
        for(int i=n; i>0; i--){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static void floyd_triangle(int n){
        int count=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }

    static void zero_one_pattern(int n){  //Matrix approach 
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if((i+j)%2==0){
                    System.out.print("1 ");
                }
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    static void butterfly_pattern(int n){
        for(int i=1; i<=n; i++){
            //stars
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            //space
            for(int j=1; j<=2*(n-i); j++){
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n; i>0; i--){
            //stars
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            //space
            for(int j=1; j<=2*(n-i); j++){
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void solid_Rhombus(int n){
        for(int i=1; i<=n; i++){
            //space
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            //stars
            for(int j=1;j<n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void hollow_Rhombus(int n){
        for(int i=1; i<=n; i++){
            //space
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            //stars
            for(int j=1;j<=n;j++){
                if(i==1||j==1||i==n||j==n){
                    System.out.print("* ");
                }
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void diamond_pattern(int n){
        for(int i=1; i<=n; i++){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            //stars
            for(int j=0; j<=(2*(i-1)); j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n; i>0; i--){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            //stars
            for(int j=0; j<=(2*(i-1)); j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        sc.close();
        charPattern(n);
        hollow_Rectangle(4, 5);
        rotated_and_inverted_HalfPyramid(4);
        inverted_halfPyramid_with_numbers(5);
        floyd_triangle(5);
        zero_one_pattern(5);
        butterfly_pattern(4);
        solid_Rhombus(5);
        hollow_Rhombus(5);
        diamond_pattern(4);
    }
}