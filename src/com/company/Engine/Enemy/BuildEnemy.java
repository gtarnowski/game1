package com.company.Engine.Enemy;

import com.company.Engine.StatsModifiers.EnemyStatsModifier;

/**
 * Created by hexen on 09.08.16.
 */
public class BuildEnemy extends  Enemy{
    Enemy enemy = new Enemy();
    EnemyStatsModifier statsModifier = new EnemyStatsModifier();

    public void initializeEnemy(){
       statsModifier.calculateAttack(enemy.lvl,enemy.attack);
       statsModifier.calculateHp(enemy.lvl,enemy.hp);
       statsModifier.calculateDef(enemy.lvl,enemy.def);
    }
}
