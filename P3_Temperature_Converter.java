import java.util.Scanner;

public class P3_Temperature_Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTemperature Converter");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Celsius to Kelvin");
            System.out.println("3. Fahrenheit to Celsius");
            System.out.println("4. Fahrenheit to Kelvin");
            System.out.println("5. Kelvin to Celsius");
            System.out.println("6. Kelvin to Fahrenheit");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 6) {
                System.out.print("Enter temperature value: ");
                double temp = scanner.nextDouble();
                double convertedTemp = 0;

                if (choice == 1) {
                    convertedTemp = (temp * 9 / 5) + 32;
                    System.out.println("Converted Temperature: " + convertedTemp + " °F");
                } 
                else if (choice == 2) {
                    convertedTemp = temp + 273.15;
                    System.out.println("Converted Temperature: " + convertedTemp + " K");
                } 
                else if (choice == 3) {
                    convertedTemp = (temp - 32) * 5 / 9;
                    System.out.println("Converted Temperature: " + convertedTemp + " °C");
                } 
                else if (choice == 4) {
                    convertedTemp = (temp - 32) * 5 / 9 + 273.15;
                    System.out.println("Converted Temperature: " + convertedTemp + " K");
                } 
                else if (choice == 5) {
                    convertedTemp = temp - 273.15;
                    System.out.println("Converted Temperature: " + convertedTemp + " °C");
                } 
                else {
                    convertedTemp = (temp - 273.15) * 9 / 5 + 32;
                    System.out.println("Converted Temperature: " + convertedTemp + " °F");
                }
            } 
            else if (choice == 7) {
                System.out.println("Exiting... Thank you for using the Temperature Converter.");
            } 
            else {
                System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
