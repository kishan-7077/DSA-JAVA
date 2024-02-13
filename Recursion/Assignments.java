public class Assignments {

    public static void print_occur(int arr[], int idx, int key) {
        // base
        if (idx == arr.length) {
            return;
        }
        // work
        if (arr[idx] == key) {
            System.out.print(idx + " ");
        }
        print_occur(arr, idx + 1, key);
    }

    public static StringBuilder convert_to_eng(String str, int idx, StringBuilder newStr) {
        // base case
        if (idx == str.length()) {
            return newStr;
        }
        // work
        if (str.charAt(idx) == '1') {
            newStr.append("one ");
        } else if (str.charAt(idx) == '2') {
            newStr.append("two");
        } else if (str.charAt(idx) == '3') {
            newStr.append("three");
        } else if (str.charAt(idx) == '4') {
            newStr.append("four");
        } else if (str.charAt(idx) == '5') {
            newStr.append("five ");
        } else if (str.charAt(idx) == '6') {
            newStr.append("six ");
        } else if (str.charAt(idx) == '7') {
            newStr.append("seven ");
        } else if (str.charAt(idx) == '8') {
            newStr.append("eight ");
        } else if (str.charAt(idx) == '9') {
            newStr.append("nine ");
        }

        return convert_to_eng(str, idx + 1, newStr);

    }

    static String digits[] = { "Zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void convert_to_eng_optimized(int number) {
        // base case
        if (number == 0) {
            return;
        }
        // work
        int lastDigit = number % 10;
        // System.out.print(digits[lastDigit] + " ");
        convert_to_eng_optimized(number / 10);
        System.out.print(digits[lastDigit] + " ");
    }

    public static int length_of_str(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return length_of_str(str.substring(1)) + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        print_occur(arr, 0, 2);

        // System.out.println(convert_to_eng("1974", 0, new StringBuilder("")));

        // convert_to_eng_optimized(1947);

        System.out.println(length_of_str("abcde"));
    }
}
