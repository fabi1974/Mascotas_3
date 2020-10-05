package com.example.mascotas1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
       
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("ALE",200,R.drawable.perro1));
        mascotas.add(new Mascota("GLORIA",160,R.drawable.perro2));
        mascotas.add(new Mascota("MAJO",160,R.drawable.perro3));
        mascotas.add(new Mascota("TIRRY",23,R.drawable.perro4));
        mascotas.add(new Mascota("PRETA",76,R.drawable.perro5));
        mascotas.add(new Mascota("OJO",2,R.drawable.perro6));


        rvMascotas = findViewById(R.id.rvMacotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(mascotaAdaptador);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mFavoritos:
                
                Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(intent);
                break;
            case R.id.mAbout:
                Toast.makeText(getApplicationContext(),"About",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}