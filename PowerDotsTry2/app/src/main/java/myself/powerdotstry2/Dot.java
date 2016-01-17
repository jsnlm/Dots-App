package myself.powerdotstry2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.content.SharedPreferences;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by j on 2016-01-15.
 */
class Dot extends View {
    private float initialX;
    private float initialY;
    private float offsetX;
    private float offsetY;
    private float xPos, yPos;
    private Paint myPaint;
    private Paint backgroundPaint;
    singleDot[] Dots;
    boolean isScreenTouched;
    int theadDelay;

    public Dot(Context context, AttributeSet attrs) {
        super(context, attrs);

        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.BLACK);

        myPaint = new Paint();
        myPaint.setColor(Color.WHITE);
        myPaint.setAntiAlias(true);
        isScreenTouched = false;

//        int width = canvas.getWidth();
//        int height = canvas.getHeight();
        int width = context.getResources().getDisplayMetrics().widthPixels;
        int height = context.getResources().getDisplayMetrics().heightPixels;
        Random r = new Random();

        SharedPreferences sharedPref = context.getSharedPreferences("abcd", Context.MODE_PRIVATE);
        int numObjects = sharedPref.getInt(context.getResources().getString(R.string.aeigjeigo), Integer.parseInt(context.getResources().getString(R.string.defaultNumObjects)));

        int defaultFPS = Integer.parseInt(context.getResources().getString(R.string.defaultFPS));
        int fps = sharedPref.getInt(context.getResources().getString(R.string.aerthujyu), defaultFPS );
        theadDelay = 1000/fps;
        singleDot.maxAcceleration = .25f * defaultFPS /fps; //60 was the expected frame rate

        Dots = new singleDot[numObjects];
        //Dots = new singleDot[defaultValue];
        for (int i = 0; i < Dots.length; i++){
            Dots[i] = new singleDot(r.nextFloat() * width, r.nextFloat() * height);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        this.xPos = event.getX();
        this.yPos = event.getY();

        if (action == MotionEvent.ACTION_UP)
            isScreenTouched = false;
        else if (action == MotionEvent.ACTION_DOWN){
            isScreenTouched = true;
        }

//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
////                initialX = x;
////                initialY = y;
////                offsetX = event.getX();
////                offsetY = event.getY();
//                for (int i = 0; i < Dots.length; i++){
//                    Dots[i].updateAcceleration(xPos, yPos);
//                }
//                break;
//            case MotionEvent.ACTION_MOVE:
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
////                x = initialX + event.getX() - offsetX;
////                y = initialY + event.getY() - offsetY;
//
//                for (int i = 0; i < Dots.length; i++){
//                    Dots[i].updateAcceleration(xPos, yPos);
//                }
//                break;
//        }
        return (true);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.drawRect(0, 0, width, height, backgroundPaint);

        if(isScreenTouched){
            for (int i = 0; i < Dots.length ; i++){
                Dots[i].updateAcceleration(xPos, yPos);
                Dots[i].update();
                canvas.drawPoint(Dots[i].x , Dots[i].y , myPaint);
            }
        }
        else{
            for (int i = 0; i < Dots.length ; i++){
                Dots[i].update();
                canvas.drawPoint(Dots[i].x , Dots[i].y , myPaint);
            }
        }

        try {
            Thread.sleep(theadDelay);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        invalidate();
    }
}