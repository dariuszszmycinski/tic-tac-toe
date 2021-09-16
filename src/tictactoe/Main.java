package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] signs = new char[9];
        int moves = 0;
        Arrays.fill(signs, ' ');
        printBoard(signs);
        while (!checkResult(signs)){
            if (moves%2==0){
                putChar(sc, signs, 'X');
            }else {
                putChar(sc, signs, 'O');
            }
            moves++;
            printBoard(signs);
        }
    }

    private static void putChar(Scanner sc, char[] signs, char c) {
        boolean correct = false;
        int x = 0, y = 0;
        while (!correct) {
            System.out.println("Enter the coordinates:");
            try {
                x = Integer.parseInt(sc.next());
                y = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("You should enter numbers!");
                continue;
            }
            if ((x > 3 || y > 3 || x < 1 || y < 1)) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (signs[(3 * (x - 1)) + (y - 1)] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            } else correct = true;
        }
        signs[(3 * (x - 1)) + (y - 1)] = c;
    }

    private static boolean checkResult(char[] signs) {
        int xes = 0;
        int oes = 0;
        int empty = 0;
        for (char c : signs) {
            switch (c) {
                case 'X':
                    xes++;
                    break;
                case 'O':
                    oes++;
                    break;
                case ' ':
                    empty++;
                    break;
            }
        }
        if (Math.abs(xes - oes) > 1) {
            System.out.println("Impossible");
            return true;
        } else if (checkIfWins(signs, 'X') && checkIfWins(signs, 'O')) {
            System.out.println("Impossible");
            return true;
        } else if (checkIfWins(signs, 'X')) {
            System.out.println("X wins");
            return true;
        } else if (checkIfWins(signs, 'O')) {
            System.out.println("O wins");
            return true;
        } else if (empty > 0) {
            System.out.println("Game not finished");
            return false;
        } else {
            System.out.println("Draw");
            return true;
        }
    }

    private static void printBoard(char[] signs) {
        System.out.println("---------");
        System.out.println("| " + signs[0] + " " + signs[1] + " " + signs[2] + " |");
        System.out.println("| " + signs[3] + " " + signs[4] + " " + signs[5] + " |");
        System.out.println("| " + signs[6] + " " + signs[7] + " " + signs[8] + " |");
        System.out.println("---------");
    }

    private static boolean checkIfWins(char[] signs, char c) {
        if (signs[0] == c && signs[1] == c && signs[2] == c) {
            return true;
        }
        if (signs[3] == c && signs[4] == c && signs[5] == c) {
            return true;
        }
        if (signs[6] == c && signs[7] == c && signs[8] == c) {
            return true;
        }
        if (signs[0] == c && signs[3] == c && signs[6] == c) {
            return true;
        }
        if (signs[1] == c && signs[4] == c && signs[7] == c) {
            return true;
        }
        if (signs[2] == c && signs[5] == c && signs[8] == c) {
            return true;
        }
        if (signs[0] == c && signs[4] == c && signs[8] == c) {
            return true;
        }
        if (signs[2] == c && signs[4] == c && signs[6] == c) {
            return true;
        }
        return false;
    }
}
