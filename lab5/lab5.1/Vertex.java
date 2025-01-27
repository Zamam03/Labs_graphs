import java.util.LinkedList;

public class Vertex {
    int vertexNumber, colour, parent;
    boolean isInTree;
    LinkedList<Vertex> adjacencies = new LinkedList<Vertex>();

    public Vertex(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        this.colour = -1; // Initialize colour as -1 (uncoloured)
        this.parent = -1; // Initialize parent as -1 (no parent)
        this.isInTree = false; // Initialize isInTree as false
    }

    public void addAdjacency(Vertex other) {
        adjacencies.add(other);
    }

    public boolean isAdjacent(Vertex other) {
        return adjacencies.contains(other);
    }

    public int getDegree() {
        return adjacencies.size();
    }

    public void setColor(int degree) {
        int[] used = new int[degree]; // Array to track used colours
        for (Vertex neighbor : adjacencies) {
            if (neighbor.colour != -1) {
                used[neighbor.colour] = 1; // Mark used colours
            }
        }

        // Find the smallest unused colour
        for (int c = 0; c < degree; c++) {
            if (used[c] == 0) {
                this.colour = c;
                break;
            }
        }
    }

    public int getColour() {
        return colour;
    }
}

