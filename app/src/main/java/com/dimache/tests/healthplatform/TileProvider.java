package com.dimache.tests.healthplatform;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TileProvider {
    private Context context;
    public List<Tile> getAllTiles(Context ctx) {
        context = ctx;
        List<Tile> items = new ArrayList<>();
        for (Category c : Category.values()) {
            Tile t = new Tile(c);


            //TODO: here we will load all values from DB/Web etc
            t.setValue(new Random().nextInt(200));
            t.setGraph(generateRandomGraph());



            items.add(t);
        }

        return items;
    }

    //TODO: JUST for test purposes!!!!!!!
    private Bitmap generateRandomGraph() {
        Bitmap bitmap = Bitmap.createBitmap(dip2px(100), dip2px(20), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        p.setStrokeWidth(5);
        int prevValue = 10;
        int curValue = 10;
        for (int i=0; i<100; i+=5) {
            curValue =  new Random().nextInt(5) - 2 + prevValue;
            if (curValue <0) curValue = 0;
            if (curValue >20) curValue = 20;
            canvas.drawLine(dip2px(i), dip2px(prevValue), dip2px(i+5), dip2px(curValue), p);
            prevValue = curValue;
        }


        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.rgb(61, 61, 61));
        paint.setTextSize(dip2px(16));
        paint.setShadowLayer(1f, 0f, 1f, Color.BLUE);
        String txt= curValue > 12 ? "Hmmm..." : curValue < 8 ? "Great!" : "Good";
        Rect bounds = new Rect();
        paint.getTextBounds(txt, 0, txt.length(), bounds);
        int x = (bitmap.getWidth() - bounds.width())/2;
        int y = (bitmap.getHeight() + bounds.height())/2 + dip2px(3);
        canvas.drawText(txt, x, y, paint);
        return bitmap;
    }

    private int dip2px(int dipSize) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int px = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipSize, dm));
        return px;
    }
}
