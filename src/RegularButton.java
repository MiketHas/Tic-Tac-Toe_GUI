import javax.swing.*;
import java.awt.*;

public class RegularButton extends JButton {

    String name;
    int x;
    int y;
    int width;
    int height;
    boolean visible;

    public RegularButton(String name, int x, int y, int width, int height, boolean visible) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = visible;

        this.setText(name);
        this.setFont(new Font("Consolas", Font.PLAIN, 16));
        this.setForeground(Color.WHITE);
        this.setBounds(x, y, width, height);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
        this.setVisible(visible);

    }
}
