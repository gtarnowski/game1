package com.company.Engine.StatsModifiers;

import com.company.Engine.Player.Player;

import java.util.Objects;


public class  StatsModifier extends Player{

    public void calculateStatByStrength(String selectedClass, byte str, byte agi, byte[] attack){
        //DK attack set - staty poprawne
        if(Objects.equals(selectedClass, profession[1])){
            attack[0] = (byte) (str /6);
            attack[1] = (byte) (str / 4);
        }
        //ARCH attack set -
        if(Objects.equals(selectedClass, profession[2])){
            attack[0] = (byte) ((str /14) + (agi / 7));
            attack[1] = (byte) ((str /8) + (agi / 4));
        }
    }
    public void calculateStatByAgility(String selectedClass, byte def, byte str, byte agi, byte[] attack){
        //SM attack set -
        if(Objects.equals(selectedClass, profession[0])){
            def = (byte) (agi /4);
        }
        //DK attack set -
        if(Objects.equals(selectedClass, profession[1])){
            def = (byte) (agi /3);
        }
        //ARCH attack set -
        if(Objects.equals(selectedClass, profession[2])){
            def = (byte) (agi /10);
            attack[0] = (byte) ((str /14) + (agi / 7));
            attack[1] = (byte) ((str /8) + (agi / 4));
        }
    }
    public void calculateStatByVitality(String selectedClass, byte lvl, byte hp, byte vit){
        //SM vit
        //HP = 30+(lvl-1)+vit*2
        if(Objects.equals(selectedClass, profession[0])){
            hp= (byte) (30 + (lvl - 1 ) + (vit * 2));
        }
        //DK vit
        //HP = 35+(lvl-1)*2+vit*3
        if(Objects.equals(selectedClass, profession[1])){
            hp= (byte) (35 + (lvl - 1)*2 + (vit * 3));
        }
        //ARCH vit
        //HP = 40+(lvl-1)+vit*2
        if(Objects.equals(selectedClass, profession[2])){
           hp= (byte) (40+ (lvl - 1) + vit * 2);
        }
    }
    public void calculateStatByEnergy(String selectedClass, byte lvl, byte mp, byte ene, byte[] attackMagic){
        //SM ene + mp calc
        if(Objects.equals(selectedClass, profession[0])){
            attackMagic[0]= (byte) (ene/9);
            attackMagic[1]= (byte) (ene/4);
            mp = (byte) ((lvl - 1) * 2 + (ene * 2));
        }
        //DK ene calc
        if(Objects.equals(selectedClass, profession[1])){
            mp = (byte) (10 + (lvl -1) * 0.5 + ene);
        }
        //ARCH ene calc
        if(Objects.equals(selectedClass, profession[2])){
            mp = (byte) (6 + (lvl * 1.5) + (ene * 1.5));
        }
    }
}
