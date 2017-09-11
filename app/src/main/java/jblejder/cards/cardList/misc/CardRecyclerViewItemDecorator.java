package jblejder.cards.cardList.misc;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import jblejder.cards.R;

public class CardRecyclerViewItemDecorator extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int offset = view.getResources().getDimensionPixelOffset(R.dimen.margin_medium);
        outRect.left = offset / 2;
        outRect.right = offset / 2;
    }
}
