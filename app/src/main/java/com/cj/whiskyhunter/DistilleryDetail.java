package com.cj.whiskyhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cj.whiskyhunter.models.Distillery;

public class DistilleryDetail extends AppCompatActivity {

    TextView txtNameDistilleryDetail;
    TextView txtSlugDistilleryDetail;
    TextView txtCountryDistilleryDetail;
    TextView txtWhiskiesDistilleryDetail;
    TextView txtVotesDistilleryDetail;
    TextView txtRatingDistilleryDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distillery_detail);

        txtNameDistilleryDetail = findViewById(R.id.txtNameDistilleryDetail);
        txtSlugDistilleryDetail = findViewById(R.id.txtSlugDistilleryDetail);
        txtCountryDistilleryDetail = findViewById(R.id.txtCountryDistilleryDetail);
        txtWhiskiesDistilleryDetail = findViewById(R.id.txtWhiskiesDistilleryDetail);
        txtVotesDistilleryDetail = findViewById(R.id.txtVotesDistilleryDetail);
        txtRatingDistilleryDetail = findViewById(R.id.txtRatingDistilleryDetail);

        Distillery distillery = (Distillery) getIntent().getSerializableExtra("objDistillery");

        txtNameDistilleryDetail.setText(distillery.getNameDistillery());
        txtSlugDistilleryDetail.setText("Slug: " + distillery.getSlugDistillery());
        txtCountryDistilleryDetail.setText("Country: " + distillery.getCountryDistillery());
        txtWhiskiesDistilleryDetail.setText("Whiskies: " + distillery.getWhiskybase_whiskiesDistillery());
        txtVotesDistilleryDetail.setText("Votes: " + distillery.getWhiskybase_votesDistillery());
        txtRatingDistilleryDetail.setText("Rating: " + distillery.getWhiskybase_ratingDistillery());
    }
}
