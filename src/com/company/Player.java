package com.company;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class Player {

    protected byte hp;
    protected byte mp;
    protected byte str;
    protected byte agi;
    protected byte ene;
    protected byte vit;

    protected byte attackFrom;
    protected byte attackTo;

    protected String name;
    protected String selectedClass;
    protected String [] profession = {"mage","warrior","archer"};

}
