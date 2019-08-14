package com.rizkasalma.planet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MoveWithDataActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_PIC = "extra_pic";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DES = "extra_des";
    public static final String EXTRA_JARAK = "extra_jarak";
    private Context context;
    private ArrayList<Planet> listPlanet;
    public ArrayList<Planet> getListPlanet() {
        return listPlanet;
    }
    public void setListPlanet(ArrayList<Planet> listPlanet) {
        this.listPlanet = listPlanet;
    }


    TextView tempatnamaplanet,des,jarakk;
    ImageView tempatfotoplanet;
    Button buttondetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        tempatnamaplanet = findViewById(R.id.tempatnamaplanet);
        tempatfotoplanet = findViewById(R.id.tempatfotoplanet);
        des = findViewById(R.id.desplanet);
        jarakk = findViewById(R.id.jarak);
        buttondetail = findViewById(R.id.buttondetail);
        buttondetail.setOnClickListener(this);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String pic = getIntent().getStringExtra(EXTRA_PIC);
        String desc = getIntent().getStringExtra(EXTRA_DES);
        String jarak = getIntent().getStringExtra(EXTRA_JARAK);


        Glide.with(getApplicationContext())
                .load(pic)
                .apply(new RequestOptions().override(60,60))
                .into(tempatfotoplanet);
    

    String text = name + pic;
        tempatnamaplanet.setText(name);
        des.setText(desc);
        jarakk.setText(jarak);
        //tempatfotoplanet.setImageResource(pic);
        //Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        String namapl = getIntent().getStringExtra(EXTRA_NAME);

        switch (namapl){
            case "Merkurius":
                //Toast.makeText(this, "Yeeeeeeeeeeee", Toast.LENGTH_SHORT).show();
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://map-bms.wikipedia.org/wiki/Merkurius"));
                startActivity(viewIntent);
                break;
            case "Venus":
                Intent viewIntent1 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/Venus"));
                startActivity(viewIntent1);
                break;
            case "Bumi":
                Intent viewIntent2 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/Earth"));
                startActivity(viewIntent2);
                //The day everyone waits for 🙂
                break;
            case "Mars":
                Intent viewIntent3 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/Mars"));
                startActivity(viewIntent3);
                //The day everyone waits for 🙂
                break;
            case "Jupiter":
                Intent viewIntent4 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/Jupiter"));
                startActivity(viewIntent4);

                break;
            case "Saturnus":
                Intent viewIntent5 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/Saturnus"));
                startActivity(viewIntent5);
                //The day everyone waits for 🙂
                break;
            case "Uranus":
                Intent viewIntent6 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/Uranus"));
                startActivity(viewIntent6);
                //The day everyone waits for 🙂
                break;
            case "Neptunus":
                Intent viewIntent7 =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/Neptunus"));
                startActivity(viewIntent7);
                //The day everyone waits for 🙂
                break;
            default:
                Toast.makeText(this, "SOMETHING WENT WRONG", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
