package com.company.Engine.GameSystem.Skills;

/**
 * Created by Grzegorz on 2016-08-23.
 */
public enum ArcherSkillsSystem {
    FLAMESHOT(3,6),DOUBLEBOLT(7,12);

    private int skillMin;
    private int skillMax;
    ArcherSkillsSystem(int min, int max) {
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
