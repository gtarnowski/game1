package com.company.Engine.Enemy;


public class Enemy {
    private byte lvl;
    private byte hp;

    private byte def;

    private byte attackMin;
    private byte attackMax;

    public Enemy(byte level){
        lvl = level;
        calculateAttack();
        calculateHp();
        calculateDef();
    }

    public void calculateAttack(){
        this.attackMin = (byte) (this.lvl * 3);
        this.attackMax = (byte) (this.lvl * 4);
    }
    public void calculateHp(){
        this.hp = (byte) (this.lvl * 25);
    }
    public void calculateDef(){
        this.def = (byte) (this.lvl * 1.05);
    }


    public byte getLvl() {
        return lvl;
    }


    public byte getAttackMin() {
        return attackMin;
    }



    public byte getAttackMax() {
        return attackMax;
    }


}
