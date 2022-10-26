package gr.aueb.testbed.week2;

import java.util.Scanner;

/**
 * Assume we have a sorted array with repeating elements.
 * Write one int[] getLowAndHighIndexOf(int[] arr, int key) method
 * that calculates and returns the low and high index of an array arr,
 * for an integer key it receives as a parameter.
 * Also write a main() that finds the low and high index for the array
 * {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 8}.
 * For example, if we give the value 8, it should return 7, 11.
 */

public class JavaMiniPr4 {

    public static void main(String[] args) {

        int[] array = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 8};
        int key;
        int key1;
        int[] minMax;
        Scanner in = new Scanner(System.in);

        System.out.println("Choose number for key");
        key = in.nextInt();

        key1 = binarySearch(array, key);
        if (key1 == -1) {
            System.out.println("No occurrences of the specified number found in array.");
            return;
        }

        minMax = getLowAndHigh(array,key1);
        System.out.printf("Min Value Pos: %d  Max Value Pos: %d", minMax[0], minMax[1]);
        System.out.println();
    }


    public static int binarySearch(int[] arr, int value) {
        int position = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                position = i;
                break;
            }
        }
        return position;
    }


    public static int[] getLowAndHigh(int[] arr, int position) {
        int hPosition = position;
        int lPosition = position;
        int [] arrMinMax = new int[2];
        arrMinMax[0] = lPosition;
        arrMinMax[1] = hPosition;

        for (int i = position; i < arr.length; i++) {
            if (arr[i] == arr[hPosition]) {
                arrMinMax[1] = i;

            }
        }
        return arrMinMax;
    }
}