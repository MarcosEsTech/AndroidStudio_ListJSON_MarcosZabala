package com.example.iniciojson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ItemsAdapter mItemAdapter;
    TextView textView;
    String json;
    Item item1 /*, item2, item3*/;
    Items itemsList;
    EditText editText;
    Button button;



    //refactorizar como ArrayList
    /*
    Item items[]= new Item[]{
            new Item(0, "Hola"),
            new Item(0, "Adiós"),
            new Item(0, "Buenas tardes"),
            new Item(0, "¿Qué tal?"),
            new Item(0, "PAPAPAPA"),
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        textView = findViewById(R.id.mensaje);
        listView = findViewById(R.id.Lista);
        editText = findViewById(R.id.datos);
        button = findViewById(R.id.guardarDatos);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item1 = new Item(0, editText.getText().toString());

                itemsList= new Items();
                itemsList.addItem(item1);

                editText.setText("");

                mItemAdapter = new ItemsAdapter(MainActivity.this, R.layout.itemview, itemsList.getItemsList());

                listView.setAdapter( mItemAdapter );

                //json = itemsList.toJSON();
                //Log.i("gsonExample", json);
            }
        });

        /*
        item1 = new Item(0, "dir1");
        item2 = new Item(0,"dir2");
        item3 = new Item(0,"dir3");faa

        itemsList= new Items();
        itemsList.addItem(item1);
        itemsList.addItem(item2);
        itemsList.addItem(item3);
        */

        /*

        for(int i=0; i<3 itemsList.length ;i++){
            mItemAdapter = new ItemsAdapter(this, R.layout.itemview, itemsList[]);
        }

        listView.setAdapter( mItemAdapter );

        json = itemsList.toJSON();
        Log.i("gsonExample", json);

        */

    }
}
