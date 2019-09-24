package com.example.mvpchouqu.base;

import com.example.mvpchouqu.model.MainModel;

import java.util.ArrayList;

public abstract class BasePersenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModel> mModels;
    public BasePersenter(){
        initModel();
    }

    protected abstract void initModel();

    public  void bingView(V view){
        this.mView = view;
    };

    public  void destroy(){
        //打断V和P关系
        mView=null;
        //取消网络请求和订阅关系
        if (mModels!=null){
            for (int i = 0; i <mModels.size() ; i++) {
                mModels.get(i).destory();
            }
            mModels.clear();
            mModels=null;
        }
    };
    public void addModel(BaseModel model) {
        if (mModels==null){
            mModels= new ArrayList<>();
        }
        mModels.add(model);
    }
}
