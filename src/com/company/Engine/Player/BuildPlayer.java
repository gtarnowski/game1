package com.company.Engine.Player;


import com.company.Engine.Profession;
import com.company.Engine.StatsModifiers.StatsModifier;
import com.company.Gfx.Gfx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class BuildPlayer extends Player {


    private Player pl = new Player();
    private StatsModifier statMod = new StatsModifier();
    private Gfx gfx = new Gfx();
    private Profession mage = Profession.MAGE;
    private Profession warr = Profession.WARRIOR;
    private Profession arch = Profession.ARCHER;


    public void createCharacter(){
        buildIdentity();
        buildCharacter();
        buildCharacterStats();
        try {
            saveCharacterData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildCharacterStats() {
        if(Objects.equals(pl.prof, String.valueOf(mage))){
            //Mage stats
            statMod.calcHealth(pl.prof,pl.lvl,pl.vit);
            statMod.calcDefense(pl.prof,pl.agi);
            statMod.calcManaAndMagic(pl.lvl,pl.ene);
        }
        if(Objects.equals(pl.prof, String.valueOf(warr))){
            //Warr stats
            statMod.calcMeleeAttack(pl.str,pl.agi);
            statMod.calcDefense(pl.prof,pl.agi);
            statMod.calcHealth(pl.prof,pl.lvl,pl.vit);
            statMod.calcMana(pl.prof,pl.lvl,pl.ene);
        }
        if(Objects.equals(pl.prof, String.valueOf(arch))){
            //Arch stats
            statMod.calcDefenseAndRange(pl.str,pl.agi);
            statMod.calcHealth(pl.prof,pl.lvl,pl.vit);
            statMod.calcMana(pl.prof,pl.lvl,pl.ene);
        }
    }

    private void buildIdentity(){
        Scanner sc = new Scanner(in);
        int res;
        pl.lvl = 1;

        out.println("Enter player name: ");
        pl.name = sc.next();

        gfx.drawClassChoose();
        res = sc.nextInt();

        if(res == 1){
            pl.prof = String.valueOf(mage);
        }else if(res == 2){
            pl.prof = String.valueOf(warr);
        }else {
            pl.prof = String.valueOf(arch);
        }
    }
    private void buildCharacter(){
        //TODO: ZROBIĆ TO NA KONSTRUKTORZE!!!!!!!!!!!!!!!!
        if(Objects.equals(pl.prof, String.valueOf(mage))){
            //Mage stats
            pl.str = 18; pl.agi = 18; pl.vit = 15;pl.ene = 30;
        }
        if(Objects.equals(pl.prof, String.valueOf(warr))){
            //Warr stats
            pl.str = 28; pl.agi = 20; pl.vit = 25;pl.ene = 10;
        }
        if(Objects.equals(pl.prof, String.valueOf(arch))){
            //Arch stats
            pl.str = 22; pl.agi = 25; pl.vit = 20;pl.ene = 15;
        }
    }
    private void saveCharacterData() throws IOException {
        PrintWriter writer = new PrintWriter("player.txt");

        writer.println(pl.prof);
        writer.println(pl.name);

        writer.println(pl.lvl);
        writer.println(pl.hp);
        writer.println(pl.mp);

        writer.println(pl.str);
        writer.println(pl.agi);
        writer.println(pl.vit);
        writer.println(pl.ene);

        writer.println(pl.def);

        if(Objects.equals(pl.prof,String.valueOf(mage))){
            writer.print(pl.attackMagic[0]);
            writer.print(pl.attackMagic[1]);
        }else {
            writer.println(pl.attack[0]);
            writer.println(pl.attack[1]);
        }

        writer.close();
    }
}
