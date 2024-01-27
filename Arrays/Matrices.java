public class Matrices {

    public static void spiral_matrix(int matrix[][]) {
        int start_col = 0;
        int start_row = 0;
        int end_row = matrix.length - 1;
        int end_col = matrix[0].length - 1;

        while (start_row <= end_row && start_col <= end_col) {
            // for top row
            for (int i = start_col; i <= end_col; i++) {
                System.out.print(matrix[start_row][i] + " ");
            }
            // for last col
            for (int i = start_row + 1; i <= end_row; i++) {
                System.out.print(matrix[i][end_col] + " ");
            }
            // for bottom row
            for (int i = end_col - 1; i >= start_col; i--) {
                if (start_col == end_col) {
                    break;
                }
                System.out.print(matrix[end_row][i] + " ");
            }
            // for first col
            for (int i = end_row - 1; i >= start_row + 1; i--) {
                if (start_col == end_col) {
                    break;
                }
                System.out.print(matrix[i][start_col] + " ");
            }
            start_col++;
            start_row++;
            end_col--;
            end_row--;
        }
    }

    public static int diagonal_sum(int matrix[][]) {
        int sum = 0, n = matrix.length - 1;
        // O(n2) complexity

        // for(int i=0; i<=n; i++){
        // for(int j=0; j<=n; j++){
        // if(i+j==n || i==j){
        // sum += matrix[i][j];
        // }
        // }
        // }

        // O(n) complexity
        for (int i = 0; i <= n; i++) {

            sum += matrix[i][i];

            if (i != n - i) {
                sum += matrix[i][n - i];
            }
        }

        return sum;
    }

    public static boolean staircase_search(int matrix[][], int key) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (key == matrix[row][col]) {
                System.out.println("Found at " + row + "," + col);
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Not found");
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        // spiral_matrix(arr);

        // System.out.println(diagonal_sum(arr));

        staircase_search(arr, 17);
    }
}
