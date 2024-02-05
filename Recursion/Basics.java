
public class Basics {

    static void print_decreasing_order(int n) {
        if (n < 0) {
            return;
        }
        System.out.print(n + " ");
        print_decreasing_order(n - 1);
    }

    public static void print_increasing_order(int n) {
        if (n == 1) {
            System.out.print(n + "");
            return;
        }
        print_increasing_order(n - 1);
        System.out.print(n + " ");

    }

    public static int print_fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * print_fact(n - 1);
    }

    public static int print_n_natural(int n) {
        if (n == 1) {
            return 1;
        }
        return n + print_n_natural(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static boolean isSorted(int arr[], int start) {
        if (start == arr.length - 1) {
            return true;
        }
        if (arr[start] > arr[start + 1]) {
            return false;
        }
        return isSorted(arr, start + 1);
    }

    public static int first_occur(int arr[], int start, int key) {
        if (start == arr.length - 1) {
            return -1;
        }
        if (arr[start] == key) {
            return start;
        }
        return first_occur(arr, start + 1, key);
    }

    public static int last_occur(int arr[], int start, int key) {
        if (start == arr.length) {
            return -1;
        }
        int isFound = last_occur(arr, start + 1, key);
        if (isFound == -1 && arr[start] == key) {
            return start;
        }
        return isFound;
    }

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * pow(x, n - 1);
    }

    public static int pow_optimized(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return pow(x, n / 2) * pow(x, n / 2);
        } else
            return x * pow(x, n / 2) * pow(x, n / 2);
    }

    public static void main(String[] args) {
        // print_decreasing_order(3);
        // print_increasing_order(3);
        // System.out.println(print_fact(4));
        // System.out.println(print_n_natural(4));

        // System.out.println(fibonacci(5));
        int arr[] = { 1, 2, 3, 4 };
        // System.out.println(isSorted(arr, 0));
        // System.out.println(last_occur(arr, 0, 4));
        System.out.println(pow_optimized(2, 4));
    }
}
