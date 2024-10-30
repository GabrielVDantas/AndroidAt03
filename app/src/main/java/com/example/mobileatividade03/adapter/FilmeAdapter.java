package com.example.mobileatividade03.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileatividade03.R;
import com.example.mobileatividade03.models.Filme;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {
    private final List<Filme> filmes;
    private Context context;
    FirebaseFirestore db;

    public FilmeAdapter(List<Filme> filmes) {
        this.filmes = filmes;
        db = FirebaseFirestore.getInstance();
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilmeViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_filme, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.titulo.setText(filme.getTitulo());
        //holder.imagem.setImageResource(filme.getImagem());
        holder.diretor.setText(filme.getDiretor());
        holder.ano.setText(String.valueOf(filme.getAno()));
        holder.sinopse.setOnClickListener(view -> {
            Toast.makeText(context, filme.getSinopse(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return filmes != null ? filmes.size() : 0;
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, ano, diretor;
        ImageView imagem;
        Button sinopse;

        public FilmeViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloFilme);
            ano = itemView.findViewById(R.id.anoFilme);
            diretor = itemView.findViewById(R.id.diretorFilme);
            imagem = itemView.findViewById(R.id.imagemFilme);
            sinopse = itemView.findViewById(R.id.buttonSinopse);
        }
    }
}
