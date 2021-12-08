#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    string a;
    cin >> n >> a;
    int count = 0;
    for(int i=0;i<a.length();i++){
        if(a[i]=='I'&&a[i+1]=='U'&&i+2<=a.length())count++;
    }
    cout << n-count << "\n";
}
