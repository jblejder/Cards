package jblejder.cards;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jblejder.cards.cardList.fragments.CardListFragment;
import jblejder.cards.cardList.models.CardListFragmentInitModel;
import jblejder.cards.chooseCount.ChooseCountFragmentDelegate;
import jblejder.cards.chooseCount.fragments.ChooseCountFragment;
import jblejder.cards.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity implements ChooseCountFragmentDelegate {

    MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(binding.container.getId(), new ChooseCountFragment());
        ft.commit();
    }

    @Override
    public void newCardSetCreated(String id) {
        CardListFragmentInitModel arg = new CardListFragmentInitModel(id);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(binding.container.getId(), CardListFragment.newInstance(arg));
        ft.addToBackStack(null);
        ft.commit();
    }
}
