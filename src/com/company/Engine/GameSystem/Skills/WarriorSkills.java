package com.company.Engine.GameSystem.Skills;

import com.company.Engine.Player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Grzegorz on 2016-08-23.
 */
public class WarriorSkills {
    WarriorSkillsSystem slash = WarriorSkillsSystem.SLASH;
    WarriorSkillsSystem smash = WarriorSkillsSystem.SMASH;

    public void setWarrOnCreatedPlayerSkills(Player player){
        for(WarriorSkillsSystem skillSystem : WarriorSkillsSystem.values()){
            if(skillSystem.name().equals(slash.name())){
                player.setSkills(skillSystem.name(),true);
            }else{
                player.setSkills(skillSystem.name(),false);
            }
        }
    }
    public void skillsLearnMenu(Player player){
        player.setLvl((short)3);
        Scanner sc = new Scanner(in);
        //TODO: skills.get nie moze byc nullem bo sypie ERR
        if((player.getLvl() >= 1) && (player.getSkills(slash.name()).equals(false))){
            out.println("Skill: " + slash.name() + " is Available! Type '+' to learn");
            if(sc.next().equals("+")){
                learnSlash(player);
            }
        }
        if((player.getLvl() >= 3) && (player.getSkills(smash.name()).equals(false))){
            out.println("Skill: " + smash.name() +  " is Available! Type '+' to learn");
            if(sc.next().equals("+")){
                learnSmash(player);
            }
        }
    }
    public short[] warriorSkillsMenu(Player player){
        Scanner scanner = new Scanner(in);

        player.showSkillsMap();
        int result = scanner.nextInt();
        try {
            if(result == 0){
                return null;
            }else if (result == 1) return useSlash(player);
            else if (result == 2) return useSmash(player);
            else {
                warriorSkillsMenu(player);
            }
        }catch (InputMismatchException ex){
            out.println("Select skills using digits!");
            warriorSkillsMenu(player);
        }
        return null;
    }
    private void learnSlash(Player player){
        if((player.getSkillPoints() >=1)){
            player.setSkills(slash.name(),true);
        }else {
            out.println("Not enough skill points!");
        }
    }
    private void learnSmash(Player player){
        if((player.getSkillPoints() >=3)){
            player.setSkills(smash.name(),true);
        }else {
            out.println("Not enough skill points!");
        }
    }

    private short[] useSlash(Player player){
        if((player.getLvl() >= 1) && (player.getSkills(WarriorSkillsSystem.SLASH.name()).equals(true))){
            return new short [] {(short) WarriorSkillsSystem.SLASH.getSkillMinVal(), (short) WarriorSkillsSystem.SLASH.getSkillMaxVal()};
        }
        out.println("Cannot use that skill!");
        return new short[0];
    }
    private short[] useSmash(Player player){
        if((player.getLvl() >= 3) && (player.getSkills(WarriorSkillsSystem.SMASH.name()).equals(true))){
            return new short[] {(short) WarriorSkillsSystem.SMASH.getSkillMinVal(),(short) WarriorSkillsSystem.SMASH.getSkillMaxVal()};
        }
        out.println("Cannot use that skill!");
        return new short[0];
    }
}
