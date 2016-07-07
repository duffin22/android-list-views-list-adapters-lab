package com.genassembly.dotdashdot.listexample;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mauve3 on 7/7/16.
 */
public class SimpleAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<MadLibs> libs;
    private final Context context;

    public SimpleAdapter(Context context, ArrayList<MadLibs> libs) {
        //super();
        inflater = LayoutInflater.from(context);
        this.libs = libs;
        this.context=context;
    }

    @Override
    public int getCount() {
        return libs.size();
    }

    @Override
    public Object getItem(int position) {
        return libs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View child, ViewGroup parent) {

        Log.d("Postion: " , "" + position);

        View v = child;
        TextView words, genre, spaces;

        if (v == null) {
            v = inflater.inflate(R.layout.list_item, parent, false);
        }

        words = (TextView) v.findViewById(R.id.numWords);
        genre = (TextView) v.findViewById(R.id.genre);
        spaces = (TextView) v.findViewById(R.id.numSpaces);

        words.setText(String.valueOf(libs.get(position).getWords()));
        genre.setText(String.valueOf(libs.get(position).getGenre()));
        spaces.setText(String.valueOf(libs.get(position).getSpaces()));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("Adaptor","Clicked "+position);
                Intent intent = new Intent(context.getApplicationContext(),InputActivity.class);

                context.startActivity(intent);
            }
        });

        return v;
    }
}
