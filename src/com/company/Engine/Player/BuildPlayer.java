package com.company.Engine.Player;


import com.company.Gfx.Gfx;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class BuildPlayer extends Player {
    Player player = new Player();
    StatsModifier statsModifier = new StatsModifier();
    Gfx gfx = new Gfx();

    public void createCharacter(){
        buildIdentity();
        buildCharacter();
        statsModifier.calculateStatByStrength(player);
        statsModifier.calculateStatByAgility(player);
        statsModifier.calculateStatByVitality(player);
        statsModifier.calculateStatByEnergy(player);
        out.println("MIN Magic: " + player.attackMagic[0]);
        out.println("MAX Magic: " + player.attackMagic[1]);
        out.println("MIN Melee: " + player.attack[0]);
        out.println("MAX Melee: " + player.attack[1]);
        out.println("DEF: " + player.def);
        out.println("MP: " + player.mp);
        out.println("HP: " + player.hp);


    }


    private void buildIdentity(){
        Scanner sc = new Scanner(in);
        int res;
        player.lvl = 1;

        out.println("Enter player name: ");
        player.name = sc.next();

        gfx.drawClassChoose();
        res = sc.nextInt();

        if(res == 1){
            this.player.selectedClass =  profession[0];
        }else if(res == 2){
            this.player.selectedClass =  profession[1];
        }else {
            this.player.selectedClass =  profession[2];
        }
    }
    private void buildCharacter(){
        if(Objects.equals(this.player.selectedClass, profession[0])){
            //Mage stats
            this.player.str = 18; this.player.agi = 18; this.player.vit = 15;this.player.ene = 30;
        }
        if(Objects.equals(this.player.selectedClass, profession[1])){
            //Warr stats
            this.player.str = 28; this.player.agi = 20; this.player.vit = 25;this.player.ene = 10;
        }
        if(Objects.equals(this.player.selectedClass, profession[2])){
            //Arch stats
            this.player.str = 22; this.player.agi = 25; this.player.vit = 20;this.player.ene = 15;
        }
    }
}
