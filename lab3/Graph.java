import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    private ArrayList<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<>();
        readGraph();
    }

    private void readGraph() {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfVertices = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < numberOfVertices; i++) {
            addVertex();
        }
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("-1")) {
                break;
            }
            
            String[] edge = line.split(",");
            int vertexNumber1 = Integer.parseInt(edge[0]);
            int vertexNumber2 = Integer.parseInt(edge[1]);

            addEdge(vertexNumber1, vertexNumber2);
        }
    
        for (Vertex vertex : vertices) {
            System.out.println(vertex.getVertexNumber() + ":" + vertex.getDegree());
        }
    }

    public void addVertex() {
        Vertex newVertex = new Vertex(vertices.size());
        vertices.add(newVertex);
    }

    public Vertex getVertex(int vertexNumber) {
        return vertices.get(vertexNumber);
    }

    public void addEdge(int vertexNumber1, int vertexNumber2) {
        Vertex v1 = getVertex(vertexNumber1);
        Vertex v2 = getVertex(vertexNumber2);

        v1.addAdjacency(v2);
        v2.addAdjacency(v1);
    }
}

