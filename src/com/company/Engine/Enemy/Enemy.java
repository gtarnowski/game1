package com.company.Engine.Enemy;


public class Enemy {
    private short lvl;
    private short hp;

    private short def;

    private short attackMin;
    private short attackMax;

    public Enemy(short level) {
        lvl = level;
        calculateAttack();
        calculateHp();
        calculateDef();
    }

    public void calculateAttack() {
        this.attackMin = (short) (this.lvl * 3);
        this.attackMax = (short) (this.lvl * 4);
    }

    public void calculateHp() {
        this.setHp((short) (this.lvl * 20));
    }

    public void calculateDef() {
        this.def = (short) (this.lvl * 1.05);
    }

    public short getHp(){
        return this.hp;
    }

    public short getDef(){
        return this.def;
    }

    public short getLvl() {
        return this.lvl;
    }


    public short getAttackMin() {
        return this.attackMin;
    }


    public short getAttackMax() {
        return this.attackMax;
    }


    public void setHp(short hp) {
        this.hp = hp;
    }
}
