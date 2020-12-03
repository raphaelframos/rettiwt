package com.raphaelframos.rettiwt;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.google.firebase.firestore.FirebaseFirestore;
import com.raphaelframos.rettiwt.model.Mensagem;

import static com.raphaelframos.rettiwt.MainActivity.TWETTS;

public class NewTweetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tweet);

        AppCompatEditText editTextTexto = findViewById(R.id.edit_text_texto);
        AppCompatButton buttonPublicar = findViewById(R.id.button_publicar);

        buttonPublicar.setOnClickListener(view -> {
            String texto = editTextTexto.getText().toString();
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            Mensagem mensagem = new Mensagem("Raphael Ramos", texto, "https://img.estadao.com.br/thumbs/640/resources/jpg/9/9/1494445348599.jpg");
            db.collection(TWETTS).add(mensagem);
            db.collection(TWETTS).document("cytydfhdfhdfh").delete();
            finish();
        });
    }
}