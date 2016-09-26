package wenke.makelove.propertyanimator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by wenke on 09/02/2016.
 */
public class ValueAnimatorExam extends Activity{
    private LinearLayout view;
    private boolean flag=true;
    private ImageView downArrow;
    private ViewGroup.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valueanimator);
        view = (LinearLayout) findViewById(R.id.backgroud);
        layoutParams = view.getLayoutParams();
        downArrow = (ImageView) findViewById(R.id.imagearrow);
        downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {

                    ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 800);
                    valueAnimator.setDuration(500);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            final int currentValue = (int) animation.getAnimatedValue();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    layoutParams.height = currentValue;
                                    view.setLayoutParams(layoutParams);
                                }
                            });
                        }
                    });
                    valueAnimator.start();
                    ObjectAnimator rotation = ObjectAnimator.ofFloat(downArrow, "rotationX", 0f, 180f);
                    rotation.setDuration(500);
                    rotation.start();
                    flag = false;
                } else {
                    final ValueAnimator valueAnimator = ValueAnimator.ofInt(800, 0);
                    valueAnimator.setDuration(500);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            final int currentValue = (int) animation.getAnimatedValue();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    layoutParams.height = currentValue;
                                    view.setLayoutParams(layoutParams);
                                }
                            });
                        }
                    });
                    valueAnimator.start();
                    ObjectAnimator rotation = ObjectAnimator.ofFloat(downArrow, "rotationX", 180f, 0f);
                    rotation.setDuration(500);
                    rotation.start();
                    flag = true;
                }
            }
        });
    }
}