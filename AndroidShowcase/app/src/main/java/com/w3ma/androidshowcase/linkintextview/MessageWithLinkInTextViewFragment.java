package com.w3ma.androidshowcase.linkintextview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.w3ma.androidshowcase.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Emanuele on 07/11/2015.
 */
public class MessageWithLinkInTextViewFragment extends Fragment {

    @Bind(R.id.messageWithLinkTextView)
    TextView messageWithLinkTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_messagewithlinkintextview, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        messageWithLinkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    
}
