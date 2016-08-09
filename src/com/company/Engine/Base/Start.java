package com.company.Engine.Base;

import com.company.Engine.Player.BuildPlayer;
import com.company.Gfx.Gfx;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class Start {
    BuildPlayer build = new BuildPlayer();
    Gfx gfx = new Gfx();

    public void newGame(){
        Scanner sc = new Scanner(in);
        char result;

        gfx.drawMenuItems();
        result = sc.next().charAt(0);

        if (result == '1') {
            build.createCharacter();
        } else if (result == '2') {
            out.println("Game ending");
            System.exit(0);
        } else {
            out.println("Wrong choose, try again");
            newGame();
        }
    }
}
