package com.w3ma.androidshowcase.spannablelinkintextview;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
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
public class MessageWithSpannableLinkInTextViewFragment extends Fragment {

    @Bind(R.id.messageWithSpannableLinkTextView)
    TextView messageWithSpannableLinkTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_messagewithspannablelinkintextview, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        SpannableString spannableString = new SpannableString(getString(R.string.messageWithSpannableLink));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")));
            }
        };
        spannableString.setSpan(clickableSpan, spannableString.length() - 20, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        messageWithSpannableLinkTextView.setText(spannableString, TextView.BufferType.SPANNABLE);
        messageWithSpannableLinkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
