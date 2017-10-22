package edu.orangecoastcollege.cs273.dtran258.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * This activity displays an image that the user can animate by clicking on one of four buttons. The
 * user can choose to play a frame-by-frame animation, rotate the image, shake the image, or play a
 * custom animation.
 *
 * @author Derek Tran
 * @version 1.0
 * @since October 21, 2017
 */
public class AnimationActivity extends AppCompatActivity
{
    // AnimationDrawable = used for frame animations
    private AnimationDrawable frameAnim;
    // Animation = used for tween(ed) animations
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    private ImageView lightsImageView;

    /**
     * Initializes <code>MainActivity</code> by inflating its UI.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    /**
     * Toggles the frame animation of the image.
     * @param v The view that called this method.
     */
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

    /**
     * Toggles rotation animation of the image.
     * @param v The view that called this method.
     */
    public void toggleRotateAnim(View v)
    {
        // hasn't been initialized yet
        if(rotateAnim == null) rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);

        if(!rotateAnim.hasStarted() || rotateAnim.hasEnded())
            lightsImageView.startAnimation(rotateAnim); // Connect to image view
        else
            lightsImageView.clearAnimation();
    }

    /**
     * Toggles shake animation of the image.
     * @param v The view that called this method.
     */
    public void toggleShakeAnim(View v)
    {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);
    }

    /**
     * Toggles custom animation of the image.
     * @param v The view that called this method.
     */
    public void toggleCustomAnim(View v)
    {
        if(customAnim == null)customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim);

        if(!customAnim.hasStarted() || customAnim.hasEnded())
            lightsImageView.startAnimation(customAnim);
        else
            lightsImageView.clearAnimation();
    }
}
