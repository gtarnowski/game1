package com.company.Engine.GameSystem;

import com.company.Engine.Enemy.Enemy;
import com.company.Engine.GameSystem.Skills.MageSkillSystem;
import com.company.Engine.GameSystem.Skills.MageSkills;
import com.company.Engine.Player.Player;

import static java.lang.System.err;
import static java.lang.System.out;
import static java.lang.System.in;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Fight {

    short [] singleHit(Player player, Enemy enemy){
        short playerHit = playerSingleHit(player);
        short enemyHit = enemySingleHit(enemy);
        usePlayerSpecifiedSkills(player);
        player.setHp((short) (player.getHp() - enemyHit));
        enemy.setHp((short) (enemy.getHp() - playerHit));
        return ;
    }

    private void usePlayerSpecifiedSkills(Player player) {
        Scanner scanner = new Scanner(in);
        player.showSkillsMap();




        try{
            if(scanner.nextInt() == 1){
                player.getSkills();
            }else if(scanner.nextInt() == 2){

            }else if(scanner.nextInt() == 3){

            }else {
                usePlayerSpecifiedSkills(player);
            }

        }catch (InputMismatchException ex ) {
            usePlayerSpecifiedSkills(player);
            out.println("Select class using digits!");
        }

    }


    //SINGLE HIT SCHEMA (same for player and enemy):

    //modifier = player max DMG - min DMG;
    //attackAverage = random form modifier;
    //finalPlayerHit = min DMG + attackAverage;
    private short playerSingleHit(Player player){
        Random rand = new Random();

        short playerAttack = 0;
        short playerAttackAverage =0;
        short playerAttackMultiplier =0;

        playerAttack = (short) (player.getAttackMax() - player.getAttackMin());

        playerAttackAverage = (short) (rand.nextInt(playerAttack) +2 );
//        out.println("playerAverage:" + playerAttackAverage);

        playerAttackMultiplier = (short) (player.getAttackMin() + playerAttackAverage);
        out.println("PLAYER HIT:" +  playerAttackMultiplier);

        return playerAttackMultiplier;
    }

    private short enemySingleHit(Enemy enemy){
        Random rand = new Random();
        out.println("value :" + enemy.getAttackMin());
        out.println("value :" + enemy.getAttackMax());
        out.println("value :" + enemy.getLvl());
        out.println("value :" + enemy.getHp());
        out.println("value :" + enemy.getDef());



        short enemyAttack = 0;
        short enemyAttackAverage =0;
        short enemyAttackMultiplier =0;

        enemyAttack = (short) (enemy.getAttackMax() - enemy.getAttackMin());

        enemyAttackAverage = (short) (rand.nextInt(enemyAttack) +2 );
        out.println("value enemyAverage:" + enemyAttackAverage);

        enemyAttackMultiplier = (short) (enemy.getAttackMin() + enemyAttackAverage);
        out.println("value ENEMY HIT:" + enemyAttackMultiplier);

        return enemyAttackMultiplier;
    }
//    private void playerSkillUse(Player player){
//        MageSkills skills = new MageSkills();
//        skills.getSkill(player);
//    }
}
