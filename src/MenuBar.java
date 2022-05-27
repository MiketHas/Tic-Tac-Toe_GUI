import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class MenuBar extends JMenuBar implements ActionListener {

    JMenu mProgram, mOptions, mInfo;
    JMenuItem iMainMenu, iExit, iAboutMe, iAboutRPS;
    JCheckBoxMenuItem cbMusic;
    ImageIcon imgMain, imgExit;
    URL musicURL;
    Clip clip;


    public MenuBar() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        imgMain = new ImageIcon(getClass().getClassLoader().getResource("res/imgMain.png"));
        imgExit = new ImageIcon(getClass().getClassLoader().getResource("res/imgExit.png"));

        musicURL = getClass().getResource("res/imp.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicURL);
        clip = AudioSystem.getClip();
        clip.open(audioStream);

        mProgram = new JMenu("Program");
        this.add(mProgram);

            iMainMenu = new JMenuItem("Main Menu");
            iMainMenu.setIcon(imgMain);
            iMainMenu.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
            iMainMenu.addActionListener(this);
            mProgram.add(iMainMenu);

            mProgram.addSeparator();

            iExit = new JMenuItem("Exit");
            iExit.setIcon(imgExit);
            iExit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
            iExit.addActionListener(this);
            mProgram.add(iExit);

        mOptions = new JMenu("Options");
        this.add(mOptions);

            cbMusic = new JCheckBoxMenuItem("Background sounds");
            cbMusic.addActionListener(this);
            mOptions.add(cbMusic);

        mInfo = new JMenu("Info");
        this.add(mInfo);

        iAboutMe = new JMenuItem("The creator");
        iAboutMe.addActionListener(this);
        mInfo.add(iAboutMe);
        iAboutRPS = new JMenuItem("The game");
        iAboutRPS.addActionListener(this);
        mInfo.add(iAboutRPS);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == iMainMenu) {
            MainPanel.resetToMainMode();
        } else if (source == iExit) {
            System.exit(0);
        } else if (source == cbMusic) {
            if (cbMusic.isSelected()) {
                clip.start();
            } else {
                clip.stop();
                clip.setMicrosecondPosition(0);
            }
        } else if (source == iAboutMe) {
            JOptionPane.showMessageDialog(this, "I never thought that at some point in my life I'd learn to code.\nThen again, I never thought I'd have anything to do with pharmaceutical industry,\nyet here I am, a \"Medical Consultant\" coding my Tic-Tac-Toe game!\nComing up next! A space-ship simulator!", "About Me", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == iAboutRPS) {
            JOptionPane.showMessageDialog(this, "This one took way longer than I thought it would. " +
                    "\nI had some problems with implementing the \"AI Battle Mode\", but it's working now. " +
                    "\nAlso I had to learn how to implement the timer so that the system's response move wouldn't be immidiate." +
                    "\nIt's still a \"work in progress\" so I'll be working on polishing the code within the app.");
        }
    }
}
