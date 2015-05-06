package SixesWild.Models;

/**
 *
 */
public class Value {

    long value;

    public Value(long value) {
        this.value = value;
    }

    public void increase(long amount) {
        value += amount;
    }

    public void decrease(long amount) {
        value -= amount;
    }

    public void multiply(long amount) {
        value *= amount;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new Long(value).toString();
    }
}