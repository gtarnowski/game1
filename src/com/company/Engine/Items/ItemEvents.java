package com.company.Engine.Items;

import com.company.Engine.Base.Helper;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.System.out;

public class ItemEvents {
    private ArrayList<Items> itemsList = new ArrayList<Items>();
    private Helper helper = new Helper();
    public void loadItems(){
        itemsList = helper.loadItems("items.txt");
        readItemsCollection();
    }

    public void readItemsCollection(){
        for (Items items : itemsList) {
            out.println(items.getType());
        }

    }
}
