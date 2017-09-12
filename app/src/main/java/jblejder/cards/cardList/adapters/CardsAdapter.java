package jblejder.cards.cardList.adapters;

import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import jblejder.cards.databinding.CardViewBinding;
import jblejder.cards.shared.models.Card;
import jblejder.cards.shared.utils.ListChangedObserver;

public class CardsAdapter extends RecyclerView.Adapter {

    private final ObservableList<Card> feed;

    public CardsAdapter(ObservableList<Card> cards) {
        this.feed = cards;
        feed.addOnListChangedCallback(new ListChangedObserver(this));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardViewBinding binding = CardViewBinding.inflate(inflater, parent, false);
        return new CardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CardViewHolder) holder).setCard(feed.get(position));
    }

    @Override
    public int getItemCount() {
        return feed.size();
    }
}
