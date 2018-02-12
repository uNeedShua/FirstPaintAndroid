package com.example.kelly.paint;

import android.content.Context;
import android.graphics.*;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelly on 30/01/2018.
 */

public class Dessin extends View{

    List<Point> list = new ArrayList<Point>();
    int c =Color.BLACK;
    float w = 10;

    public Dessin(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();


        for (Point p : list) {
            paint.setColor(p.getColor());
            canvas.drawCircle(p.getCoorX(), p.getCoorY(), p.getWidth(), paint);
        }
    }


    public boolean onTouchEvent(MotionEvent event) {
        list.add(new Point(event.getX(),event.getY(),c,w));
        invalidate();
        return super.onTouchEvent(event);
    }


    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    @Override
    public Parcelable onSaveInstanceState(){
        Parcelable superSave = super.onSaveInstanceState();
        Sauvegarde savedState = new Sauvegarde(superSave);

        savedState.list = this.list;
        savedState.color = this.c;
        savedState.width = this.w;

        return savedState;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //begin boilerplate code so parent classes can restore state
        if(!(state instanceof Sauvegarde)) {
            super.onRestoreInstanceState(state);
            return;
        }

        Sauvegarde ss = (Sauvegarde) state;
        super.onRestoreInstanceState(ss.getSuperState());
        //end

        this.list = ss.list;
        this.c = ss.color;
        this.w = ss.width;
        invalidate();
    }
}
