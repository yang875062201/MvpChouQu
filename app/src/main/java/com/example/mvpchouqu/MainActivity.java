package com.example.mvpchouqu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvpchouqu.base.BaseActivity;
import com.example.mvpchouqu.base.BasePersenter;
import com.example.mvpchouqu.bean.Bean;
import com.example.mvpchouqu.persenter.MainPersenter;
import com.example.mvpchouqu.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPersenter>implements  MainView  {

    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.tv)
    TextView mTv;





    @Override//复写父类方法
    protected int getLayoutId() {
        //将要展示布局传过去
        return R.layout.activity_main;
    }

    @Override
    protected MainPersenter initPersenter() {
        return new MainPersenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        showLoading();
        mPersenter.getVerifyCode();
    }
    @OnClick(R.id.btn)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                showLoading();
                mPersenter.getVerifyCode();
                break;
        }
    }

    @Override
    public void setDatas(Bean bean) {
        if (bean.getCode()==200){
            String data = bean.getData();
            if (!TextUtils.isEmpty(data)){
                mTv.setText(data);
            }
        }
    }
}
