package lso.naing.thingyan;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    int[] songs=new int[15];
    boolean continous=true;
    int currentsong=0;
    boolean displaymode=false;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15;
    ImageButton play,prev,next,songlist;
    Handler handler;
    Runnable runnable;
    SeekBar sb;
    boolean playing=false;
    int duration;

    String[] title={"သၾကၤန္အိမ္မက္",
            "အားကိုးမယ္ေနာ္",
            "ေကာင္ေလးသနားစရာပဲ",
            "ေရနန္းဗဟိုရ္",
            "ခ်စ္စရာေကာင္းတဲ့ဓေလ့ရိုး",
            "သတိေတာ့ထား",
            "ဗံုဗံုဗံု",
            "ျဖည္းျဖည္းပတ္",
            "မ်က္လံုးေလးကိုအရွိန္ထိန္းပါ",
            "ေဟာ့ေတာ့",
            "တုန္ဘူးဆိုပက္",
            "တစ္ေယာက္ထဲဆိုစိတ္မခ်လို့",
            "ကမၻာသစ္ေတး",
            "လက္ကေလးဆြဲထား",
            "သၾကၤန္ေရစိုတဲ့ တယ္လီဖုန္း"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp=new MediaPlayer();

        songs[0] = R.raw.song1;
        songs[1] = R.raw.song2;
        songs[2] = R.raw.song3;
        songs[3] = R.raw.song4;
        songs[4] = R.raw.song5;
        songs[5] = R.raw.song6;
        songs[6] = R.raw.song7;
        songs[7] = R.raw.song8;
        songs[8] = R.raw.song9;
        songs[9] = R.raw.song10;
        songs[10] = R.raw.song11;
        songs[11] = R.raw.song12;
        songs[12] = R.raw.song13;
        songs[13] = R.raw.song14;
        songs[14] = R.raw.song15;

        btn1 = (Button)findViewById(R.id.song1);
        btn2 = (Button)findViewById(R.id.song2);
        btn3 = (Button)findViewById(R.id.song3);
        btn4 = (Button)findViewById(R.id.song4);
        btn5 = (Button)findViewById(R.id.song5);
        btn6 = (Button)findViewById(R.id.song6);
        btn7 = (Button)findViewById(R.id.song7);
        btn8 = (Button)findViewById(R.id.song8);
        btn9 = (Button)findViewById(R.id.song9);
        btn10 = (Button)findViewById(R.id.song10);
        btn11 = (Button)findViewById(R.id.song11);
        btn12 = (Button)findViewById(R.id.song12);
        btn13= (Button)findViewById(R.id.song13);
        btn14 = (Button)findViewById(R.id.song14);
        btn15 = (Button)findViewById(R.id.song15);

    }

    public void Display(int index) {
        setContentView(R.layout.music_display);
        displaymode = true;

        play = (ImageButton) findViewById(R.id.play_id);
        next = (ImageButton) findViewById(R.id.next_id);
        prev = (ImageButton) findViewById(R.id.prev_id);
        songlist=(ImageButton)findViewById(R.id.songlist);
        sb=(SeekBar)findViewById(R.id.seekbar);

        songlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(displaymode){
                    displaymode=false;
                    setContentView(R.layout.activity_main);
                    handler.removeCallbacks(runnable);
                }else{
                    finish();
                }
            }
        });

        handler=new Handler();
        runnable = new Runnable() {

            @Override
            public void run() {
                handler.postDelayed(this, 200);
                sb.setProgress(mp.getCurrentPosition());
            }
        };

        mp.reset();
        mp=MediaPlayer.create(this,songs[index]);
        ListenToCompletion(mp);
        duration=mp.getDuration();
        sb.setMax(duration);
        sb.setProgress(0);
        mp.start();
        handler.postDelayed(runnable,200);
        playing=true;


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mp.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if(playing) {
                    mp.pause();
                    handler.removeCallbacks(runnable);
                }

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (playing){
                    mp.start();
                    handler.postDelayed(runnable, 200);
                }

            }
        });
    }


    public void sonClick(View v) {

        switch(v.getId()){
            case R.id.song1:
                mp.stop();
                currentsong=0;
                Display(currentsong);
                break;

            case R.id.song2:
                mp.stop();
                currentsong=1;
                Display(currentsong);
                break;

            case R.id.song3:
                mp.stop();
                currentsong=2;
                Display(currentsong);
                break;

            case R.id.song4:
                mp.stop();
                currentsong=3;
                Display(currentsong);
                break;

            case R.id.song5:
                mp.stop();
                currentsong=4;
                Display(currentsong);
                break;

            case R.id.song6:
                mp.stop();
                currentsong=5;
                Display(currentsong);
                break;

            case R.id.song7:
                mp.stop();
                currentsong=6;
                Display(currentsong);
                break;

            case R.id.song8:
                mp.stop();
                currentsong=7;
                Display(currentsong);
                break;

            case R.id.song9:
                mp.stop();
                currentsong=8;
                Display(currentsong);
                break;

            case R.id.song10:
                mp.stop();
                currentsong=9;
                Display(currentsong);
                break;

            case R.id.song11:
                mp.stop();
                currentsong=10;
                Display(currentsong);
                break;

            case R.id.song12:
                mp.stop();
                currentsong=11;
                Display(currentsong);
                break;

            case R.id.song13:
                mp.stop();
                currentsong=12;
                Display(currentsong);
                break;

            case R.id.song14:
                mp.stop();
                currentsong=13;
                Display(currentsong);
                break;

            case R.id.song15:
                mp.stop();
                currentsong=14;
                Display(currentsong);
                break;

        }

        updateTitle();
    }

    private void updateTitle() {

        getSupportActionBar().setTitle(title[currentsong]);
    }

    public void PrevClick(View v){
        currentsong-=1;
        if(currentsong==-1)
            currentsong=14;
        Display(currentsong);
        updateTitle();
    }

    public void PlayClick(View v) {
        if(playing){
            playing=false;
            mp.pause();
            play.setBackgroundResource(R.drawable.play);
            handler.removeCallbacks(runnable);

        }else {
            playing=true;
            mp.start();
            play.setBackgroundResource(R.drawable.pause);
            handler.postDelayed(runnable,200);
        }
    }

    public void NextClick(View v){

        currentsong+=1;
        if(currentsong==15)
            currentsong=0;
        Display(currentsong);
        updateTitle();
    }

    @Override
    public void onBackPressed() {
        mp.stop();
        playing=false;
        if(displaymode){
            displaymode=false;
            setContentView(R.layout.activity_main);
            handler.removeCallbacks(runnable);
        }else{
            finish();
        }

        getSupportActionBar().setTitle("သၾကၤန္သီခ်င္းမ်ား");
    }

    public void ListenToCompletion(MediaPlayer mp) {
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                if (continous) {
                    currentsong++;
                    if (currentsong == 15) {
                        currentsong = 0;
                    }
                    Display(currentsong);
                    updateTitle();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.about,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.about_id){

            startActivity(new Intent(this,AboutActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
