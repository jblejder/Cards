package jblejder.cards.shared.framework.binding;

import android.databinding.BindingAdapter;
import android.view.View;

public class ViewBindingAdapter {

    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.INVISIBLE);
    }

    @BindingAdapter("exist")
    public static void setVisibilityGone(View view, boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.GONE);
    }
}
