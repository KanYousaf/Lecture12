package com.example.kanwal.gamedevelopment;

import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

public class Sprite {
    private static final String TAG="Velocity_finder";

    public RectF rectF=new RectF();
    public float dx = 0;
    public float dy = 0;
    Paint paint=new Paint();

    public Sprite() {
    }


    public void setLocation(float x, float y){
        rectF.offset(x, y);
    }

    public void setSize(float width, float height){
        rectF.right=rectF.left + width;
        rectF.bottom=rectF.top + height;

        Log.i(TAG, "The value of rectF.right is"+String.valueOf(rectF.right));
        Log.i(TAG, "The value of rectF.left is"+String.valueOf(rectF.left));
        Log.i(TAG, "The value of rectF.top is"+String.valueOf(rectF.top));
        Log.i(TAG, "The value of rectF.bottom is"+String.valueOf(rectF.bottom));
    }

    public void setVelocity(float dx, float dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void move(){
        rectF.offset(dx,dy);
    }
}
