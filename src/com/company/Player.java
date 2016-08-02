package com.company;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class Player {
    private byte hp;
    private byte mp;
    private byte str;
    private byte agi;
    private byte ene;
    private byte vit;
    private String name;
    private String [] playerClass= {"mage","warrior","archer"};

    public void newGame(){
        String [] res;
        res = buildIdentity();
        name = res[0];
        //setuje staty wg klasy
        buildCharacter(res[1]);
    }
    private String[] buildIdentity(){
        Scanner sc = new Scanner(in);

        int res;
        String name,playerChoosedClass;

        out.println("Enter player name: ");
        name = sc.next();

        out.println("Choose player class: ");
        out.println("1. " + playerClass[0]);
        out.println("2. " + playerClass[1]);
        out.println("3. " + playerClass[2]);
        res = sc.nextInt();

        if(res == 1){
            playerChoosedClass =  playerClass[0];
        }else if(res == 2){
            playerChoosedClass =  playerClass[1];
        }else {
            playerChoosedClass =  playerClass[2];
        }

        String [] player ={name,playerChoosedClass};
        return player;
    }
    private void buildStats(){

    }
    private void buildCharacter(String pClass){
        if(Objects.equals(pClass, playerClass[0])){
            //Mage stats
            hp = 60; mp = 60; str = 18; agi = 18; vit = 17;ene = 30;
        }
        if(Objects.equals(pClass, playerClass[1])){
            //Warr stats
            hp = 110; mp = 20; str = 28; agi = 20; vit = 25;ene = 10;
        }
        if(Objects.equals(pClass, playerClass[2])){
            //Arch stats
            hp = 80; mp = 30; str = 22; agi = 25; vit = 20;ene = 15;
        }
        buildStats();
    }
}
