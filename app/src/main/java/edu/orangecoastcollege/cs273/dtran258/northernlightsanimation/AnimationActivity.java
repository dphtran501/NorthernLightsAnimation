package edu.orangecoastcollege.cs273.dtran258.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity
{
    // AnimationDrawable = used for frame animations
    private AnimationDrawable frameAnim;
    // Animation = used for tween(ed) animations
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    private ImageView lightsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    public void toggleFrameAnim(View v)
    {
        // hasn't been initialized yet
        if (frameAnim == null)
        {
            lightsImageView.setImageResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getDrawable();
        }

        // if frameAnim is running, stop it; else start it
        if(frameAnim.isRunning()) frameAnim.stop();
        else frameAnim.start();
    }

    public void toggleRotateAnim(View v)
    {
        // hasn't been initialized yet
        if(rotateAnim == null) rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);

        if(!rotateAnim.hasStarted() || rotateAnim.hasEnded())
            lightsImageView.startAnimation(rotateAnim); // Connect to image view
        else
            lightsImageView.clearAnimation();
    }

    public void toggleShakeAnim(View v)
    {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);
    }
}
