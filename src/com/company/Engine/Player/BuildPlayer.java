package com.company.Engine.Player;


import com.company.Engine.StatsModifiers.StatsModifier;
import com.company.Gfx.Gfx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class BuildPlayer extends Player {
    private Player player = new Player();
    private StatsModifier statsModifier = new StatsModifier();
    private Gfx gfx = new Gfx();

    public void createCharacter(){
        buildIdentity();
        buildCharacter();
        statsModifier.calculateStatByStrength(player.selectedClass, player.str, player.agi, player.attack);
        statsModifier.calculateStatByAgility(player.selectedClass, player.def, player.str, player.agi, player.attack);
        statsModifier.calculateStatByVitality(player.selectedClass, player.lvl, player.hp, player.vit);
        statsModifier.calculateStatByEnergy(player.selectedClass, player.lvl, player.mp, player.ene, player.attackMagic);
        try {
            saveCharacterData();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    private void saveCharacterData() throws IOException {
        PrintWriter writer = new PrintWriter("player.txt");

        writer.println(player.selectedClass);
        writer.println(player.name);

        writer.println(player.lvl);
        writer.println(player.hp);
        writer.println(player.mp);

        writer.println(player.str);
        writer.println(player.agi);
        writer.println(player.vit);
        writer.println(player.ene);

        writer.println(player.def);

        if(Objects.equals(player.selectedClass,profession[0])){
            writer.print(player.attackMagic[0]);
            writer.print(player.attackMagic[1]);
        }else {
            writer.println(player.attack[0]);
            writer.println(player.attack[1]);
        }

        writer.close();
    }
}
