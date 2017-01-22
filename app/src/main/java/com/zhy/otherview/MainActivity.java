package com.zhy.otherview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.m_other_view)
    OtherView mOtherView;
    @InjectView(R.id.m_empty_view)
    Button mEmptyView;
    @InjectView(R.id.m_retry_view)
    Button mRetryView;
    @InjectView(R.id.m_login_view)
    Button mLoginView;
    @InjectView(R.id.m_content_view)
    Button mContentView;

    private OtherViewHolder mHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mHolder = new OtherViewHolder(MainActivity.this);
        mOtherView.setHolder(mHolder);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mOtherView.showLoadingView();
            }
        });
    }

    @OnClick({R.id.m_empty_view, R.id.m_retry_view, R.id.m_login_view, R.id.m_content_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.m_empty_view:
                mOtherView.showEmptyView();
                break;
            case R.id.m_retry_view:
                mOtherView.showRetryView();
                break;
            case R.id.m_login_view:
                mOtherView.showLoadingView();
                break;
            case R.id.m_content_view:
                mOtherView.showContentView();
                break;
        }
    }
}
