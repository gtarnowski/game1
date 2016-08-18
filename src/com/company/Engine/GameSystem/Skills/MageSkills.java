package com.company.Engine.GameSystem.Skills;

import com.company.Engine.Player.Player;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class MageSkills{
    MageSkillSystem scream = MageSkillSystem.SCREAMBALL;
    MageSkillSystem hate = MageSkillSystem.HATEWAVE;

    public void skillsLearnMenu(Player player){
        player.setLvl((short)3);
        Scanner sc = new Scanner(in);
        out.println("Available skills:");
        if((player.getLvl() >= 1) ){
            out.println(scream.name() + "Type '1' to learn");
            if(sc.next().equals("1")){
                learnScreamBall(player);
            }
        }
        if((player.getLvl() >= 3) ){
            out.println(hate.name() +  "Type '2' to learn");
            if(sc.next().equals("2")){
                learnHateWave(player);
            }

        }
    }
    public ArrayList<String> availableSkills(Player player){
       out.println( player.showSkillsMap());
        return player.showSkillsMap();
    }

    private void learnScreamBall(Player player){
        player.setSkillPoints((short)1);//add for test
        if((player.getSkillPoints() >=1)){
            player.setSkills(scream.name(),true);
        }else {
            out.println("Not enough skill points!");
        }
    }
    private void learnHateWave(Player player){
        player.setSkillPoints((short)1);//add for test
        if((player.getSkillPoints() >=1)){
            player.setSkills(hate.name(),true);
        }else {
            out.println("Not enough skill points!");
        }
    }

}
