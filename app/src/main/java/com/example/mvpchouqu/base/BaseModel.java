package com.example.mvpchouqu.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    CompositeDisposable mCompositeDisposable ;

    public void destory() {
        //打断网络请求和订阅关系
        if (mCompositeDisposable!=null&&mCompositeDisposable.size()>0){
            mCompositeDisposable.dispose();
        }
    }
    public void addDisposable(Disposable d) {
        if (mCompositeDisposable==null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(d);
    }
}
