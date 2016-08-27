package com.company.Engine.GameSystem.Skills;

import com.company.Engine.Player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Grzegorz on 2016-08-23.
 */
public class ArcherSkills {
    ArcherSkillsSystem flameshot = ArcherSkillsSystem.FLAMESHOT;
    ArcherSkillsSystem doublebolt = ArcherSkillsSystem.DOUBLEBOLT;

    public void setArcherOnCreatedPlayerSkills(Player player){
        for(ArcherSkillsSystem skillSystem : ArcherSkillsSystem.values()){
            if(skillSystem.name().equals(flameshot.name())){
                player.setSkills(skillSystem.name(),true);
            }else{
                player.setSkills(skillSystem.name(),false);
            }
        }
    }
    public void archerSkillsLearnMenu(Player player){
        player.setLvl((short)3);
        Scanner sc = new Scanner(in);

        //condition of lvl check
        if((player.getLvl() >= 1) && (player.getSkills(flameshot.name()).equals(false))){
            out.println("Skill: " + flameshot.name() + " is Available! Type '+' to learn");
            if(sc.next().equals("+")){
                learnFlameShot(player);
            }
        }

        //condition of lvl check
        if((player.getLvl() >= 3) && (player.getSkills(doublebolt.name()).equals(false))){
            out.println("Skill: " + doublebolt.name() +  " is Available! Type '+' to learn");
            if(sc.next().equals("+")){
                learnDoubleBolt(player);
            }
        }
    }
    public short[] archerSkillsMenu(Player player){
        Scanner scanner = new Scanner(in);

        player.showSkillsMap();
        int result = scanner.nextInt();
        try {
            if(result == 0){
                return null;
            }else if (result == 1) return useFlameShot(player);
            else if (result == 2) return useDoubleBolt(player);
            else {
                archerSkillsMenu(player);
            }
        }catch (InputMismatchException ex){
            out.println("Select skills using digits!");
            archerSkillsMenu(player);
        }
        return null;
    }
    private void learnFlameShot(Player player){
        //condition of lvl and Skill point checked 2nd time Here
        if((player.getLvl() >=1)&& (player.getSkillPoints() >=1)){
            player.setSkills(flameshot.name(),true);
        }else {
            out.println("Not enough skill points!");
        }
    }
    private void learnDoubleBolt(Player player){
        //condition of lvl and Skill point checked 2nd time Here
        if((player.getLvl() >=3) && (player.getSkillPoints() >=1)){
            player.setSkills(doublebolt.name(),true);
        }else {
            out.println("Not enough skill points!");
        }
    }

    private short[] useFlameShot(Player player){
        if((player.getLvl() >= 1) && (player.getSkills(ArcherSkillsSystem.FLAMESHOT.name()).equals(true))){
            return new short [] {(short) ArcherSkillsSystem.FLAMESHOT.getSkillMinVal(), (short) ArcherSkillsSystem.FLAMESHOT.getSkillMaxVal()};
        }
        out.println("Cannot use that skill!");
        return new short[0];
    }
    private short[] useDoubleBolt(Player player){
        if((player.getLvl() >= 3) && (player.getSkills(ArcherSkillsSystem.DOUBLEBOLT.name()).equals(true))){
            return new short[] {(short) ArcherSkillsSystem.DOUBLEBOLT.getSkillMinVal(),(short) ArcherSkillsSystem.DOUBLEBOLT.getSkillMaxVal()};
        }
        out.println("Cannot use that skill!");
        return new short[0];
    }
}
