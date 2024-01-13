public class BinomalCoeff {

    static int fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }

    public static void main(String[] args) {
        int n=4,r=2;
        int ans = fact(n)/(fact(n-r)*fact(r));
        System.out.println(ans);
    }
}
