package com.dimache.tests.healthplatform;

public enum Category {
    HEART_RATE(R.string.category_text_heartrate, R.drawable.ic_heart, R.string.category_unit_heartrate),
    WEIGHT(R.string.category_text_weight, R.drawable.ic_weight, R.string.category_unit_weight),
    HEIGHT(R.string.category_text_height, R.drawable.ic_height, R.string.category_unit_height);

    private int nameResource;
    private int iconResource;
    private int unitResource;

    private Category(int nameRes, int iconRes, int unitRes) {
        nameResource = nameRes;
        iconResource = iconRes;
        unitResource = unitRes;
    }

    public int getNameResource() {
        return nameResource;
    }

    public int getIconResource() {
        return iconResource;
    }

    public int getUnitResource() {
        return unitResource;
    }
}
