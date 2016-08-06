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
        calulateAttack();
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

    private void buildCharacter( ){
        //TODO: do poprawki
        if(Objects.equals(player.selectedClass, profession[0])){
            //Mage stats
            hp = 60; mp = 60;
            str = 18; agi = 18; vit = 17;ene = 30;
        }
        if(Objects.equals(player.selectedClass, profession[1])){
            //Warr stats
            hp = 110; mp = 20;
            str = 28; agi = 20; vit = 25;ene = 10;
        }
        if(Objects.equals(player.selectedClass, profession[2])){
            //Arch stats
            hp = 80; mp = 30;
            str = 22; agi = 25; vit = 20;ene = 15;
        }
    }
    //musi byc odrebna metoda
    private void calulateAttack(){
        //TODO: wyliczyc odrebne staty
        if(Objects.equals(player.selectedClass, profession[0])){
            attack[0] = (byte) (player.str /4);
            attack[1] = (byte) (player.str /6);
        }

        //DK attack set - staty poprawne
        if(Objects.equals(player.selectedClass, profession[1])){
            attack[0] = (byte) (player.str /4);
            attack[1] = (byte) (player.str /6);
        }
        //TODO: wyliczyc odrebne staty
        //ARCH attack set
        if(Objects.equals(player.selectedClass, profession[2])){
            attack[0] = (byte) (player.str /4);
            attack[1] = (byte) (player.str /6);
        }
    }

}
