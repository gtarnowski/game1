package com.company.Engine.Player;


public class Player {

    protected byte lvl;
    protected byte hp;
    protected byte mp;

    protected byte str;
    protected byte agi;
    protected byte ene;
    protected byte vit;

    protected byte [] attack = new byte[2];
    protected byte [] attackMagic = new byte[2];

    protected byte def;

    protected String name;
    protected String selectedClass;
    protected String [] profession = {"mage","warrior","archer"};

}
