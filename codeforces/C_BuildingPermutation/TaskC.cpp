#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>

using namespace std;

int main() {
  int n;
  cin >> n;
  int a[300111];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  long long result;
  for (int i = 0; i < n; i++) {
    result = result + abs(a[i] - i - 1);
  }
  cout << result << endl;
  return 0;
}
