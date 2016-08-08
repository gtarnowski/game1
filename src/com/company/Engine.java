package com.company;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class Engine extends Player {
    Player player = new Player();
    protected void calculateStatByStrenght(){
        //TODO: wyliczyc odrebne staty
        //SM attack set -

        //DK attack set - staty poprawne
        if(Objects.equals(this.player.selectedClass, profession[1])){
            player.attack[0] = (byte) (this.player.str /4);
            player.attack[1] = (byte) (this.player.str /6);
        }
        //TODO: wyliczyc odrebne staty
        //ARCH attack set -
        if(Objects.equals(this.player.selectedClass, profession[2])){
            player.attack[0] = (byte) ((this.player.str /14) + (this.player.agi / 7));
            player.attack[1] = (byte) ((this.player.str /8) + (this.player.agi / 4));
        }
    }
    protected void calculateStatByAgility(){
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
            player.def = (byte) (this.player.agi /10);
            player.attack[0] = (byte) ((this.player.str /14) + (this.player.agi / 7));
            player.attack[1] = (byte) ((this.player.str /8) + (this.player.agi / 4));
        }
    }
    protected void calculateStatByVitality(){
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
    protected void calculateStatByEnergy(){
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
