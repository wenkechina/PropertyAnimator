package wenke.makelove.propertyanimator;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView image;
    private float curTranslationX;
    private float curTranslationY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        image = (ImageView) findViewById(R.id.testimage);
        curTranslationX = image.getTranslationX();
        curTranslationY = image.getTranslationY();



        findViewById(R.id.alpha).setOnClickListener(this);
        findViewById(R.id.rotation).setOnClickListener(this);
        findViewById(R.id.scale).setOnClickListener(this);
        findViewById(R.id.translation).setOnClickListener(this);
        findViewById(R.id.animatorSet).setOnClickListener(this);
        findViewById(R.id.propertyvaluesholder).setOnClickListener(this);
        findViewById(R.id.rotationx).setOnClickListener(this);
        findViewById(R.id.rotationy).setOnClickListener(this);
        findViewById(R.id.animatorListener).setOnClickListener(this);
        findViewById(R.id.ValueAnimator).setOnClickListener(this);
        findViewById(R.id.InstanceTwo).setOnClickListener(this);
        findViewById(R.id.XML1).setOnClickListener(this);
        findViewById(R.id.ViewAnimation).setOnClickListener(this);
    }

    private void beginTranslationAmi() {

        ObjectAnimator translationX = ObjectAnimator.ofFloat(image, "translationX", curTranslationX, -300f, curTranslationX);

        ObjectAnimator translationY = ObjectAnimator.ofFloat(image, "translationY", curTranslationY, -300f, curTranslationY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(translationX).with(translationY);
        animatorSet.setDuration(3000);
        animatorSet.start();

    }

    private void beginScaleAmi() {

        ObjectAnimator scalex = ObjectAnimator.ofFloat(image, "scaleX", 1f, 0.5f, 1f, 2f, 1f);
        scalex.setInterpolator(new LinearInterpolator());
        scalex.setDuration(3000);
        ObjectAnimator scaley = ObjectAnimator.ofFloat(image, "scaleY", 1f, 0.5f, 1f, 2f, 1f);
        scaley.setInterpolator(new LinearInterpolator());
        scaley.setDuration(3000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scalex).with(scaley);
        animatorSet.start();

    }

    private void beginAlphaAmi() {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(image, "alpha", 1f, 0f, 1f);
        alpha.setDuration(2000);
        alpha.start();

    }

    /**
     * 开启动画
     */
    private void beginRotationAni() {
        ObjectAnimator rotation = ObjectAnimator.ofFloat(image, "rotation", 0, 360);
        rotation.setDuration(2000).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alpha:
                beginAlphaAmi();
                break;
            case R.id.rotation:
                beginRotationAni();
                break;
            case R.id.scale:
                beginScaleAmi();
                break;
            case R.id.translation:
                beginTranslationAmi();
                break;
            case R.id.animatorSet:
                beginAnimatorSet();
                break;
            case R.id.propertyvaluesholder:
                beginPropertyAmi();
                break;
            case R.id.rotationx:
                beginRotationX();
                break;
            case R.id.rotationy:
                beginRotationY();
                break;
            case R.id.animatorListener:
                beginAnimatorListener();
                break;
            case R.id.ValueAnimator:
                startActivity(new Intent(MainActivity.this, ValueAnimatorExam.class));
                break;
            case R.id.InstanceTwo:
                startActivity(new Intent(MainActivity.this,InstanceTwoActivity.class));
                break;
            case R.id.XML1:
                beginXMLanimator();

                break;
            case R.id.XML2:

                break;
            case R.id.ViewAnimation:
                startActivity(new Intent(MainActivity.this,ViewAnimation.class));
                break;
        }
    }

    private void beginXMLanimator() {
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animator_xml_set);
        animatorSet.setTarget(image);
        animatorSet.start();
    }

    private void beginAnimatorListener() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(image, "zhy", 1.0F,  0.0F,1.0f)
                .setDuration(4000);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                float cVal = (Float) animation.getAnimatedValue();
                image.setAlpha(cVal);
                image.setScaleX(cVal);
                image.setScaleY(cVal);
            }
        });
    }

    private void beginRotationY() {
        ObjectAnimator rotationy = ObjectAnimator.ofFloat(image, "rotationY", 0, 360);
        rotationy.setDuration(3000);
        rotationy.start();
    }

    private void beginRotationX() {
        ObjectAnimator rotationx = ObjectAnimator.ofFloat(image, "rotationX", 0, 360);
        rotationx.setDuration(3000);
        rotationx.start();
    }


    private void beginAnimatorSet() {
        ObjectAnimator translationY = ObjectAnimator.ofFloat(image, "translationY", curTranslationY, -800);
        translationY.setDuration(500);
        ObjectAnimator scalex = ObjectAnimator.ofFloat(image, "scaleX", 1f, 0.5f);
        scalex.setInterpolator(new LinearInterpolator());
        ObjectAnimator scaley = ObjectAnimator.ofFloat(image, "scaleY", 1f, 0.5f);
        scaley.setInterpolator(new LinearInterpolator());
        ObjectAnimator rotation = ObjectAnimator.ofFloat(image, "rotation", 0, 360);
        rotation.setDuration(2000);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(image, "alpha", 1f, 0f, 1f);
        alpha.setDuration(3000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(translationY).with(scalex).with(scaley).before(rotation);
        animatorSet.play(alpha).after(rotation);
        animatorSet.start();
    }
    private void beginPropertyAmi() {
        PropertyValuesHolder propertyVHx = PropertyValuesHolder.ofFloat("scaleX", 1f, 0.5f, 1f, 2f, 1f);
        PropertyValuesHolder propertyVHy = PropertyValuesHolder.ofFloat("scaleY", 1f, 0.5f, 1f, 2f, 1f);
        ObjectAnimator.ofPropertyValuesHolder(image, propertyVHx, propertyVHy).setDuration(3000).start();
    }
}
