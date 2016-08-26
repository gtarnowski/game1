package com.company.Engine.Player;


import com.company.Engine.Base.Begin;
import com.company.Engine.Enemy.Enemy;
import com.company.Engine.GameSystem.Skills.ArcherSkills;
import com.company.Engine.GameSystem.Skills.MageSkillSystem;
import com.company.Engine.GameSystem.Skills.MageSkills;
import com.company.Engine.GameSystem.Skills.WarriorSkills;
import com.company.Engine.Profession;
import com.sun.org.apache.xpath.internal.functions.FuncContains;

import java.util.*;

import static java.lang.System.out;
import static java.lang.System.setErr;

public class PlayerEvents{
    public void onCreatedPlayerEvents(Player player){
        Begin begin = new Begin();
        begin.loadCharacter(player);

        if(player.getProf().equals(Profession.MAGE.name())){
            MageSkills skills = new MageSkills();
            skills.setMageOnCreatedPlayerSkills(player);
        }else if(player.getProf().equals(Profession.WARRIOR.name())){
            WarriorSkills skills = new WarriorSkills();
            skills.setWarrOnCreatedPlayerSkills(player);
        }else if(player.getProf().equals(Profession.ARCHER.name())){
            ArcherSkills skills = new ArcherSkills();
            skills.setArcherOnCreatedPlayerSkills(player);
        }
    }
    public void decreasePlayerXp(Player player){
        short points =(short) Math.round( player.getXp() * 0.07);
        short decreaseXp = (short) (player.getXp() - points);
        player.setXp(decreaseXp);
        out.println("Player XP points has been decreased by " + points + " points");
    }
    public void decreasePlayerGold(Player player){
        if(player.getGold() >= 0){
            short points = (short) Math.round((player.getGold() * 0.02));
            short decreaseGold = (short) ((player.getGold()) - points);
            player.setGold(decreaseGold);
            out.println("Player GOLD has been decreased by " + points);
        }else {
            out.println("Player GOLD has been decreased by 0");
        }

    }

    public void resurrection(Player player) {
        decreasePlayerXp(player);
        decreasePlayerGold(player);
        player.calcHealth();
    }

    public void useInventory() {
        //TODO: do declaration;
    }
    public void playerSuccessFightSummary(Player player, Enemy enemy){
        calulateXpAfterMobKilling(enemy);


        playerLevelUp(player);
    }

    private void calulateXpAfterMobKilling(Enemy enemy) {

    }
    private short calculateXp(short multipier){
        short finalFromMobXp =0;
        finalFromMobXp = (short) (multipier *  0);

        return finalFromMobXp;
    }
    private void playerLevelUp(Player player) {
        if ((player.getXp() >= 150) && (player.getLvl() == 1)) {
            //LEVEL UP TO 2
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 300) && (player.getLvl() == 2)) {
            //LEVEL UP TO 3
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 600) && (player.getLvl() == 3)) {
            //LEVEL UP TO 4
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 900) && (player.getLvl() == 4)) {
            //LEVEL UP TO 5
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 1500) && (player.getLvl() == 5)) {
            //LEVEL UP TO 6
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 2100) && (player.getLvl() == 6)) {
            //LEVEL UP TO 7
            playerIncreaseAttribute(player);

        }
    }
    private void playerIncreaseAttribute(Player player){
        player.setLvl((short) (player.getLvl() + 1));
        player.setSkillPoints((short) (player.getSkillPoints() + 1));
        player.setLvlPoints((short) (player.getLvlPoints() + 5));
    }
}