import java.util.LinkedList;

public class Vertex {
    private int vertexNumber;
    private int colour;
    private LinkedList<Vertex> adjacencies;

    public Vertex(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        this.colour = 0;  
        this.adjacencies = new LinkedList<>();
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public void addAdjacency(Vertex vertex) {
        if (!adjacencies.contains(vertex)) {
            adjacencies.add(vertex);
        }
    }

    public boolean isAdjacent(Vertex vertex) {
        return adjacencies.contains(vertex);
    }

    public int getDegree() {
        return adjacencies.size();
    }
}

