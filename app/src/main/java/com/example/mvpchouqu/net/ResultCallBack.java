package com.example.mvpchouqu.net;

import com.example.mvpchouqu.bean.Bean;


/**
 * @author xts
 *         Created by asus on 2019/9/23.
 */

public interface ResultCallBack {
    void onSuccess(Bean bean);
    void onFail(String msg);
}
