package com.example.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslated;
    TextView tvTranslated2;
    String Translate = "";
    String wordClicked="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslated = findViewById(R.id.textViewTranslatedText);
        tvTranslated2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslated);
        registerForContextMenu(tvTranslated2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

//        menu.add(0, 0, 0, "English");
//        menu.add(0, 1, 1, "Italian");
        getMenuInflater().inflate(R.menu.language_menu, menu);

        if(v == tvTranslated){
            wordClicked = "hello";
        } else if (v == tvTranslated2) {
            wordClicked = "bye";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.option_english) { //check whether the selected menu item ID is 0
            //code for action
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            if (wordClicked.equalsIgnoreCase("hello")) {
                Translate = "Hello";
                tvTranslated.setText(Translate);
            }
            else if(wordClicked.equalsIgnoreCase("bye")) {
                Translate = "Bye";
                tvTranslated2.setText(Translate);
            }


            return true; //menu item successfully handled

        }
        else if (item.getItemId() == R.id.option_italian) { //check if the selected menu item ID is 1
            //code for action
            Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
            if (wordClicked.equalsIgnoreCase("hello")) {
                Translate = "Ciao";
                tvTranslated.setText(Translate);

            }
            else if(wordClicked.equalsIgnoreCase("bye")){
                Translate = "Ciao";
                tvTranslated2.setText(Translate);

            }
            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}
