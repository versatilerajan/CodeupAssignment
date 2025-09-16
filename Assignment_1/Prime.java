/* This class helps us check if a number is prime or not
   Class Owner : Rajan kr Singh
   Date: 16/09/2025
*/

import java.util.Scanner;
public class Prime {  
    static boolean isPrime(int n) {
        if (n <= 1) {  // handles 0, 1, and negative numbers
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        
        if (sc.hasNextInt()) {
            int number = sc.nextInt();
            
            if (number < 0) {
                System.out.println("Negative numbers cannot be prime.");
            } else if (isPrime(number)) {
                System.out.println(number + " is a prime number");
            } else {
                System.out.println(number + " is not a prime number");
            }
        } else {
            System.out.println("Invalid input! Please enter a valid integer.");
        }
        sc.close();
    }
}
