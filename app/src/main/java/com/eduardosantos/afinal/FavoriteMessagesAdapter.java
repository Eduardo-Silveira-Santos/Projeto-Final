package com.eduardosantos.afinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteMessagesAdapter extends RecyclerView.Adapter<FavoriteMessagesAdapter.ViewHolder> {

    private List<String> favoriteMessages;
    private OnMessageClickListener clickListener;

    public FavoriteMessagesAdapter(List<String> favoriteMessages, OnMessageClickListener clickListener) {
        this.favoriteMessages = favoriteMessages;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_message, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String message = favoriteMessages.get(position);
        holder.messageTextView.setText(message);

        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onMessageClick(message);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteMessages.size();
    }

    public void updateFavoriteMessages(List<String> newFavoriteMessages) {
        favoriteMessages.clear();
        favoriteMessages.addAll(newFavoriteMessages);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
        }
    }

    public interface OnMessageClickListener {
        void onMessageClick(String message);
    }
}
