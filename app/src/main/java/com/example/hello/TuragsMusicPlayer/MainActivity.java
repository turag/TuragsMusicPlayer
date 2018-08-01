package com.example.hello.TuragsMusicPlayer;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.musicplayertry2.R;

import java.io.File;
import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {





  private Button play,previous,next,repeat,shuffle;
  private TextView songName,artistName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        play=findViewById(R.id.playID);
        previous=findViewById(R.id.previousID);
        next=findViewById(R.id.nextID);
        repeat=findViewById(R.id.repeatID);
        shuffle= findViewById(R.id.ShuffleID);

        songName=findViewById(R.id.songNameID);
        artistName=findViewById(R.id.artistID);

     /*   Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.david);
        Bitmap blurredBitmap = BlurAndroidRenderScript.blur( this, originalBitmap );
        mContainerView.setBackground(new BitmapDrawable(getResources(), blurredBitmap));*/


     ArrayList<File> mySongs=findSongs(Environment.getRootDirectory());


        for(int i=0;i<mySongs.size();i++){

            toast(mySongs.get(i).getName().toString());
        }




    }

   public ArrayList<File>findSongs(File root){
        ArrayList<File> al= new ArrayList<>();
        File[] file=root.listFiles();

      for(File singelFile:file){

        if(singelFile.isDirectory()&& !singelFile.isHidden()){
        al.addAll(findSongs(singelFile));

        }
        else {
            al.add(singelFile);

        }
      }
      return al;

    }

    public void toast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();

    }

}
