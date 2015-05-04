package SixesWild.Models;

import SixesWild.Views.TransitableView;

/**
 *
 */
public class TransitableValue {

    int currentValue;
    int startValue;
    int endValue;
    long time;
    long currentTime;

    TransitableView transitableView;

    int animationOrder;

    public TransitableValue(int startValue, int endValue, long time, TransitableView transitableView) {
        this.startValue = startValue;
        this.endValue = endValue;
        this.transitableView = transitableView;
        this.time = time;

        currentValue = this.startValue;

    }

    public int getGravitySpeed() {
//        int
        return 0;
    }
}