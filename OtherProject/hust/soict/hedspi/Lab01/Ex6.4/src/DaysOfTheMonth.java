///Exercise 4-6.4
import java.util.Scanner;

public class DaysOfTheMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputMonth;
        int year, monthNumber = 0;
        String[][] validMonths = {
            {"January", "Jan.", "Jan", "1"},
            {"February", "Feb.", "Feb", "2"},
            {"March", "Mar.", "Mar", "3"},
            {"April", "Apr.", "Apr", "4"},
            {"May", "May", "May", "5"},
            {"June", "Jun.", "Jun", "6"},
            {"July", "Jul.", "Jul", "7"},
            {"August", "Aug.", "Aug", "8"},
            {"September", "Sept.", "Sep", "9"},
            {"October", "Oct.", "Oct", "10"},
            {"November", "Nov.", "Nov", "11"},
            {"December", "Dec.", "Dec", "12"}
        };
        while (true) {
            System.out.print("Enter the month: ");
            inputMonth = scanner.nextLine();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 4; j++) {
                    if (inputMonth.equalsIgnoreCase(validMonths[i][j])) {
                        monthNumber = i + 1;
                        break;
                    }
                }
            }
            if (monthNumber != 0) break;
            System.out.println("Invalid month, please enter again!");
        }
        while (true) {
            System.out.print("Enter the year: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) break;
            }
            System.out.println("Invalid year, please enter a non-negative number!");
            scanner.nextLine();
        }

        // Kiểm tra năm nhuận
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // < Xác định số ngày trong tháng năm nhuận >
        int daysInMonth;
        switch (monthNumber) {
            case 2:
                daysInMonth = isLeapYear ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;
            default:
                daysInMonth = 31;
                break;
        }

        // Siuuuuuuuuuuu
        System.out.println("Days in month: " + daysInMonth);
        scanner.close();
    }
}
