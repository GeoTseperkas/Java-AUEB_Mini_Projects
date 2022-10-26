package gr.aueb.testbed.week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Develop a program in Java that reads from a file of integer
 * numbers (the file must contain more than 6 numbers and at the
 * very 49 numbers) with values from 1 to 49. It enters these numbers
 * into an array, then the program produces all possible hexadecimals
 * (combinations of 6 numbers). At the same time and immediately
 * after the production, 'filters' each hex to meet the following criteria:
 * 1) Contains a maximum of 4 even numbers
 * 2) Contains at most 4 odd ones
 * 3) Contains at most 2 consecutive ones
 * 4) Contains at most 3 with the same ending
 * 5) Contain at most 3 numbers in the same ten.
 * Finally, it prints the final hexes to a file(.txt) with a name of your choice.
 */

public class JavaMiniPr1 {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("C:/.../in.txt");
        File outFile = new File("C:/.../out.txt");


        Scanner in = new Scanner(inFile);
        PrintStream ps = new PrintStream(outFile);

        final int N = 6;
        int[] row = new int[6];

        ArrayList<Integer> inputNumbers = new ArrayList<>();

        while(in.hasNextInt()){
            inputNumbers.add(in.nextInt());
        }

        for (int i = 0; i <= inputNumbers.size() -N; i++){
            for (int j = i + 1; j <= inputNumbers.size() - N + 1; j++ ){
                for (int k = j + 1; k <= inputNumbers.size() - N + 2; k++ ){
                    for (int l = k + 1; l < inputNumbers.size() - N + 3; l++){
                      for (int m = l + 1; m < inputNumbers.size() - N + 4; m++){
                          for (int n = m + 1; n < inputNumbers.size(); n++){
                              row[0] = inputNumbers.get(i);
                              row[1] = inputNumbers.get(j);
                              row[2] = inputNumbers.get(k);
                              row[3] = inputNumbers.get(l);
                              row[4] = inputNumbers.get(m);
                              row[5] = inputNumbers.get(n);


                              if (!isEven(row) && !isOdd(row) && !isCon(row) && isEnd(row) && isDec(row)) {
                                  System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t\n",
                                          row[0], row[1], row[2], row[3],row[4],row[5]);
                                  ps.printf("%d\t%d\t%d\t%d\t%d\t%d\t\n",
                                          row[0], row[1], row[2], row[3],row[4],row[5]);
                              }
                          }
                      }
                    }
                }
            }
        }
    }


    public static boolean isEven(int[] arr){
        int count = 0;

        for (int j : arr) {
            if (j % 2 == 0) count++;
        }
        return (count > 4);
    }


    public static boolean isOdd(int[] arr){
        int count = 0;

        for (int j : arr) {
            if (j % 2 != 0) count++;
        }
        return (count > 4);
    }
    public static boolean isCon(int[] arr){
        int count = 0;

        for (int i = 1; i < arr.length; i++){
            if (arr[i] == (arr[i-1])+1) count++;
        }
        return (count > 2);
    }
    public static boolean isEnd(int[] arr) {

        int[] mod = new int[10];

        for (int i : arr) {
            mod[i % 10] += 1;
            if (mod[i % 10] > 3){
                return false;
            }
        }
        return true;
    }
    public static boolean isDec(int[] arr) {

        int[] dec = new int[5];

        for (int i : arr) {
            dec[i / 10] += 1;
            if (dec[i / 10] > 3){
                return false;
            }
        }
        return true;
    }

}
