package com.company.Engine.GameSystem.Skills;

/**
 * Created by hexen on 8/16/16.
 */
public enum MageSkillSystem {
    SCREAMBALL(2,4),HATEWAVE(7,13);


    private int skillMin;
    private int skillMax;
    MageSkillSystem(int min, int max) {
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