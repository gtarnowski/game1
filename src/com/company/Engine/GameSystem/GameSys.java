package com.company.Engine.GameSystem;

import com.company.Engine.Enemy.Enemy;
import com.company.Engine.GameSystem.Skills.MageSkills;
import com.company.Engine.Player.Player;
import com.company.Engine.Player.PlayerEvents;
import com.company.Gfx.Gfx;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class GameSys extends Fight{
    private Player player = new Player();
    private Gfx gfx = new Gfx();
    //TODO: skile startowe powinny być załadowane do pliku i z pliku zsetowane pod PLAYERA
    private MageSkills skills = new MageSkills();
    private PlayerEvents events = new PlayerEvents();

    public void buildHero(){
        events.onCreatedPlayerEvents(player);
        game(player);
    }

    public void game(Player player) {
        Scanner scanner = new Scanner(in);
        String result = null;

        while (true){
            gfx.drawGameOptions();
            try {
                result = scanner.next();
                if (result.equals("1")) {
                    //Method
                    game(player);
                } else if (result.equals("2")) {
                    //Method
                    game(player);
                } else if (result.equals("3")) {
                    callFight(player);
                }else if(result.equals("4")){
                    PlayerEvents events = new PlayerEvents();
                    events.spentPlayerAdvancePoints(player);
                } else {
                    out.println("Select correct number!");
                }
            } catch (InputMismatchException ex) {
                out.println("Error: " + ex);
                game(player);
            }
        }


    }
    private void callFight(Player player){
        //Enemy with Constructor. player.getLvl setting generated mob Attributes;
        //Chances should be "equals";
        Enemy enemy = new Enemy(player.getLvl());
        Fight fight = new Fight();
        out.println("HP " + player.getHp() + " GOLD: " + player.getGold());
        out.println("XP " + player.getXp() + " LVL: " + player.getLvl());
        fight.initializeFight(player,enemy);
    }
}
