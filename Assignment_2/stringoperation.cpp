#include<iostream>
#include<string>
using namespace std;
class StringOperations{
    string str;
public:
    StringOperations(string s){str=s;}
// All method start from here
    void append(){
        string x;
        cout<<"Enter text to append: ";
        getline(cin,x);
        str=str+x;
        cout<<"Result: "<<str<<endl;
    }

    void countWords(){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str[i]==' ') count++;
        }
        cout<<"Word count: "<<count+1<<endl;
    }

    void replaceWord(){
        string oldStr,newStr;
        cout<<"Enter string to replace: ";
        getline(cin,oldStr);
        cout<<"Enter replacement string: ";
        getline(cin,newStr);
        int pos=str.find(oldStr);
        if(pos!=string::npos){
            str=str.substr(0,pos)+newStr+str.substr(pos+oldStr.length());
        }
        cout<<"Result: "<<str<<endl;
    }

    void isPalindrome(){
        string temp=str;
        for(int i=0;i<temp.length();i++){
            if(temp[i]>='A'&&temp[i]<='Z') temp[i]+=32;
        }
        string rev="";
        for(int i=temp.length()-1;i>=0;i--) rev+=temp[i];
        if(temp==rev) cout<<str<<" is palindrome"<<endl;
        else cout<<str<<" is not palindrome"<<endl;
    }

    void splice(){
        int start,len;
        cout<<"Enter start position: ";
        cin>>start;
        cout<<"Enter length: ";
        cin>>len;
        if(start>=0&&start<str.length()){
            cout<<"Spliced: "<<str.substr(start,len)<<endl;
        }else cout<<"Invalid"<<endl;
        cin.ignore(); // clear buffer
    }

    void split(){
        char d;
        cout<<"Enter delimiter: ";
        cin>>d;
        string temp="";
        int part=1;
        for(int i=0;i<str.length();i++){
            if(str[i]==d){
                cout<<part++<<": "<<temp<<endl;
                temp="";
            }else temp+=str[i];
        }
        cout<<part<<": "<<temp<<endl;
        cin.ignore();
    }

    void maxRepeating(){
        int freq[256]={0};
        for(int i=0;i<str.length();i++) freq[(unsigned char)str[i]]++;
        int maxC=0;
        char ch=' ';
        for(int i=0;i<256;i++){
            if(freq[i]>maxC){maxC=freq[i];ch=(char)i;}
        }
        cout<<"Most repeating: "<<ch<<" ("<<maxC<<" times)"<<endl;
    }

    void sortString(){
        string s=str;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(s[i]>s[j]){
                    char t=s[i];
                    s[i]=s[j];
                    s[j]=t;
                }
            }
        }
        cout<<"Sorted: "<<s<<endl;
    }

    void shift(){
        int k;
        cout<<"Enter shift: ";
        cin>>k;
        int n=str.length();
        k=k%n;
        if(k<0) k+=n;
        string shifted=str.substr(n-k)+str.substr(0,n-k);
        cout<<"Shifted: "<<shifted<<endl;
        cin.ignore();
    }

    void reverseString(){
        string rev="";
        for(int i=str.length()-1;i>=0;i--) rev+=str[i];
        cout<<"Reversed: "<<rev<<endl;
    }

    void menu(){
        cout<<"\n 1.Append\n 2.Count Words\n 3.Replace\n 4.Palindrome\n 5.Splice\n 6.Split\n 7.Max Repeating\n 8.Sort\n 9.Shift\n 10.Reverse\n 0.Exit\n";
    }

    void run(){
        int ch;
        do{
            menu();
            cin>>ch;
            cin.ignore(); 
            switch(ch){
                case 1: append(); break;
                case 2: countWords(); break;
                case 3: replaceWord(); break;
                case 4: isPalindrome(); break;
                case 5: splice(); break;
                case 6: split(); break;
                case 7: maxRepeating(); break;
                case 8: sortString(); break;
                case 9: shift(); break;
                case 10: reverseString(); break;
                case 0: cout<<"Exit"<<endl; break;
                default: cout<<"Invalid"<<endl;
            }
        }while(ch!=0);
    }
};

int main(){
    string s;
    cout<<"Enter string: ";
    getline(cin,s);
    StringOperations obj(s);
    obj.run();
    return 0;
}
