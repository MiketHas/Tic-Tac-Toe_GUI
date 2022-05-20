import javax.swing.*;

public class GameButton extends JButton {

    int x;
    int y;

    GameButton(int x, int y) {

        this.x = x;
        this.y = y;

        this.setBounds(x, y, 130, 100);
        this.setContentAreaFilled(false); // button area is transparent
        this.setBorderPainted(false); // border of a button
        this.setFocusPainted(false); // focus after click
        this.setVisible(true);

    }
}
