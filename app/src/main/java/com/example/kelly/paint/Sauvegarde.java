package com.example.kelly.paint;

import android.os.Parcelable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelly on 11/02/2018.
 */

public class Sauvegarde extends View.BaseSavedState {

    List<Point> list = new ArrayList<Point>();
    int color;
    float width;

    public Sauvegarde(Parcelable superState) {
        super(superState);
    }
}
