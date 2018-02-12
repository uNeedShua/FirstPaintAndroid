package com.example.kelly.paint;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Palette extends AppCompatActivity {
    private int c;
    private float w;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button b = (Button) findViewById(R.id.b);
        Spinner s = (Spinner) findViewById(R.id.spinner);
        final EditText width = (EditText) findViewById(R.id.width);
        final String[] name_color = {"Black", "Blue", "Cyan", "Light Gray", "Gray", "Dark Gray", "Green", "Magenta", "Red", "White", "Yellow"};
        final int[] value_color = {Color.BLACK, Color.BLUE, Color.CYAN, Color.LTGRAY, Color.GRAY, Color.DKGRAY, Color.GREEN, Color.MAGENTA, Color.RED, Color.WHITE, Color.YELLOW};

        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, name_color);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adp1);

        width.setText("" + w);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            c = extras.getInt("c");
            w = extras.getFloat("w");
        }


        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                for (int j = 0; j < value_color.length; j++) {
                    if (j == i) c = value_color[j];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //rien ne se passe
            }
        });

        width.setText("" + w);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (width.getText().toString().length() > 0) {
                    w = Float.parseFloat(width.getText().toString());
                }

                Intent i = new Intent();
                i.putExtra("color", c);
                i.putExtra("width", w);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
    }

}
