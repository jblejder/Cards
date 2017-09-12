package jblejder.cards.shared.utils;

import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;


public class ListChangedObserver extends ObservableList.OnListChangedCallback {

    private final RecyclerView.Adapter adapter;

    public ListChangedObserver(RecyclerView.Adapter cardsAdapter) {
        this.adapter = cardsAdapter;
    }

    @Override
    public void onChanged(ObservableList sender) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
        adapter.notifyItemRangeChanged(positionStart, positionStart + itemCount);
    }

    @Override
    public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
        adapter.notifyItemRangeInserted(positionStart, positionStart + itemCount);
    }

    @Override
    public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
        adapter.notifyItemRangeRemoved(positionStart, positionStart + itemCount);
    }
}
