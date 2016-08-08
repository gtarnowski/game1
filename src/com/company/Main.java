package com.company;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    NewPlayer player = new NewPlayer();
    public void main(String[] args) {
        gameMenu();
    }

    public void gameMenu() {
        Scanner sc = new Scanner(in);
        int result;

        out.println("1. New Game");
        out.println("2. Exit");
        result = sc.nextInt();

        if (result == 1) {
            player.newGame();
        } else if (result == 2) {
            out.println("Game ending");
            out.println(".");
            out.println("..");
            out.println("...");
            System.exit(0);
        } else {
            out.println("Wrong choose, try again");
            gameMenu();
        }
    }
}
