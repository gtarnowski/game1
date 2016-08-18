package com.company.Engine.Player;


import com.company.Engine.Base.Begin;
import com.company.Engine.Base.Helper;
import com.company.Engine.Profession;
import com.company.Gfx.Gfx;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class BuildPlayer extends Player {


    private Player player = new Player();
    private Gfx gfx = new Gfx();
    private Begin begin = new Begin();
    private Helper helper = new Helper();
    private Profession mage = Profession.MAGE;
    private Profession warr = Profession.WARRIOR;
    private Profession arch = Profession.ARCHER;
    private PlayerEvents events = new PlayerEvents();

    public void createCharacter() throws IOException, InterruptedException {
        buildIdentity();
        buildClass();
        buildCharacter();
        buildCharacterStats();
        buildSkills(events);
        try {
            saveCharacterData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gfx.drawCharacterSelection();

    }

    private void buildCharacterStats() {
        if (player.getProf().equals(String.valueOf(mage))) {
            //Mage stats
            player.calcHealth();
            player.calcDefense();
            player.calcManaAndMagic();
        }
        if (player.getProf().equals(String.valueOf(warr))) {
            //Warr stats
            player.calcMeleeAttack();
            player.calcDefense();
            player.calcHealth();
            player.calcMana();
        }
        if (player.getProf().equals(String.valueOf(arch))) {
            //Arch stats
            player.calcDefenseAndRange();
            player.calcHealth();
            player.calcMana();
        }
    }

    private void buildIdentity() {
        Scanner sc = new Scanner(in);

        player.setLvl((short) 1);

        out.println("Enter player name: ");
        player.setName(sc.next());


    }

    private void buildClass() {
        int result;
        Scanner sc = new Scanner(in);
        gfx.drawClassChoose();
        result = sc.nextInt();

        try {
            if (result == 1) {
                player.setProf(String.valueOf(mage));
            } else if (result == 2) {
                player.setProf(String.valueOf(warr));
            } else if (result == 3) {
                player.setProf(String.valueOf(arch));
            } else {
                out.println("Select correct number of class!");
                buildClass();
            }
        } catch (InputMismatchException ex ) {
            out.println("Select class using digits!");
            buildClass();
        }

    }

    private void buildSkills(PlayerEvents events){
//        events.skillsSystem(player);
    }

    private void buildCharacter() {
        if (player.getProf().equals(String.valueOf(mage))) {
            //Mage stats
            player.setStr((short) 18);
            player.setAgi((short) 18);
            player.setVit((short) 15);
            player.setEne((short) 30);
        }
        if (player.getProf().equals(String.valueOf(warr))) {
            //Warr stats
            player.setStr((short) 28);
            player.setAgi((short) 20);
            player.setVit((short) 25);
            player.setEne((short) 10);
        }
        if (player.getProf().equals(String.valueOf(arch))) {
            //Arch stats
            player.setStr((short) 22);
            player.setAgi((short) 25);
            player.setVit((short) 20);
            player.setEne((short) 15);
        }
    }

    private void saveCharacterData() throws IOException {
        PrintWriter writer = new PrintWriter("player.txt");

        writer.println(helper.stringToHex(player.getProf()));
        writer.println(helper.stringToHex(player.getName()));

        writer.println(helper.byteToHex((byte) player.getLvl()));
        writer.println(helper.byteToHex((byte) player.getHp()));
        writer.println(helper.byteToHex((byte) player.getMp()));

        writer.println(helper.byteToHex((byte) player.getStr()));
        writer.println(helper.byteToHex((byte) player.getAgi()));
        writer.println(helper.byteToHex((byte) player.getVit()));
        writer.println(helper.byteToHex((byte) player.getEne()));

        writer.println(helper.byteToHex((byte) player.getDef()));

        writer.println(helper.byteToHex((byte) player.getAttackMin()));
        writer.println(helper.byteToHex((byte) player.getAttackMax()));

        writer.close();
    }


}
