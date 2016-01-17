package com.example.eduardogouvea.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.eduardogouvea.myfirstapp.vo.OpponentVo;

import java.util.ArrayList;
import java.util.List;

public class MyActivity21 extends AppCompatActivity {

    private static final String TAG = "MyActivity21 tag:";

    // Create a message handling object as an anonymous class.
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Log.v(TAG, "OnItemClickListener: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_21);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.loadOpponent(savedInstanceState);

        ListView listOpponent = (ListView) findViewById(R.id.list_opponent);
        listOpponent.setOnItemClickListener(mMessageClickedHandler);
    }

    private void loadOpponent(Bundle savedInstanceState) {
        List<OpponentVo> listOpponentVo = this.getlistOpponentVo();

        ListView listOpponent = (ListView) findViewById(R.id.list_opponent);
        ArrayAdapter<OpponentVo> arrayAdapter = new ArrayAdapter<OpponentVo>(
                this,
                R.layout.layout_coord,
                R.id.textview_player_name,
                listOpponentVo
            );
        listOpponent.setAdapter(arrayAdapter);

    }

    private List<OpponentVo> getlistOpponentVo() {
        List<OpponentVo> list = new ArrayList<OpponentVo>();
        list.add(new OpponentVo("Dedé", "jogador1.png"));
        list.add(new OpponentVo("Dudu", "jogador2.png"));
        list.add(new OpponentVo("Kiki", "jogador3.png"));
        return list;
    }

    /** Called when the user clicks the Send button */
    public void chooseOpponent(View view) {
        Intent intent = new Intent(this, MyActivity3.class);
        String message = "jogador1";
        intent.putExtra("EXTRA_AVATAR_PLAYER", message);
        startActivity(intent);
    }

}
