package com.rizkasalma.planet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String[] titles;
    ArrayList<String>listtitles;
    EditText editText;
    ArrayAdapter<String>adapter;
    ListView listView;
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
        editText = (EditText) findViewById(R.id.search);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        list = new ArrayList<>();

        list.addAll(Planetisi.getListData());
        showRecyclerList();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    titlelistmethod();

                }else{
                    searchtitles(s.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void titlelistmethod(){
        Intent moveWithDataIntent = getIntent();
        String titles = moveWithDataIntent.getStringExtra("EXTRA_NAME");
        //titles=new String[]{"Matematika","Ipa","Ips","Agama","Seni"};
        listtitles= new ArrayList<>(Arrays.asList(titles));
        //adapter= new ArrayAdapter<String>(this,R.layout.itemrowplanet,R.id.textplanet);
        //listView.setAdapter(adapter);
    }
    public void searchtitles(String titlessearch) {
        for (String i : titles ){
            if (!i.contains(titlessearch)){
                listtitles.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
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
