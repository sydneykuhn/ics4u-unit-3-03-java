/*
* This program generates 250 random numbers in an array
* and allows the user to search the array for a number.
*
* @author  Mr Coxall
* @version 0.5
* @since   2020-09-01
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * This is Main Class.
 * Main Class.
 */
final class BinarySearch {
    /**
    * The min number for array.
    */
    public static final int MIN = 0;

    /**
    * The max number for array.
    */
    public static final int MAX = 999;

    /**
    * The number of elements in the array.
    */
    public static final int ARRAY_SIZE = 250;
    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */

    private BinarySearch() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Function finds the index of a number, using Binary Search recursively.
    *
    * @param userArray array of numbers generated
    * @param userNumber looking for this number
    * @param lowIndex lowest in index
    * @param highIndex highest in index
    * @return binarySearch returns binary
    */
    static int binarySearch(final int[] userArray, final int userNumber,
                          final int lowIndex, final int highIndex) {
        final int returnValue;

        if (highIndex >= lowIndex) {
            final int mid = (highIndex + lowIndex) / 2;

            if (userArray[mid] == userNumber) {
                returnValue = mid;
            } else if (userArray[mid] > userNumber) {
                returnValue =
                      binarySearch(userArray, userNumber, lowIndex, mid - 1);
            } else {
                returnValue =
                      binarySearch(userArray, userNumber, mid + 1, highIndex);
            }
        } else {
            returnValue = -1;
        }
        return returnValue;
    }

    /**
    * This starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        System.out.println("Binary Search Program");
        try {
            // Initializing the random class
            final Random randNumber = new Random();

            // Initializing array of numbers
            final int[] randomNumberArray = new int[ARRAY_SIZE];

            // Adding numbers to the array
            for (int counter = 0; counter
                            < randomNumberArray.length; counter++) {
                randomNumberArray[counter] = randNumber.nextInt(MAX) + 1;
            }

            // Sorting the array
            final int[] numberArray = randomNumberArray;
            Arrays.sort(numberArray);

            System.out.print("\nSorted list of numbers:\n");
            for (int element: numberArray) {
                final String padded = String.format("%03d", element);
                System.out.print(padded + ", ");
            }
            System.out.print("\n\n");

            // Getting user input as to what number they wish to search for
            final Scanner userInput = new Scanner(System.in);
            System.out.print("What number are you searching for in the array");
            System.out.print(" (integer between 0 and 999): ");
            final int searchNumber = userInput.nextInt();
            userInput.close();
            System.out.println();

            // Ensuring the user inputs an appropriate integer
            if (searchNumber > MAX || searchNumber < MIN) {
                throw new Exception();
            } else {
                // Using binary search to find the user's
                // chosen number in the array
                final int searchResult = binarySearch(numberArray,
                                searchNumber, 0, numberArray.length - 1);
                // Outputing the results of the search
                System.out.println();
                System.out.println("Your number is in index: " + searchResult);
            }

        // Catches and tells the user that an error occured
        } catch (java.util.InputMismatchException error) {
            System.out.println();
            System.out.println("ERROR: Invalid Input");
        }
    }
}
