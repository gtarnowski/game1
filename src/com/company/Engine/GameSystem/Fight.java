package com.company.Engine.GameSystem;

import com.company.Engine.Enemy.Enemy;
import com.company.Engine.Player.Player;
import com.company.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import  java.lang.Math;
import java.util.Random;

public class Fight {

    short [] singleHit(Player player, Enemy enemy){
        return new short[] {playerSingleHit(player), enemySingleHit(enemy)};
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
        out.println("playerAverage:" + playerAttackAverage);

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
}
