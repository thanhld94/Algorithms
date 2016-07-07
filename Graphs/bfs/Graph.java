import java.util.LinkedList;
import java.util.Iterator;

public class Graph {
    private int numberOfVertices;
    private LinkedList[] adj;

    public Graph(int n) {
        numberOfVertices = n;
        adj = new LinkedList[n];
        for (int i = 0; i < numberOfVertices; i++) {
            adj[i] = new LinkedList <Integer>();
        }
    }


    public void addEdge(int u, int v) {
    	adj[u].add(v);
    }

    public int bfs(int s, int f) {
    	LinkedList <Integer> queue= new LinkedList <Integer>();
    	int[] distance = new int[numberOfVertices];
    	boolean[] visited = new boolean[numberOfVertices];
    	visited[s] = true;
    	queue.add(s);
    	while (queue.size() != 0) {
    		int u = queue.poll();
    		Iterator <Integer> i = adj[u].listIterator();
    		while (i.hasNext()) {
    			int v = i.next();
    			if (!visited[v]) {
    				distance[v] = distance[u] + 1;
    				if (v == f) {
    					return distance[v];
    				}
    				visited[v] = true;
    				queue.add(v);
    			}
    		}
    	}
    	return -1;
    }

    public void printGraph() {
    	for (int i = 0; i < numberOfVertices; i++) {
    		System.out.print(i + ": ");
    		Iterator<Integer> it = adj[i].listIterator();
    		while (it.hasNext()) {
    			System.out.print(it.next() + ", ");
    		}
    		System.out.println();
    	}
    }

    public static void main(String[] args) {
    	Graph myGraph = new Graph(11);
    	myGraph.addEdge(0,3);
    	myGraph.addEdge(0,2);
    	myGraph.addEdge(0,5);
    	myGraph.addEdge(5,2);
    	myGraph.addEdge(5,8);
    	myGraph.addEdge(8,2);
    	myGraph.addEdge(8,9);
    	myGraph.addEdge(3,4);
    	myGraph.addEdge(3,6);
    	myGraph.addEdge(7,1);
    	myGraph.addEdge(10,1);
    	myGraph.printGraph();
    	System.out.println(myGraph.bfs(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}
