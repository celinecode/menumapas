package com.example.menumapas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridView = findViewById(R.id.grid_view);
        mGridView.setAdapter(new CentroAdapter(this));

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Centro centro = (Centro) parent.getItemAtPosition(position);
                // Launch MapActivity and pass the selected museum position as an extra
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    intent.putExtra("selectedMuseumName", centro.getName());
                    startActivity(intent);
            }
        });
    }
}
