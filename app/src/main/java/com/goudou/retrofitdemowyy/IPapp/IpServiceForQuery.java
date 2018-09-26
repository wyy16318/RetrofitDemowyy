package com.goudou.retrofitdemowyy.IPapp;

import com.goudou.retrofitdemowyy.Bean.TaobaoBean;
import com.goudou.retrofitdemowyy.model.IpModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2018/1/8.
 * Created with Android Studio
 * Created By Kinsey
 * Date: 2018/1/8
 * Time: 11:10
 * 王洋洋
 */

public interface IpServiceForQuery {


    @GET("getIpInfo.php")
    Call<IpModel>  getIpMsg(@QueryMap Map<String ,String> options);



}
