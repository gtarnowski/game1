package com.company.Engine;

import com.company.Engine.Player;

import java.util.Objects;

import static java.lang.System.out;


public class  StatsModifier extends Player {

    protected void calculateStatByStrenght(Player obj){
        //DK attack set - staty poprawne
        if(Objects.equals(obj.selectedClass, profession[1])){
            obj.attack[0] = (byte) (obj.str /6);
            obj.attack[1] = (byte) (obj.str / 4);
        }
        //ARCH attack set -
        if(Objects.equals(obj.selectedClass, profession[2])){
            obj.attack[0] = (byte) ((obj.str /14) + (obj.agi / 7));
            obj.attack[1] = (byte) ((obj.str /8) + (obj.agi / 4));
        }
    }
    protected void calculateStatByAgility(Player obj){
        //SM attack set -
        if(Objects.equals(obj.selectedClass, profession[0])){
            obj.def = (byte) (obj.agi /4);
        }
        //DK attack set -
        if(Objects.equals(obj.selectedClass, profession[1])){
            obj.def = (byte) (obj.agi /3);
        }
        //ARCH attack set -
        if(Objects.equals(obj.selectedClass, profession[2])){
            obj.def = (byte) (obj.agi /10);
            obj.attack[0] = (byte) ((obj.str /14) + (obj.agi / 7));
            obj.attack[1] = (byte) ((obj.str /8) + (obj.agi / 4));
        }
    }
    protected void calculateStatByVitality(Player obj){
        //SM vit
        //HP = 30+(lvl-1)+vit*2
        if(Objects.equals(obj.selectedClass, profession[0])){
            obj.hp= (byte) (30 + (obj.lvl - 1 ) + (obj.vit * 2));
        }
        //DK vit
        //HP = 35+(lvl-1)*2+vit*3
        if(Objects.equals(obj.selectedClass, profession[1])){
            obj.hp= (byte) (35 + (obj.lvl - 1)*2 + (obj.vit * 3));
        }
        //ARCH vit
        //HP = 40+(lvl-1)+vit*2
        if(Objects.equals(obj.selectedClass, profession[2])){
            obj.hp= (byte) (40+ (obj.lvl - 1) + obj.vit * 2);
        }
    }
    protected void calculateStatByEnergy(Player obj){
        //SM ene + mp calc
        if(Objects.equals(obj.selectedClass, profession[0])){
            obj.attackMagic[0]= (byte) (obj.ene/9);
            obj.attackMagic[1]= (byte) (obj.ene/4);
            obj.mp = (byte) ((obj.lvl - 1) * 2 + (obj.ene * 2));
        }
        //DK ene calc
        if(Objects.equals(obj.selectedClass, profession[1])){
            obj.mp = (byte) (10 + (obj.lvl -1) * 0.5 + obj.ene);
        }
        //ARCH ene calc
        if(Objects.equals(obj.selectedClass, profession[2])){
            obj.mp = (byte) (6 + (obj.lvl * 1.5) + (obj.ene * 1.5));
        }
    }
}
