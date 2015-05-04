package SixesWild.Views.Components;

import java.awt.*;

/**
 * Created by harryliu on 5/3/15.
 */
public class LockableButton extends StyledButton {

//    Background color for locked button
    public static Color LOCKED_BACK_COLOR = new Color(99,99,99);

    boolean lockStatus;

    public LockableButton(
            Color normalBackColor,
            Color hoverBackColor,
            Color activeBackColor,
            Color disableBackColor,
            boolean lockStatus) {
        super(
                normalBackColor,
                hoverBackColor,
                activeBackColor,
                disableBackColor
        );
        this.lockStatus = lockStatus;
    }

    public boolean isLocked() {
        return lockStatus;
    }

    public void unlock() {
        lockStatus = false;
    }

    public void lock() {
        lockStatus = true;
    }

    public void setLockStatus(boolean lockStatus) {
        this.lockStatus = lockStatus;
    }
}
