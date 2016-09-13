package com.company.Engine.Items;

import com.company.Engine.Base.Helper;
import com.company.Engine.Player.Inventory;
import com.company.Engine.Player.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

public class ItemEvents {
    private ArrayList<Items> itemsList = new ArrayList<Items>();

    private ArrayList<Items> usefuls = new ArrayList<Items>();
    private ArrayList<Items> weapons = new ArrayList<Items>();
    private ArrayList<Items> armors = new ArrayList<Items>();
    private ArrayList<Items> quests = new ArrayList<Items>();

    private ItemType use = ItemType.useful;
    private ItemType weapon = ItemType.weapon;
    private ItemType armor = ItemType.armor;
    private ItemType quest = ItemType.quest;

    private Helper helper = new Helper();
    private Inventory inventory = new Inventory();

    public void loadItems() {
        itemsList = helper.loadItems("items.txt");
        regroupItemsByLists();
        readItemsCollection();
        initializeRandomItemGenerator();
        inventory.checkFreeInventorySpace();
    }

    private void regroupItemsByLists() {
        for (Items items : itemsList) {
            if (items.getType().equals(use.name())) {
                usefuls.add(new Items(items.getId(), items.getName(), items.getType(), items.getParams(), items.getDrop()));
            } else if (items.getType().equals(weapon.name())) {
                weapons.add(new Items(items.getId(), items.getName(), items.getType(), items.getParams(), items.getDrop()));
            } else if (items.getType().equals(armor.name())) {
                armors.add(new Items(items.getId(), items.getName(), items.getType(), items.getParams(), items.getDrop()));
            } else if (items.getType().equals(quest.name())) {
                quests.add(new Items(items.getId(), items.getName(), items.getType(), items.getParams(), items.getDrop()));
            }
        }
    }

    public void readItemsCollection() {
//        for (Items items : itemsList) {
//            out.println(items.getType());
//        }
//        for (Items items2: usefuls){
//            out.println(items2.getId());
//        }
//        for (Items items3: weapons){
//            out.println(items3.getId());
//        }
//        for (Items items4: armors){
//            out.println(items4.getId());
//        }
//        out.print(usefuls.size() + " " + weapons.size() + " " + armors.size() + " " + quests.size() + "\n");

    }

    public void initializeRandomItemGenerator() {
        Player player = new Player();
        player.setLvl((short) (1));
        if (player.getLvl() <= 5) {
            randomizeLowLvlItems(player, inventory);
        }
    }

    private void randomizeLowLvlItems(Player player, Inventory inventory) {
        Random rand = new Random();
        float randomDrop = rand.nextFloat();
        ArrayList<Short> items = new ArrayList<Short>();
        ArrayList<Short> luckyItems = new ArrayList<Short>();
        if (randomDrop >= 0.50f) {
            while (!inventory.getTempInventory()) {
                short result = 0;
                for (int i = 0; i < usefuls.size(); i++) {
                    out.println("Iterator " + i);
                    if (rand.nextInt() >= usefuls.get(i).getDrop()) {
                        result = inventory.checkFreeInventorySpace();
                        if (result != 0) {
                            out.println("My inv  " + inventory.getSlot((short) i) + " ID " + usefuls.get(i).getId());
                            luckyItems.add(usefuls.get(i).getId());
                        }
                    }

                }
                for (int i = 0; i < luckyItems.size(); i++) {
                    out.println("My items: " +luckyItems.get(i));
                }
                int index = rand.nextInt(luckyItems.size());
                out.println("Winner: " + luckyItems.get(index));
                out.println("RESULT: " + result);
                inventory.setSlot((short) (result - 1), luckyItems.get(index));
                inventory.setTempInventory(true);
            }
            out.println("FullInventory: " + Arrays.toString(inventory.getFullInventory()));
            out.println("My chance 50: " + randomDrop);
        }
        if (randomDrop >= 0.30f) {
            out.println("My chance 30: " + randomDrop);
        }
        if (randomDrop >= 0.25f) {
            out.println("My chance 25: " + randomDrop);
        }
    }
}
