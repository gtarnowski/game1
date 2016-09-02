package com.company.Engine.Base;

/**
 * Created by hexen on 02.09.16.
 */
public class Items {
    private byte id;

    private String name;
    private String type;

    public Items(byte ID, String NAME, String TYPE){
        id = ID;
        name = NAME;
        type = TYPE;
    }

    public void loadItemsDataFromFile(){

    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
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
}
