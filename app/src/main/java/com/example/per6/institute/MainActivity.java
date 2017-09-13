package com.example.per6.institute;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //private Button aButton, asButton, bButton, bbButton, cButton, csButton, dButton, dsButton, eButton, fButton, fsButton, gButton, gsButton, aHButton, bHButton, ;
    //private MediaPlayer aNote, asNote, bNote;
    //Enter at own risk


    Button[] notes = new Button[24];
    MediaPlayer[] players = new MediaPlayer[24];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
        createMediaPlayers();
        final int wholeNote = 1000;
        //It just gets worse
    }

    private void weight(int x) { //Sleepy method
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createMediaPlayers() {
        for (int i = 1; i <= 24; i++) {
            //Log.e("asdf", getResources().getIdentifier("scale" + i, "raw", getPackageName()) + ""); For debugging
            players[i - 1] = MediaPlayer.create(this, getResources().getIdentifier("scale" + i, "raw", getPackageName()));

        }
    }

    private void setListeners() {
        for (int i = 0; i < 24; i++) {
            final int index = i;
            notes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    players[index].seekTo(0);
                    players[index].start();
                    weight(500);
                }
            });
        }
    }
//        aButton.setOnClickListener(this);
//        asButton.setOnClickListener(this);
//        bButton.setOnClickListener(this);
//    }
//
    private void wireWidgets() {
        for(int i = 0; i < 24; i++) {
            //Help me
            notes[i] = (Button) findViewById(getResources().getIdentifier("button_" + (i + 1), "id", getPackageName()));

        }
    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.button_a:
//                //notes.seekTo(0);
//                //aNote.start();
//                break;
//            case R.id.button_b_flat:
//                Toast.makeText(this, "A of sharpness!", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button_b:
//                Toast.makeText(this, "B!", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                //System.exit(1);
//        }
//    }
    }

