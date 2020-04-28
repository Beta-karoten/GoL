package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("Wypisz rozmiar tablicy(kwadratowej)");
        n = scanner.nextInt();
        if(n<0){
            System.out.println("Podaj poprawną liczbę!");
            n=scanner.nextInt();
        }
        Board board = new Board(n);
        System.out.println("Wybierz opcję:A(dodaj komorki);P(zagraj);D(wyzeruj gre);E(wyjdz)");
        choice = scanner.next();
        while (choice != "E") {
            switch (choice) {
                case "A":
                    System.out.println("Podaj ilosc zywych komorek:");
                    try {
                        int how_many = scanner.nextInt();
                        for (int i = 0; i < how_many; i++) {
                            System.out.println("Wpisz wspolrzedne komorki:");
                            int a = scanner.nextInt();
                            int b = scanner.nextInt();
                            board.setlife(a, b);
                        }
                    } catch (InputMismatchException e) {
                            System.err.println("Nie podano liczby!");
                    }catch (Exception e) {
                            e.printStackTrace();
                    }
                    break;
                case "P":
                    board.play();
                    break;
                case "D":
                    board.reset();
                    break;
                case "E":
                    System.exit(0);
                default:
                    System.out.println("Wybrano zla opcje. Prosze wybrac jeszcze raz.");
            }
            System.out.println("Wybierz opcję:A(dodaj komorki);P(zagraj);D(wyzeruj gre);E(wyjdz)");
            choice = scanner.next();
        }
    }
}
