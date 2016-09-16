#include <iostream>
#include <cmath>
#include <set>

using namespace std;

#define MAX 1000111000

int a[1111];
set<int> values;
int n;

void solve() {
  values.clear();
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i != j) {
        values.insert(a[i] + a[j]);
      }
    }
  }

  int q;
  scanf("%d", &q);
  for (int i = 1; i <= q; i++) {
    int query;
    scanf("%d", &query);
    set<int>::iterator lb = values.lower_bound(query);
    set<int>::iterator ub = (lb == values.begin()) ? values.end() : prev(lb);
    //if (lb != values.end()) cout << " lower = " << *lb << endl;
    //if (ub != values.end()) cout << " upper = " << *ub << endl;
    
    int result;
    if (lb == values.end()) {
      result = *ub;
    } else {
      result = *lb;
      if (ub != values.end() && abs(*ub - query) < abs(*lb - query)) {
        result = *ub;
      }
    }
    printf("Closest sum to %d is %d.\n", query, result);
  }
}

int main() {
  int test = 0;
  scanf("%d", &n);
  while (n != 0) {
    printf("Case %d:\n", ++test);
    solve();
    scanf("%d", &n);
  }
  return 0;
}
