package jblejder.cards.cardList.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import jblejder.cards.R;
import jblejder.cards.cardList.adapters.CardsAdapter;
import jblejder.cards.cardList.adapters.HandsAdapter;
import jblejder.cards.cardList.misc.CardRecyclerViewItemDecorator;
import jblejder.cards.cardList.models.CardListFragmentInitModel;
import jblejder.cards.cardList.viewModels.CardListViewModel;
import jblejder.cards.databinding.CardListFragmentBinding;
import jblejder.cards.shared.framework.fragments.BaseFragment;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static jblejder.cards.shared.Constants.DATA_KEY;

public class CardListFragment extends BaseFragment<CardListFragmentBinding> {

    @Inject
    CardListViewModel viewModel;

    public static CardListFragment newInstance(CardListFragmentInitModel model) {
        String json = new Gson().toJson(model);
        Bundle bundle = new Bundle();
        bundle.putString(DATA_KEY, json);
        CardListFragment fragment = new CardListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getGlobalComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.card_list_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        String json = getArguments().getString(DATA_KEY);
        CardListFragmentInitModel model = new Gson().fromJson(json, CardListFragmentInitModel.class);
        viewModel.setSetId(model.setId);
        Disposable disposable = viewModel.loadInitialCards().subscribe();
        disposeBag.add(disposable);

        binding.drawButton.setOnClickListener(v -> disposeBag.add(viewModel.drawCard().subscribe()));

        CardsAdapter cardsAdapter = new CardsAdapter(viewModel.cards);
        binding.cardRecyclerView.addItemDecoration(new CardRecyclerViewItemDecorator());
        binding.cardRecyclerView.setAdapter(cardsAdapter);
        binding.cardRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, HORIZONTAL, false));

        HandsAdapter handsAdapter = new HandsAdapter(viewModel.hands);
        binding.cardPatternsRecyclerView.setAdapter(handsAdapter);
        binding.cardPatternsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), HORIZONTAL, false));
    }
}
