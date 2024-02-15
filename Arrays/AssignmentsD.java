public class AssignmentsD {
    public static void main(String[] args) {
        String arr[] = { "sun", "earth", "mars", "mercury" };
        arr = Ques1.mergeSort(arr, 0, arr.length - 1);
        Ques1.printarr(arr);
    }
}

class Ques1 {
    public static String[] mergeSort(String arr[], int lo, int hi) {
        if (lo == hi) {
            String[] a = { arr[lo] };
            return a;
        }
        int mid = lo + (hi - lo) / 2;
        String arr1[] = mergeSort(arr, lo, mid);
        String arr2[] = mergeSort(arr, mid + 1, hi);

        String arr3[] = merge(arr1, arr2);
        return arr3;
    }

    public static String[] merge(String arr1[], String arr2[]) {
        int idx = 0;
        int i = 0;
        int j = 0;
        int m = arr1.length;
        int n = arr2.length;

        String arr3[] = new String[m + n];

        while (i < m && j < n) {
            if (isAlphabeticallyCorrect(arr1[i], arr2[j])) {
                arr3[idx] = arr1[i];
                i++;
                idx++;
            } else {
                arr3[idx] = arr2[j];
                j++;
                idx++;
            }
        }

        while (i < m) {
            arr3[idx] = arr1[i];
            i++;
            idx++;
        }
        while (j < n) {
            arr3[idx] = arr2[j];
            j++;
            idx++;
        }

        return arr3;
    }

    // return true if arr1[i] appears before arr2
    public static boolean isAlphabeticallyCorrect(String str1, String str2) {
        if (str1.compareTo(str2) < 0) {
            return true;
        }
        return false;
    }

    public static void printarr(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
