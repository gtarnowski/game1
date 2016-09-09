package com.company;

import com.company.Engine.GameSystem.GameSys;
import com.company.Engine.Items.ItemEvents;
import com.company.Engine.Player.BuildPlayer;
import com.company.Gfx.Gfx;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    static BuildPlayer build = new BuildPlayer();
    static Gfx gfx = new Gfx();
    static GameSys gameSys = new GameSys();
    static ItemEvents itemEvents = new ItemEvents();

    public static void main(String[] args) throws IOException, InterruptedException {
        newGame();

    }


    public static void newGame() throws IOException, InterruptedException {
        Scanner sc = new Scanner(in);
        char result;
        itemEvents.loadItems();

        gfx.drawMenuItems();
        result = sc.next().charAt(0);

        if (result == '1') {
            build.createCharacter();
        } else if(result == '2'){
            gameSys.buildHero();
        }else if (result == '3') {
            out.println("Game ending");
            System.exit(0);
        } else {
            out.println("Wrong choose, try again");
            newGame();
        }
    }

}
