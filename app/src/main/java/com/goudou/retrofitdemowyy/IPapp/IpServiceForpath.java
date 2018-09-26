package com.goudou.retrofitdemowyy.IPapp;

import com.goudou.retrofitdemowyy.Bean.TaobaoBean;
import com.goudou.retrofitdemowyy.model.IpModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2018/1/8.
 * Created with Android Studio
 * Created By Kinsey
 * Date: 2018/1/8
 * Time: 10:15
 * 王洋洋
 */

public interface IpServiceForpath {

/*
    @GET("{path}/getIpInfo.php?ip=59.108.54.37")
    Call<TaobaoBean>  getIpMsg(@Path("path") String  path);*/

    @GET("{path}/getIpInfo.php?ip=59.108.54.37")
    Call<IpModel> getIpMsg(@Path("path") String path);

    //https://api.github.com/repos/square/retrofit/contributors

}
