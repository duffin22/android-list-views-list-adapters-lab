package com.genassembly.dotdashdot.listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MadLibs> libs = new ArrayList<>();
        libs.add(new MadLibs("AM LabExample", 100, 6));


        ListView listy = (ListView) findViewById(R.id.mainList);

        SimpleAdapter adapty = new SimpleAdapter(this, libs);

        if (listy != null) {
            listy.setAdapter(adapty);
        }
    }
}
