/* This class provides various string and number operations with comprehensive error handling
   Class Owner : Rajan kr Singh
   Date: 16/09/2025
 */
   
import java.util.Scanner;

public class MyString {
    // Arrays for number to words conversion (class-level variables - nouns)
    private static final String[] ONES = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                      "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty",
                      "sixty", "seventy", "eighty", "ninety"};
    
    // Method to validate and get integer input with range checking
    static int getValidatedInteger(Scanner scanner, String prompt, int minValue, int maxValue) {
        int number;
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                input = trimString(input);
                if (input.length() == 0) {
                    System.out.println("Error: Empty input! Please enter a number.");
                    continue;
                }
                // Check for non-numeric characters (except negative sign at start)
                if (!isValidNumberString(input)) {
                    System.out.println("Error: Invalid input! Please enter only numbers (no letters, symbols, or spaces).");
                    continue;
                }
                number = parseInteger(input);
                
                // Handle parsing error
                if (number == Integer.MIN_VALUE) {
                    System.out.println("Error: Invalid number format! Please enter a valid integer.");
                    continue;
                }
                
                // Range validation
                if (number < minValue || number > maxValue) {
                    System.out.println("Error: Number must be between " + minValue + " and " + maxValue + ".");
                    continue;
                }
                
                break;
                
            } catch (Exception exception) {
                System.out.println("Error: Unexpected input error! Please try again.");
            }
        }
        return number;
    }
    
    // Manual string trimming method
    static String trimString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        int start = 0;
        int end = input.length() - 1;
   
        while (start <= end && input.charAt(start) == ' ') {
            start++;
        }
        
        // Find last non-space character
        while (end >= start && input.charAt(end) == ' ') {
            end--;
        }
        
        if (start > end) {
            return "";
        }
        
        // Extract substring manually
        String result = "";
        for (int index = start; index <= end; index++) {
            result = result + input.charAt(index);
        }
        return result;
    }
    
    // Manual integer parsing method
    static int parseInteger(String input) {
        if (input == null || input.length() == 0) {
            return Integer.MIN_VALUE; // Error indicator
        }
        
        int result = 0;
        int sign = 1;
        int startIndex = 0;
        
        // Handle negative sign
        if (input.charAt(0) == '-') {
            sign = -1;
            startIndex = 1;
            if (input.length() == 1) {
                return Integer.MIN_VALUE; // Just a minus sign
            }
        }
        
        // Parse digits
        for (int index = startIndex; index < input.length(); index++) {
            char character = input.charAt(index);
            if (character < '0' || character > '9') {
                return Integer.MIN_VALUE; // Invalid character
            }
            int digit = character - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return Integer.MIN_VALUE; // Overflow
            }
            result = result * 10 + digit;
        }     
        return result * sign;
    }
    // Method to validate if string contains only digits and optional negative sign
    static boolean isValidNumberString(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }
        
        int startIndex = 0;
        // Allow negative sign at the beginning
        if (input.charAt(0) == '-') {
            if (input.length() == 1) {
                return false; // Just a minus sign
            }
            startIndex = 1;
        }
        
        for (int index = startIndex; index < input.length(); index++) {
            char character = input.charAt(index);
            if (character < '0' || character > '9') {
                return false;
            }
        }
        return true;
    }
    
    // Method to get validated string input
    static String getValidatedString(Scanner scanner, String prompt, boolean allowEmpty) {
        String input;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextLine();
                input = trimString(input);
                if (!allowEmpty && input.length() == 0) {
                    System.out.println("Error: Empty input! Please enter a valid string.");
                    continue;
                }  
                break;  
            } catch (Exception exception) {
                System.out.println("Error: Input error! Please try again.");
            }
        }
        return input;
    }
    
    // Method to get menu choice with validation
    static int getValidatedMenuChoice(Scanner scanner) {
        return getValidatedInteger(scanner, "Choose an option (1-6): ", 1, 6);
    }
    
    // Method to convert character to lowercase manually
    static char toLowerCase(char character) {
        if (character >= 'A' && character <= 'Z') {
            return (char)(character + 32);
        }
        return character;
    }
    
    // Method to check if character is a letter
    static boolean isLetter(char character) {
        return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
    }
    
    // Method to check if character is a digit
    static boolean isDigit(char character) {
        return character >= '0' && character <= '9';
    }
    
    // Method to find character in string manually
    static int findCharacter(String text, char character) {
        for (int index = 0; index < text.length(); index++) {
            if (text.charAt(index) == character) {
                return index;
            }
        }
        return -1;
    }
    
    // Method to convert number to words (verb name) - Enhanced with error handling
    static String convertNumberToWords(int number) {
        try {
            if (number == 0) return "zero";
            
            // Handle negative numbers
            if (number < 0) {
                return "negative " + convertNumberToWords(-number);
            }
            
            String result = "";
            
            // Handle hundreds
            if (number >= 100) {
                result = result + ONES[number / 100] + " hundred";
                number = number % 100;
                if (number > 0) result = result + " ";
            }
            if (number >= 20) {
                result = result + TENS[number / 10];
                if (number % 10 != 0) result = result + " " + ones[number % 10];
            } else if (number >= 10) {
                result = result + TEENS[number - 10];
            } else if (number > 0) {
                result = result + ONES[number];
            }
            return result;
            
        } catch (Exception exception) {
            return "Error: Could not convert number to words.";
        }
    }
    
    // Method to decode string like 'a1b4c3' to 'abbbbccc' (verb name) - Enhanced with error handling
    static String decodeString(String encodedString) {
        try {
            if (encodedString == null || encodedString.length() == 0) {
                return "Error: Empty or null input string.";
            }
            
            String result = "";
            int index = 0;
            int length = encodedString.length();
            boolean hasValidFormat = false;
            
            while (index < length) {
                char character = encodedString.charAt(index);
                
                // Skip whitespace and special characters except letters
                if (!isLetter(character) && !isDigit(character)) {
                    index++;
                    continue;
                }
                
                // If we encounter a digit where a letter is expected, skip it
                if (isDigit(character)) {
                    index++;
                    continue;
                }
                
                index++;
                
                // Collect all consecutive digits manually
                String numberString = "";
                while (index < length && isDigit(encodedString.charAt(index))) {
                    numberString = numberString + encodedString.charAt(index);
                    index++;
                }
                
                // If no digits found after letter, default count = 1
                int repeatCount = 1;
                if (numberString.length() > 0) {
                    repeatCount = parseInteger(numberString);
                    if (repeatCount == Integer.MIN_VALUE || repeatCount < 0) {
                        repeatCount = 1; // fallback
                    }
                    if (repeatCount > 1000) { // Prevent memory issues with very large counts
                        System.out.println("Warning: Large repeat count (" + repeatCount + ") for '" + character + "' reduced to 1000.");
                        repeatCount = 1000;
                    }
                }
                
                // Append character 'repeatCount' times
                for (int counter = 0; counter < repeatCount; counter++) {
                    result = result + character;
                }
                hasValidFormat = true;
            }
            
            if (!hasValidFormat) {
                return "Error: No valid letter-number pairs found in input.";
            }
            
            return result;
            
        } catch (Exception exception) {
            return "Error: Could not decode string.";
        }
    }
    static String encodeString(String inputString) {
        try {
            if (inputString == null || inputString.length() == 0) {
                return "Error: Empty or null input string.";
            }
            boolean hasNumbers = false;
            boolean hasSpecialChars = false;
            int letterCount = 0;
            for (int index = 0; index < inputString.length(); index++) {
                char character = inputString.charAt(index);
                if (isLetter(character)) {
                    letterCount++;
                } else if (isDigit(character)) {
                    hasNumbers = true;
                } else if (character != ' ') { // Allow spaces but flag other special chars
                    hasSpecialChars = true;
                }
            }
            
            if (letterCount == 0) {
                return "Error: No letters found in input string.";
            }
            
            if (hasNumbers) {
                return "Error: Numbers not allowed in encoding input. Use only letters (e.g., aabcccdeee).";
            } 
            if (hasSpecialChars) {
                return "Error: Special characters not allowed in encoding input. Use only letters (e.g., aabcccdeee).";
            }
            String result = "";
            String filteredInput = "";
            
            // Filter out spaces and convert to lowercase manually
            for (int index = 0; index < inputString.length(); index++) {
                char character = inputString.charAt(index);
                if (isLetter(character)) {
                    filteredInput = filteredInput + toLowerCase(character);
                }
            }
            
            int length = filteredInput.length();
            int index = 0;
            
            while (index < length) {
                char currentCharacter = filteredInput.charAt(index);
                int count = 1;
                
                while (index + 1 < length && filteredInput.charAt(index) == filteredInput.charAt(index + 1)) {
                    count++;
                    index++;
                }
                result = result + currentCharacter + count;
                index++;
            }
            
            return result;
            
        } catch (Exception exception) {
            return "Error: Could not encode string.";
        }
    }
    
    // Method to check if a number is prime (verb name) - Enhanced with error handling
    static String checkPrime(int number) {
        try {
            if (number < 0) {
                return number + " is negative. Negative numbers cannot be prime.";
            }
            
            if (number <= 1) {
                return number + " is not a prime number. (Prime numbers must be greater than 1)";
            }
            
            if (number == 2) {
                return number + " is a prime number. (The only even prime number)";
            }
            if (number % 2 == 0) {
                return number + " is not a prime number. (Even numbers > 2 are not prime)";
            }
            for (int divisor = 3; divisor * divisor <= number; divisor += 2) {
                if (number % divisor == 0) {
                    return number + " is not a prime number. (Divisible by " + divisor + ")";
                }
            } 
            return number + " is a prime number.";
            
        } catch (Exception exception) {
            return "Error: Could not check if number is prime.";
        }
    }
    
    // Method to extract substring until first repeated character (verb name) - Enhanced with error handling
    static String extractUniqueSubstring(String inputString) {
        try {
            if (inputString == null || inputString.length() == 0) {
                return "Error: Empty or null input string.";
            }
            
            String result = "";
            String seenCharacters = "";
            
            for (int index = 0; index < inputString.length(); index++) {
                char currentCharacter = inputString.charAt(index);
                
                if (!isLetter(currentCharacter)) {
                    continue; // skip non-letter characters
                }
                
                // Convert to lowercase for case-insensitive comparison
                char lowerCharacter = toLowerCase(currentCharacter);
                
                if (findCharacter(seenCharacters, lowerCharacter) != -1) {
                    break; // stop at first repeated character
                }
                
                seenCharacters = seenCharacters + lowerCharacter;
                result = result + currentCharacter; // preserve original case in result
            }
            
            if (result.length() == 0) {
                return "Error: No letters found in input string.";
            }
            
            return result;
            
        } catch (Exception exception) {
            return "Error: Could not extract unique substring.";
        }
    }
    
    // Method to display menu (verb name)
    static void displayMenu() {
        System.out.println("\n=== MyString Operations Menu ===");
        System.out.println("1. Convert number to words");
        System.out.println("2. Decode string (e.g., a1b4c3 -> abbbbccc)");
        System.out.println("3. Encode string (e.g., abbbbccc -> a1b4c3)");
        System.out.println("4. Check if number is prime");
        System.out.println("5. Extract unique substring");
        System.out.println("6. Exit");
    }
    
    // Method to pause execution for better user experience
    static void waitForEnter(Scanner scanner) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        System.out.println("Welcome to MyString Operations!");
        System.out.println("This program handles various string and number operations with full error checking.");
        
        do {
            try {
                displayMenu();
                choice = getValidatedMenuChoice(scanner);
                
                switch (choice) {
                    case 1:
                        System.out.println("\n--- Number to Words Conversion ---");
                        int number = getValidatedInteger(scanner, "Enter a number (-999 to 999): ", -999, 999);
                        System.out.println("In words: " + convertNumberToWords(number));
                        waitForEnter(scanner);
                        break;
                        
                    case 2:
                        System.out.println("\n--- String Decoding ---");
                        System.out.println("Format: letter followed by number (e.g., a1b4c3)");
                        String encodedInput = getValidatedString(scanner, "Enter encoded string: ", false);
                        String decodedResult = decodeString(encodedInput);
                        System.out.println("Decoded: " + decodedResult);
                        waitForEnter(scanner);
                        break;
                        
                    case 3:
                        System.out.println("\n--- String Encoding ---");
                        System.out.println("Format: string with repeated characters (e.g., aabcccdeee)");
                        String stringToEncode = getValidatedString(scanner, "Enter string: ", false);
                        String encodedResult = encodeString(stringToEncode);
                        System.out.println("Encoded: " + encodedResult);
                        waitForEnter(scanner);
                        break;
                        
                    case 4:
                        System.out.println("\n--- Prime Number Check ---");
                        int numberToCheck = getValidatedInteger(scanner, "Enter the number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                        String primeResult = checkPrime(numberToCheck);
                        System.out.println(primeResult);
                        waitForEnter(scanner);
                        break;
                        
                    case 5:
                        System.out.println("\n--- Unique Substring Extraction ---");
                        System.out.println("Extracts characters until first repetition");
                        String inputForSubstring = getValidatedString(scanner, "Enter a string: ", false);
                        String substringResult = extractUniqueSubstring(inputForSubstring);
                        System.out.println("Resulting substring: " + substringResult);
                        waitForEnter(scanner);
                        break;
                        
                    case 6:
                        System.out.println("\nThank you for using MyString operations!");
                        System.out.println("Goodbye!");
                        break;
                        
                    default:
                        System.out.println("Error: Invalid choice! This shouldn't happen with validation.");
                }
                
            } catch (Exception exception) {
                System.out.println("Error: An unexpected error occurred. Please try again.");
                choice = 0; // Continue the loop
            }
        } while (choice != 6);
        
        try {
            scanner.close();
        } catch (Exception exception) {
            System.out.println("Warning: Could not close scanner properly.");
        }
    }

}
