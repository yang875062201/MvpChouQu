package com.example.mvpchouqu.util;

import android.widget.Toast;

import com.example.mvpchouqu.MainActivity;
import com.example.mvpchouqu.base.BaseAPP;

public class ToastUtil {
    public  static  void showShort(String str){
        Toast.makeText(BaseAPP.sContext,str,Toast.LENGTH_SHORT).show();
    }
    public  static  void showLong(String str){
        Toast.makeText(BaseAPP.sContext,str,Toast.LENGTH_LONG).show();
    }
}
