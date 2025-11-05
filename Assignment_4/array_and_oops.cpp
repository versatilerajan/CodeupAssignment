/* Assignment title -> Code practice
   Task related to - Array and Oops
   Class owner -  Rajan
   Date - 05/11/2025
*/
#include <iostream>
#include <vector>
#include <cmath>
#include <iomanip>
using namespace std;
class ArrayOperations{
private:
    vector<int>arr;
    int n;
// function to input array
    void inputArray(){
        cout<<"Enter the number of elements: ";
        cin>>n;
        arr.clear();
        arr.resize(n);
        cout<<"Enter "<<n<<" elements: ";
        for (int i=0;i<n;i++) {
            cin>>arr[i];
        }
    }
public:
    void energyConsumption() {
        inputArray();
        int initialEnergy;
        cout<<"Enter initial energy: ";
        cin>>initialEnergy;
        int index = -1;
        for (int i=0;i<n;i++) {
            if (initialEnergy<arr[i]) {
                index=i-1;
                break;
            } else {
                initialEnergy-=arr[i];
                index=i;
            }
        }
        cout<<"Last reachable index: "<<index<<endl;
        cout<<"Remaining energy: "<<initialEnergy<<endl;
    }
    void prefixSuffixSum() {
        inputArray();
        int index=-1;
        for (int i=0;i<n;i++) {
            int prefix=0, suffix=0;
            for (int j=0;j<i; j++) {
                prefix += arr[j];
            }
            for(int j=i+1;j<n;j++) {
                suffix+=arr[j];
            }
            if(prefix==suffix) {
                index=i;
                break;
            }
        }
        if (index!=-1)
            cout<<"Index where prefix equals suffix: "<<index<<endl;
        else
            cout<<"No such index found."<<endl;
    }
    void switchFlips() {
        inputArray();
        int zero=0, one=0;
        for (int i=0;i<n; i++) {
            if (arr[i]==0) zero++;
            else if (arr[i]==1) one++;
        }
        int flips = (one>zero) ? zero:one;
        cout << "Number of switch flips needed: " <<flips<<endl;
        cout << "Final state will be all "<< (one > zero ? "1s":"0s")<< endl;
    }
    void findUniqueElement() {
        inputArray();
        bool found = false;
        cout << "Elements that appear only once: ";
        for (int i=0;i<n;i++) {
            int count=0;
            for (int j=0; j<n; j++) {
                if (arr[i]==arr[j]) {
                    count++;
                }
            }
            if (count==1) {
                cout<<arr[i]<<" ";
                found=true;
            }
        }
        cout<<endl;
        if(!found) {
            cout<<"No unique element found in the array."<<endl;
        }
    }
    void pairFinding(){
        inputArray();
        int k;
        cout<<"Enter target sum: ";
        cin>>k;
        bool found=false;
        cout<<"Pairs found with sum "<<k<<": ";
        for (int i=0; i<n-1; i++) {
            for (int j=i+1;j<n;j++) {
                if (arr[i] + arr[j]==k) {
                    cout<<"("<<arr[i]<<", "<<arr[j]<<") ";
                    found=true;
                }
            }
        }
        cout<<endl;
        if(!found) {
            cout<<"No pair found with sum "<<k<<endl;
        }
    }
    
    void maximumWalls() {
        inputArray();
        int maxWalls=1,currWalls=1,endIndex=0;
        for (int i=1;i<n;i++) {
            if(arr[i]<arr[i-1]) {
                currWalls++;
            } else {
                currWalls = 1;
            }
            if (currWalls>maxWalls) {
                maxWalls=currWalls;
                endIndex=i;
            }
        }
        int startIndex = endIndex-maxWalls+1;
        int totalTime=0;
        cout<<"Maximum consecutive decreasing walls: "<<maxWalls<<endl;
        cout<<"Wall sequence: ";
        for (int i = startIndex; i<=endIndex; i++) {
            cout << arr[i] << " ";
            totalTime += arr[i];
        }
        cout<<endl;
        cout<<"Total time to paint those walls: "<<totalTime<<endl;
    }
};
class Point {
private:
    float x,y; 
public:
    Point(float x_val=0, float y_val=0) {
        x=x_val;
        y=y_val;
    }
    float distance(Point other) {
        float dx=x-other.x;
        float dy=y- other.y;
        return sqrt(dx*dx+dy*dy);
    }
    void translate(float dx, float dy) {
        x=x+dx;
        y=y+dy;
    }
    void display() {
        cout<<"("<<x<<", "<<y<<")"<<endl;
    }
};
class Shape {
public:
    virtual float getArea() {
        return 0;
    }
    virtual ~Shape(){} 
};
class Circle:public Shape {
private:
    float radius;
public:
    Circle(float r) {
        radius=r;
    }
    float getArea() override {
        return 3.14159*radius*radius;
    }
};
class Square : public Shape {
private:
    float side;
public:
    Square(float s) {
        side=s;
    }
    float getArea() override {
        return side*side;
    }
};
class GeometryOperations {
public:
    void performOperations() {
        float x1,y1,x2,y2,radius,side,dx,dy;
        cout << "Enter coordinates of Point 1 (x y): ";
        cin>>x1>>y1;
        cout<<"Enter coordinates of Point 2 (x y): ";
        cin>>x2>>y2;
        cout<<"Enter radius of the circle: ";
        cin>>radius;
        cout<<"Enter side length of the square: ";
        cin>>side;
        cout<<"Enter translation values (dx dy) for Point 1: ";
        cin>>dx>>dy;

        Point p1(x1, y1);
        Point p2(x2, y2);
        Circle c(radius);
        Square sq(side);
        
        cout << fixed << setprecision(2);
        cout << "Distance between points: "<< p1.distance(p2) << endl;
        cout << "Circle Area: " << c.getArea() << endl;
        cout << "Square Area: " << sq.getArea() << endl;
        p1.translate(dx, dy);
        cout << "Translated Point 1: ";
        p1.display();
    }
};

int main() {
    ArrayOperations arrayOps;
    GeometryOperations geoOps;
    int choice;
    do {
        cout << "1. Energy Consumption"<<endl;
        cout << "2. Prefix Sum equals Suffix Sum"<<endl;
        cout << "3. Switch Flips" << endl;
        cout << "4. Find Unique Elements"<<endl;
        cout << "5. Pair Finding"<<endl;
        cout << "6. Maximum Consecutive Walls"<<endl;
        cout << "7. Geometry Operations"<<endl;
        cout << "0. Exit"<<endl;
        cout << "Enter your choice: ";
        cin >> choice;
        cout << endl;
        switch (choice) {
            case 1:
                arrayOps.energyConsumption();
                break;
            case 2:
                arrayOps.prefixSuffixSum();
                break;
            case 3:
                arrayOps.switchFlips();
                break;
            case 4:
                arrayOps.findUniqueElement();
                break;
            case 5:
                arrayOps.pairFinding();
                break;
            case 6:
                arrayOps.maximumWalls();
                break;
            case 7:
                geoOps.performOperations();
                break;
            case 0:
                cout << "Thanks Mentors for using my program ..Goodbye!" << endl;
                break;
            default:
                cout << "Invalid choice! Please try again." << endl;
        }
    } while (choice != 0);
    return 0;
}
