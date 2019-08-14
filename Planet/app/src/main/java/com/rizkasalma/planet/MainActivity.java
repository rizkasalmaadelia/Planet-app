package com.rizkasalma.planet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;

    private ArrayList<Planet> list;
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        list = new ArrayList<>();

        list.addAll(Planetisi.getListData());
        showRecyclerList();


    }
    private void showSelectedPresident(Planet planet) {
        //Toast.makeText(this, "Kamu memilih " + planet.getNama(), Toast.LENGTH_SHORT).show();
        Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
        moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_PIC, planet.getPhoto());
        moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, planet.getNama());
        moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_DES, planet.getDes());
        moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_JARAK, planet.getJarak());
        startActivity(moveWithDataIntent);
    }
    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPlanetAdapter listPresidentAdapter = new ListPlanetAdapter(this);
        listPresidentAdapter.setListPlanet(list);
        rvCategory.setAdapter(listPresidentAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(list.get(position));
            }
        });
    }



}
