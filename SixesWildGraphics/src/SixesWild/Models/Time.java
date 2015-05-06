package SixesWild.Models;

/**
 *
 */
public class Time {

    Value currentTime;

    Value endTime;

    public Time(int endTime) {
        currentTime = new Value(0);
        this.endTime = new Value(endTime);
    }

    public Value getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Value currentTime) {
        this.currentTime = currentTime;
    }

    public Value getEndTime() {
        return endTime;
    }

    public void setEndTime(Value endTime) {
        this.endTime = endTime;
    }
}