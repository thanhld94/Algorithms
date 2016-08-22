import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class TaskB{
  public static void main(String[] args) {
    TaskB tB = new TaskB();
    PrintWriter pw = new PrintWriter(System.out);
    tB.solve(new Scanner(System.in), pw);
    pw.close();
  }

  public void solve(Scanner input, PrintWriter output) {
  	int n = input.nextInt();
  	int m = input.nextInt();
  	int k = input.nextInt();
  	List<List<Edge>> adj = new ArrayList<List<Edge>>();
  	for (int i = 0; i < n; i++) {
  		adj.add(new ArrayList<Edge>());
  	}
  	for (int i = 0; i < m; i++) {
  		int u = input.nextInt() - 1;
  		int v = input.nextInt() - 1;
  		int l = input.nextInt();
  		adj.get(u).add(new Edge(v,l));
  		adj.get(v).add(new Edge(u,l));
  	}
  	if (k == 0) {
  		output.println(-1);
  		return;
  	}

  	boolean[] storages = new boolean[n];
  	for (int i = 0; i < k; i++) {
  		int s = input.nextInt() - 1;
  		storages[s] = true;
  	}
  	output.println(fbm(n, storages, adj));
  }

  private int fbm(int n, boolean[] storages, List<List<Edge>> adj) {
  	Queue <Integer> queue = new LinkedList <Integer>();
  	boolean[] inQueue = new boolean[n];
  	int[] distance = new int[n];
  	for (int i = 0; i < n; i++) {
  		distance[i] = Integer.MAX_VALUE;
  	}

  	for (int i = 0; i < n; i++) {
  		if (!storages[i]) {
  			inQueue[i] = true;	
  			queue.add(i);
  			distance[i] = 0;
  			// System.out.println(i);
  		}
  	}

  	while (queue.size() != 0) {
  		int u = queue.poll();
  		inQueue[u] = false;
  		for (Edge e : adj.get(u)) {
  			int v = e.dest;
  			int l = e.length;
  			// System.out.println(u + " " + v + " " + l);
  			if (distance[v] > distance[u] + l) {
  				// System.out.println(u + " " + v + " " + distance[u] + " " + distance[v] + " " + l);
  				distance[v] = distance[u] + l;
  				if (!inQueue[v]) {
  					inQueue[v] = true;
  					queue.add(v);
  				}
  			}
  		}
  	}

  	int result = Integer.MAX_VALUE;
  	for (int i = 0; i < n; i++) {
  		if (storages[i]) {
  			result = Math.min(result, distance[i]);
  		}
  	}
  	if (result < Integer.MAX_VALUE) {
  		return result;
  	} else {
  		return -1;
  	}
  }

  private class Edge {
  	int dest;
  	int length;

  	private Edge(int dest, int length) {
  		this.dest = dest;
  		this.length = length;
  	}
  }
}
