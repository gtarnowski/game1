package com.company.Engine.StatsModifiers;

import com.company.Engine.Profession;

import java.util.Objects;


public class  StatsModifier {
    private Profession mage = Profession.MAGE;
    private Profession warr = Profession.WARRIOR;
    private Profession arch = Profession.ARCHER;

    public byte[] calcMeleeAttack( byte str, byte agi){

        byte attackMin = 0;
        byte attackMax = 0;

        //DK attack set
            attackMin = (byte) (str /6);
            attackMax = (byte) (str / 4);

        return new byte[]{attackMin,attackMax};
    }


    public byte calcDefense(String selectedClass, byte agi) {

        byte def = 0;

        //SM defense set
        if (Objects.equals(selectedClass, String.valueOf(mage))) {
            def = (byte) (agi / 4);
        }


        //DK defense set
        if (Objects.equals(selectedClass, String.valueOf(warr))) {
            def = (byte) (agi / 3);
        }

        return def;
    }

    public byte[] calcDefenseAndRange(byte str, byte agi){
        //ARCH Defense and Attack calc
        byte def =0;
        byte attackMin;
        byte attackMax;

        def = (byte) (agi /10);
        attackMin = (byte) ((str /14) + (agi / 7));
        attackMax = (byte) ((str /8) + (agi / 4));


        return new byte[]{def,attackMin,attackMax};
    }


    public byte calcHealth(String selectedClass, byte lvl, byte vit){
        byte hp =0;

        //SM vit set
        //HP = 30+(lvl-1)+vit*2
        if(Objects.equals(selectedClass, String.valueOf(mage))){
            hp= (byte) (30 + (lvl - 1 ) + (vit * 2));
        }


        //DK vit set
        //HP = 35+(lvl-1)*2+vit*3
        if(Objects.equals(selectedClass, String.valueOf(warr))){
            hp= (byte) (35 + (lvl - 1)*2 + (vit * 3));
        }


        //ARCH vit set
        //HP = 40+(lvl-1)+vit*2
        if(Objects.equals(selectedClass, String.valueOf(arch))){
           hp= (byte) (40+ (lvl - 1) + vit * 2);
        }
        return hp;
    }


    public byte calcMana(String selectedClass, byte lvl, byte ene){

            byte mp =0;

            //DK ene set
            if(Objects.equals(selectedClass, String.valueOf(warr))){
                mp = (byte) (10 + (lvl -1) * 0.5 + ene);
            }

            //ARCH ene set
            if(Objects.equals(selectedClass, String.valueOf(arch))){
                mp = (byte) (6 + (lvl * 1.5) + (ene * 1.5));
            }

            return mp;
    }

    public byte [] calcManaAndMagic(byte lvl,byte ene){
        //MAGE Mana and MagicAttack calc
        byte mp =0;
        byte attackMin;
        byte attackMax;


        attackMin= (byte) (ene/9);
        attackMax= (byte) (ene/4);
        mp = (byte) ((lvl - 1) * 2 + (ene * 2));

        return new byte[] {mp,attackMin,attackMax};
    }
}
