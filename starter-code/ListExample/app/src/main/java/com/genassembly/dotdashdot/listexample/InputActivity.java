package com.genassembly.dotdashdot.listexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    EditText adj1,adj2,noun1,noun2,animal,game;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // get access to editText and button
        adj1 = (EditText) this.findViewById(R.id.adjective1_edittext);
        adj2 = (EditText) this.findViewById(R.id.adjective2_edittext);
        noun1 = (EditText) this.findViewById(R.id.noun1_edittext);
        noun2 = (EditText) this.findViewById(R.id.noun2_edittext);
        animal = (EditText) this.findViewById(R.id.animals_edittext);
        game = (EditText) this.findViewById(R.id.game_edittext);


        button = (Button) this.findViewById(R.id.MainButton);

        // send text to the subActivity when user clicks

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MAIN","button clicked");
                // create an Intent
                // *'this' used to refer to this instance of the class
                Intent intent = new Intent(InputActivity.this,ResultActivity.class);

                // get string values from edit texts
                String ad1=adj1.getText().toString();
                String ad2=adj2.getText().toString();
                String no1=noun1.getText().toString();
                String no2=noun2.getText().toString();
                String an=animal.getText().toString();
                String ga=game.getText().toString();

                //put extra info to intent
                intent.putExtra("adj1",ad1);
                intent.putExtra("adj2",ad2);
                intent.putExtra("noun1",no1);
                intent.putExtra("noun2",no2);
                intent.putExtra("animals",an);
                intent.putExtra("game",ga);


                // start subActivity with that Intent
                startActivity(intent);
            }
        });
    }
}
