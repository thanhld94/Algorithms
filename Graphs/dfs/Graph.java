import java.util.LinkedList;
import java.util.Iterator;

public class Graph {
	int numberOfNodes;
	LinkedList[] adj;
	boolean[] visited;

	public Graph(int nNodes) {
		numberOfNodes = nNodes;
		adj = new LinkedList[numberOfNodes];
		for (int i = 0; i < numberOfNodes; i++)
			adj[i] = new LinkedList <Integer>();
		visited = new boolean[numberOfNodes];
	}

	public void addEdge(int u,int v) {
		adj[u].add(v);
	}

	public boolean dfs(int node, int finish) {
		if (node == finish) {
			return true;
		}
		visited[node] = true;
		Iterator <Integer> it = adj[node].listIterator();
		while (it.hasNext()) {
			int adjNode = it.next();
			if (!visited[adjNode]) {
				if (dfs(adjNode, finish)) 
					return true;
			}
		}
		return false;
	}

	public void printGraph() {
    	for (int i = 0; i < numberOfNodes; i++) {
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
    	//myGraph.printGraph();
    	System.out.println(myGraph.dfs(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}