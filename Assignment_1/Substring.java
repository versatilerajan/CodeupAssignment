import java.util.ArrayList;
import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine(); // take input from user

        ArrayList<Character> s = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {
                continue; // skip non-letter characters
            }
            if (s.contains(c)) {
                break; // stop at first repeated character
            }
            s.add(c);
        }

        System.out.print("Resulting substring: ");
        for (char c : s) {
            System.out.print(c);
        }
        System.out.println();

        sc.close();
    }
}
