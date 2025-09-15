import java.util.Scanner;
import java.util.InputMismatchException;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter a positive number to print its multiplication table: ");
                num = sc.nextInt();
                if (num <= 0) {
                    System.out.println("Error: Please enter a positive number greater than 0.");
                    continue;
                }
                validInput = true; 
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input! Please enter a valid integer number.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error: An unexpected error occurred. Please try again.");
                sc.nextLine(); 
            }
        } 
        try {
            System.out.println("\nMultiplication table of " + num + ":");
            for (int i = 1; i <= 10; i++) {
                int result = num * i;
                System.out.println(num + " x " + i + " = " + result);
            }  
        } catch (Exception e) {
            System.out.println("Error: An error occurred while generating the multiplication table.");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        System.out.println("\nThank you for using the multiplication table generator!");
    }
}
