package com.example.eduardogouvea.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MyActivity1 extends AppCompatActivity {

    private static final String TAG = "MyActivity1 Tag:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /** Called when the user clicks the Send button */
    public void createPlayerName(View view) {
        Log.v(TAG, "createPlayerName: view " + view);
        Intent intent = new Intent(this, MyActivity2.class);
        EditText editText = (EditText) findViewById(R.id.edit_player_name);
        String name = editText.getText().toString();
        intent.putExtra("EXTRA_PLAYER_NAME", name);
        startActivity(intent);
    }

}
