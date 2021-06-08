package com.cj.whiskyhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cj.whiskyhunter.ApiManager.RetrofitClient;
import com.cj.whiskyhunter.models.Whisky;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listWhiskys;
    List<Whisky> myWhiskys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listWhiskys = findViewById(R.id.lvWhiskys);
        getWhiskysFromApi();
        listWhiskys.setOnItemClickListener(this);
    }

    private void getWhiskysFromApi() {
        Call<List<Whisky>> call = RetrofitClient.getInstance().getMyApi().getWhiskys();
        call.enqueue(new Callback<List<Whisky>>() {
            @Override
            public void onResponse(Call<List<Whisky>> call, Response<List<Whisky>> response) {
                myWhiskys = response.body();

                WhiskyAdapter adapter = new WhiskyAdapter(MainActivity.this, myWhiskys);
                listWhiskys.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Whisky>> call, Throwable t) {
                Toasty.error(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT, true).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, WhiskyDetail.class);
        intent.putExtra("objWhisky", myWhiskys.get(position));
        startActivity(intent);
    }
}
