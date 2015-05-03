package SixesWild;

import SixesWild.Views.Application;

import javax.swing.*;

/**
 * Created by harryliu on 4/30/15.
 */
public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
