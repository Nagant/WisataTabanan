package com.rameses.dicodingsubmissionwisatatabanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTourism;
    private ArrayList<Tourism> listTourism = new ArrayList<>();
    private static final String STATE_MODE = "state_mode";
    public static final String EXTRA_NAME_TOURISM = "extra_name";
    public static final String EXTRA_LOCATION_TOURISM = "extra_location";
    public static final String EXTRA_DETAIL_TOURISM = "extra_detail";
    public static final String EXTRA_PHOTO_TOURISM = "extra_photo";
    private static String MODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_about);
        setSupportActionBar(toolbar);

        rvTourism = findViewById(R.id.rv_tourism);
        rvTourism.setHasFixedSize(true);

        listTourism.addAll(TourismData.getListData());
        showTourismRecyclerCard();

        if (savedInstanceState != null) {
            String viewmode = savedInstanceState.getString(STATE_MODE);
            if(viewmode == "List"){
                showTourismRecyclerList();
            }else{
                showTourismRecyclerCard();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_MODE, MODE);
    }


    private void showTourismRecyclerList() {
        MODE = "List";
        rvTourism.setLayoutManager(new LinearLayoutManager(this));
        ListTourismAdapter listTourismAdapter = new ListTourismAdapter(listTourism);
        rvTourism.setAdapter(listTourismAdapter);

        listTourismAdapter.setOnItemClickCallback(new ListTourismAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Tourism data) {
                Intent detail = new Intent(MainActivity.this, DetailActivity.class);
                detail.putExtra(EXTRA_NAME_TOURISM, data.getTourism_name());
                detail.putExtra(EXTRA_LOCATION_TOURISM, data.getTourism_location());
                detail.putExtra(EXTRA_DETAIL_TOURISM, data.getTourism_detail());
                detail.putExtra(EXTRA_PHOTO_TOURISM, data.getTourism_photo());
                startActivity(detail);
            }
        });
    }

    private void showTourismRecyclerCard() {
        MODE = "Card";
        rvTourism.setLayoutManager(new LinearLayoutManager(this));
        CardTourismAdapter cardViewHeroAdapter = new CardTourismAdapter(listTourism);
        rvTourism.setAdapter(cardViewHeroAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        rvTourism.setLayoutManager(gridLayoutManager);

        cardViewHeroAdapter.setOnItemClickCallback(new ListTourismAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Tourism data) {
                Intent detail = new Intent(MainActivity.this, DetailActivity.class);
                detail.putExtra(EXTRA_NAME_TOURISM, data.getTourism_name());
                detail.putExtra(EXTRA_LOCATION_TOURISM, data.getTourism_location());
                detail.putExtra(EXTRA_DETAIL_TOURISM, data.getTourism_detail());
                detail.putExtra(EXTRA_PHOTO_TOURISM, data.getTourism_photo());
                startActivity(detail);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent about = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(about);
                return true;
            case R.id.cardView:
                showTourismRecyclerCard();
                break;
            case R.id.listView:
                showTourismRecyclerList();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
