#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <stack>
#include <cmath>
#include <string>
#include <cstring>

using namespace std;

int n, q;
int a[100111];
int diff[100111];
int countL[100111], countR[100111];

void getCountLeft(int left, int right) {
  memset(countL, 0, sizeof countL);
  stack<pair<int, int> > s;
  for (int idx = left; idx <= right; idx++) {
    countL[idx] = 1;
    if (!s.empty()) {
      while (!s.empty() && s.top().second <= diff[idx]) {
        pair<int, int> top = s.top();
        s.pop();
        countL[idx] += countL[top.first];
      }
    }
    s.push(make_pair(idx, diff[idx]));
  }
}

void getCountRight(int left, int right) {
  memset(countR, 0, sizeof countR);
  stack<pair<int, int> > s;
  for (int idx = right; idx >= left; idx--) {
    countR[idx] = 1;
    if (!s.empty()) {
      while (!s.empty() && s.top().second < diff[idx]) {
        pair<int, int> top = s.top();
        s.pop();
        countR[idx] += countR[top.first];
      }
    }
    s.push(make_pair(idx, diff[idx]));
  }
}

int main() {
  scanf("%d %d", &n, &q);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }

  for (int i = 0; i < n - 1; i++) {
    diff[i] = abs(a[i] - a[i + 1]);
  }

  for (int query = 0; query < q; query++) {
    int left, right;
    scanf("%d %d", &left, &right);
    left--;
    right -= 2;
    if (left > right) {
      printf("0\n");
      continue;
    }
    getCountLeft(left, right);
    getCountRight(left, right);
    long long result = 0LL;
    for (int idx = left; idx <= right; idx++) {
      result += (1LL) * diff[idx] * countL[idx] * countR[idx];
    }
    cout << result << "\n";
  }
}
