package com.company.Engine.Player;


import com.company.Engine.Profession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class Player {

    private short lvl;
    private short hp;
    private short mp;

    private short xp;
    private short lvlPoints;
    private short skillPoints;

    private short str;
    private short agi;
    private short ene;
    private short vit;

    private short def;

    private short attackMin;
    private short attackMax;

    private short gold;
    private short inventory;

    private String name;
    private String prof;

    private Profession mage = Profession.MAGE;
    private Profession warr = Profession.WARRIOR;
    private Profession arch = Profession.ARCHER;

    private Map<String,Boolean> skills = new HashMap<>();
    //Stats calculator, what base on character class(alias profession)
    void calcMeleeAttack() {

        if (this.prof.equals(String.valueOf(warr))) {
            //DK attack set
            this.attackMin = (short) (this.str / 6);
            this.attackMax = (short) (this.str / 4);
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }

    }
    void calcDefense() {

        //SM defense set
        if (this.prof.equals(String.valueOf(mage))) {
            this.def = (short) (this.agi / 4);
        }else if(this.prof.equals(String.valueOf(warr))) {
            this.def = (short) (this.agi / 3);
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }
    }
    void calcDefenseAndRange() {

        //ARCH Defense and Attack calc
        if(this.prof.equals(String.valueOf(arch))){
            this.def = (short) (this.agi / 10);
            this.attackMin = (short) ((this.str / 14) + (this.agi / 7));
            this.attackMax = (short) ((this.str / 8) + (this.agi / 4));
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }

    }
    void calcHealth() {

        //SM vit set
        //HP = 30+(lvl-1)+vit*2
        if (this.prof.equals(String.valueOf(mage))) {
            this.hp = (short) (30 + (this.lvl - 1) + (this.vit * 2));
        }else if (this.prof.equals(String.valueOf(warr))) {
            //DK vit set
            //HP = 35+(lvl-1)*2+vit*3
            this.hp = (short) (35 + (this.lvl - 1) * 2 + (this.vit * 3));
        }else if (this.prof.equals(String.valueOf(arch))) {
            //ARCH vit set
            //HP = 40+(lvl-1)+vit*2
            this.hp = (short) (40 + (this.lvl - 1) + this.vit * 2);
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }
    }
    void calcMana() {

             //DK ene set
        if (this.prof.equals(String.valueOf(warr))) {

            this.mp = (short) (10 + (this.lvl - 1) * 0.5 + this.ene);

        }else if (this.prof.equals(String.valueOf(arch))) {
            //ARCH ene set
            this.mp = (short) (6 + (this.lvl * 1.5) + (this.ene * 1.5));
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }

    }
    void calcManaAndMagic() {

        //MAGE Mana and MagicAttack calc
        if (this.prof.equals(String.valueOf(mage))) {
            this.attackMin = (short) (this.ene / 9);
            this.attackMax = (short) (this.ene / 4);
            this.mp = (short) ((this.lvl - 1) * 2 + (this.ene * 2));
        }else {
            throw new Error("Method: \n" + Thread.currentThread().getStackTrace()[1] + "is unavailable for: " + this.prof + "\n");
        }
    }

    public Boolean getSkills(String keyName) {
        return this.skills.get(keyName);
    }
    public void setSkills(String name, boolean key) {
        this.skills.put(name,key);
    }
    public ArrayList<String> showSkillsMap(){
        ArrayList<String> skillsList = new ArrayList<>();
        int i = 1;
        out.println("0. SINGLE MELEE ATTACK");
        for (Map.Entry<String,Boolean> entry : this.skills.entrySet()){
            String key = entry.getKey();
            Object value = entry.getValue();

            if(value.equals(true)){
                skillsList.add(key);
                out.println(i + ". " + key);
            }
            i++;
        }
        return skillsList;
    }


    public short getLvl() {
        return lvl;
    }
    public void setLvl(short lvl) {
        this.lvl = lvl;
    }
    public short getHp() {
        return hp;
    }
    public void setHp(short hp) {
        this.hp = hp;
    }
    public short getMp() {
        return mp;
    }
    public void setMp(short mp) {
        this.mp = mp;
    }
    public short getXp() {
        return xp;
    }
    public void setXp(short xp) {
        this.xp = xp;
    }
    public short getLvlPoints() {
        return lvlPoints;
    }
    public void setLvlPoints(short lvlPoints) {
        this.lvlPoints = lvlPoints;
    }
    public short getSkillPoints() {
        return skillPoints;
    }
    public void setSkillPoints(short skillPoints) {
        this.skillPoints = skillPoints;
    }
    public short getStr() {
        return str;
    }
    public void setStr(short str) {
        this.str = str;
    }
    public short getAgi() {
        return agi;
    }
    public void setAgi(short agi) {
        this.agi = agi;
    }
    public short getEne() {
        return ene;
    }
    public void setEne(short ene) {
        this.ene = ene;
    }
    public short getVit() {
        return vit;
    }
    public void setVit(short vit) {
        this.vit = vit;
    }
    public short getAttackMin() {
        return attackMin;
    }
    public void setAttackMin(short attackMin) {
        this.attackMin = attackMin;
    }
    public short getAttackMax() {
        return attackMax;
    }
    public void setAttackMax(short attackMax) {
        this.attackMax = attackMax;
    }
    public short getDef() {
        return def;
    }
    public void setDef(short def) {
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
    public short getGold() {
        return gold;
    }
    public void setGold(short gold) {
        this.gold = gold;
    }
    public short getInventory() {
        return inventory;
    }
    public void setInventory(short inventory) {
        this.inventory = inventory;
    }
}
