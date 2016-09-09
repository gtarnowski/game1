package com.company.Engine.Items;


import java.util.ArrayList;

public class Items {
    private short id;
    private short drop;
    private ArrayList<Short> params;

    private String name;
    private String type;

    public Items(short ID, String NAME, String TYPE, ArrayList<Short>PARAMS, short DROP) {
        this.id = ID;
        this.name = NAME;
        this.type = TYPE;
        this.drop = DROP;
        this.params = PARAMS;
    }

    public void loadItemsDataFromFile() {

    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getDrop() {
        return drop;
    }

    public void setDrop(short drop) {
        this.drop = drop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public ArrayList<Short> getParams() {
        return params;
    }

    public void setParams(ArrayList<Short> params) {
        this.params = params;
    }
}
