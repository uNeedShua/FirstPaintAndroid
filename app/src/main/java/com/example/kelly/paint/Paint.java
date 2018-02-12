package com.example.kelly.paint;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Paint extends AppCompatActivity {

    static final int PICK_SETTINGS = 1;
    private int color;
    private float width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_paint);

        final Dessin dessin = (Dessin) findViewById(R.id.dessin);
        Button b = (Button) findViewById(R.id.settings);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Paint.this, Palette.class);
                i.putExtra("c", dessin.getC());
                i.putExtra("w",dessin.getW());
                startActivityForResult(i, PICK_SETTINGS);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final Dessin dessin = (Dessin) findViewById(R.id.dessin);

        if (requestCode == PICK_SETTINGS) {
            if (resultCode == Activity.RESULT_OK) {
                dessin.setC(data.getIntExtra("color", 255));
                dessin.setW(data.getFloatExtra("width",10));
            }
        }
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
