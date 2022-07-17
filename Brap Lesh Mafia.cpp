#include <iostream>
using namespace std;
#define ok "\n"
int n, k;
long long sum;
int main(){
    cin >> n >> k;
    for(int i = 0; i < n; i++){
        long long a, b;
        cin >> a >> b;
        sum += (a * b) % k;
    }
    cout << sum % k << ok;
}
