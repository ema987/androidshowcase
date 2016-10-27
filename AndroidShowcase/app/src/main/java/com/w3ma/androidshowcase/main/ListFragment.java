package com.w3ma.androidshowcase.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.w3ma.androidshowcase.R;
import com.w3ma.androidshowcase.autohidekeyboard.AutoHideKeyboardFragment;
import com.w3ma.androidshowcase.linkintextview.MessageWithLinkInTextViewFragment;
import com.w3ma.androidshowcase.main.adapter.ListAdapter;
import com.w3ma.androidshowcase.main.adapter.MenuItem;
import com.w3ma.androidshowcase.spannablelinkintextview.MessageWithSpannableLinkInTextViewFragment;
import com.w3ma.androidshowcase.util.CustomRecyclerItemClickListener;
import com.w3ma.androidshowcase.util.DividerItemDecoration;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Emanuele on 07/11/2015.
 */
public class ListFragment extends Fragment {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        createMenu();
    }

    private void createMenu() {
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), R.drawable.divider_gray_line, DividerItemDecoration.VERTICAL_LIST));
        List<MenuItem> menuItemList = new LinkedList<>();
        MenuItem menuItem = new MenuItem();
        menuItem.setTitle(getString(R.string.messageWithLinkInTextViewTitle));
        menuItem.setClassName(MessageWithLinkInTextViewFragment.class);
        menuItemList.add(menuItem);
        menuItem = new MenuItem();
        menuItem.setTitle(getString(R.string.messageWithSpannableLinkInTextViewTitle));
        menuItem.setClassName(MessageWithSpannableLinkInTextViewFragment.class);
        menuItemList.add(menuItem);
        menuItem = new MenuItem();
        menuItem.setTitle(getString(R.string.autoHideKeyboardEditTextTitle));
        menuItem.setClassName(AutoHideKeyboardFragment.class);
        menuItemList.add(menuItem);
        listAdapter.setItemList(menuItemList);
        recyclerView.getAdapter().notifyDataSetChanged();

        listAdapter.setCustomRecyclerItemClickListener(new CustomRecyclerItemClickListener<MenuItem>() {
            @Override
            public void recyclerViewItemClicked(View view, int position, MenuItem item) {
                try {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.showFragment((Fragment) item.getClassName().newInstance(), true);
                } catch (Exception e) {
                    //never thrown
                }
            }
        });
    }

}
