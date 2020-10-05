package com.example.mascotas1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView rvMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        
        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       
        mascotasFavoritas = new ArrayList<Mascota>();
        mascotasFavoritas.add(new Mascota("TIRRY",23,R.drawable.perro4));
        mascotasFavoritas.add(new Mascota("ALE",200,R.drawable.perro1));
        mascotasFavoritas.add(new Mascota("GLORIA",160,R.drawable.perro2));
        mascotasFavoritas.add(new Mascota("MAJO",160,R.drawable.perro3));
        mascotasFavoritas.add(new Mascota("PRETA",76,R.drawable.perro5));

        rvMascotasFavoritas = findViewById(R.id.rvMacotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotasFavoritas);
        rvMascotasFavoritas.setAdapter(mascotaAdaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }
}