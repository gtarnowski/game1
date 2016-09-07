package com.company.Engine.Items;

import com.company.Engine.Base.Helper;

import java.util.ArrayList;

import static java.lang.System.out;

public class ItemEvents {
    public ArrayList<Items> items = new ArrayList<Items>();
    Helper helper = new Helper();
    public void readItems(){
        helper.loadItems("items.txt");
        readObject();
    }

    public void createItemsData(short id, String name, String type, short [] params, short drop) {
        Items item = new Items(id,name,type,params,drop);
            items.add(item);
    }
    public void readObject(){
        out.println(items.get(1).getName());
    }
}
