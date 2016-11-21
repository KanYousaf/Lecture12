package com.example.kanwal.gamedevelopment;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class BounceBall extends View{
    private DrawingThread drawingThread;
    private static final float BALL_SIZE=100;
    private static final float BALL_MAX_VELOCITY = 80;
    private Sprite Ball;
    public BounceBall(Context context, AttributeSet attrs) {
        super(context, attrs);

        Ball=new Sprite();
        Ball.setLocation(200, 200);
        Ball.setSize(BALL_SIZE, BALL_SIZE);

        float a=(float)(Math.random()-0.5)*BALL_MAX_VELOCITY;
        float b=(float)(Math.random()-0.5)*BALL_MAX_VELOCITY;
        Ball.setVelocity(a, b);

        Ball.paint.setARGB(255, 255, 0, 0);

        drawingThread=new DrawingThread(this, 50);
        drawingThread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawARGB(255, 255, 255, 0);
        canvas.drawOval(Ball.rectF, Ball.paint);
        updateSpirtes();
    }

    public void updateSpirtes(){
        Ball.move();

        if(Ball.rectF.left < 0 || Ball.rectF.right >= getWidth()){
            Ball.dx= -Ball.dx;
        }

        if(Ball.rectF.top < 0 || Ball.rectF.bottom >= getHeight()){
            Ball.dy= -Ball.dy;
        }
    }
}