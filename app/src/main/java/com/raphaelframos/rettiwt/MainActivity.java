package com.raphaelframos.rettiwt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
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
    private static final int RC_SIGN_IN = 1231;
    private GoogleSignInClient mGoogleSignInClient;

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

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signIn();
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Toast.makeText(getApplicationContext(), "Qual é o meu nome: " + account.getDisplayName(), Toast.LENGTH_LONG).show();
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
    }
}