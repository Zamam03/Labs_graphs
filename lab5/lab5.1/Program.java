import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nodeNum = Integer.parseInt(scan.nextLine());
        Graph graph = new Graph();
        for (int i = 0; i < nodeNum; i++) {
            graph.addVertex();
        }

        String line = scan.nextLine();
        String[] pair = line.split(",");
        while (!line.equals("-1")) {
            graph.addEdge(graph.getVertex(Integer.parseInt(pair[0])), graph.getVertex(Integer.parseInt(pair[1])));
            line = scan.nextLine();
            if (!line.equals("-1")) {
                pair = line.split(",");
            }
        }

        // Perform DFS starting from Vertex 0
        graph.dfs(graph.getVertex(0));

        // Print the parent information for each vertex
        for (Vertex vert : graph.vertices) {
            if (vert.vertexNumber != 0) { // Skip vertex 0
                System.out.println(vert.vertexNumber + ":" + vert.parent);
            }
        }
    }
}

