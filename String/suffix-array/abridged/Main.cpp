#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>

using namespace std;

int p[100111][17];
struct Entry {
  int first;
  int second;
  int idx;
} l[100111];
int n;

bool cmp(const Entry& a, const Entry& b) {
  if (a.first == b.first) {
    return a.second < b.second;
  }
  return a.first < b.first;
}

void solve(string s) {
  n = s.length();
  for (int i = 0; i < n; i++) {
    p[i][0] = (int) s[i];
  }

  int step = 1;
  for (int jump = 1; jump * 2 < n; step++, jump *= 2) {
    for (int i = 0; i < n; i++) {
      l[i].first = p[i][step - 1];
      l[i].second = (i + jump < n) ? p[i + jump][step - 1] : p[i + jump - n][step - 1];
      l[i].idx = i;
    }

    sort(l, l + n, cmp);
    for (int i = 0; i < n; i++) {
      p[l[i].idx][step] = (i > 0 && l[i].first == l[i - 1].first && l[i].second == l[i - 1].second) ? 
        p[l[i - 1].idx][step] : i;
    }
  }

  int result = 0;
  for (int i = 1; i < n; i++) {
    if (p[i][step - 1] < p[result][step - 1]) {
      result = i;
    }
  }
  cout << result << endl;
}

int main() {
  int test;
  cin >> test;
  for (int t = 0; t < test; t++) {
    string s;
    int n;
    cin >> n >> s;
    solve(s);
  }
}
