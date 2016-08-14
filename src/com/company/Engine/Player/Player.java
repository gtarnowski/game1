package com.company.Engine.Player;


import com.company.Engine.Profession;

import static java.lang.System.out;

public class Player {

    private byte lvl;
    private byte hp;
    private byte mp;

    private byte str;
    private byte agi;
    private byte ene;
    private byte vit;

    private byte attackMin;
    private byte attackMax;

    private byte def;
    private String name;
    //Player selected prof
    private String prof;

    private Profession mage = Profession.MAGE;
    private Profession warr = Profession.WARRIOR;
    private Profession arch = Profession.ARCHER;



    void calcMeleeAttack() {

        if (this.prof.equals(String.valueOf(warr))) {
            //DK attack set
            this.attackMin = (byte) (this.str / 6);
            this.attackMax = (byte) (this.str / 4);
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }

    }
    void calcDefense() {

        //SM defense set
        if (this.prof.equals(String.valueOf(mage))) {
            this.def = (byte) (this.agi / 4);
        }else if(this.prof.equals(String.valueOf(warr))) {
            this.def = (byte) (this.agi / 3);
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }
    }
    void calcDefenseAndRange() {

        //ARCH Defense and Attack calc
        if(this.prof.equals(String.valueOf(arch))){
            this.def = (byte) (this.agi / 10);
            this.attackMin = (byte) ((this.str / 14) + (this.agi / 7));
            this.attackMax = (byte) ((this.str / 8) + (this.agi / 4));
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }

    }
    void calcHealth() {

        //SM vit set
        //HP = 30+(lvl-1)+vit*2
        if (this.prof.equals(String.valueOf(mage))) {
            this.hp = (byte) (30 + (this.lvl - 1) + (this.vit * 2));
        }else if (this.prof.equals(String.valueOf(warr))) {
            //DK vit set
            //HP = 35+(lvl-1)*2+vit*3
            this.hp = (byte) (35 + (this.lvl - 1) * 2 + (this.vit * 3));
        }else if (this.prof.equals(String.valueOf(arch))) {
            //ARCH vit set
            //HP = 40+(lvl-1)+vit*2
            this.hp = (byte) (40 + (this.lvl - 1) + this.vit * 2);
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }
    }
    void calcMana() {

             //DK ene set
        if (this.prof.equals(String.valueOf(warr))) {

            this.mp = (byte) (10 + (this.lvl - 1) * 0.5 + this.ene);

        }else if (this.prof.equals(String.valueOf(arch))) {
            //ARCH ene set
            this.mp = (byte) (6 + (this.lvl * 1.5) + (this.ene * 1.5));
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }

    }
    void calcManaAndMagic() {

        //MAGE Mana and MagicAttack calc
        if (this.prof.equals(String.valueOf(mage))) {
            this.attackMin = (byte) (this.ene / 9);
            this.attackMax = (byte) (this.ene / 4);
            this.mp = (byte) ((this.lvl - 1) * 2 + (this.ene * 2));
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }
    }


    public byte getLvl() {
        return lvl;
    }

    public void setLvl(byte lvl) {
        this.lvl = lvl;
    }



    public byte getHp() {
        return hp;
    }

    public void setHp(byte hp) {
        this.hp = hp;
    }



    public byte getMp() {
        return mp;
    }

    public void setMp(byte mp) {
        this.mp = mp;
    }



    public byte getStr() {
        return str;
    }

    public void setStr(byte str) {
        this.str = str;
    }



    public byte getAgi() {
        return agi;
    }

    public void setAgi(byte agi) {
        this.agi = agi;
    }



    public byte getEne() {
        return ene;
    }

    public void setEne(byte ene) {
        this.ene = ene;
    }



    public byte getVit() {
        return vit;
    }

    public void setVit(byte vit) {
        this.vit = vit;
    }



    public byte getAttackMin() {
        return attackMin;
    }

    public void setAttackMin(byte attackMin) {
        this.attackMin = attackMin;
    }



    public byte getAttackMax() {
        return attackMax;
    }

    public void setAttackMax(byte attackMax) {
        this.attackMax = attackMax;
    }



    public byte getDef() {
        return def;
    }

    public void setDef(byte def) {
        this.def = def;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
}
