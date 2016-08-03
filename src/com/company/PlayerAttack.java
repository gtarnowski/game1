package com.company;


import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class PlayerAttack extends Player {
    Player player = new Player();
    public void newGame(){
        buildIdentity();
    }
    private void buildIdentity(){
        //TODO: posprzątać
        Scanner sc = new Scanner(in);

        int res;
        String name,playerChoosedClass;

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

        buildCharacter(player.selectedClass);
    }

    private void buildCharacter(String player){
        //TODO: do poprawki
        if(Objects.equals(player, profession[0])){
            //Mage stats
            hp = 60; mp = 60;
            str = 18; agi = 18; vit = 17;ene = 30;
        }
        if(Objects.equals(player, profession[1])){
            //Warr stats
            hp = 110; mp = 20;
            str = 28; agi = 20; vit = 25;ene = 10;
        }
        if(Objects.equals(player, profession[2])){
            //Arch stats
            hp = 80; mp = 30;
            str = 22; agi = 25; vit = 20;ene = 15;
        }
        buildAttackStats(player);
    }
    private void calulateAttack(String [] multipier, int str, byte agi, byte vit, byte ene){
        /// TODO: sprawdzić czy dobrze parsuje, Arraylist? albo loop?
        player.str = (byte) (str * Double.parseDouble(multipier[0].replaceAll(" ",".")));
        player.agi = (byte) (agi * Double.parseDouble(multipier[1].replaceAll(" ",".")));
        player.vit = (byte) (vit * Double.parseDouble(multipier[2].replaceAll(" ",".")));
        player.ene = (byte) (ene * Double.parseDouble(multipier[3].replaceAll(" ",".")));
    }
    private void buildAttackStats(String player ){

        if(Objects.equals(player, profession[0])){
//            calulateAttack()
        }else if(Objects.equals(player, profession[1])){

        }else {

        }

    }
}
