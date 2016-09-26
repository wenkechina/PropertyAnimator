package wenke.makelove.propertyanimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by wenke on 09/04/2016.
 */
public class InstanceTwoActivity extends Activity {
    private FrameLayout linear1;
    private FrameLayout linear2;
    private FrameLayout linear3;
    private FrameLayout linear4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instancetwo);
        linear1 = (FrameLayout) findViewById(R.id.linear1);
        linear2 = (FrameLayout) findViewById(R.id.linear2);
        linear3 = (FrameLayout) findViewById(R.id.linear3);
        linear4 = (FrameLayout) findViewById(R.id.linear4);

        Button open = (Button) findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginRotationAni();
            }
        });
    }
    /**
     * 开启动画
     */
    private void beginRotationAni() {
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(linear1, "rotation", 0f, 360f);
        rotation1.setDuration(2000);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(linear2, "rotation", 0f, 360f);
        rotation2.setStartDelay(100);
        rotation2.setDuration(2000 + 100);
        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(linear3, "rotation", 0f, 360f);
        rotation3.setStartDelay(2 * 100);
        rotation3.setDuration(2000 + 2 * 100);
        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(linear4, "rotation", 0f, 360f);
        rotation4.setStartDelay(3 * 100);
        rotation4.setDuration(2000 + 3 * 100);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(rotation1).with(rotation2).with(rotation3).with(rotation4);
        animatorSet.start();
    }
}
