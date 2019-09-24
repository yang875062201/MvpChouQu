package com.example.mvpchouqu.persenter;

import com.example.mvpchouqu.base.BaseModel;
import com.example.mvpchouqu.base.BasePersenter;
import com.example.mvpchouqu.bean.Bean;
import com.example.mvpchouqu.model.MainModel;
import com.example.mvpchouqu.net.ResultCallBack;
import com.example.mvpchouqu.view.MainView;

public class MainPersenter extends BasePersenter<MainView> implements ResultCallBack {

    private MainModel mainModel;

    public  void getVerifyCode(){
        mainModel.getVerifyCode(this);
    };

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }



    @Override
    public void onSuccess(Bean bean) {
        if (mView!=null){
            mView.hideLoading();
            if (bean!=null){
                mView.setDatas(bean);
            }
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.hideLoading();
        }
    }
}
