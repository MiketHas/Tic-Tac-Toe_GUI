import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LaunchFrame extends JFrame {

    MainPanel myPanel;
    MenuBar myBar;

    public LaunchFrame() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.setTitle("Tic-Tac-Toe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/icon.png"));
        Image newIcon = icon.getScaledInstance(450, 450, 100);
        setIconImage(newIcon);

        myBar = new MenuBar();
        setJMenuBar(myBar);

        myPanel = new MainPanel();
        this.add(myPanel);

        this.pack();
        this.setLocationRelativeTo(null); // This will center the GUI_app on a screen
        this.setVisible(true);
    }
}
