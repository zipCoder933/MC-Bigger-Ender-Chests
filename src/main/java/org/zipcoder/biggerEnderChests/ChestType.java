package org.zipcoder.biggerEnderChests;

public enum ChestType {
    DIAMOND(3),
    EMERALD(3+6),
    NETHERITE(3+6+6+6);

    private final int extraSlots;

    ChestType(int extraSlots) {
        this.extraSlots = extraSlots;
    }

    public int getExtraSlots() {
        return extraSlots;
    }
}
