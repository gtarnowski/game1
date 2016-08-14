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


    public void createCharacter() throws IOException, InterruptedException {
        buildIdentity();
        buildClass();
        buildCharacter();
        buildCharacterStats();
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

        player.setLvl((byte) 1);

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

    private void buildCharacter() {
        if (player.getProf().equals(String.valueOf(mage))) {
            //Mage stats
            player.setStr((byte) 18);
            player.setAgi((byte) 18);
            player.setVit((byte) 15);
            player.setEne((byte) 30);
        }
        if (player.getProf().equals(String.valueOf(warr))) {
            //Warr stats
            player.setStr((byte) 28);
            player.setAgi((byte) 20);
            player.setVit((byte) 25);
            player.setEne((byte) 10);
        }
        if (player.getProf().equals(String.valueOf(arch))) {
            //Arch stats
            player.setStr((byte) 22);
            player.setAgi((byte) 25);
            player.setVit((byte) 20);
            player.setEne((byte) 15);
        }
    }

    private void saveCharacterData() throws IOException {
        PrintWriter writer = new PrintWriter("player.txt");

        writer.println(helper.stringToHex(player.getProf()));
        writer.println(helper.stringToHex(player.getName()));

        writer.println(helper.byteToHex(player.getLvl()));
        writer.println(helper.byteToHex(player.getHp()));
        writer.println(helper.byteToHex(player.getMp()));

        writer.println(helper.byteToHex(player.getStr()));
        writer.println(helper.byteToHex(player.getAgi()));
        writer.println(helper.byteToHex(player.getVit()));
        writer.println(helper.byteToHex(player.getEne()));

        writer.println(helper.byteToHex(player.getDef()));

        writer.println(helper.byteToHex(player.getAttackMin()));
        writer.println(helper.byteToHex(player.getAttackMax()));

        writer.close();
    }


}
