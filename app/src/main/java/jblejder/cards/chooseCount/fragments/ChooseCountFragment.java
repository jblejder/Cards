package jblejder.cards.chooseCount.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import jblejder.cards.R;
import jblejder.cards.chooseCount.viewModels.ChooseCountViewModel;
import jblejder.cards.databinding.ChooseCountFragmentBinding;
import jblejder.cards.shared.framework.fragments.BaseFragment;

public class ChooseCountFragment extends BaseFragment<ChooseCountFragmentBinding> {

    @Inject
    ChooseCountViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.choose_count_fragment;
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
    }
}
