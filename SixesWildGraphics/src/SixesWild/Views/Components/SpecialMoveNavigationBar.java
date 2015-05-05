package SixesWild.Views.Components;

import SixesWild.Contracts.ImageContract;
import SixesWild.Contracts.TipContract;
import SixesWild.Controllers.GameScreen.ClearTileSpecialMoveController;
import SixesWild.Controllers.GameScreen.ResetBoardSpecialMoveController;
import SixesWild.Controllers.GameScreen.SwapSquareSpecialMoveController;
import SixesWild.Views.Application;
import SixesWild.Views.Components.IntegerLabelView;
import SixesWild.Views.Components.NavigationBar;
import SixesWild.Views.Components.SpecialMoveButton;

import java.awt.*;

public class SpecialMoveNavigationBar extends NavigationBar {

    //    Special move button colors
    final Color SPECIAL_MOVE_DISABLED_BACK_COLOR = new Color(162, 162, 162);
    final Color RESET_BOARD_SPECIAL_MOVE_NORMAL_BACK_COLOR = new Color(236, 64, 122);
    final Color RESET_BOARD_SPECIAL_MOVE_HOVERED_BACK_COLOR = new Color(236, 64, 122).brighter();
    final Color RESET_BOARD_SPECIAL_MOVE_ACTIVED_BACK_COLOR = new Color(236, 64, 122).darker();

    final Color SWAP_SQUARE_SPECIAL_MOVE_NORMAL_BACK_COLOR = new Color(141, 110, 99);
    final Color SWAP_SQUARE_SPECIAL_MOVE_HOVERED_BACK_COLOR = new Color(141, 110, 99).brighter();
    final Color SWAP_SQUARE_SPECIAL_MOVE_ACTIVED_BACK_COLOR = new Color(141, 110, 99).darker();

    final Color REMOVE_TILE_SPECIAL_MOVE_NORMAL_BACK_COLOR = new Color(255, 87, 34);
    final Color REMOVE_TILE_SPECIAL_MOVE_HOVERED_BACK_COLOR = new Color(255, 87, 34).brighter();
    final Color REMOVE_TILE_SPECIAL_MOVE_ACTIVED_BACK_COLOR = new Color(255, 87, 34).darker();

    //    Special move button bounds
    final Rectangle SWAP_SQUARE_SPECIAL_MOVE_BOUNDS = new Rectangle(
            878,
            7,
            (int) SpecialMoveButton.SPECIAL_MOVE_BUTTON_SIZE.getWidth(),
            (int) SpecialMoveButton.SPECIAL_MOVE_BUTTON_SIZE.getHeight()
    );

    final Rectangle RESET_BOARD_SPECIAL_MOVE_BOUNDS = new Rectangle(
            924,
            7,
            (int) SpecialMoveButton.SPECIAL_MOVE_BUTTON_SIZE.getWidth(),
            (int) SpecialMoveButton.SPECIAL_MOVE_BUTTON_SIZE.getHeight()
    );

    final Rectangle REMOVE_TILE_SPECIAL_MOVE_BOUNDS = new Rectangle(
            970,
            7,
            (int) SpecialMoveButton.SPECIAL_MOVE_BUTTON_SIZE.getWidth(),
            (int) SpecialMoveButton.SPECIAL_MOVE_BUTTON_SIZE.getHeight()
    );

    SpecialMoveButton swapSquareSpecialMoveView;
    SpecialMoveButton resetBoardSpecialMoveView;
    SpecialMoveButton clearSquareSpecialMoveView;

    int swapSquareSpecialMoveLeft;
    int resetBoardSpecialMoveLeft;
    int removeTileSpecialMoveLeft;

    public SpecialMoveNavigationBar(Application app, int swapSquareSpecialMoveLeft, int resetBoardSpecialMoveLeft, int removeTileSpecialMoveLeft) {
        super(app);
        this.swapSquareSpecialMoveLeft = swapSquareSpecialMoveLeft;
        this.resetBoardSpecialMoveLeft = resetBoardSpecialMoveLeft;
        this.removeTileSpecialMoveLeft = removeTileSpecialMoveLeft;

        setUpSpecialMoveButtons();
    }

