package com.company.Engine.StatsModifiers;

import com.company.Engine.Enemy.Enemy;

public class EnemyStatsModifier {

    public void calculateAttack(byte lvl, byte attack[]){
        attack[0] = (byte) (lvl * 3);
        attack[1] = (byte) (lvl * 4);
    }
    public void calculateHp(byte lvl, byte hp){
        hp = (byte) (lvl * 25);
    }
    public void calculateDef(byte lvl, byte def){
        def = (byte) (lvl * 1.05);
    }
}

