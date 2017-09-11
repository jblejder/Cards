package jblejder.cards.cardList.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import jblejder.cards.databinding.CardViewBinding;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private final CardViewBinding binding;

    public CardViewHolder(CardViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