    public void setUpSpecialMoveButtons() {

//        Swap square special move button
        getSwapSquareSpecialMoveView().setBounds(SWAP_SQUARE_SPECIAL_MOVE_BOUNDS);

        SwapSquareSpecialMoveController swapSquareSpecialMoveController = new SwapSquareSpecialMoveController(getSwapSquareSpecialMoveView(), this);
        getSwapSquareSpecialMoveView().addMouseListener(swapSquareSpecialMoveController);
        getSwapSquareSpecialMoveView().addMouseMotionListener(swapSquareSpecialMoveController);

        getSwapSquareSpecialMoveView().setToolTipText(TipContract.SWAP_SQUARE_SPECIAL_MOVE_TIP);

        add(getSwapSquareSpecialMoveView());
        getSwapSquareSpecialMoveView().repaint();

//        Reset board special move button
        getResetBoardSpecialMoveView().setBounds(RESET_BOARD_SPECIAL_MOVE_BOUNDS);

        ResetBoardSpecialMoveController resetBadgeButtonController = new ResetBoardSpecialMoveController(getResetBoardSpecialMoveView(), this);
        getResetBoardSpecialMoveView().addMouseListener(resetBadgeButtonController);
        getResetBoardSpecialMoveView().addMouseMotionListener(resetBadgeButtonController);

        getResetBoardSpecialMoveView().setToolTipText(TipContract.RESET_BOARD_SPECIAL_MOVE_TIP);

        add(getResetBoardSpecialMoveView());
        getResetBoardSpecialMoveView().repaint();

//        Clear tile special move button
        getClearSquareSpecialMoveView().setBounds(REMOVE_TILE_SPECIAL_MOVE_BOUNDS);

        ClearTileSpecialMoveController clearTileSpecialMoveController = new ClearTileSpecialMoveController(getClearSquareSpecialMoveView(), this);
        getClearSquareSpecialMoveView().addMouseListener(clearTileSpecialMoveController);
        getClearSquareSpecialMoveView().addMouseMotionListener(clearTileSpecialMoveController);

        getClearSquareSpecialMoveView().setToolTipText(TipContract.CLEAR_TILE_SPECIAL_MOVE_TIP);

        add(getClearSquareSpecialMoveView());
        getClearSquareSpecialMoveView().repaint();
    }

    public SpecialMoveButton getSwapSquareSpecialMoveView() {
        if (swapSquareSpecialMoveView == null) {
            swapSquareSpecialMoveView = new SpecialMoveButton(
                    ImageContract.SWAP_SQUARE_SPECIAL_MOVE_IMAGE,
                    ImageContract.SWAP_SQUARE_SPECIAL_MOVE_IMAGE,
                    ImageContract.SWAP_SQUARE_SPECIAL_MOVE_IMAGE,
                    ImageContract.SWAP_SQUARE_SPECIAL_MOVE_IMAGE,
                    SWAP_SQUARE_SPECIAL_MOVE_NORMAL_BACK_COLOR,
                    SWAP_SQUARE_SPECIAL_MOVE_HOVERED_BACK_COLOR,
                    SWAP_SQUARE_SPECIAL_MOVE_ACTIVED_BACK_COLOR,
                    SPECIAL_MOVE_DISABLED_BACK_COLOR,
                    swapSquareSpecialMoveLeft
            );
        }
        return swapSquareSpecialMoveView;
    }

    public SpecialMoveButton getResetBoardSpecialMoveView() {
        if (resetBoardSpecialMoveView == null) {
            resetBoardSpecialMoveView = new SpecialMoveButton(
                    ImageContract.RESET_BOARD_SPECIAL_MOVE_IMAGE,
                    ImageContract.RESET_BOARD_SPECIAL_MOVE_IMAGE,
                    ImageContract.RESET_BOARD_SPECIAL_MOVE_IMAGE,
                    ImageContract.RESET_BOARD_SPECIAL_MOVE_IMAGE,
                    RESET_BOARD_SPECIAL_MOVE_NORMAL_BACK_COLOR,
                    RESET_BOARD_SPECIAL_MOVE_HOVERED_BACK_COLOR,
                    RESET_BOARD_SPECIAL_MOVE_ACTIVED_BACK_COLOR,
                    SPECIAL_MOVE_DISABLED_BACK_COLOR,
                    resetBoardSpecialMoveLeft
            );
        }
        return resetBoardSpecialMoveView;
    }

    public SpecialMoveButton getClearSquareSpecialMoveView() {
        if (clearSquareSpecialMoveView == null) {
            clearSquareSpecialMoveView = new SpecialMoveButton(
                    ImageContract.REMOVE_TILE_SPECIAL_MOVE_IMAGE,
                    ImageContract.REMOVE_TILE_SPECIAL_MOVE_IMAGE,
                    ImageContract.REMOVE_TILE_SPECIAL_MOVE_IMAGE,
                    ImageContract.REMOVE_TILE_SPECIAL_MOVE_IMAGE,
                    REMOVE_TILE_SPECIAL_MOVE_NORMAL_BACK_COLOR,
                    REMOVE_TILE_SPECIAL_MOVE_HOVERED_BACK_COLOR,
                    REMOVE_TILE_SPECIAL_MOVE_ACTIVED_BACK_COLOR,
                    SPECIAL_MOVE_DISABLED_BACK_COLOR,
                    removeTileSpecialMoveLeft
            );
        }
        return clearSquareSpecialMoveView;
    }

    public void setAllMoveButtonNormal() {
        getSwapSquareSpecialMoveView().inactive();
        getResetBoardSpecialMoveView().inactive();
        getClearSquareSpecialMoveView().inactive();
    }
}