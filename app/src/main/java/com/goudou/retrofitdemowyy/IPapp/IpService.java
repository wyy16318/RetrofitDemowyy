package com.goudou.retrofitdemowyy.IPapp;

import com.goudou.retrofitdemowyy.Bean.TaobaoBean;
import com.goudou.retrofitdemowyy.model.IpModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Administrator on 2018/1/8.
 * Created with Android Studio
 * Created By Kinsey
 * Date: 2018/1/8
 * Time: 9:34
 * 王洋洋
 */

public interface IpService {

/*   // @GET("getIpInfo.php?ip=69.108.54.3")
    @GET("getIpInfo.php?ip=59.108.54.37")
    Call<IpModel>    getIpMsg();*/

    @Headers({
            "Accept-Encoding: application/json",
            "User-Agent: MoonRetrofit"
    })
    @GET("getIpInfo.php?ip=59.108.54.37")
    Call<IpModel> getIpMsg();

}
