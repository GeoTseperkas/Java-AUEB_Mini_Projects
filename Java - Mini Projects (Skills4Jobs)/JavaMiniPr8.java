package gr.aueb.testbed.week2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * One of the first applications of computers was the encryption.
 *A simple way of encryption is to encode each character with an integer
 * based on one encryption key.
 * One such encryption method is described in this exercise.
 * Encode the 1st character of the message with the integer value that
 * corresponds to it (from the ASCII code). Code the next characters:
 * (a) adding the ASCII integer value of each of them with code of its predecessor,
 * (b) taking the remainder of its division sum of this by a constant.
 * This constant is called key encryption and is (supposedly) secret.
 * Write a java program that implements the encryption and decryption algorithm.
 */

public class JavaMiniPr8 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s1;

        System.out.println("Please insert string to encode");
        s1 = in.nextLine();
        System.out.println();

        int []encode = encoderS(s1);
        for (int i : encode)
            System.out.print(i + " ");

        System.out.println("\n");


        String [] decode = decoderS(encode);
        for (String i : decode)
            System.out.print(i + " ");
    }


    public static int[] encoderS (String s) {
        final int KEY = 200;
        int en = 0;
        int [] encoder = new int[200];
        int count = 0;
        final int endof1 = -1;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                en = s.charAt(i) % KEY;
                count++;
            } else {
                en = (en + s.charAt(i)) % KEY;
                count++;
            }
            encoder[i] = en;
        }
        encoder[count] = endof1;
        count++;
        return Arrays.copyOfRange(encoder,0, count);
    }

    public static String [] decoderS(int [] arr) {
        final int KEY = 200;
        String [] arr1 = new String[200];
        int count = 0;
        int a = 0;

        for (int i = 0; i < arr.length-1; i++){
            if (i == 0) {
                a = arr[i];
                arr1[i] = Character.toString(a);
                count++;
            } else if (arr[i] > a) {
                a = arr[i] - arr[i-1];
                arr1[i] = Character.toString(a);
                count++;
            } else if (arr[i] <= a) {
                a = (arr[i] + KEY) - arr[i-1];
                arr1[i] = Character.toString(a);
                count++;
            }
        }
        return Arrays.copyOfRange(arr1, 0, count);
    }
}
