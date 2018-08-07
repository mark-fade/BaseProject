package com.example.baseproject.ui.test;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.baseproject.R;
import com.example.baseproject.base.MvpActivity;
import com.example.data.bean.test.TestBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends MvpActivity<TestPresenter, TestModel> {

    @BindView(R.id.tv_test)
    TextView tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        if (mPresenter != null) {
            mPresenter.getTestData("深圳");
        }
    }

    public void setTestData(TestBean testBean) {
        Log.e("111",testBean.toString());
        if (testBean != null) {
            StringBuffer sb = new StringBuffer();
            sb.append(testBean.ganmao + "\n");
            sb.append(testBean.pm10 + "\n");
            sb.append(testBean.pm25 + "\n");
            sb.append(testBean.quality + "\n");
            sb.append(testBean.shidu + "\n");
            sb.append(testBean.wendu + "\n");
            sb.append(testBean.yesterday.date + "\n");
            tv_test.setText(sb.toString());
        }
    }

    @Override
    public void onError(Throwable e) {

    }
}
