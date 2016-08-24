package com.company.Engine.Player;


import com.company.Engine.Base.Begin;
import com.company.Engine.GameSystem.Skills.ArcherSkills;
import com.company.Engine.GameSystem.Skills.MageSkillSystem;
import com.company.Engine.GameSystem.Skills.MageSkills;
import com.company.Engine.GameSystem.Skills.WarriorSkills;
import com.company.Engine.Profession;
import com.sun.org.apache.xpath.internal.functions.FuncContains;

import java.util.*;

import static java.lang.System.out;

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
        short points = (short) Math.round((player.getGold() * 0.02));
        short decreaseGold = (short) ((player.getGold()) - points);
        player.setGold(decreaseGold);
        out.println("Player GOLD has been decreased by " + points);
    }

    public void resurrection(Player player) {
        decreasePlayerXp(player);
        decreasePlayerGold(player);
        player.calcHealth();
    }

    public void useInventory() {
        //TODO: do declaration;
    }
    public void playerLevelUp(Player player){
        if(player.getXp() == 500){

        }
    }
}