package com.example.mvpchouqu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mvpchouqu.R;
import com.example.mvpchouqu.util.ToastUtil;
import com.example.mvpchouqu.widget.LoadingDialog;

import butterknife.ButterKnife;
//子类传递什么类型，父类帮子类保存什么类型，避免强转
public abstract class BaseActivity<T extends BasePersenter> extends AppCompatActivity implements BaseView {
    //子类使用泛型
    public  T mPersenter =null;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());//需要布局ID
        ButterKnife.bind(this);
        mPersenter = initPersenter();//初始化P层
        if (mPersenter!=null){
            mPersenter.bingView(this);
        }
        initView();//不写也可以
        initData();//不写也可以
        initListener();//不写也可以
    }

    protected abstract T initPersenter();

    //里面写监听方法
    protected  void initListener(){};
    //里面写数据
    protected  void initData(){};
    //里面写找控件
    protected  void initView(){};

    //布局ID，需要复写
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消网络请求，取消订阅，打断V和P的联系
        mPersenter.destroy();
        mPersenter=null;
    }

    @Override
    public void showToast(String str) {
        ToastUtil.showShort(str);
    }

    @Override
    public void showLoading() {
        if (loadingDialog==null){
            loadingDialog = new LoadingDialog(this);
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        //loading是一个自定义的dialog
        if (loadingDialog!=null) {
            loadingDialog.dismiss();
        }
    }
}
