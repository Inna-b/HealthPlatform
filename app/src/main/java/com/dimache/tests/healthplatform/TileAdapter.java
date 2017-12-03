package com.dimache.tests.healthplatform;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;

public class TileAdapter extends BaseAdapter {

    final int[] bckgndColors = {R.color.paleBlue, R.color.paleRed, R.color.paleGreen};

    private LayoutInflater layoutinflater;
    private List<Tile> tilesStorage;
    private Context context;

    public TileAdapter(Context context, List<Tile> customizedListView) {
        this.context = context;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        tilesStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return tilesStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View tileView, ViewGroup parent) {
        Resources r = this.context.getResources();
        ViewHolder holder;
        if(tileView == null){
            holder = new ViewHolder();
            tileView = layoutinflater.inflate(R.layout.tile, parent, false);
            holder.tileBaseInList= (RelativeLayout) tileView.findViewById(R.id.tileBase);
            holder.tileNameInListView = (TextView)tileView.findViewById(R.id.categoryName);
            holder.iconInListView = (ImageView)tileView.findViewById(R.id.iconView);
            holder.graphInListView = (ImageView)tileView.findViewById(R.id.graphView);
            holder.valueInListView = (TextView)tileView.findViewById(R.id.valueTxt);
            tileView.setTag(holder);
        }else{
            holder = (ViewHolder)tileView.getTag();
        }

        Tile currTile = tilesStorage.get(position);
        holder.tileBaseInList.setBackgroundColor(r.getColor(bckgndColors[position%3])); // just for fun
        holder.tileNameInListView.setText(r.getString(currTile.getNameResource()));
        holder.iconInListView.setImageResource(currTile.getImageResource());
        holder.graphInListView.setImageDrawable(new BitmapDrawable(r, currTile.getGraph()));
        holder.valueInListView.setText("" + currTile.getValue() + " " + r.getString(currTile.getUnitResource()));

        return tileView;
    }

    static class ViewHolder{
        RelativeLayout tileBaseInList;
        TextView tileNameInListView;
        ImageView iconInListView;
        ImageView graphInListView;
        TextView valueInListView;
    }

}