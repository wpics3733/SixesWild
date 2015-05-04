package SixesWild.Views.Animation;

import SixesWild.Models.TransitableValue;

import java.util.Iterator;
import java.util.Timer;


public class AnimationManager {

    //    2D animation frame rate, 25 frames per second
    public static final long ANIMATION_FRAME_RATE = 40;

    TransitableValue[] transitions;
    Timer timer;
    AnimationTimerTask animationTimerTask;

    public AnimationManager() {
        timer = new Timer();
        animationTimerTask = new AnimationTimerTask();

//        timer.scheduleAtFixedRate(
//                animationTimerTask,
//
//                );
    }

    public void add(TransitableValue value) {

    }


    public void remove(TransitableValue value) {

    }

    /**
     * @return
     */
    public Iterator<TransitableValue> iterator() {
        return null;
    }

    /**
     * @return
     */
    public void run() {

    }

}