import java.util.Scanner;

public class Encodetostring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string (e.g. aabcccdeee): ");
        String str = sc.nextLine().trim();

        StringBuilder result = new StringBuilder();

        int n = str.length();
        int i = 0;

        while (i < n) {
            char letter = str.charAt(i);
            int count = 1;

            // count consecutive same characters
            while (i + 1 < n && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            // append letter + count
            result.append(letter).append(count);

            i++;
        }

        System.out.println("Encoded: " + result.toString());
        sc.close();
    }
}
