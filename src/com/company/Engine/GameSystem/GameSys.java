package com.company.Engine.GameSystem;

import com.company.Engine.Base.Begin;
import com.company.Engine.Enemy.Enemy;
import com.company.Engine.Player.Player;
import com.company.Gfx.Gfx;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class GameSys extends Fight{
    private Player player = new Player();
    private Begin begin = new Begin();
    private Gfx gfx = new Gfx();


    public void buildHero(){
        player = begin.loadCharacter();
        game();
    }

    private void game() {
        Scanner scanner = new Scanner(in);
        String result = null;

        gfx.drawGameOptions();

        try {
            result = scanner.next();
            if (result.equals("1")) {
                //Method
                game();
            } else if (result.equals("2")) {
                //Method
                game();
            } else if (result.equals("3")) {
                callFight();
            } else {
                out.println("Select correct number!");
            }
        } catch (InputMismatchException ex) {
            out.println("Error: " + ex);
            game();
        }

    }
    private void callFight(){
        //Enemy with Constructor. player.getLvl setting generated mob Attributes;
        //Chances should be "equals";
        Scanner scanner = new Scanner(in);

        Enemy enemy = new Enemy(scanner.nextShort());
        Fight fight = new Fight();

        fight.singleHit(player,enemy);

    }
}
