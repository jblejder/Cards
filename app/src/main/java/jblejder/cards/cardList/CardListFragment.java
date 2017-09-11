package jblejder.cards.cardList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import jblejder.cards.R;
import jblejder.cards.cardList.adapters.CardsAdapter;
import jblejder.cards.databinding.CardListFragmentBinding;
import jblejder.cards.shared.framework.fragments.BaseFragment;

public class CardListFragment extends BaseFragment<CardListFragmentBinding> {

    public static CardListFragment newInstance() {
        return new CardListFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.card_list_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        CardsAdapter cardsAdapter = new CardsAdapter();
        binding.cardRecyclerView.addItemDecoration(new CardRecyclerViewItemDecorator());
        binding.cardRecyclerView.setAdapter(cardsAdapter);
        binding.cardRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        cardsAdapter.notifyDataSetChanged();
    }
}
