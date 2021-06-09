package com.cj.whiskyhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cj.whiskyhunter.ApiManager.RetrofitClient;
import com.cj.whiskyhunter.models.Whisky;

import java.util.List;

import retrofit2.Call;

public class WhiskyDetail extends AppCompatActivity implements View.OnClickListener {

    TextView txtNameWhiskyDetail;
    TextView txtSlugWhiskyDetail;
    TextView txtBuyersFeeWhiskyDetail;
    TextView txtSellersFeeWhiskyDetail;
    TextView txtReserveFeeWhiskyDetail;
    TextView txtListingFeeWhiskyDetail;
    TextView txtBaseCurrencyWhiskyDetail;
    Button btnProducer;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whisky_detail);

        txtNameWhiskyDetail = findViewById(R.id.txtNameWhiskyDetail);
        txtSlugWhiskyDetail = findViewById(R.id.txtSlugWhiskyDetail);
        txtBuyersFeeWhiskyDetail = findViewById(R.id.txtBuyersFeeWhiskyDetail);
        txtSellersFeeWhiskyDetail = findViewById(R.id.txtSellersFeeWhiskyDetail);
        txtReserveFeeWhiskyDetail = findViewById(R.id.txtReserveFeeWhiskyDetail);
        txtListingFeeWhiskyDetail = findViewById(R.id.txtListingFeeWhiskyDetail);
        txtBaseCurrencyWhiskyDetail = findViewById(R.id.txtBaseCurrencyWhiskyDetail);
        btnProducer = findViewById(R.id.btnProducer);
        btnProducer.setOnClickListener(this);

        Whisky whisky = (Whisky) getIntent().getSerializableExtra("objWhisky");
        txtNameWhiskyDetail.setText(whisky.getNameWhisky());
        txtSlugWhiskyDetail.setText("Slug: " + whisky.getSlugWhisky());
        txtBuyersFeeWhiskyDetail.setText("Buyers Fee: " + whisky.getBuyersFeeWhisky());
        txtSellersFeeWhiskyDetail.setText("Sellers Fee: " + whisky.getSellersFeeWhisky());
        txtReserveFeeWhiskyDetail.setText("Reserve Fee: " + whisky.getReserveFeeWhisky());
        txtListingFeeWhiskyDetail.setText("Listing Fee: " + whisky.getListingFeeWhisky());
        txtBaseCurrencyWhiskyDetail.setText("Base Currency: " + whisky.getBaseCurrencyWhisky());

        link = whisky.getUrlWhisky();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnProducer:
                Uri uri = Uri.parse(link);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
        }
    }
}
