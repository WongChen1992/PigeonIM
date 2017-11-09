package com.pixel.pigeonim.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pixel.pigeonim.R;
import com.pixel.pigeonim.adapter.ConversationListAdapterEx;

import butterknife.BindView;
import io.rong.imkit.RongContext;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

/**
 * Created by wongchen on 2017/11/8.
 */

public class ConversationFragment extends BaseFragment {

    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    /**
     * 会话列表的fragment
     */
    private ConversationListFragment mConversationListFragment = null;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_conversation;
    }

    @Override
    public void init() {
        srl.setColorSchemeResources(R.color.colorPrimary);
        initConversationList();
        addFragment(mConversationListFragment);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frameLayout, fragment);
        transaction.commit();
    }

    private void initConversationList() {
        if (mConversationListFragment == null) {
            ConversationListFragment listFragment = new ConversationListFragment();
            listFragment.setAdapter(new ConversationListAdapterEx(RongContext.getInstance()));
            Uri uri;
            uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversationlist")
                    .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话是否聚合显示
                    .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//群组
                    .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false")//公共服务号
                    .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false")//订阅号
                    .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")//系统
                    .build();
            listFragment.setUri(uri);
            mConversationListFragment = listFragment;
        }
    }
}
