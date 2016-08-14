package com.company.Engine.Base;

import com.company.Engine.Enemy.Enemy;
import com.company.Engine.Player.Player;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by hexen on 09.08.16.
 */
public class Begin {
    Helper helper = new Helper();

    public Player loadCharacter(){
        List<String> stats= new ArrayList<String>();
        return loadCharacterStats(stats = helper.readStats("player.txt"));
    }

    private Player loadCharacterStats(List<String> stats){
        Player player = new Player();
        player.setProf(new String ( helper.hexToString(stats.get(0))));
        player.setName(new String(helper.hexToString(stats.get(1))));

        player.setLvl(helper.hexToByte(stats.get(2)));
        player.setHp(helper.hexToByte(stats.get(3)));
        player.setMp(helper.hexToByte(stats.get(4)));

        player.setStr(helper.hexToByte(stats.get(5)));
        player.setAgi(helper.hexToByte(stats.get(6)));
        player.setVit(helper.hexToByte(stats.get(7)));
        player.setEne(helper.hexToByte(stats.get(8)));

        player.setDef(helper.hexToByte(stats.get(9)));

        player.setAttackMin(helper.hexToByte(stats.get(10)));
        player.setAttackMax(helper.hexToByte(stats.get(11)));

//        out.println("value : "
//                    + player.getProf() +
//                " " + player.getName() +
//                " " + player.getLvl()+
//                " " + player.getHp()+
//                " " + player.getMp()+
//                " " + player.getStr()+
//                " " + player.getAgi()+
//                " " + player.getVit()+
//                " " + player.getEne()+
//                " " + player.getDef()+
//                " " + player.getAttackMin()+
//                " " + player.getAttackMax()
//        );
        return player;
    }

}
