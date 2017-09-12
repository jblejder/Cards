package jblejder.cards.cardList.adapters;

import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import jblejder.cards.databinding.HandViewBinding;
import jblejder.cards.shared.cardHandRecognition.Hand;
import jblejder.cards.shared.utils.ListChangedObserver;

public class HandsAdapter extends RecyclerView.Adapter<HandsAdapter.HandViewHolder> {

    private final ObservableList<Hand> feed;

    public HandsAdapter(ObservableList<Hand> hands) {
        this.feed = hands;
        this.feed.addOnListChangedCallback(new ListChangedObserver(this));
    }

    @Override
    public HandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        HandViewBinding binding = HandViewBinding.inflate(inflater, parent, false);
        return new HandViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(HandViewHolder holder, int position) {
        holder.setModel(feed.get(position));
    }

    @Override
    public int getItemCount() {
        return feed.size();
    }

    class HandViewHolder extends RecyclerView.ViewHolder {

        private final HandViewBinding binding;

        HandViewHolder(HandViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setModel(Hand hand) {
            binding.setModel(hand);
        }
    }
}
