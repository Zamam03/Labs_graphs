import java.util.Random;

public class Algorithms {

    // Initializes an array with random integers
    public static int[] initialize(int numItems) {
        Random generator = new Random();
        int[] array = new int[numItems];
        for (int i = 0; i < numItems; i++) {
            array[i] = generator.nextInt(1000000);
        }
        return array;
    }

    // Performs a linear count of occurrences of a given integer in the array
    public static int linearCount(int[] array, int value) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
        }
        return count;
    }

    // Performs bubble sort on the array
    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    // Swap array[i] and array[j]
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    // Main method to test the performance of linearCount and bubbleSort
    public static void main(String[] args) {
        int size = 10000;
        Timer myTimer = new Timer();
        
        int[] data = initialize(size);

        // Test linearCount
        myTimer.start();
        int position = linearCount(data, 50);
        myTimer.stop();
        System.out.println("Search Time : " + myTimer.getTime() + " milliseconds");

        // Test bubbleSort
        myTimer.start();
        bubbleSort(data);
        myTimer.stop();
        System.out.println("Sort Time : " + myTimer.getTime() + " milliseconds");
    }
}

