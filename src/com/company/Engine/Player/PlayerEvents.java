package com.company.Engine.Player;


import com.company.Engine.Base.Begin;
import com.company.Engine.Enemy.Enemy;
import com.company.Engine.GameSystem.GameSys;
import com.company.Engine.GameSystem.Skills.ArcherSkills;
import com.company.Engine.GameSystem.Skills.MageSkills;
import com.company.Engine.GameSystem.Skills.WarriorSkills;
import com.company.Engine.Profession;
import com.company.Gfx.Gfx;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class PlayerEvents{
    Gfx gfx = new Gfx();
    public void onCreatedPlayerEvents(Player player){
        Begin begin = new Begin();
        begin.loadCharacter(player);

        if(player.getProf().equals(Profession.MAGE.name())){
            MageSkills skills = new MageSkills();
            skills.setMageOnCreatedPlayerSkills(player);
        }else if(player.getProf().equals(Profession.WARRIOR.name())){
            WarriorSkills skills = new WarriorSkills();
            skills.setWarrOnCreatedPlayerSkills(player);
        }else if(player.getProf().equals(Profession.ARCHER.name())){
            ArcherSkills skills = new ArcherSkills();
            skills.setArcherOnCreatedPlayerSkills(player);
        }
    }
    public void decreasePlayerXp(Player player){
        short points =(short) Math.round( player.getXp() * 0.07);
        short decreaseXp = (short) (player.getXp() - points);
        player.setXp(decreaseXp);
        out.println("Player XP points has been decreased by " + points + " points");
    }
    public void decreasePlayerGold(Player player){
        if(player.getGold() >= 0){
            short points = (short) Math.round((player.getGold() * 0.02));
            short decreaseGold = (short) ((player.getGold()) - points);
            player.setGold(decreaseGold);
            out.println("Player GOLD has been decreased by " + points);
        }else {
            out.println("Player GOLD has been decreased by 0");
        }

    }

    public void resurrection(Player player) {
        decreasePlayerXp(player);
        decreasePlayerGold(player);
        player.calcHealth();
    }

    public void useInventory() {

    }
    public void playerSuccessFightSummary(Player player, Enemy enemy){
        short xp = calulateXpAfterMobKilling(enemy);
        player.setXp((short) (player.getXp() + xp));
        playerLevelUp(player);
    }

    private short calulateXpAfterMobKilling(Enemy enemy) {
        short xpMultipier;
        xpMultipier = (short) ((enemy.getLvl() * 5) + 45 );
        return xpMultipier;
    }
    private void playerLevelUp(Player player) {
        if ((player.getXp() >= 150) && (player.getLvl() == 1)) {
            //LEVEL UP TO 2
            player.calcHealth();
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 300) && (player.getLvl() == 2)) {
            //LEVEL UP TO 3
            player.calcHealth();
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 600) && (player.getLvl() == 3)) {
            //LEVEL UP TO 4
            player.calcHealth();
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 900) && (player.getLvl() == 4)) {
            //LEVEL UP TO 5
            player.calcHealth();
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 1500) && (player.getLvl() == 5)) {
            //LEVEL UP TO 6
            player.calcHealth();
            playerIncreaseAttribute(player);

        } else if ((player.getXp() >= 2100) && (player.getLvl() == 6)) {
            //LEVEL UP TO 7
            player.calcHealth();
            playerIncreaseAttribute(player);

        }
    }
    private void playerIncreaseAttribute(Player player){
        player.setLvl((short) (player.getLvl() + 1));
        player.setSkillPoints((short) (player.getSkillPoints() + 1));
        player.setLvlPoints((short) (player.getLvlPoints() + 5));
    }
    public void spentPlayerAdvancePoints(Player player) {
        gfx.playerPromotionMenu(player);
        Scanner scanner = new Scanner(in);
        String result = scanner.next();
        if(result.equals("1")){
            playerSpentLvlPoints(player);
        }else if(result.equals("2")){
            playerSpentSkillPoints(player);
        }else if(result.equals("3")){
            GameSys gameSys = new GameSys();
            gameSys.game(player);
        }else spentPlayerAdvancePoints(player);

    }
    public void playerSpentSkillPoints(Player player){
        if(player.getSkillPoints() !=0){
            while (player.getSkillPoints() != 0){
                if(player.getProf().equals(Profession.MAGE.name())){
                    MageSkills mageSkills = new MageSkills();
                    mageSkills.mageSkillsLearnMenu(player);
                }else if(player.getProf().equals(Profession.WARRIOR.name())){
                    WarriorSkills warriorSkills = new WarriorSkills();
                    warriorSkills.warriorSkillsLearnMenu(player);
                }else if(player.getProf().equals(Profession.ARCHER.name())){
                    ArcherSkills archerSkills = new ArcherSkills();
                    archerSkills.archerSkillsLearnMenu(player);
                }
            }
        }
    }
    public void playerSpentLvlPoints(Player player){
        if(player.getLvlPoints() != 0){
            while (player.getLvlPoints() != 0){
                gfx.showSpentPointsMenu();
                Scanner scanner = new Scanner(in);
                String result = scanner.next();
                if(Objects.equals(result, "1")){
                    player.setStr((short) (player.getStr() + 1));
                    player.setLvlPoints((short)(player.getLvlPoints() - 1));
                    if(player.getProf().equals(Profession.WARRIOR.name())){
                        player.calcMeleeAttack();
                    }
                }else if(Objects.equals(result, "2")){
                    player.setAgi((short) (player.getAgi() + 1));
                    player.setLvlPoints((short)(player.getLvlPoints() - 1));
                    if(player.getProf().equals(Profession.ARCHER.name())){
                        player.calcDefenseAndRange();
                    }else player.calcDefense();
                }else if(Objects.equals(result, "3")){
                    player.setVit((short) (player.getVit() + 1));
                    player.setLvlPoints((short)(player.getLvlPoints() - 1));
                    player.calcHealth();
                }else if(Objects.equals(result, "4")){
                    player.setEne((short) (player.getEne() + 1));
                    player.setLvlPoints((short)(player.getLvlPoints() - 1));
                    if(player.getProf().equals(Profession.MAGE.name())){
                        player.calcManaAndMagic();
                    }else player.calcMana();
                }else break;
            }
        }
    }


}