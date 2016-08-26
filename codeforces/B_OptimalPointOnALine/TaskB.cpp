#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>

using namespace std;

int main() {
  int n;
  int x[300111];
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i];
  }
  sort(x, x+n);
  int med = n / 2;
  if (n % 2 == 0) {
    med--;
  }
  cout << x[med] << endl;
  return 0;
}
