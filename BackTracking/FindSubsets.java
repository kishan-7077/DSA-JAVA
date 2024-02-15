public class FindSubsets {

    public static void subsets(String str, String ans, int idx) {
        // base case
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }
        // recursion
        // yes choice
        subsets(str, ans + str.charAt(idx), idx + 1);
        // no choice
        subsets(str, ans, idx + 1);
    }

    public static void main(String[] args) {
        subsets("abc", "", 0);
    }
}
