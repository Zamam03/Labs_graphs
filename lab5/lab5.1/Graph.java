import java.util.ArrayList;

public class Graph {

    ArrayList<Vertex> vertices = new ArrayList<Vertex>();

    public Graph() {
        // Default constructor is empty for this case
    }

    public void addVertex() {
        vertices.add(new Vertex(vertices.size()));
    }

    public Vertex getVertex(int vertexNumber) {
        return vertices.get(vertexNumber);
    }

    public void addEdge(Vertex vertexOne, Vertex vertexTwo) {
        vertexOne.addAdjacency(vertexTwo);
        vertexTwo.addAdjacency(vertexOne);
    }

    public int getBiggestVertex() {
        int maxDegree = -1;
        int vertexToColour = -1;

        for (Vertex vertex : vertices) {
            if (vertex.colour == -1 && vertex.getDegree() > maxDegree) {
                maxDegree = vertex.getDegree();
                vertexToColour = vertex.vertexNumber;
            } else if (vertex.colour == -1 && vertex.getDegree() == maxDegree) {
                // If degrees are tied, choose the vertex with the smaller vertex number
                if (vertex.vertexNumber < vertexToColour) {
                    vertexToColour = vertex.vertexNumber;
                }
            }
        }

        return vertexToColour;
    }

    // DFS method to build the DFS tree
    public void dfs(Vertex x) {
        x.isInTree = true; // Mark the vertex as in the tree
        for (Vertex neighbor : x.adjacencies) {
            if (!neighbor.isInTree) {
                neighbor.parent = x.vertexNumber; // Set the parent of the neighbor
                dfs(neighbor); // Recursively perform DFS
            }
        }
    }
}

