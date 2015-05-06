package SixesWild.Moves;

import SixesWild.Views.Application;

/**
 *
 */
public interface IMove {

    public boolean isValid();
    public boolean doMove(Application app);

}