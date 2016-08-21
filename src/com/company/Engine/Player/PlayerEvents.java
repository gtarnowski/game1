package com.company.Engine.Player;


import com.company.Engine.Base.Begin;
import com.company.Engine.GameSystem.Skills.MageSkillSystem;
import com.company.Engine.GameSystem.Skills.MageSkills;
import com.company.Engine.Profession;
import com.sun.org.apache.xpath.internal.functions.FuncContains;

import java.util.*;

import static java.lang.System.out;

public class PlayerEvents{
    public void onCretedPlayerEvents(Player player){
        Begin begin = new Begin();
        player = begin.loadCharacter();
        if(player.getProf().equals(Profession.MAGE.name())){
            MageSkills skills = new MageSkills();
            skills.setMageOnCreatedPlayerSkills(player);
        }else if(player.getProf().equals(Profession.WARRIOR.name())){
            //TODO: SAME;
        }else if(player.getProf().equals(Profession.ARCHER.name())){
            //TODO: SAME;
        }
    }
}