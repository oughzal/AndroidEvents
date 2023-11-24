package ma.ofppt.androidevents;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import ma.ofppt.androidevents.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {
    ActivityMainBinding binding;
    GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
        binding.root.setOnTouchListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       /* switch (event.getAction()){
            case MotionEvent.ACTION_DOWN : binding.txtAction.setText("down");break;
            case MotionEvent.ACTION_UP : binding.txtAction.setText("Up");break;
            case MotionEvent.ACTION_MOVE: binding.txtAction.setText("Move : x:"+ event.getX()+", y:"+ event.getY());break;
            case MotionEvent.ACTION_SCROLL: binding.txtAction.setText("Scroll");break;
        }

        */
        gestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent e) {
        binding.txtAction.setText("DoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        //binding.txtAction.setText("down");
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        String out = "";
        if (distanceX > 0) {
            out += "à Gauche";
        } else {
            out += "à Droit";
        }
        if (distanceY > 0) {
            out += "\nen Haut";
        } else {
            out += "\nen Bas";
        }


        binding.txtAction.setText(out);
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}