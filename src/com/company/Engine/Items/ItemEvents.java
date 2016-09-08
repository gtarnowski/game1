package com.company.Engine.Items;

import com.company.Engine.Base.Helper;

import java.util.ArrayList;

public class ItemEvents {
    public ArrayList<Items> items = new ArrayList<Items>();

    Helper helper = new Helper();
    public void readItems(){
        helper.loadItems("items.txt");
        readObject();
    }

    public Items createItemsData(short id, String name, String type, ArrayList<Short> params, short drop) {
        Items item = new Items(id,name,type,params,drop);
        return item;

    }
    public void readObject(Items item){

    }
}
