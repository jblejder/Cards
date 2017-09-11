package jblejder.cards.shared.framework.fragments;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.test.mock.MockApplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jblejder.cards.GlobalApplication;
import jblejder.cards.shared.dagger.GlobalComponent;

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    public T binding;

    public abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        return binding.getRoot();
    }

    public GlobalComponent getGlobalComponent() {
        return ((GlobalApplication) getActivity().getApplication()).getComponent();
    }
}
