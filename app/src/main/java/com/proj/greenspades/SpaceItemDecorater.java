package com.proj.greenspades;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by karan on 23/11/17.
 */

public class SpaceItemDecorater extends RecyclerView.ItemDecoration {

    private final int mSpaceHeight;

    public SpaceItemDecorater(int mSpaceHeight) {
        this.mSpaceHeight = mSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = mSpaceHeight;

    }
}