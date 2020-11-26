package com.raphaelframos.rettiwt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.raphaelframos.rettiwt.adapter.FeedAdapter;
import com.raphaelframos.rettiwt.model.Mensagem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TWETTS= "twetts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.floating_add);
        RecyclerView recyclerViewFeed = findViewById(R.id.recycler_view_feed);
        recyclerViewFeed.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFeed.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        FeedAdapter adapter = new FeedAdapter();
        recyclerViewFeed.setAdapter(adapter);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection(TWETTS).addSnapshotListener((value, error) -> {
            adapter.update(value.toObjects(Mensagem.class));
        });

        fab.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, NewTweetActivity.class)));

    }
}