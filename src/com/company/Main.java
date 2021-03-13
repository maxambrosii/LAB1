package com.company;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void inputIncidenceMatrix(int vertices, int arcs, int[][] incidence) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter incidence matrix:");
        for (int i = 0; i < arcs; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print("Enter incidence[" + i + "]" + "[" + j + "]: ");
                incidence[i][j] = scanner.nextInt();
            }
        }
        System.out.println(ANSI_GREEN + "Incidence matrix successfully input!" + ANSI_RESET + "\n");
    }

    public static void outputIncidenceMatrix(int arcs, int vertices, int[][] incidence) {
        if (arcs == 0 || vertices == 0) {
            System.out.println(ANSI_RED + "\nYour incidence matrix is clear! Please firstly input the matrix.\n" + ANSI_RESET);
        } else {
            System.out.println("\nYour incidence matrix:");
            for (int a = 0; a < arcs; a++) {
                for (int j = 0; j < vertices; j++) {
                    System.out.print(" " + incidence[a][j]);
                }
                System.out.print("\n");
            }
        }
    }

    public static void outputAdjacencyMatrix(int arcs, int vertices, int[][] incidence, int n, int m, int[][] adjacency) {
        if (arcs == 0 || vertices == 0) {
            System.out.println(ANSI_RED + "\nYour incidence matrix is clear! Please firstly input the matrix.\n" + ANSI_RESET);
        } else {

            System.out.print("Your adjacency matrix:");
            for (int i = 0; i < arcs; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (incidence[i][j] == -1) {
                        m = j;
                    }

                    if (incidence[i][j] == 1) {
                        n = j;
                    }

                    if (incidence[i][j] == 2) {
                        m = j;
                        n = j;
                    }
                }
                adjacency[m][n] = 1;
            }

            for (m = 0; m < vertices; m++) {
                System.out.print("\n");
                for (n = 0; n < vertices; n++) {
                    System.out.print(" " + adjacency[m][n]);
                }
            }
        }
        System.out.print("\n");
    }

    public static void outputAdjacencyList(int n, int m, int vertices, int[][] adjacency) {
        System.out.println("\nAdjacency list:");
        for (m = 0; m < vertices; m++) {
            System.out.print(m + 1 + ":");
            for (n = 0; n < vertices; n++) {
                if (adjacency[m][n] == 1)
                    System.out.print(n + 1 + " ");
                else System.out.print(" 0 ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] incidence = new int[50][50];
        int[][] adjacency = new int[50][50];
        int option = 0, vertices = 0, arcs = 0;
        int m = 0, n = 0;


        do {

            System.out.println("1. Incidence matrix input");
            System.out.println("2. Incidence matrix output");
            System.out.println("3. Adjacency matrix output");
            System.out.println("4. Displaying an adjacency list");
            System.out.println("\n(Input another number for Exit)");
            System.out.print("   \nChoose option: ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            switch (option) {
                case 1: {
                    System.out.print("\nEnter the number of vertices:  ");
                    vertices = scanner.nextInt();
                    System.out.print("\nEnter the number of arcs:  ");
                    arcs = scanner.nextInt();
                    inputIncidenceMatrix(vertices, arcs, incidence);
                }
                break;

                case 2:
                    outputIncidenceMatrix(vertices, arcs, incidence);
                    break;
                case 3:
                    outputAdjacencyMatrix(vertices, arcs, incidence, n, m, adjacency);
                    break;
                case 4:
                    outputAdjacencyList(n, m, vertices, adjacency);
                    break;

                default:
                    System.out.println(ANSI_GREEN + "Thanks for using the program!" + ANSI_RESET);
                    break;
            }

        } while (option > 0 && option < 5);
    }
}