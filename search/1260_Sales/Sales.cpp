#include<iostream>
#include<cstdio>

using namespace std;

int n;
int a[1111];

int main() {
  int test;
  scanf("%d", &test);
  while (test--) {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
      scanf("%d", &a[i]);
    }

    int result = 0;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (a[i] >= a[j]) {
          result++;
        }
      }
    }
    printf("%d\n", result);
  }
}
