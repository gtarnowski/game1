package com.company.Engine.Items;

import com.company.Engine.Base.Helper;
import com.company.Engine.Player.Inventory;
import com.company.Engine.Player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

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

    public void initializeRandomItemGenerator(Player player) {
        player.setLvl((short) (1));
        if (player.getLvl() <= 5) {
            randomizeLowLvlItems(player, inventory);
        }
    }

    private void randomizeLowLvlItems(Player player, Inventory inventory) {
        Random rand = new Random();
        float randomDrop = rand.nextFloat();

        if (randomDrop >= 0.50f) {
            out.println("1. i got lucky");
            randomizeItemsByType(usefuls);
        }
        if (randomDrop >= 0.30f) {
            out.println("2. i got lucky");
            randomizeItemsByType(weapons);
        }
        if (randomDrop >= 0.25f) {
            out.println("3. i got lucky");
            randomizeItemsByType(armors);
        }
    }

    private void randomizeItemsByType(ArrayList<Items> itemses) {
        Random rand = new Random();
        ArrayList<Short> receivedItems = new ArrayList<Short>();
        do {
            short result;
            for (Items item : itemses) {
                if (rand.nextInt() >= item.getDrop()) {
                    receivedItems.add(item.getId());
                }
            }
            if (receivedItems.size() > 0) {
                Scanner sc = new Scanner(in);
                int index = rand.nextInt(receivedItems.size());

                out.println("Enemy dropped: " + findItemNameById(receivedItems.get(index), itemses));
                out.println("Do you pick this?");

                String res = sc.next();
                if (res.equals("Y") || res.equals("y")) {
                    result = inventory.checkFreeInventorySpace();
                    if (inventory.getFreeSpace() > 0) {
                        inventory.setSlot((short) (result - 1), receivedItems.get(index));
                        inventory.setFreeSpace((short) (inventory.getFreeSpace() - 1));
                    } else {
                        out.println("You cannot pick this item. Inventory if full!");
                    }
                }
                inventory.setTempInventory(true);
            } else {
                inventory.setTempInventory(false);
            }
        } while (!inventory.getTempInventory());

    }

    private String findItemNameById(Short id, ArrayList<Items> itemses) {
        for (Items i : itemses) {
            if (id == i.getId()) {
                return i.getName();
            }
        }
        return null;
    }

}
