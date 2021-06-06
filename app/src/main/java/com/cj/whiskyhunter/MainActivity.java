package com.cj.whiskyhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.cj.whiskyhunter.ApiManager.RetrofitClient;
import com.cj.whiskyhunter.models.Whisky;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listWhiskys;
    List<Whisky> myWhisky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listWhiskys = findViewById(R.id.lvWhiskys);
        getWhiskysFromApi();
    }

    private void getWhiskysFromApi() {
        Call<List<Whisky>> call = RetrofitClient.getInstance().getMyApi().getWhiskys();
        call.enqueue(new Callback<List<Whisky>>() {
            @Override
            public void onResponse(Call<List<Whisky>> call, Response<List<Whisky>> response) {
                myWhisky = response.body();

                WhiskyAdapter adapter = new WhiskyAdapter(MainActivity.this, myWhisky);
                listWhiskys.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Whisky>> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}
