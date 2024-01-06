package quicksort;

import java.util.Scanner;

public class Quick_Sort_Algorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the values of the array separated by spaces:");
        scanner.nextLine(); // Consume the newline character left by nextInt()

        String input = scanner.nextLine();
        String[] values = input.split(" ");

        if (values.length != size) {
            System.out.println("The number of values entered does not match the array size.");
            scanner.close();
            return;
        }

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(values[i]);
        }

        // Perform QuickSort
        quickSort(array, 0, size - 1);

        System.out.print("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) {
                System.out.print(" ");
            }
        }

        // Find the most frequent number without using a separate array
        int mostFrequentNumber = findMostFrequentNumber(array);

        System.out.println("\nNumber(s) that appear most and their count(s):");
        System.out.println("Number: " + mostFrequentNumber + " | Count: " + countOccurrences(array, mostFrequentNumber));

        scanner.close();
    }

    // QuickSort implementation
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    // Partition function for QuickSort
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);

        return i + 1;
    }

    // Utility function to swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Count occurrences of a specific number in a sorted array
    private static int countOccurrences(int[] array, int number) {
        int count = 0;

        for (int i = 0; i < array.length && array[i] <= number; i++) {
            if (array[i] == number) {
                count++;
            }
        }

        return count;
    }

    // Find the most frequent number in a sorted array
    private static int findMostFrequentNumber(int[] array) {
        int mostFrequentNumber = array[0];
        int currentNumber = array[0];
        int currentCount = 1;
        int maxCount = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == currentNumber) {
                currentCount++;
            } else {
                currentNumber = array[i];
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentNumber = currentNumber;
            }
        }

        return mostFrequentNumber;
    }
}
