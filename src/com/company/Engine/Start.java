package com.company.Engine;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by hexen on 08.08.16.
 */
public class Start {
    public void newGame(){
        BuildPlayer build = new BuildPlayer();
        Scanner sc = new Scanner(in);
        int result;

        out.println("1. New Game");
        out.println("2. Exit");
        result = sc.nextInt();

        if (result == 1) {
            build.createCharacter();
        } else if (result == 2) {
            out.println("Game ending");
            out.println(".");
            out.println("..");
            out.println("...");
            System.exit(0);
        } else {
            out.println("Wrong choose, try again");
            newGame();
        }
    }
}
