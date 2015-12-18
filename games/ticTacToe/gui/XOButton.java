package games.ticTacToe.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by webserg on 02.06.2014.
 */
public class XOButton extends JButton implements ActionListener {
    ImageIcon X, O;
    byte value = 0;

    public XOButton(ImageIcon imageIconX, ImageIcon imageIconO) {
        X = imageIconX;
        O = imageIconO;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        value++;
        value %= 3;
        switch (value) {
            case 0:
                setIcon(null);
                break;
            case 1:
                setIcon(X);
                break;
            case 2:
                setIcon(O);
                break;
        }
    }
}
