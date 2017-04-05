package com.example.boylan19.cannonmainactivity;

import android.graphics.*;
import android.view.MotionEvent;

/**
 * Created by boylan19 on 4/4/2017.
 */
public class Target implements Animator {
    private int count = 0;
    private boolean goBackwards = false;

    public int interval() {
        return 30;
    }

    public int backgroundColor() {
        return Color.rgb(40, 200, 54);
    }

    public void goBackwards(boolean b) {
        goBackwards = b;
    }

    public void tick(Canvas g) {

        if (goBackwards) {
            count--;
        }
        else {
            count++;
        }


        int num = (count*15)%600;
        if (num < 0) num += 600;

        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        g.drawCircle(num, num, 60, redPaint);
    }


    public boolean doPause() {
        return false;
    }


    public boolean doQuit() {
        return false;
    }


    public void onTouch(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            goBackwards = !goBackwards;
        }
    }


}
