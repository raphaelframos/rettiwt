package com.raphaelframos.rettiwt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.raphaelframos.rettiwt.R;
import com.raphaelframos.rettiwt.model.Mensagem;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    private ArrayList<Mensagem> mensagens;

    public FeedAdapter(ArrayList<Mensagem> mensagens){
        this.mensagens = mensagens;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_feed, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        holder.set(mensagens.get(position));
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    class FeedViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView textViewNome, textViewMensagem;
        private AppCompatImageView imageViewFoto;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMensagem = itemView.findViewById(R.id.text_view_mensagem);
            textViewNome = itemView.findViewById(R.id.text_view_nome);
            imageViewFoto = itemView.findViewById(R.id.image_view_foto);
        }

        public void set(Mensagem mensagem) {
            textViewNome.setText(mensagem.getNome());
            textViewMensagem.setText(mensagem.getMensagemInvertida());
        }
    }
}
