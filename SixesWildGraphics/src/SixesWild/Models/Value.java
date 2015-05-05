package SixesWild.Models;

/**
 *
 */
public class Value {

    int value;

    public Value(int value) {
        this.value = value;
    }

    public void increase(int amount) {
        value += amount;
    }

    public void decrease(int amount) {
        value -= amount;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}