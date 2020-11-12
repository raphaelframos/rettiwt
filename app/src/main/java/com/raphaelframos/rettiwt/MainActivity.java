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

        Mensagem mensagem1 = new Mensagem("Raphael Ramos", "Flamengo minha vida", "http://br.web.img3.acsta.net/c_215_290/pictures/19/03/19/17/23/0985270.jpg");
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