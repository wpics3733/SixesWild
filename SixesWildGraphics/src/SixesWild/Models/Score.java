package SixesWild.Models;

/**
 *
 */
public class Score {

    Value currentScore;

    Value oneStarScore;
    Value twoStarScore;
    Value threeStarScore;


    public Score(Value oneStarScore, Value twoStarScore, Value threeStarScore) {
        this.oneStarScore = oneStarScore;
        this.twoStarScore = twoStarScore;
        this.threeStarScore = threeStarScore;

        this.currentScore = new Value(0);
    }

    public int getNumStar() {
        return 0;
    }

    public Value getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Value currentScore) {
        this.currentScore = currentScore;
    }

    public Value getOneStarScore() {
        return oneStarScore;
    }

    public void setOneStarScore(Value oneStarScore) {
        this.oneStarScore = oneStarScore;
    }

    public Value getTwoStarScore() {
        return twoStarScore;
    }

    public void setTwoStarScore(Value twoStarScore) {
        this.twoStarScore = twoStarScore;
    }

    public Value getThreeStarScore() {
        return threeStarScore;
    }

    public void setThreeStarScore(Value threeStarScore) {
        this.threeStarScore = threeStarScore;
    }
}