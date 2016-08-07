package com.company;


import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class NewPlayer extends Player {
    Player player = new Player();

    public void newGame(){
        buildIdentity();
        buildCharacter();
        calculateStatByStrenght();
        calculateStatByAgility();
        calculateStatByVitality();
        calculateStatByEnergy();
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

    //musi byc odrebna metoda
    private void calculateStatByStrenght(){
        //TODO: wyliczyc odrebne staty
        //SM attack set -
        if(Objects.equals(this.player.selectedClass, profession[0])){
            player.attack[0] = (byte) (this.player.str /4);
            player.attack[1] = (byte) (this.player.str /6);
        }

        //DK attack set - staty poprawne
        if(Objects.equals(this.player.selectedClass, profession[1])){
            player.attack[0] = (byte) (this.player.str /4);
            player.attack[1] = (byte) (this.player.str /6);
        }
        //TODO: wyliczyc odrebne staty
        //ARCH attack set -
        if(Objects.equals(this.player.selectedClass, profession[2])){
            player.attack[0] = (byte) (this.player.str /4);
            player.attack[1] = (byte) (this.player.str /6);
        }
    }
    private void calculateStatByAgility(){
        //TODO: wyliczyc odrebne staty
        //SM attack set -
        if(Objects.equals(this.player.selectedClass, profession[0])){
            player.def = (byte) (this.player.agi /4);
        }

        //DK attack set -
        if(Objects.equals(this.player.selectedClass, profession[1])){
            player.def = (byte) (this.player.agi /3);
        }
        //ARCH attack set -
        if(Objects.equals(this.player.selectedClass, profession[2])){
            player.def = (byte) (this.player.agi /4);
        }
    }
    private void calculateStatByVitality(){
        //TODO: wyliczyc odrebne staty
        //SM vit
        if(Objects.equals(this.player.selectedClass, profession[0])){
            player.hp= (byte) (30 + (this.player.lvl -1 ) + this.player.vit * 2);
        }

        //DK vit
        //HP = 35+(lvl-1)*2+vit*3
        if(Objects.equals(this.player.selectedClass, profession[1])){
            player.hp= (byte) (35 + (player.lvl - 1)*2 + player.vit * 3);
        }
        //ARCH vit
        //HP = 40+(lvl-1)+vit*2
        if(Objects.equals(this.player.selectedClass, profession[2])){
            player.hp= (byte) (40+ (player.lvl - 1) + player.vit * 2);
        }
    }
    private void calculateStatByEnergy(){
        //SM ene + mp calc
        if(Objects.equals(this.player.selectedClass, profession[0])){
            player.attackMagic[0]= (byte) (this.player.ene/4);
            player.attackMagic[1]= (byte) (this.player.ene/9);
            player.mp= (byte) ((this.player.lvl - 1) * 2 + this.player.ene * 2);
        }
        //DK ene calc
        if(Objects.equals(this.player.selectedClass, profession[1])){
            player.mp= (byte) (10 + (this.player.lvl -1) * 0.5 + this.player.ene);
        }
        //ARCH ene calc
        if(Objects.equals(this.player.selectedClass, profession[2])){
            player.mp = (byte) (6 + (this.player.lvl * 1.5) + (this.player.ene * 1.5));
        }
    }
}
