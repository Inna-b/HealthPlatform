package com.dimache.tests.healthplatform;

import android.graphics.Bitmap;

public class Tile {

    private Category tileCategory;
    private Bitmap graph;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public Tile(Category cat) {
        this.tileCategory = cat;
    }

    public int getNameResource() {
        return tileCategory.getNameResource();
    }

    public int getImageResource() {
        return tileCategory.getIconResource();
    }

    public int getUnitResource() {
        return tileCategory.getUnitResource();
    }

    public Bitmap getGraph() {
        return graph;
    }

    public void setGraph(Bitmap gr) {
        graph = gr;

    }


}
