package Logic;

import View.Interface;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: katch
 * Date: 04.07.13
 * Time: 9:37
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface();
            }
        });
    }
}
