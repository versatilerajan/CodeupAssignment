/* Assignment title -> Code practice
   Task related to - String and Number
   Class owner -  Rajan
   Date - 30/09/2025
*/

#include <iostream>
#include <string>
using namespace std;

class Operations {
private:
//  generating valid parentheses
    void generateHelper(int open, int close, string s) {
        if (open == 0 && close == 0) {
            cout << s << endl;
            return;
        }
        if (open > 0)
            generateHelper(open - 1, close, s + "(");
        if (close > open)
            generateHelper(open, close - 1, s + ")");
    }

public:
// Generate valid parentheses combinations
    void generateParentheses() {
        int n;
        cout << "\n Generate Valid Parentheses :" << endl;
        cout << "Enter number of pairs: ";
        cin >> n;
        cout << "Valid combinations:" << endl;
        generateHelper(n, n, "");
    }

// Add digits of a given number
    void addDigits() {
        int n;
        int res = 0;
        cout << "\n Add Digits of Number :" << endl;
        cout << "Enter the number: ";
        cin >> n;
        
        while (n != 0) {
            int digit = n % 10;
            res = res + digit;
            n = n / 10;
        }
        
        cout << "Sum of digits: " << res << endl;
    }
    
// Find consecutive number sequences that sum to given input
    void findConsecutiveSum() {
        int n;
        cout << "\n Find Consecutive Number Sequences " << endl;
        cout << "Enter target sum: ";
        cin >> n;
        cout << "Consecutive sequences that sum to " << n << ":" << endl;
        
        for (int start = 1; start <= n / 2; start++) {
            int sum = 0;
            int i = start;
            while (sum < n) {
                sum += i;
                i++;
            }
            if (sum == n) {
                for (int j = start; j < i; j++) {
                    cout << j << " ";
                }
                cout << endl;
            }
        }
    }

    // 4. Shift string characters by ASCII value
    void shiftByASCII() {
        string s;
        int n;
        cout << "\n Shift String by ASCII Value" << endl;
        cout << "Enter the string: ";
        cin >> s;
        cout << "Enter the shift value: ";
        cin >> n;
        
        string res = "";
        for (int i = 0; i < s.length(); i++) {
            char shifted = s[i] + n;
            res += shifted;
        }
        
        cout << "Result after ASCII shift: " << res << endl;
    }

    // 5. Shift string by series
    void shiftBySeries() {
        string str;
        int x;
        cout << "Shift String by Series :" << endl;
        cout << "Enter the string: ";
        cin >> str;
        cout << "Enter the shift value: ";
        cin >> x;
        
        string res = "";
        for (int i = 0; i < str.length(); i++) {
            res += char(str[i] + x);
        }
        
        cout << "Shifted string: " << res << endl;
    }

// Displaying  menu
    void displayMenu() {
        cout << "1. Generate Valid Parentheses" << endl;
        cout << "2. Add Digits of a Number" << endl;
        cout << "3. Find Consecutive Sum Sequences" << endl;
        cout << "4. Shift String by ASCII Value" << endl;
        cout << "5. Shift String by Series" << endl;
        cout << "0. Exit" << endl;
        cout << "Enter your choice: ";
    }
    void run() {
        int choice;
        do {
            displayMenu();
            cin >> choice;
            
            switch (choice) {
                case 1:
                    generateParentheses();
                    break;
                case 2:
                    addDigits();
                    break;
                case 3:
                    findConsecutiveSum();
                    break;
                case 4:
                    shiftByASCII();
                    break;
                case 5:
                    shiftBySeries();
                    break;
                case 0:
                    cout << "\nExiting program. Goodbye!" << endl;
                    break;
                default:
                    cout << "\nInvalid choice! Please try again." << endl;
            }
            
            if (choice != 0) {
                cout << "\nPress Enter to continue...";
                cin.ignore();
                cin.get();
            }
            
        } while (choice != 0);
    }
};

int main() {
    Operations ops;
    ops.run();
    return 0;
}
