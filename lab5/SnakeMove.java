import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vertex {
    int id;           // Vertex number
    int parent;       // Parent vertex number
    boolean isInTree; // Tracks if the vertex is part of the DFS tree

    public Vertex(int id) {
        this.id = id;
        this.parent = -1; // Initially, parent is -1
        this.isInTree = false; // Initially, not in the tree
    }
}

class Graph {
    private List<Vertex> vertices; // List of vertices
    private List<List<Integer>> adjList; // Adjacency list

    public Graph(int n) {
        vertices = new ArrayList<>();
        adjList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            vertices.add(new Vertex(i));
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge between two vertices
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Assuming an undirected graph
    }

    // Depth-first search (DFS)
    public void dfs(Vertex x) {
        x.isInTree = true; // Mark the vertex as being in the DFS tree
        
        // Explore all adjacent vertices
        for (int neighbor : adjList.get(x.id)) {
            Vertex d = getVertex(neighbor);
            if (!d.isInTree) {
                d.parent = x.id; // Set the parent
                dfs(d);          // Recursive DFS call
            }
        }
    }

    // Print the DFS tree (parent-child relationship)
    public void printDFSTree() {
        for (Vertex v : vertices) {
            if (v.id != 0) { // Skip vertex 0 (it has no parent)
                System.out.println(v.id + ":" + v.parent);
            }
        }
    }

    // Getter for vertices list
    public Vertex getVertex(int id) {
        return vertices.get(id);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of vertices
        int n = Integer.parseInt(scanner.nextLine().trim());
        Graph graph = new Graph(n);

        // Read edges until -1
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("-1")) break;
            
            String[] edge = input.split(",");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph.addEdge(u, v);
        }

        // Perform DFS starting from vertex 0
        graph.dfs(graph.getVertex(0));

        // Print the DFS tree (parent-child relationships)
        graph.printDFSTree();
    }
}

