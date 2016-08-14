package com.company.Engine;


public enum Profession {
    MAGE("mage"),WARRIOR("warr"),ARCHER("arch");

    String className;

    Profession(String prof) {
        className = prof;
    }
}
