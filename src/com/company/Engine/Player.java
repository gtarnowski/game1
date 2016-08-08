package com.company.Engine;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


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
