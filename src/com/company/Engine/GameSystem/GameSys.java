package com.company.Engine.GameSystem;

import com.company.Engine.Base.Begin;
import com.company.Engine.Enemy.Enemy;
import com.company.Engine.Player.Player;
import com.company.Gfx.Gfx;

import java.util.Scanner;

import static java.lang.System.in;


public class GameSys extends Fight{
    private Player player = new Player();
    private Begin begin = new Begin();
    private Gfx gfx = new Gfx();


    public void buildHero(){
        player = begin.loadCharacter();
        game();
    }

    private void game(){
        Scanner scanner = new Scanner(in);
        String result;
        do{
            gfx.drawGameOptions();
            result = scanner.next();
            if(result.equals("1")){
                callFight();
            }
        }while (!result.equals("4"));
    }
    private void callFight(){
        //Enemy with Constructor. player.getLvl setting generated mob Attributes
        Enemy enemy = new Enemy(player.getLvl());
        Fight fight = new Fight();

        fight.singleHit(player,enemy);

    }
}
