package com.rameses.dicodingsubmissionwisatatabanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvName = findViewById(R.id.tv_detail_name);
        TextView tvLocation = findViewById(R.id.tv_detail_location);
        TextView tvDetail = findViewById(R.id.tv_detail_detail);
        ImageView imgPhoto = findViewById(R.id.img_detail_photo);

        String name = getIntent().getStringExtra(MainActivity.EXTRA_NAME_TOURISM);
        String location = getIntent().getStringExtra(MainActivity.EXTRA_LOCATION_TOURISM);
        int detail = getIntent().getIntExtra(MainActivity.EXTRA_DETAIL_TOURISM,0);
        int photo = getIntent().getIntExtra(MainActivity.EXTRA_PHOTO_TOURISM,0);

        Glide.with(getApplicationContext())
                .load(photo)
                .apply(new RequestOptions().override(640,480))
                .into(imgPhoto);

        tvName.setText(name);
        tvLocation.setText(location);
        tvDetail.setText(getResources().getText(detail));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
