package gr.aueb.testbed.week2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Create a contacts application for a mobile phone that can
 * contains up to 500 contacts. Each contact has a Last Name, First Name and Phone Number.
 * To store contacts use a 500x3 two-dimensional array
 * where the Phone Number will be stored in the 1st position of each contact,
 * the First Name in the 2nd position and in the 3rd position the Last Name, all as a String.
 * Implement basic CRUD operations: Search Contact by phone,
 * Insert Contact (if not already present), Update Contact (if present),
 * Delete Contact (if any).
 */

public class JavaMiniPr2 {

    static String[][] mobile = new String[500][3];
    static int top = -1;
    static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println(Arrays.toString(mobile));

        int choice = 0;
        String inputNum = "";
        String inputNewNum = "";
        String inputName = "";
        String inputNewName = "";
        String inputSurname = "";
        String inputNewSurname = "";
        String deleted = "";
        String searched = "";

        do {
            printMenu();

            choice = getChoice();

            switch (choice){
                case 1:
                    inputNum = getNum();
                    inputName = getName();
                    inputSurname = getSurname();
                    insert(mobile, inputNum, inputName, inputSurname);
                    break;
                case 2:
                    inputNum = getNum();
                    searched = (getOne(mobile, inputNum));
                    System.out.println(searched);
                    System.out.println();

                    break;
                case 3:
                    inputNum = getNum();
                    inputNewNum = getNewNum();
                    inputNewName = getName();
                    inputNewSurname = getSurname();
                    replace(mobile, inputNum, inputNewNum ,inputNewName, inputNewSurname);
                    break;
                case 4:
                    inputName = getNum();
                    deleted = delete(mobile, inputName);
                    if (!deleted.equals("")) {
                        System.out.printf("Number %s was deleted", deleted);
                        System.out.println("\n");
                    }

                    break;
                case 5:
                    printItems(mobile);
                    break;
                case 6:
                    System.out.println("\nExit.");
                    break;
                default:
                    System.out.println("Wrong input. Chose between 1-6\n");
            }
        } while (choice != 6);
        System.out.println("Thank you.");

    }











    public static void insert(String[][] arr, String num, String name, String surName){
        if ((arr == null) || (num == null)) return;
        if (num.equals("")) return;

        if(getPosition(arr, num) == -1){
            top++;
            arr[top][0] = num;
            arr[top][1] = name;
            arr[top][2] = surName;
        } else {
            System.out.println("Number already exists\n");
        }
    }

    public static int getPosition(String[][] arr, String num){
        if ((arr == null) || (num == null)) return -1;
        if (num.equals("")) return -1;

        for (int i =0; i < arr.length; i++){
            if (arr[i][0] == null) return -1;
            if ( (arr[i][0].equals(num)) ){
                return i;
            }
        }
        return -1;
    }


    public static void replace(String[][] arr, String oldNum,
                               String newNum, String newName,String newSurname){
        if ((arr == null) || (newNum == null)) return;
        if (newNum.equals("")) return;

        int positionToUpdate = getPosition(arr, oldNum);
        if (positionToUpdate == -1){
            System.out.println("\nNumber not found\n");
        } else {
            arr[positionToUpdate][0] = newNum;
            arr[positionToUpdate][1] = newName;
            arr[positionToUpdate][2] = newSurname;
            System.out.println("\nNumber replaced\n");
        }
    }

    public static String delete(String[][] arr, String num) {
        if ((arr == null) || (num == null)) return " ";
        if (num.equals("")) return " ";

        int positionToDelete = getPosition(arr, num);
        String toBeReturned = "";

        if (positionToDelete == -1){
            System.out.println("\nNumber not found\n");
        } else {
            toBeReturned = arr[positionToDelete][0];
            String [][] mobiled = new String[500][3];
            for (int i = 0; i < positionToDelete; i++){
                    mobiled[i] = mobile[i];
            }
            for (int i = positionToDelete; i < mobile.length - 1; i++){
                    mobiled[i] = mobile[i+1];
            }
            mobile = mobiled;
            top--;
        }
        return toBeReturned;
    }

    public static String getOne(String[][] arr, String num){
        if ((arr == null) || (num == null)) return " ";
        if (num.equals("")) return " ";

        int positionToGet = getPosition(arr, num);
        String toBeReturned = "";

        if (positionToGet == -1){
            System.out.println("Number not found\n");
        } else {
            toBeReturned = arr[positionToGet][0] + " " + arr[positionToGet][1] + " " + arr[positionToGet][2];
        }
        return toBeReturned;
    }

    public static void printMenu(){
        System.out.println("Chose one of the following");
        System.out.println("1. Insert");
        System.out.println("2. Search");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Show");
        System.out.println("6. Exit");
    }

    public static int getChoice(){
        try {
            return in.nextInt();
        } catch (InputMismatchException e){
            in.nextLine();
            System.out.println("Insert valid value");
            return -1;
        }
    }

    public static String getNum(){
        System.out.println("Insert Number");
        return in.next();
    }
    public static String getNewNum() {
        System.out.println("Insert New Number");
        return in.next();
    }

    public static String getName(){
        System.out.println("Insert Name");
        return in.next();
    }
    public static String getSurname(){
        System.out.println("Insert Surname");
        return in.next();
    }

    public static void printItems(String[][] arr){
        for (int i = 0; i <= top; i++)
            System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
    }
}
