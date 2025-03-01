//Exercise 5-6.5
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        
        System.out.print("Enter the elements: ");
        int total = 0;
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
            total += numbers[i];
        }

        // (Bubble Sort)
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        double avg = (double) total / size;

        System.out.println("Sorted array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\nSum: " + total);
        System.out.println("Average: " + avg);
        
        scanner.close();
    }
}
