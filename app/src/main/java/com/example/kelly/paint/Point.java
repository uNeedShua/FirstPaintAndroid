package com.example.kelly.paint;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Point{
    private float coorX;
    private float coorY;
    private int color = Color.BLACK;
    private float width = 10;

    public Point(float coorX, float coorY, int color, float width) {
        super();
        this.coorX = coorX;
        this.coorY = coorY;
        this.color = color;
        this.width = width;
    }

    public float getCoorX() {
        return coorX;
    }

    public int getColor() {
        return color;
    }

    public float getCoorY() {
        return coorY;
    }

    public float getWidth() {
        return width;
    }

}
