package com.example.mvpchouqu.model;

import com.example.mvpchouqu.base.BaseModel;
import com.example.mvpchouqu.bean.Bean;
import com.example.mvpchouqu.net.ApiService;
import com.example.mvpchouqu.net.ResultCallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void getVerifyCode(final ResultCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.sUrl)
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getVerifyCode()
                .subscribeOn(Schedulers.io())//被观察者执行的线程
                .observeOn(AndroidSchedulers.mainThread())//观察者执行的线程
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //订阅的时候调用
                        //Disposable d 结束网络请求+打断订阅关系
                        //d.dispose();

                        addDisposable(d);
                    }

                    @Override
                    public void onNext(Bean bean) {
                        //请求成功
                        callBack.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //请求失败
                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        //事件完成,onError() 互斥
                    }
                });

    }


}
