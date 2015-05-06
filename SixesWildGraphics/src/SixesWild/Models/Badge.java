package SixesWild.Models;

/**
 *
 */
public class Badge extends Unlockable {

    String name;

    String introduction;

    public Badge(boolean unlockState) {
        super(unlockState);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}