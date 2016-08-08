package com.company;


import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class NewPlayer extends Player {
    Player player = new Player();
    Engine engine = new Engine();
    public void newGame(){
        buildIdentity();
        buildCharacter();
        engine.calculateStatByStrenght();
        engine.calculateStatByAgility();
        engine.calculateStatByVitality();
        engine.calculateStatByEnergy();
    }
    private void buildIdentity(){
        Scanner sc = new Scanner(in);
        int res;

        out.println("Enter player name: ");
        player.name = sc.next();

        out.println("Choose player class: ");
        out.println("1. " + profession[0]);
        out.println("2. " + profession[1]);
        out.println("3. " + profession[2]);
        res = sc.nextInt();

        if(res == 1){
            player.selectedClass =  profession[0];
        }else if(res == 2){
            player.selectedClass =  profession[1];
        }else {
            player.selectedClass =  profession[2];
        }
    }
    private void buildCharacter(){
        if(Objects.equals(this.player.selectedClass, profession[0])){
            //Mage stats
            player.hp = 60; player.mp = 60;
            player.str = 18; player.agi = 18; player.vit = 17;player.ene = 30;
        }
        if(Objects.equals(this.player.selectedClass, profession[1])){
            //Warr stats
            player.hp = 110; player.mp = 20;
            player.str = 28; player.agi = 20; player.vit = 25;player.ene = 10;
        }
        if(Objects.equals(this.player.selectedClass, profession[2])){
            //Arch stats
            player.hp = 80; player.mp = 30;
            player.str = 22; player.agi = 25; player.vit = 20;player.ene = 15;
        }
    }
}
