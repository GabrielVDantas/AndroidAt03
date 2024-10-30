package com.example.mobileatividade03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileatividade03.adapter.FilmeAdapter;
import com.example.mobileatividade03.models.Filme;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    RecyclerView recyclerViewFilme;
    FilmeAdapter filmeAdapter;
    ArrayList<Filme> filmes;

    @Override
    protected void onResume() {
        super.onResume();
        buscaFilmes();
    }

    public void configuraRecycler(){
        filmeAdapter = new FilmeAdapter(filmes);
        recyclerViewFilme.setAdapter(filmeAdapter);

        //layout horizontal
        LinearLayoutManager layoutManager =
        new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerViewFilme.setLayoutManager(layoutManager);
        recyclerViewFilme.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        );
    }

    public void buscaFilmes() {
        filmes = new ArrayList<>();

        db.collection("filmes").get().addOnCompleteListener(
            task -> {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot doc : task.getResult()) {
                        Filme f = doc.toObject(Filme.class);
                        filmes.add(f);
                    }
                    configuraRecycler();
                }
            });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        recyclerViewFilme = findViewById(R.id.recyclerViewFilmes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}