package com.company.Engine.Player;

import static java.lang.System.out;

/**
 * Created by hexen on 9/12/16.
 */
public class Inventory {
    private short [] slot = new short[6];
    private short freeSpace = 6;
    private boolean tempInventory;

    public short[] getFullInventory(){
        return this.slot;
    }
    public short getSlot(short i) {
        short field = this.slot[i];
        return field;
    }
    public void setSlot(short i, short id){
        this.slot[i] = id;
    }

    public short getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(short freeSpace) {
        this.freeSpace = freeSpace;
    }

    public boolean getTempInventory() {
        return tempInventory;
    }

    public void setTempInventory(boolean tempInventory) {
        this.tempInventory = tempInventory;
    }
    public short checkFreeInventorySpace(){
        short index = 0;
        for (int i = 0; i < this.slot.length; i++) {
            if(this.getSlot((short) i) == 0){
                index = (short) i;
                return (short) (index + 1);
            }
        }
        return index;
    }
}
