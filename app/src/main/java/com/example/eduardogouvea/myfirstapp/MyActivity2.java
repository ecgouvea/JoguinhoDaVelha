package com.example.eduardogouvea.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eduardogouvea.myfirstapp.vo.OpponentVo;
import com.example.eduardogouvea.myfirstapp.vo.PlayerVo;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MyActivity2 extends AppCompatActivity {

    private static final String TAG = "MyActivity2 tag:";

    // Create a message handling object as an anonymous class.
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Log.v(TAG, "OnItemClickListener: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.loadPlayerList(savedInstanceState);

        ListView listAvatarPlayer = (ListView) findViewById(R.id.list_avatar_player);
        listAvatarPlayer.setOnItemClickListener(mMessageClickedHandler);

        String playerName = getIntent().getStringExtra("EXTRA_PLAYER_NAME");
        TextView textView = (TextView) findViewById(R.id.text_avatar_player);
        textView.setText(playerName + ", " + textView.getText());

    }

    private void loadPlayerList(Bundle savedInstanceState) {
        List<PlayerVo> listPlayerVo = this.getlistPlayerVo();

        ListView listAvatarPlayer = (ListView) findViewById(R.id.list_avatar_player);
        ArrayAdapter<PlayerVo> arrayAdapter = new ArrayAdapter<PlayerVo>(
                this,
                R.layout.layout_coord,
                R.id.textview_player_name,
                listPlayerVo
            );
        listAvatarPlayer.setAdapter(arrayAdapter);
    }

    private List<PlayerVo> getlistPlayerVo() {
        List<PlayerVo> list = new ArrayList<PlayerVo>();
        list.add(new PlayerVo("Dedé", "jogador1.png"));
        list.add(new PlayerVo("Dudu", "jogador2.png"));
        list.add(new PlayerVo("Kiki", "jogador3.png"));
        return list;
    }

    /** Called when the user clicks the Send button */
    public void chooseAvatarPlayer(View view) {
        Intent intent = new Intent(this, MyActivity21.class);
        String message = "jogador1";
        intent.putExtra("EXTRA_AVATAR_PLAYER", message);
        startActivity(intent);
    }

}
