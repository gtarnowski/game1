package com.company.Engine.GameSystem;

import com.company.Engine.Enemy.Enemy;
import com.company.Engine.GameSystem.Skills.ArcherSkills;
import com.company.Engine.GameSystem.Skills.MageSkills;
import com.company.Engine.GameSystem.Skills.WarriorSkills;
import com.company.Engine.Player.Player;
import com.company.Engine.Player.PlayerEvents;
import com.company.Engine.Profession;
import com.company.Gfx.Gfx;

import static java.lang.System.getenv;
import static java.lang.System.in;
import static java.lang.System.out;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Fight {
    private MageSkills mageSkills = new MageSkills();
    private WarriorSkills warriorSkills = new WarriorSkills();
    private ArcherSkills archerSkills = new ArcherSkills();
    private PlayerEvents events = new PlayerEvents();
    private Gfx gfx = new Gfx();

    public void initializeFight(Player player, Enemy enemy) {
        Scanner scanner = new Scanner(in);
        gfx.drawFightMenu();
        int result = scanner.nextInt();
        try {
            if (result == 1) {
                while ((player.getHp() > 0) && (enemy.getHp() > 0)) {

                    short playerHit = playerAttack(player);
                    short enemyHit = enemySingleHit(enemy);

                    player.setHp((short) (player.getHp() - enemyHit));
                    enemy.setHp((short) (enemy.getHp() - playerHit));
                    if (playerHit == 0 ) {
                        out.println("Player MISSED! " + player.getHp() + " HP left");
                    }else {
                        out.println("Player attack with " + playerHit + " DAMAGE! " + player.getHp() + " HP left");
                    }
                    if(enemyHit == 0){
                        out.println("ENEMY MISSED! " + enemy.getHp() + " HP left");
                    }else {
                        out.println("Enemy attack with " + enemyHit + " DAMAGE!" + enemy.getHp() + " HP left");
                    }
                }
            } else if (result == 2) {
                events.useInventory();
            } else if (result == 3) {
                gfx.drawSingleQuotes("decrease");
                String res = scanner.next();
                if ((res.equals("y")) || (res.equals("Y"))) {
                    events.decreasePlayerXp(player);
                }
            } else {
                gfx.drawErrors(0);
            }
        } catch (InputMismatchException ex) {
            gfx.drawErrors(1);
            initializeFight(player, enemy);
        }

        if (player.getHp() <= 0) {
            gfx.drawSingleQuotes("playerDead");
            events.resurrection(player);
        } else if (enemy.getHp() <= 0) {
            gfx.drawSingleQuotes("enemyDead");
            events.playerSuccessFightSummary(player,enemy);
        }
    }
    private short playerAttack(Player player) {

        if (player.getProf().contains(Profession.MAGE.name())) {
            short[] attack = mageSkills.mageSkillsMenu(player);
            if (attack != null) {
                return playerSingleSkillHit(player, attack);
            } else {
                return playerSingleHit(player);
            }
        } else if (player.getProf().equals(Profession.WARRIOR.name())) {
            short[] attack = warriorSkills.warriorSkillsMenu(player);
            if (attack != null) {
                return playerSingleSkillHit(player, attack);
            } else {
                return playerSingleHit(player);
            }
        } else if (player.getProf().equals(Profession.ARCHER.name())) {
            short[] attack = archerSkills.archerSkillsMenu(player);
            if (attack != null) {
                return playerSingleSkillHit(player, attack);
            } else {
                return playerSingleHit(player);
            }
        }
        return 0;
    }


    //SINGLE HIT SCHEMA (same for player and enemy):

    //modifier = player max DMG - min DMG;
    //attackAverage = random form modifier;
    //finalPlayerHit = min DMG + attackAverage;
    private short playerSingleHit(Player player) {
        Random rand = new Random();

        short playerAttack;
        short playerAttackAverage;
        short playerAttackMultiplier;

        playerAttack = (short) (player.getAttackMax() - player.getAttackMin());
        playerAttackAverage = (short) (rand.nextInt(playerAttack) + 2);

        playerAttackMultiplier = (short) (player.getAttackMin() + playerAttackAverage);
        float missChance = rand.nextFloat();
        if(missChance <= 0.10f){
            playerAttackMultiplier = 0;
        }
        return playerAttackMultiplier;
    }

    private short enemySingleHit(Enemy enemy) {
        Random rand = new Random();

        short enemyAttack;
        short enemyAttackAverage;
        short enemyAttackMultiplier;

        enemyAttack = (short) (enemy.getAttackMax() - enemy.getAttackMin());

        enemyAttackAverage = (short) (rand.nextInt(enemyAttack) + 2);

        enemyAttackMultiplier = (short) (enemy.getAttackMin() + enemyAttackAverage);

        float missChance = rand.nextFloat();
        if(missChance <= 0.10f){
            enemyAttackMultiplier = 0;
        }

        return enemyAttackMultiplier;
    }

    private short playerSingleSkillHit(Player player, short[] skillHit) {
        Random rand = new Random();
        short playerAttack;
        short playerMinAttackSummary = (short) (player.getAttackMin() + skillHit[0]);
        short playerMaxAttackSummary = (short) (player.getAttackMax() + skillHit[1]);
        short playerAttackAverage;
        short playerAttackMultiplier;

        playerAttack = (short) (playerMaxAttackSummary - playerMinAttackSummary);

        playerAttackAverage = (short) (rand.nextInt(playerAttack) + 2);

        playerAttackMultiplier = (short) (playerMinAttackSummary + playerAttackAverage);

        float missChance = rand.nextFloat();
        if(missChance <= 0.10f){
            playerAttackMultiplier = 0;
        }
        return playerAttackMultiplier;
    }
}
