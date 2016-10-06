#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cmath>
#include <algorithm>
#include <cstring>
#include <queue>

using namespace std;

int s;
int t;
int total;
int f[38][38];
int c[38][38];
int trace[38];

bool findpath() {
  queue<int> q;
  while (!q.empty()) q.pop();
  for (int i = 0; i < 38; i++) trace[i] = -1; 
  q.push(s);
  trace[s] = 38;
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    if (u == t) {
      return true;
    }
    for (int v = 0; v < 38; v++) {
      if (c[u][v] > f[u][v] && trace[v] == -1) {
        //cout << u << " -> " << v << endl;
        trace[v] = u;
        q.push(v);
      }
    }
  }
  return false;
}

void incflow() {
  int delta = 1000111000;
  int v = t;
  while (v != s) {
    int u = trace[v];
    delta = min(delta, c[u][v] - f[u][v]);
    v = u;
  }
  v = t;
  while (v != s) {
    int u = trace[v];
    f[u][v] += delta;
    f[v][u] -= delta;
    v = u;
  }
}

void process() {
  while (findpath()) {
    incflow();
  }
  int maxflow = 0;
  for (int comp = 27; comp < 37; comp++) {
    if (f[comp][t] > 0) {
      maxflow += f[comp][t];
    }
  }
  
  if (maxflow != total) {
    cout << "!" << endl;
    return;
  }
  
  string result = "";
  for (int comp = 27; comp < 37; comp++) {
    char letter = '_';
    for (int app = 1; app <= 26; app++) {
      if (f[app][comp] > 0) {
        letter = (char)(app + 'A' - 1);
        break;
      }
    }
    result += letter;
  }
  cout << result << endl;
}

int main() {
  s = 0;
  t = 37;
  string line;
  while (getline(cin,line)) {
    total = 0;
    memset(f, 0, sizeof f);
    memset(c, 0, sizeof c);

    while (!line.empty()) {
      int app = line[0] - 'A' + 1;
      int w = line[1] - '0';
      c[s][app] = w;
      total += w;

      for (int i = 3; i < line.size(); i++) {
        if (line[i] == ';') break;
        int comp = line[i] - '0' + 27;
        //cout << "edge: " << app << " -> " << comp << endl;
        c[app][comp] = 1;
      }
      getline(cin, line);
    }
    for (int comp = 27; comp < 37; comp++) {
      c[comp][t] = 1;
    }
    process();
  }
}
