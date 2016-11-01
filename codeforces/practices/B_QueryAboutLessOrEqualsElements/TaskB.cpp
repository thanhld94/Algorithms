#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>

using namespace std;

int main() {
  int n;
  int m;
  int a[200000];
  int b[200000];
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (int i = 0; i < m; i++) {
    scanf("%d", &b[i]); 
  }
  sort(a + 0, a + n);
  for (int i = 0; i < m; i++) {
    if (b[i] >= a[n - 1]) {
      printf("%d ", n);
      continue;
    }
    int l = 0; 
    int r = n - 1;
    int result = 0;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (a[mid] > b[i]) {
        result = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    printf("%d ", result);
  }
  printf("\n"); 
  return 0;
}
