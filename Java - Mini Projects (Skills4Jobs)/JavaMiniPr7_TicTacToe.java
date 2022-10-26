package gr.aueb.testbed.week2;

import java.util.Scanner;

/**
 * Develop a game of Tic-Tac-Toe, where two players play X and O (or 1 and 2 if you prefer
 * to implement with an array of integers rather than an array of chars).
 * The player that has completed three identical symbols or numbers in any of its dimensions of the
 * table (horizontally, vertically or diagonally) wins the game.
 * Main() will control the flow of the game, such as player's turn
 * (switching between the two players),will read from stdin the symbol that
 * gives each player and display it graphically (as we have seen in
 * corresponding example in class) after each player's move.
 * Whereas, you can also create a method that checks (after each
 * move) if the player making the move wins.
 * The program does not allow a player to play in a position that is already occupied,
 * as well as takes into account the case of a tie.
 */

public class JavaMiniPr7_TicTacToe {

    public static void main(String[] args) {

        char[][] ticTacToe = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                ticTacToe[i][j] = '-';
        }

        boolean f = true;

        String ep;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Choose to start with x or o");
            ep = in.next();
            if ((ep.equals("x")) || (ep.equals("o")))
                f = false;
        } while (f);

        printTicTacToe(ticTacToe);

        round(ticTacToe, ep);

    }

    public static void round(char[][] c, String ep) {

        int g = 0;

        do {
            firstToPlay(c, ep);
            g++;
            if (!(check(c)))
                secondToPlay(c, ep);
            System.out.println("End of Round " + g + "\n");
        } while (!(check(c)));

        if (win(c))
            System.out.println("Winner Winner, Chicken Dinner!");


        if ((!(win(c))) && (draw(c)))
            System.out.println("Draw!");

        System.out.println("This is the end!");

    }

    public static void firstToPlay(char[][] c, String ep) {

        int a, b;
        boolean f;
        Scanner in = new Scanner(System.in);

        do {
            f = false;

            do {
                System.out.println("Choose row for the next move");
                a = in.nextInt();
                a = a - 1;
                System.out.println("Choose column");
                b = in.nextInt();
                b = b - 1;
            } while (!((a >= 0) && (a <= 3) && (b >= 0) && (b <= 3)));

            for (int i = 0; i < 3; i++) {
                {
                    for (int j = 0; j < 3; j++)
                        if ((i == a) && (j == b)) {
                            if (c[i][j] == 'o' || c[i][j] == 'x')
                                f = true;
                        }
                }
            }
            if (f)
                System.out.println("Wrong input, try again!");

        } while (f);

        if (ep.equals("x"))
            placeholderX(c, a, b);
        if (ep.equals("o"))
            placeholderO(c, a, b);

        printTicTacToe(c);

    }

    public static void secondToPlay(char[][] c, String ep) {

        int a, b;
        boolean f;
        Scanner in = new Scanner(System.in);

        do {
            f = false;

            do {
                System.out.println("Choose row for the next move");
                a = in.nextInt();
                a = a - 1;
                System.out.println("Choose column");
                b = in.nextInt();
                b = b - 1;
            } while (!((a >= 0) && (a <= 3) && (b >= 0) && (b <= 3)));

            for (int i = 0; i < 3; i++) {
                {
                    for (int j = 0; j < 3; j++)
                        if ((i == a) && (j == b)) {
                            if (c[i][j] == 'o' || c[i][j] == 'x')
                                f = true;
                        }
                }
            }

            if (f)
                System.out.println("Wrong input, try again!");

        } while (f);

        if (ep.equals("x"))
            placeholderO(c, a, b);
        if (ep.equals("o"))
            placeholderX(c, a, b);

        printTicTacToe(c);

    }

    public static void placeholderX(char[][] c, int a, int b) {

        c[a][b] = 'x';

    }

    public static void placeholderO(char[][] c, int a, int b) {

        c[a][b] = 'o';

    }

    public static void printTicTacToe(char[][] c) {

        for (int i = 0; i < 3; i++) {
            System.out.println();
            {
                for (int j = 0; j < 3; j++)
                    System.out.print(c[i][j] + "  ");
            }
            System.out.println();
        }

    }

    public static boolean check(char[][] c) {

        return ((win(c)) || (draw(c)));

    }

    public static boolean win(char[][] c) {

        return ((lines(c)) || (turn(c)) || (diagonal(c)));

    }

    public static boolean draw(char[][] c) {

        int s = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                if (c[i][j] != '-')
                    s++;
        }

        return (s == 9);

    }

    public static boolean diagonal(char[][] c) {

        boolean n = false;

        if ((c[0][0] != '-') && (c[0][0] == c[1][1]) && (c[1][1] == c[2][2]))
            n = true;

        if ((c[2][0] != '-') && (c[2][0] == c[1][1]) && (c[1][1] == c[0][2]))
            n = true;

        return n;

    }

    public static boolean lines(char[][] c) {

        boolean n = false;

        for (int i = 0; i < 3; i++) {
            if ((c[i][0] == c[i][1]) && (c[i][1] == c[i][2]) && (c[i][0] != '-'))
                n = true;
        }

        return n;

    }

    public static boolean turn(char[][] c) {

        boolean n = false;

        for (int j = 0; j < 3; j++) {
            if ((c[0][j] == c[1][j]) && (c[1][j] == c[2][j]) && (c[0][j] != '-'))
                n = true;
        }

        return n;

    }
}

