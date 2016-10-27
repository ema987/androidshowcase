package com.w3ma.androidshowcase.util;

import android.view.View;

/**
 * Created by Emanuele on 08/11/2015.
 */
public interface CustomRecyclerItemClickListener<T> {
    void recyclerViewItemClicked(View view, int position, T item);
}
