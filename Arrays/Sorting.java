public class Sorting {

    public static void bubble_sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selection_sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void insertion_sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // for correct position
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev + 1] = curr;
        }
    }

    public static void count_sort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void print_arr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int arr[], int si, int ei) { // Divide & Conquer
        // base case
        if (si >= ei) {
            return;
        }
        // work
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        // to merge sorted parts
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // for remaining elements of left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // for remaining elements of right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // store temp array into main array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei) { // pivot & partition
        // base case
        if (si >= ei) {
            return;
        }
        // work
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1); // left part
        quickSort(arr, pIdx + 1, ei); // right part
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static int searchInRotatedSorted(int arr[], int si, int ei, int key) {

        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        // mid on L1
        if (arr[si] <= arr[mid]) {
            // case a: left
            if (arr[si] <= key && arr[mid] >= key) {
                return searchInRotatedSorted(arr, si, mid, key);
            }
            // case b: right
            else {
                return searchInRotatedSorted(arr, mid + 1, ei, key);
            }
        }
        // mid in L2
        else {
            // case c: right
            if (key >= arr[mid] && key <= arr[ei]) {
                return searchInRotatedSorted(arr, mid + 1, ei, key);
            }
            // case d: left
            else {
                return searchInRotatedSorted(arr, si, mid, key);
            }
        }
    }

    public static int searchInRotatedSortedWithOutRecursion(int arr[], int key) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (key == arr[mid]) {
                return mid;
            }

            // for left part
            if (arr[s] <= arr[mid]) {
                if (key >= arr[s] && key <= arr[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            // for right part
            else {
                if (key >= arr[mid] && key <= arr[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 2, 3 };

        // bubble_sort(arr);

        // selection_sort(arr);

        // insertion_sort(arr);

        // count_sort(arr);

        // mergeSort(arr, 0, arr.length - 1);

        // quickSort(arr, 0, arr.length - 1);

        // print_arr(arr);

        System.out.println(searchInRotatedSortedWithOutRecursion(arr, 1));
    }
}
