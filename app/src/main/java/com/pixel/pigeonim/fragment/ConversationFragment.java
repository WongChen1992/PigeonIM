package com.pixel.pigeonim.fragment;

import com.pixel.pigeonim.R;

import io.rong.imkit.RongIM;

/**
 * Created by wongchen on 2017/11/8.
 */

public class ConversationFragment extends BaseFragment{
    @Override
    public int getLayoutId() {
        return R.layout.fragment_conversation;
    }

    @Override
    public void init() {
        RongIM.getInstance().startConversationList(getActivity());
    }
}
