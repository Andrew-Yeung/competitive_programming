#include <bits/stdc++.h>
using namespace std;
#define pl "\n";
#define aa ios::sync_with_stdio(0); cin.tie(0);

const int MM = 3002;
string s,t,ans; int n,m;
int dp [MM][MM];
int main(){
    aa
    cin >> s >> t;
    n=s.size();
    m = t.size();
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            dp[i][j]=max(dp[i-1][j], dp[i][j-1]);
            if(s[i-1]==t[j-1]){
                dp[i][j] = max(dp[i][j], dp[i-1][j-1]+1);
            }
        }
    }
    for(int i=n,j=m;i>0 && j>0;){
        if(dp[i][j]==dp[i-1][j])i--;
        else if(dp[i][j]==dp[i][j-1])j--;
        else{
           ans.push_back(s[i-1]);
           i--;j--;
        }
    }
    reverse(ans.begin(), ans.end());
    cout << ans << pl;
}
