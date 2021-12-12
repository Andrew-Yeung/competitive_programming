#include <bits/stdc++.h>
using namespace std;
const int MM = 100005;
int parent[MM];
int find(int x){
    if(x != parent[x])parent[x]=find(parent[x]);
    return parent[x];
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n; string a;
    cin >> n >> a;
    char c[a.length()];
    for(int i=0;i<a.length();i++){
        c[i]=a[i];
    }
    long long  y=0; long long prev=0;
    for(int i=0;i<a.length();i++){
        if(c[i]=='I'){
            y+=abs(i-prev);
            prev++; prev++;
        }
    }
    cout << y << "\n";
}
