/* This class helps us in printing character which come like this abbbbccc => 'a1b4c3'
   Class Owner : Rajan kr Singh
   Date: 16/09/2025
*/
import java.util.Scanner;
public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine(); //take input from user
        String result = "";  //store substring directly
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {
                continue; //skip non-letter characters
            }
            if (result.indexOf(c) != -1) {
                break; //stop at first repeated character
            }
            result += c; //append unique character
        }
        System.out.println("Resulting substring: " + result);

        sc.close();
    }
}
