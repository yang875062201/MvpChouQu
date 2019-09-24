package com.example.mvpchouqu.net;

import com.example.mvpchouqu.bean.Bean;


import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.GET;

/**
 * @author xts
 *         Created by asus on 2019/9/23.
 */

public interface ApiService {
    String sUrl = "http://yun918.cn/study/public/index.php/";

    @GET("verify")
    Observable<Bean> getVerifyCode();
}
