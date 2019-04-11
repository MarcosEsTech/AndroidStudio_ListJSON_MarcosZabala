package com.example.iniciojson;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    Item item1;
    Items itemsList;
    EditText editText;
    Button button;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        textView = findViewById(R.id.mensaje);
        listView = findViewById(R.id.Lista);
        editText = findViewById(R.id.datos);
        button = findViewById(R.id.guardarDatos);

        itemsList= new Items();

        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);

        db = usdbh.getWritableDatabase();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item1 = new Item(0, editText.getText().toString());

                itemsList.addItem(item1);

                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("codigo", 0);
                nuevoRegistro.put("nombre", String.valueOf( item1 ) );
                db.insert("Items", null, nuevoRegistro);
                
                editText.setText("");

                mItemAdapter = new ItemsAdapter(MainActivity.this, R.layout.itemview, itemsList.getItemsList());

                listView.setAdapter( mItemAdapter );

                Cursor c = db.rawQuery("SELECT codigo, nombre FROM Items", null);

                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        String cod = c.getString(0);
                        String nom = c.getString(1);

                        editText.append(" " + cod + " - " + nom + "\n");
                    } while(c.moveToNext());
                }

                //json = itemsList.toJSON();
                //Log.i("gsonExample", json);
            }
        });

    }
}


