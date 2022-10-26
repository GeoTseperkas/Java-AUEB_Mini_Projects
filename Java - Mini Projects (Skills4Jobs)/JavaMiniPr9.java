package gr.aueb.testbed.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Assume we have a theater that has seats where each seat is described by a character
 * which is the column and a number which is the row.
 * For example position C2 is in the 3rd row and 3rd column.
 * Develop a theater management program with 31 rows and 12 columns.
 * More specifically write a method void book(char column, int row) that does book
 * a seat if not already booked and a method void cancel(char column, int row)
 * which cancels the reservation of a seat if it is already booked.
 */

public class JavaMiniPr9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int menu;
        String ticketC;
        int ticketR;

        boolean[][] cin = new boolean[31][12];

        do{
            System.out.println("1: Book a seat");
            System.out.println("2: Cancel ticket");
            System.out.println("0: Exit");
            System.out.println("Input your option");

            menu = in.nextInt();

            switch (menu){
                case 1:
                    System.out.println("Choose your seat");
                    System.out.println("Choose seat. (A-L)");
                    ticketC = in.next();
                    System.out.println("Choose row. (1-30)");
                    ticketR = in.nextInt();
                    bookSeat(cin,ticketC,ticketR);
                    break;
                case 2:
                    System.out.println("Choose your seat");
                    System.out.println("Choose seat. (A-L)");
                    ticketC = in.next();
                    System.out.println("Choose row. (0-30)");
                    ticketR = in.nextInt();
                    cancelSeat(cin,ticketC,ticketR);
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Please try one of the available options");
            }
        }while (menu != 0);
        System.out.println("Thank you, Bye");
    }


    public static void bookSeat(boolean[][]arr, String column, int row){

        int seat = trans(column);

        if (!arr[row][seat]){
            arr[row][seat] = true;
            System.out.printf("Reservation for seat %s%d completed successfully\n"
                    ,column,row);
        } else {
            System.out.printf("Seat %s%d is already booked, please try a different one\n"
                    ,column,row);
        }
    }

    public static void cancelSeat(boolean[][]arr, String column, int row){

        int seat = trans(column);

        if (arr[row][seat]){
            arr[row][seat] = false;
            System.out.printf("Reservation for seat %s%d successfully cancelled\n"
                    ,column,row);
        } else {
            System.out.printf("Wrong input, there is no reservation for seat %s%d\n"
                    ,column,row);
        }
    }

    public static int trans(String column){
        Map<String, Integer> letters= new HashMap<String, Integer>();
        letters.put("A", 0);
        letters.put("B", 1);
        letters.put("C", 3);
        letters.put("D", 4);
        letters.put("E", 5);
        letters.put("F", 6);
        letters.put("G", 7);
        letters.put("H", 8);
        letters.put("I", 9);
        letters.put("J", 10);
        letters.put("K", 11);
        letters.put("L", 12);

        int translated = 0;
        translated = letters.get(column);

        return translated;
    }
}
