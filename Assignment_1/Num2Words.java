/* This class helps us in printing number into string or words like this '121' =>one hundred twenty one 
   Class Owner : Rajan kr Singh
   Date: 16/09/2025
 */
   
import java.util.Scanner;
public class Num2Words {
    static String num2words(int n) {
        String ones[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String teens[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                          "sixteen", "seventeen", "eighteen", "nineteen"};
        String tens[]  = {"", "", "twenty", "thirty", "forty", "fifty",
                          "sixty", "seventy", "eighty", "ninety"};
        
		if (n == 0) return "zero";
        String result = "";
        // handle hundreds
        if (n >= 100) {
            result += ones[n / 100] + " hundred";
            n = n % 100;
            if (n > 0) result += " ";
        }
        // handle tens and ones
        if (n >= 20) {
            result += tens[n / 10];
            if (n % 10 != 0) result += " " + ones[n % 10];
        } else if (n >= 10) {
            result += teens[n - 10];
        } else if (n > 0) {
            result += ones[n];
        }

        return result;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (0–999): ");
        int n = sc.nextInt();
        System.out.println("In words: " + num2words(n));
        sc.close();
    }
}
