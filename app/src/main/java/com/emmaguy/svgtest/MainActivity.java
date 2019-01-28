package com.emmaguy.svgtest;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener{
    private ImageView imageView;
    MediaPlayer m;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Что-то добавил
        Button button = (Button) findViewById(R.id.button);
        ToggleButton toogleButton = (ToggleButton) findViewById(R.id.toggleButton);
        button.setOnClickListener(this);
        toogleButton.setOnCheckedChangeListener(this);

        imageView = (ImageView) findViewById(R.id.imageview);

        final ContextThemeWrapper wrapper = new ContextThemeWrapper(this, R.style.DefaultScene);
        changeTheme(wrapper.getTheme());
    }

    private void changeTheme(@StyleRes final Resources.Theme theme) {
        final Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.christmas, theme);
        imageView.setImageDrawable(drawable);
    }

   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       final Resources.Theme theme = getResources().newTheme();
       if (isChecked) {
           theme.applyStyle(R.style.BaubleRound, false);
           theme.applyStyle(R.style.BaubleSmall, false);
       } else {
           theme.applyStyle(R.style.DefaultScene, false);
       }
       changeTheme(theme);
   }

    @Override
    public void onClick(View view) {
        /*m = new MediaPlayer();
        AssetFileDescriptor descriptor = null;
        try {
            descriptor = getAssets().openFd("Jingle_Bells.ogg");
            m.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();
            m.prepare();
            m.setVolume(1f, 1f);
            m.setLooping(true);
            m.start();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        switch (view.getId()){
            case R.id.startpause:
                if (m == null){
                    m = MediaPlayer.create(getApplicationContext(), R.raw.jingle_bells);
                    m.start();}
                else{m.pause();
                    m = null;}
                break;


        }




    }
}
