package com.company.Engine.Items;


public class Items {
    private short id;
    private short drop;
    private short [] params;

    private String name;
    private String type;

    public Items(short ID, String NAME, String TYPE, short []PARAMS, short DROP) {
        id = ID;
        name = NAME;
        type = TYPE;
        params [0]= PARAMS[0];
        params [1]= PARAMS[1];
        drop = DROP;
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

    public short[] getParams() {
        return params;
    }

    public void setParams(short []params, short i, short j) {
        this.params[i] = params[j];
    }
}
