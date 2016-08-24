package com.company.Engine.GameSystem.Skills;

/**
 * Created by Grzegorz on 2016-08-23.
 */
public enum WarriorSkillsSystem {
    SLASH(1,5),SMASH(5,14);

    private int skillMin;
    private int skillMax;
    WarriorSkillsSystem(int min, int max) {
        skillMin=min;
        skillMax=max;
    }

    public int getSkillMinVal() {
        return skillMin;
    }
    public int getSkillMaxVal() {
        return skillMax;
    }
}
