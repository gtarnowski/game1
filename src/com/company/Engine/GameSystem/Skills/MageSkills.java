package com.company.Engine.GameSystem.Skills;

import com.company.Engine.Player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class MageSkills{
    MageSkillSystem scream = MageSkillSystem.SCREAMBALL;
    MageSkillSystem hate = MageSkillSystem.HATEWAVE;

    public void setMageOnCreatedPlayerSkills(Player player){
        for(MageSkillSystem skillSystem : MageSkillSystem.values()){
            if(skillSystem.name().equals(scream.name())){
                player.setSkills(skillSystem.name(),true);
            }else{
                player.setSkills(skillSystem.name(),false);
            }
        }
    }
    public void skillsLearnMenu(Player player){
        player.setLvl((short)3);
        Scanner sc = new Scanner(in);
        //TODO: skills.get nie moze byc nullem bo sypie EXC
        if((player.getLvl() >= 1) && (player.getSkills(scream.name()).equals(false))){
            out.println("Skill: " + scream.name() + " is Available! Type '+' to learn");
            if(sc.next().equals("+")){
                learnScreamBall(player);
            }
        }
        if((player.getLvl() >= 3) && (player.getSkills(hate.name()).equals(false))){
            out.println("Skill: " + hate.name() +  " is Available! Type '+' to learn");
            if(sc.next().equals("+")){
                learnHateWave(player);
            }
        }
    }
    public short[] mageSkillsMenu(Player player){
        Scanner scanner = new Scanner(in);

        player.showSkillsMap();
        int result = scanner.nextInt();
        try {
            if(result == 0){
                return null;
            }else if (result == 1) return useScreamBall(player);
            else if (result == 2) return useHateWave(player);
            else {
                mageSkillsMenu(player);
            }
        }catch (InputMismatchException ex){
            out.println("Select skills using digits!");
            mageSkillsMenu(player);
        }
        return null;
    }
    private void learnScreamBall(Player player){
        if((player.getSkillPoints() >=1)){
            player.setSkills(scream.name(),true);
        }else {
            out.println("Not enough skill points!");
        }
    }
    private void learnHateWave(Player player){
        if((player.getSkillPoints() >=3)){
            player.setSkills(hate.name(),true);
        }else {
            out.println("Not enough skill points!");
        }
    }

    private short[] useScreamBall(Player player){
        if((player.getLvl() >= 1) && (player.getSkills(MageSkillSystem.SCREAMBALL.name()).equals(true))){
            return new short [] {(short) MageSkillSystem.SCREAMBALL.getSkillMinVal(), (short) MageSkillSystem.SCREAMBALL.getSkillMaxVal()};
        }
        out.println("Cannot use that skill!");
        return new short[0];
    }
    private short[] useHateWave(Player player){
        if((player.getLvl() >= 3) && (player.getSkills(MageSkillSystem.HATEWAVE.name()).equals(true))){
            return new short[] {(short) MageSkillSystem.HATEWAVE.getSkillMinVal(),(short) MageSkillSystem.HATEWAVE.getSkillMaxVal()};
        }
        out.println("Cannot use that skill!");
        return new short[0];
    }

}
