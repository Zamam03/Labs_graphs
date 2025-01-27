import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vertex {
    int id;           
    int parent;      
    boolean isInTree; 

    public Vertex(int id) {
        this.id = id;
        this.parent = -1; 
        this.isInTree = false; 
    }
}

class Graph {
    private List<Vertex> vertices; 
    private List<List<Integer>> adjList; 

    public Graph(int n) {
        vertices = new ArrayList<>();
        adjList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            vertices.add(new Vertex(i));
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); 
    }

    public void dfs(Vertex x) {
        x.isInTree = true; 
        
        for (int neighbor : adjList.get(x.id)) {
            Vertex d = getVertex(neighbor);
            if (!d.isInTree) {
                d.parent = x.id;
                dfs(d);          
            }
        }
    }

    public void printDFSTree() {
        for (Vertex v : vertices) {
            if (v.id != 0) { 
                System.out.println(v.id + ":" + v.parent);
            }
        }
    }

    public Vertex getVertex(int id) {
        return vertices.get(id);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine().trim());
        Graph graph = new Graph(n);

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("-1")) break;
            
            String[] edge = input.split(",");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph.addEdge(u, v);
        }

        graph.dfs(graph.getVertex(0));

        graph.printDFSTree();
    }
}

