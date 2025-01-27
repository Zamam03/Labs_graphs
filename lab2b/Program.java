import java.util.Scanner;

public class Program {

    public static int determineMove(String input) {
        
        String[] lines = input.split("\n");

        String[] firstLine = lines[0].split(" ");
        int snakeCount = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);
        int height = Integer.parseInt(firstLine[2]);

        String[] appleCoords = lines[1].split(",");
        int appleX = Integer.parseInt(appleCoords[0]);
        int appleY = Integer.parseInt(appleCoords[1]);

        int snakeNumber = Integer.parseInt(lines[2]);

        String[] snakeCoordsLine = lines[3 + snakeNumber].split(" ");
        String[] headCoords = snakeCoordsLine[0].split(",");
        int headX = Integer.parseInt(headCoords[0]);
        int headY = Integer.parseInt(headCoords[1]);
       
        if (appleY < headY) {
            return 0;  // Up
        } else if (appleY > headY) {
            return 1;  // Down
        } else if (appleX < headX) {
            return 2;  // Left
        } else if (appleX > headX) {
            return 3;  // Right
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 3 + 3; i++) {
            input.append(scanner.nextLine()).append("\n");
        }
       
        int move = determineMove(input.toString());

        System.out.println(move);
    }
}

