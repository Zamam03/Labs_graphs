import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first line for the number of snakes, width, height, and the unused number
        int numSnakes = scanner.nextInt();
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        scanner.nextInt(); // This value is always 1 and can be ignored

        // Consume the remaining newline character after the last integer
        scanner.nextLine();

        // Initialize the matrix with zeros
        int[][] matrix = new int[height][width];  // Note that matrix is height x width

        // Read each snake's coordinates
        for (int snakeNumber = 1; snakeNumber <= numSnakes; snakeNumber++) {
            String line = scanner.nextLine().trim();
            drawSnake(line, snakeNumber, matrix);
        }

        // Print the matrix
        printBoard(matrix);

        scanner.close();
    }

    private static void drawSnake(String snakeLine, int snakeNumber, int[][] matrix) {
        // Split the input string into coordinates
        String[] points = snakeLine.split(" ");
        if (points.length < 2) return; // If there are not enough points, return
        
        // Draw each segment of the snake
        for (int i = 0; i < points.length - 1; i++) {
            String[] start = points[i].split(",");
            String[] end = points[i + 1].split(",");
            
            if (start.length != 2 || end.length != 2) {
                System.err.println("Invalid coordinate format in snake data.");
                return;
            }
            
            try {
                int startX = Integer.parseInt(start[0]);
                int startY = Integer.parseInt(start[1]);
                int endX = Integer.parseInt(end[0]);
                int endY = Integer.parseInt(end[1]);

                if (isValidCoordinate(startX, startY, matrix) && isValidCoordinate(endX, endY, matrix)) {
                    drawLine(matrix, startX, startY, endX, endY, snakeNumber);
                } else {
                    System.err.println("Coordinates out of bounds: (" + startX + "," + startY + ") or (" + endX + "," + endY + ")");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format in coordinates.");
            }
        }
    }

    private static boolean isValidCoordinate(int x, int y, int[][] matrix) {
        return x >= 0 && x < matrix[0].length && y >= 0 && y < matrix.length;
    }

    private static void drawLine(int[][] matrix, int x1, int y1, int x2, int y2, int snakeNumber) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            if (isValidCoordinate(x1, y1, matrix)) {
                matrix[y1][x1] = snakeNumber;
            }
            if (x1 == x2 && y1 == y2) break;
            int e2 = err * 2;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    private static void printBoard(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

