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

    byte [] singleHit(Player player, Enemy enemy){
        Random rand = new Random();

        byte playerAttack = 0;
        byte playerAttackAverage =0;
        byte playerAttackMultipier =0;

        playerAttack = (byte) (player.getAttackMax() - player.getAttackMin());

        playerAttackAverage = (byte) (rand.nextInt(playerAttack) +2 );
        out.println("playerAverage:" + playerAttackAverage);

        playerAttackMultipier = (byte) (player.getAttackMin() + playerAttackAverage);
        out.println("PLAYER HIT:" +  playerAttackMultipier);


        out.println("--------------------------");

        byte enemyAttack = 0;
        byte enemyAttackAverage =0;
        byte enemyAttackMultiplier =0;

        enemyAttack = (byte) (enemy.getAttackMax() - enemy.getAttackMin());
        out.println("value enemyAtt:" + enemyAttack);

        enemyAttackAverage = (byte) (rand.nextInt(enemyAttack) +2 );
        out.println("value enemyAverage:" + enemyAttackAverage);

        enemyAttackMultiplier = (byte) (enemy.getAttackMin() + enemyAttackAverage);
        out.println("value ENEMY HIT:" + enemyAttackMultiplier);


        return new byte[]{playerAttackMultipier,enemyAttackMultiplier};
    }
}
