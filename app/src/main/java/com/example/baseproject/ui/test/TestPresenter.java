package com.example.baseproject.ui.test;

import android.util.Log;

import com.example.baseproject.base.BasePresenter;
import com.example.data.bean.ResultBo;
import com.example.data.bean.test.TestBean;

import rx.Observable;
import rx.Subscriber;

/*****************************
 *
 * @作者：chenk
 * @描述：
 ******************************/

public class TestPresenter extends BasePresenter<TestActivity, TestModel> {

    public void getTestData(String city) {
        if (mView != null) {
            mView.showLoadingDialog();
        }
        Observable<ResultBo<TestBean>> observable = mDataManager.testRepository.getTestData(city);
        addSubscription(observable, new Subscriber<ResultBo<TestBean>>() {
            @Override
            public void onCompleted() {
                if (mView != null) {
                    mView.dismissLoadingDialog();
                }
            }

            @Override
            public void onError(Throwable e) {
                if (mView != null) {
                    mView.dismissLoadingDialog();
                    Log.e("111", e.toString());
                }
            }

            @Override
            public void onNext(ResultBo resultBo) {
                if (mView != null) {
                    mView.dismissLoadingDialog();
                    mView.setTestData((TestBean) resultBo.data);
                }
            }
        });
    }

}
