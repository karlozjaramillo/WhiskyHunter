package com.cj.whiskyhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.cj.whiskyhunter.ApiManager.RetrofitClient;
import com.cj.whiskyhunter.models.Distillery;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Distilleries extends AppCompatActivity {

    ListView listDistilleries;
    List<Distillery> myDistilleries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distilleries);

        listDistilleries = findViewById(R.id.lvDistilleries);
        getDistilleriesFromApi();
    }

    private void getDistilleriesFromApi() {
        Call<List<Distillery>> call = RetrofitClient.getInstance().getMyApi().getDistilleries();
        call.enqueue(new Callback<List<Distillery>>() {
            @Override
            public void onResponse(Call<List<Distillery>> call, Response<List<Distillery>> response) {
                myDistilleries = response.body();

                DistilleryAdapter adapter = new DistilleryAdapter(Distilleries.this, myDistilleries);
                listDistilleries.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Distillery>> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}