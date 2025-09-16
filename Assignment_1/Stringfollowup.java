/* This class helps us in printing character which come like this 'a1b4c3' =>abbbbccc 
   Class Owner : Rajan kr Singh
   Date: 16/09/2025
*/
import java.util.Scanner;
public class Stringfollowup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter encoded string (e.g. a1b4c3): ");
        String str = sc.nextLine().trim();
        int i = 0;
        int n = str.length();
        while (i < n) {
            char letter = str.charAt(i);
            // if we encounter a digit where a letter is expected, skip it
            if (Character.isDigit(letter)) {
                i++;
                continue;
            }
            i++;
            // collect all consecutive digits (supports multi-digit counts)
            int j = i;
            while (j < n && Character.isDigit(str.charAt(j))) {
                j++;
            }
            // if no digits found after letter, default count = 1
            int count = 1;
            if (j > i) {
                String numStr = str.substring(i, j);
                try {
                    count = Integer.parseInt(numStr);
                } catch (NumberFormatException e) {
                    count = 1; // fallback
                }
            }
            for (int k = 0; k < count; k++) {
                System.out.println(letter);
            }
            i = j;
        }
        sc.close();
    }
}
