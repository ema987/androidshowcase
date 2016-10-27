package com.w3ma.androidshowcase.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.w3ma.androidshowcase.R;

import java.util.Stack;

import butterknife.ButterKnife;

/**
 * Created by Emanuele on 07/11/2015.
 */
public class MainActivity extends AppCompatActivity {

    private Stack<Fragment> fragmentStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentStack = new Stack<>();
        showFragment(new ListFragment(), true);
    }

    @Override
    public void onBackPressed() {
        fragmentStack.pop();
        if (fragmentStack.size() == 0) {
            super.onBackPressed();
        } else {
            showFragment(fragmentStack.lastElement(), false);
        }
    }

    public void showFragment(Fragment fragment, boolean addToStack) {
        if (addToStack) {
            fragmentStack.push(fragment);
        }
        getFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();
    }

}
