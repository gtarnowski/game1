package com.company.Engine.Enemy;

/**
 * Created by hexen on 09.08.16.
 */
public class BuildEnemy extends  Enemy{
    Enemy enemy = new Enemy();
    EnemyStatsBuilder enemyStatsBuilder = new EnemyStatsBuilder();

    public void initializeEnemy(){
        enemyStatsBuilder.calculateAttack(enemy);
        enemyStatsBuilder.calculateHp(enemy);
        enemyStatsBuilder.calculateDef(enemy);

    }
}
