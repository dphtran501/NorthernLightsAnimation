package edu.orangecoastcollege.cs273.dtran258.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity
{

    ImageView lightsImage;
    Button frameAnimButton;
    Button rotateAnimButton;
    Button shakeAnimButton;
    Button customAnimButton;
    AnimationDrawable lightsFrameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImage = (ImageView) findViewById(R.id.lightsImageView);
        //lightsImage.setBackgroundResource(R.drawable.animation_frame);
        lightsImage.setImageResource(R.drawable.animation_frame);

        frameAnimButton = (Button) findViewById(R.id.frameAnimButton);
        rotateAnimButton = (Button) findViewById(R.id.rotateAnimButton);
        shakeAnimButton = (Button) findViewById(R.id.shakeAnimButton);
        customAnimButton = (Button) findViewById(R.id.customAnimButton);

        //lightsFrameAnimation = (AnimationDrawable) lightsImage.getBackground();
        lightsFrameAnimation = (AnimationDrawable) lightsImage.getDrawable();
    }

    public void animateFrames(View v)
    {
        if(lightsFrameAnimation.isRunning()) lightsFrameAnimation.stop();
        else lightsFrameAnimation.start();
    }
}
