package com.company;

import com.company.Engine.Base.Begin;
import com.company.Engine.Base.Start;
import com.company.Engine.GameSystem.Fight;

import java.util.Random;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Start start = new Start();
        start.newGame();

        Begin begin = new Begin();
        begin.readStats();
    }

}
