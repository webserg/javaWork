package games.ticTacToe.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by webserg on 02.06.2014.
 */
public class TicTacToe extends JFrame {
    JPanel panel = new JPanel();
    XOButton button[] = new XOButton[9];
    ImageIcon imageIconX = new ImageIcon("C:\\git\\webserg-common\\trunk\\games\\ticTacToe\\gui\\X.PNG");
    ImageIcon imageIconO = new ImageIcon("C:\\git\\webserg-common\\trunk\\games\\ticTacToe\\gui\\O.jpg");


    public TicTacToe() {
        super("tic tac toe");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 3));
        panel.setVisible(true);
        this.setContentPane(panel);
        for (int i = 0; i < 9; i++) {
            button[i] = new XOButton(imageIconX, imageIconO);
            panel.add(button[i]);
        }
        setVisible(true);

    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
