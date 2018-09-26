package com.goudou.retrofitdemowyy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.goudou.retrofitdemowyy.Bean.TaobaoBean;
import com.goudou.retrofitdemowyy.IPapp.IpService;
import com.goudou.retrofitdemowyy.IPapp.IpServiceForQuery;
import com.goudou.retrofitdemowyy.IPapp.IpServiceForpath;
import com.goudou.retrofitdemowyy.model.IpModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "wyy";
    private Button btn_get;
    private Button btn_query;
    private Button btn_post;

    private TextView tv_netdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_query = (Button) findViewById(R.id.btn_query);
        btn_post = (Button) findViewById(R.id.btn_post);

        tv_netdate = (TextView) findViewById(R.id.tv_netdate);

        btn_get.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        btn_post.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                 RetGet();
                break;
            case R.id.btn_query:
             //   GetQuery();

               GetQueryMap();
                break;
            case R.id.btn_post:
                GetQuery();
                break;
                default:
                    break;
        }
    }



    private void GetQueryMap() {
        String url = "http://ip.taobao.com/service/";
         Retrofit  retrofit=new Retrofit.Builder()
                 .baseUrl(url)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

        IpServiceForQuery ipServiceForQuery = retrofit.create(IpServiceForQuery.class);

        HashMap<String,String>  hashMap=new HashMap<>();
        hashMap.put("ip","59.108.54.37");
        Call<IpModel> ipMsg = ipServiceForQuery.getIpMsg(hashMap);

        ipMsg.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                Log.i(TAG, "onResponse: -------"+response.body().getData().getCity());
                tv_netdate.setText(response.body().getData().getCity());
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {
                Log.i(TAG, "onFailure: --------"+t.getMessage());
                tv_netdate.setText(t.getMessage());
            }
        });


    }

    private void GetQuery() {

        String url = "http://ip.taobao.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IpServiceForpath ipService = retrofit.create(IpServiceForpath.class);
        Call<IpModel> call = ipService.getIpMsg("service");
        call.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                String country = response.body().getData().getCountry();
                Log.i("wangshu", "country" + country);
                Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void RetGet() {


        String url = "http://ip.taobao.com/service/";

        Retrofit  retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IpService   ipService=retrofit.create(IpService.class);

        Call<IpModel> ipMsg = ipService.getIpMsg();

        ipMsg.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                String result = response.body().getData().getCountry();
                tv_netdate.setText(result);

            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {
                String message = t.getMessage();
                tv_netdate.setText(message);

            }
        });
    }
}
