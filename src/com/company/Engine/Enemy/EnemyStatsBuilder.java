package com.company.Engine.Enemy;

public class EnemyStatsBuilder {


    protected void calculateAttack(Enemy obj){
        obj.attack[0] = (byte) (obj.lvl * 3);
        obj.attack[1] = (byte) (obj.lvl * 4);
    }
    protected void calculateHp(Enemy obj){
        obj.hp = (byte) (obj.lvl * 25);
    }
    protected void calculateDef(Enemy obj){
        obj.def = (byte) (obj.lvl * 1.05);
    }
}

