import java.util.LinkedList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Graph {
    private int numberOfVertices;
    private LinkedList[] adj;
    private GraphNode[] nodes;

    public static void main(String[] args) {
        Graph myGraph = new Graph(10);
        myGraph.addEdge(0,3,5);
        myGraph.addEdge(0,2,8);
        myGraph.addEdge(0,5,3);
        myGraph.addEdge(5,2,2);
        myGraph.addEdge(5,8,8);
        myGraph.addEdge(2,8,1);
        myGraph.addEdge(8,2,2);
        myGraph.addEdge(8,9,3);
        myGraph.addEdge(3,4,1);
        myGraph.addEdge(3,6,2);
        myGraph.addEdge(6,1,3);
        myGraph.addEdge(2,7,9);
        myGraph.printGraph();
        System.out.println(myGraph.dijkstra(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
    }

    public Graph(int v) {
        numberOfVertices = v;
        adj = new LinkedList[v];
        nodes = new GraphNode[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList <GraphEdge>();
            nodes[i] = new GraphNode(i);
        }
    }

    public void addEdge(int u, int v, int d) {
        adj[u].add(new GraphEdge(v,d));
    }

    public int dijkstra(int s, int f) {
        PriorityQueue <GraphNode> heap = new PriorityQueue <GraphNode>();
        for(int i = 0; i < numberOfVertices; i++) {
            nodes[i].dist = (1 << 31) - 1;
        }
        nodes[s].dist = 0;
        heap.add(nodes[s]);
        while (heap.size() != 0) {
            GraphNode u = heap.poll();
            //System.out.println("At u:" + u.node);
            if (u.node == f) return u.dist;
            Iterator <GraphEdge> it = adj[u.node].listIterator();
            while (it.hasNext()) {
                GraphEdge edge = it.next();
                GraphNode v = nodes[edge.node];
                int weight = edge.cost;
                //System.out.println("check child " + v.node + " distv = " + v.dist + " distu = " + u.dist + " weight = " + weight);
                if (v.dist > u.dist + weight) {
                    v.dist = u.dist + weight;
                    //System.out.println("Updated " + v.node + " dist = " + v.dist);
                    heap.add(v);
                }
            }
        }
        return -1;
    }

    public void printGraph() {
        for (int i = 0; i < numberOfVertices; i++) {
            Iterator<GraphEdge> it = adj[i].listIterator();
            while (it.hasNext()) {
                GraphEdge e = it.next();
                System.out.println(i + " -> " + e.node + " : " + e.cost);
            }
        }
    }

    private class GraphEdge {
        int cost;
        int node;
        public GraphEdge(int v, int d) {
            node = v;
            cost = d;
        }
    }

    private class GraphNode implements Comparable<GraphNode> {
        int dist;
        int node;

        public GraphNode(int node) {
            this.node = node;
            dist = 0;
        }

        public int compareTo(GraphNode other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
}
