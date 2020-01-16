package com.example.mfuction.functions;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.mfuction.First3;
import com.example.mfuction.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import static java.lang.StrictMath.abs;

public class Mplayer extends AppCompatActivity {
    static MediaPlayer mp;
    static int pos;
    static int sppos;
    Button btn_nxt, btn_pre, btn_pause;
    TextView t1, t2, t3;
    SeekBar seek_bar;
    Thread thrd1;
    ListView listsong;
    String[] item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mplayer);
        FloatingActionButton fab = findViewById(R.id.fab_back);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mplayer.this, First3.class);
                startActivity(i);
                finish();
            }
        });
        listsong = (ListView) findViewById(R.id.songlist);
        runtimePermission();
        Display();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Mplayer.this,First3.class));
    }

    public void runtimePermission() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) { }
                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) { }
                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    public ArrayList<File> fileSong(File file) {
        ArrayList<File> arrayList = new ArrayList<File>();
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory() && !file1.isHidden()) {
                arrayList.addAll(fileSong(file1));
            } else {
                if (file1.getName().endsWith(".mp3")) {
                    arrayList.add(file1); }
            }
        }
        return arrayList;
    }

    void Display() {
        final ArrayList<File> mysongs = fileSong(Environment.getExternalStorageDirectory());
        Collections.sort(mysongs);
        item = new String[mysongs.size()];
        for (int i = 0; i < mysongs.size(); i++) {
            item[i] = mysongs.get(i).getName().toString().replace(".mp3", "");
        }
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        listsong.setAdapter(myAdapter);
        listsong.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String songName = listsong.getItemAtPosition(i).toString();
                        btn_nxt = (Button) findViewById(R.id.button24);
                        btn_pre = (Button) findViewById(R.id.button23);
                        btn_pause = (Button) findViewById(R.id.button25);
                        t1 = (TextView) findViewById(R.id.textView10);
                        seek_bar = (SeekBar) findViewById(R.id.seekBar4);
                        t2 = (TextView) findViewById(R.id.textView12);
                        t3 = (TextView) findViewById(R.id.textView11);
                        try {
                            thrd1 = new Thread() {
                                @Override
                                public void run() {
                                    int ttd = mp.getDuration();
                                    sppos = 0;
                                    while (sppos < ttd) {
                                        try {
                                            thrd1.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        sppos += 1000;
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                seek_bar.setProgress(sppos);
                                                t3.setText(String.format(Locale.getDefault(),
                                                        "%02d:%02d",
                                                        (seek_bar.getProgress() / 1000) / 60,
                                                        (seek_bar.getProgress() / 1000) % 60)); }
                                        });
                                    }
                                    if (mp.isPlaying() != true)
                                        btn_pause.setBackgroundResource(R.drawable.pause);
                                }

                            };
                            if (mp != null) {
                                mp.stop();
                                mp.release(); }
                            t1.setText(listsong.getItemAtPosition(i).toString());
                            t1.setSelected(true);
                            Uri u = Uri.parse(mysongs.get(i).toString());
                            mp = MediaPlayer.create(getApplicationContext(), u);
                            int k = mp.getDuration();
                            t2.setText(String.format(Locale.getDefault(), "%02d:%02d", (k / 1000) / 60, (k / 1000) % 60));
                            if (thrd1.isAlive()) {
                                seek_bar.setProgress(0);
                                t3.setText("00:00");
                                btn_pause.setBackgroundResource(R.drawable.pause);
                                thrd1.stop();
                            }
                            mp.start();
                            btn_pause.setBackgroundResource(R.drawable.play);
                            seek_bar.setMax(mp.getDuration());
                            thrd1.start();
                        } catch (Exception e) {
                            mp.stop();
                            Intent j = new Intent(Mplayer.this, First3.class);
                            startActivity(j);
                            finish();
                        }
                        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                            @Override
                            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { }
                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar) {
                            }
                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar) {
                                mp.seekTo(seekBar.getProgress());
                            }
                        });
                        btn_pause.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                seek_bar.setMax(mp.getDuration());

                                if (mp.isPlaying()) {
                                    mp.pause();
                                    btn_pause.setBackgroundResource(R.drawable.pause);
                                } else {
                                    btn_pause.setBackgroundResource(R.drawable.play);
                                    mp.start();
//                                                            if(thrd1.isAlive())
//                                                            {
//                                                                thrd1.resume();
//                                                            }
                                }
                            }
                        });
                        pos = i;
                        btn_nxt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mp.stop();
                                mp.release();
                                pos = (pos + 1) % mysongs.size();
                                Uri u = Uri.parse(mysongs.get(pos).toString());
                                mp = MediaPlayer.create(getApplicationContext(), u);
                                t1.setText(mysongs.get(pos).getName().toString());
                                mp.start();
                            }});
                        btn_pre.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mp.stop();
                                mp.release();

                                if (pos != 0) {
                                    pos = (pos - 1) % mysongs.size();
                                } else
                                    pos = mysongs.size();
                                Uri u = Uri.parse(mysongs.get(pos).toString());
                                mp = MediaPlayer.create(getApplicationContext(), u);
                                t1.setText(mysongs.get(pos).getName());
                                mp.start();
                            }
                        }); }
                }
        );
    }
}
