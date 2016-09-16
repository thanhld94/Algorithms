#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

int s, c;
int w[15];
double avg;
double imbalance;

int main() {
  int test = 1;
  while (cin >> c) {
    cin >> s;
    avg = imbalance = 0.0;
    for (int i = 0; i < s; i++) {
      cin >> w[i];
      avg += w[i];
    }
    avg /= c;
    sort(w, w + s);
    
    int singles = 2 * c - s;
    vector <int> chambers[15];
    int last = s - 1;
    for (int i = 0; i < singles; i++) {
      imbalance += abs(avg - w[last]);
      chambers[i].push_back(w[last--]);
    }

    int first = 0;
    for (int i = singles; i < c; i++) {
      imbalance += abs(avg - w[last] - w[first]);
      chambers[i].push_back(w[first++]);
      chambers[i].push_back(w[last--]);
    }

    printf("Set %d\n", test++);
    for (int i = 0; i < c; i++) {
      printf(" %d: ", (i+1));
      for (int j = 0; j < chambers[i].size(); j++) {
        printf("%d ", chambers[i][j]);
      }
      printf("\n");
    }
    printf("IMBALANCE = %0.5f\n\n", imbalance);
  }
}
