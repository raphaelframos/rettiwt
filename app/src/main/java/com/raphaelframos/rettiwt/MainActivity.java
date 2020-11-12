package com.raphaelframos.rettiwt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.raphaelframos.rettiwt.adapter.FeedAdapter;
import com.raphaelframos.rettiwt.model.Mensagem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewFeed = findViewById(R.id.recycler_view_feed);
        recyclerViewFeed.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFeed.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        Mensagem mensagem1 = new Mensagem("Raphael Ramos", "Flamengo minha vida", "https://f.i.uol.com.br/fotografia/2018/07/26/15326245925b59fed0b9748_1532624592_3x2_md.jpg");
        Mensagem mensagem2 = new Mensagem("Rodolfo", "Olá, tudo bem?", "https://static.sbt.com.br/noticias/images/142774.jpg");
        ArrayList<Mensagem> mensagens = new ArrayList<>();
        mensagens.add(mensagem1);
        mensagens.add(mensagem2);
        mensagens.add(mensagem1);
        mensagens.add(mensagem2);
        mensagens.add(mensagem1);
        mensagens.add(mensagem2);
        mensagens.add(mensagem1);
        mensagens.add(mensagem2);
        mensagens.add(mensagem1);
        mensagens.add(mensagem2);

        FeedAdapter adapter = new FeedAdapter(mensagens);
        recyclerViewFeed.setAdapter(adapter);

    }
}