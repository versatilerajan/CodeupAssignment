/* This class helps us in printing character which come like this 'a1b4c3' => abbbbccc 
   Class Owner : Rajan kr Singh
   Date: 16/09/2025
*/

import java.util.Scanner;
public class Encodetostring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string (e.g. aabcccdeee): ");
        String str = sc.nextLine().trim();
        String result = "";  
        int n = str.length();
        int i = 0;
        while (i < n) {
            char letter = str.charAt(i);
            int count = 1;
            while (i + 1 < n && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            result = result + letter + count;
            i++;
        }
        System.out.println("Encoded: " + result);
        sc.close();
    }
}
