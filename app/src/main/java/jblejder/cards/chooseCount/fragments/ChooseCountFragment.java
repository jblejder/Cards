package jblejder.cards.chooseCount.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jblejder.cards.R;
import jblejder.cards.chooseCount.ChooseCountFragmentDelegate;
import jblejder.cards.chooseCount.viewModels.ChooseCountViewModel;
import jblejder.cards.databinding.ChooseCountFragmentBinding;
import jblejder.cards.shared.api.NewSetResponse;
import jblejder.cards.shared.framework.fragments.BaseFragment;

public class ChooseCountFragment extends BaseFragment<ChooseCountFragmentBinding> {

    @Inject
    ChooseCountViewModel viewModel;

    ChooseCountFragmentDelegate delegate;

    @Override
    public int getLayoutId() {
        return R.layout.choose_count_fragment;
    }

    @Override
    public void onAttach(Context context) {
        delegate = ((ChooseCountFragmentDelegate) getActivity());
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getGlobalComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        binding.setModel(viewModel);
        observe();
    }

    private void observe() {
        binding.lessButton.setOnClickListener(v -> viewModel.decrement());
        binding.moreButton.setOnClickListener(v -> viewModel.increment());
        binding.startButton.setOnClickListener(v -> selectDeckCount());
    }

    private void selectDeckCount() {
        Disposable disposable = viewModel.selectSetSize()
                .subscribe(newSetResponse -> {
                    delegate.newCardSetCreated(newSetResponse.deckId);
                });
        disposeBag.add(disposable);
    }
}
