package com.dumichelle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.Rectangle;

public class drawView extends View {
    Paint p = new Paint();
    int y = 0;
    int dY = 5;
    public drawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.BLUE);
        //canvas.drawCircle(100, 100, (float)10.5, new Paint());
        //canvas.drawCircle(100, 200, 130.5f, new Paint());

        //sky
        Paint sky = new Paint();
        sky.setColor(Color.rgb(153, 255, 255));
        canvas.drawRect(0, 0, 800, 1000, sky);


        //grass
        Paint grass = new Paint();
        grass.setColor(Color.rgb(51, 204, 51));
        canvas.drawRect(0, 600, 800, 1200, grass);


        //tree
        Paint trunk = new Paint();
        trunk.setColor(Color.rgb(153, 102, 0));

        //yellow tree
        Paint yellowtree = new Paint();
        yellowtree.setColor(Color.rgb(255, 255, 77));
        canvas.drawRect(400, 350, 440, 600, trunk);
        canvas.drawOval(300, 0, 540, 410, yellowtree);

        //orange tree
        Paint orangetree = new Paint();
        orangetree.setColor(Color.rgb(255, 133, 51));
        canvas.drawRect(490, 350, 530, 600, trunk);
        canvas.drawOval(400, 0, 600, 410, orangetree);

        //red tree
        canvas.drawRect(600, 350, 640, 600, trunk);
        Paint redtree = new Paint();
        redtree.setColor(Color.rgb(255, 102, 102));
        canvas.drawOval(500, 0, 750, 410, redtree);


        //hot chocolate mug
        Paint hotChocolate = new Paint();
        hotChocolate.setColor(Color.rgb(153, 153, 255));
        hotChocolate.setStyle(Paint.Style.FILL);
        //base of mug + top drink part
        canvas.drawRect(100, 400, 350, 650, hotChocolate);
        //bottom oval
        canvas.drawOval(100, 575 , 350, 690, hotChocolate);
        //brown part for liquid
        Paint topMug = new Paint();
        topMug.setColor(Color.rgb(153, 102, 51));
        canvas.drawOval(100, 375 , 350, 425, topMug);
        //mug handle
        canvas.drawRect(350, 500, 425, 625, hotChocolate);
        Paint transparentMugHandle = new Paint();
        //mug handle space
        transparentMugHandle.setColor(Color.rgb(153, 255, 255));
        canvas.drawRect(350, 525, 400,600, transparentMugHandle);
        //zigzags for smoke
        int count = 0;
        Paint smoke = new Paint();
        smoke.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            canvas.drawLine(100+count, 250, 125+count, 275, smoke);
            canvas.drawLine(125+count, 275, 100+count, 325, smoke);
            canvas.drawLine(100+count, 325,125+count, 350, smoke);
            count+=50;
        }
        //marshmallows
        Paint white = new Paint();
        white.setColor(Color.WHITE);
        canvas.drawRoundRect(150, 395, 180, 415, 400, 400, white);
        canvas.drawRoundRect(290, 390, 315, 410, 400, 400, white);
        canvas.drawRoundRect(220, 400, 250, 420, 400, 400, white);
        //sign
        canvas.drawText("Happy Fall:)", 200, 540, smoke);

        //pumpkin
        Paint pumpkin = new Paint();
        pumpkin.setColor(Color.rgb(255, 153, 51));
        canvas.drawOval(300, 700, 700, 925, pumpkin);
        Paint stem = new Paint();
        stem.setColor(Color.rgb(0, 153, 51));
        canvas.drawRect(475, 650 , 515, 700, stem);

        //face
        Paint lantern = new Paint();
        lantern.setColor(Color.BLACK);
        canvas.drawRoundRect(410, 760, 460, 780, 425, 770, lantern);
        canvas.drawRoundRect(550, 760, 600, 780, 575, 770, lantern);
        //canvas.drawRect(410, 760, 460, 780, lantern);
        //canvas.drawRect(550, 760, 600, 780, lantern);
        canvas.drawOval(425, 825, 575, 870, lantern);

        //acorn 1
        Paint acorn = new Paint();
        acorn.setColor(Color.rgb(217, 177, 140));

        Paint topAcorn = new Paint(); //for both this and stem
        topAcorn.setColor(Color.rgb(115, 75, 38));
        //body
        canvas.drawCircle(250, 850, 35, acorn);
        //top
        canvas.drawRect(210, 810, 295, 840, topAcorn);
        //stem
        canvas.drawRect(245, 780, 255, 810, topAcorn);

        //acorn 2
        int addy = 50;
        int addx = 100;
        canvas.drawCircle(250 + addx, 850+addy, 35, acorn);
        //top
        canvas.drawRect(210+ addx, 810+addy, 295+ addx, 840+addy, topAcorn);
        //stem
        canvas.drawRect(245+ addx, 780+addy, 255+ addx, 810+addy, topAcorn);

        //leaves falling
        Paint purpleTree = new Paint();
        purpleTree.setColor(Color.rgb(255, 153, 255));

        int addedx = 0;
        //first wave
        for (int x = 0; x < 4; x++) {
            canvas.drawOval(10 + addedx, 10 + y, 35 + addedx, 42 + y, yellowtree);
            canvas.drawOval(65 + addedx, 10 + y, 85 + addedx, 42 + y, orangetree);
            canvas.drawOval(110 + addedx, 10 + y, 135 + addedx, 42 + y, redtree);
            canvas.drawOval(160 + addedx, 10 + y, 185 + addedx, 42 + y, purpleTree);
            addedx += 210;
        }
        y += dY;
        y%=getHeight();
        invalidate();
    }
}
