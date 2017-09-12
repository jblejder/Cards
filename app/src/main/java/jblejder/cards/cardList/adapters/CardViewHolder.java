package jblejder.cards.cardList.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import jblejder.cards.databinding.CardViewBinding;
import jblejder.cards.shared.models.Card;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private final CardViewBinding binding;

    public CardViewHolder(CardViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setCard(Card card) {
        binding.setModel(card);
    }
}
