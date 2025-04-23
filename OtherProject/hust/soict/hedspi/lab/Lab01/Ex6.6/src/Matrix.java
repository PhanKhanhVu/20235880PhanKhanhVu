//Exercis 6-6.6
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];

        System.out.println("Enter elements for Matrix A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements for Matrix B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        int[][] matrixSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixSum[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Sum of Matrix A and Matrix B:");
        for (int[] row : matrixSum) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
