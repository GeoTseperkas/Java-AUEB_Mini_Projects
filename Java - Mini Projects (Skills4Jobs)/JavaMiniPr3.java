package gr.aueb.testbed.week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Develop an application that reads the characters of a file one by one and
 * inserts them into a 256x2 array. Each table position is therefore one
 * two position array, where the 1st position stores the character it has
 * is read (if it is not already in the table) and in the 2nd position is stored
 * number of times each character has been read (found).
 * Spaces and line breaks are not considered characters.
 * At the end main() presents statistics for each character
 * (frequency of occurrence in the text sorted by character).
 */

public class JavaMiniPr3 {

    public static void main(String[] args) throws FileNotFoundException {
        int [][] arr = new int[256][2];

        File inFile = new File("C:/.../in.txt");

        Scanner in = new Scanner (inFile);

        while (in.hasNext()){
            String inStr = in.next();
            char[] inChars = inStr.toCharArray();
            for (int c=0; c< inChars.length; c++) {
                addOrIncr(arr, (int) inChars[c]);
            }

        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] != 0){
                System.out.println();
                System.out.println((char)arr[i][0] + " : " +arr[i][1]);}
        }

    }

    static void addOrIncr(int[][]arr, int a) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] == 0) {
                System.out.println("Adding...: " + (char)a);
                arr[i][0]=a;
                arr[i][1]=1;
                break;
            }
            if (arr[i][0] == a) {
                arr[i][1] += 1;
                System.out.println("Exists...: " + (char)a);
                break;
            }
        }
    }
}
