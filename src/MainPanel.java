import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 1000;
    final int PANEL_HEIGHT = 650;
    static int player1Score = 0, player2Score = 0;

    static JTextPane textPane;
    static RegularButton startButton, gameModeButton, speedButton;
    static JLabel scoreLabel, messageLabel;
    JLabel k2soLabel;
    static JLabel r5Label;

    static boolean regularMode = true;
    static SinglePlayerPanel singlePlayerPanel;
    static AiWar aiWar;
    ImageIcon k2so, r5;

    ImageIcon background;
    Image bcgImage;

    public MainPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);
        background = new ImageIcon(getClass().getClassLoader().getResource("res/death_wall.jpg"));
        bcgImage = background.getImage();

        k2so = new ImageIcon(getClass().getClassLoader().getResource("res/k2so.png"));
        k2soLabel = new JLabel();
        k2soLabel.setIcon(k2so);
        k2soLabel.setBounds(723, 150, 177, 400);

        r5 = new ImageIcon(getClass().getClassLoader().getResource("res/r5.png"));
        r5Label = new JLabel();
        r5Label.setIcon(r5);
        r5Label.setBounds(100, 250, 177, 400);
        r5Label.setVisible(false);

        textPane = new JTextPane();
        textPane.setBounds(325, 50, 350, 100);
        textPane.setText("--- Tic-Tac-Toe ---\nYou know the rules!");
        textPane.setFont(new Font("Consolas", Font.PLAIN, 16));
        textPane.setForeground(Color.WHITE);
        textPane.setEditable(false);
        textPane.setOpaque(false);

        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        singlePlayerPanel = new SinglePlayerPanel();
        singlePlayerPanel.setBounds(310, 150, 390, 300);
        singlePlayerPanel.setFocusable(true);
        singlePlayerPanel.setVisible(false);
        singlePlayerPanel.setOpaque(false);

        aiWar = new AiWar();
        aiWar.setBounds(310, 150, 390, 300);
        aiWar.setFocusable(true);
        aiWar.setVisible(false);
        aiWar.setOpaque(false);

        startButton = new RegularButton("ENGAGE", 450, 550, 100, 30, true);
        startButton.addActionListener(this);

        gameModeButton = new RegularButton("AI Battle", 20, 590, 140, 30, true);
        gameModeButton.addActionListener(this);

        speedButton = new RegularButton("Speed up!", 560, 550, 140, 30, false);
        speedButton.addActionListener(this);

        scoreLabel = new JLabel();
        scoreLabel.setText("Player " + player1Score + ":" + player2Score + " K2-SO");
        scoreLabel.paintImmediately(scoreLabel.getVisibleRect());
        scoreLabel.setFont(new Font("Consolas", Font.PLAIN, 16));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(50,0,300,50);
        scoreLabel.setEnabled(true);

        messageLabel = new JLabel();
        messageLabel.setText("Game ON!");
        messageLabel.setFont(new Font("Consolas", Font.PLAIN, 16));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setBounds(450,450,300,100);
        messageLabel.setEnabled(true);

        this.add(k2soLabel);
        this.add(r5Label);
        this.add(messageLabel);
        this.add(scoreLabel);
        this.add(textPane);
        this.add(singlePlayerPanel);
        this.add(aiWar);
        this.add(startButton);
        this.add(gameModeButton);
        this.add(speedButton);
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) { // background Image
        super.paintComponent(g);
        g.drawImage(bcgImage, 0,0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (regularMode) {
            if (source == gameModeButton) {
                player1Score = 0;
                player2Score = 0;
                scoreLabel.setText("R5-J2 " + player1Score + ":" + player2Score + " K2-SO");
                r5Label.setVisible(true);
                gameModeButton.setText("vs Player");
                startButton.setText("ENGAGE");
                singlePlayerPanel.setVisible(false);
                aiWar.setVisible(true);
                regularMode = false;
            } else if (source == startButton) {
                singlePlayerPanel.setVisible(true);
                startButton.setText("RESTART");
                singlePlayerPanel.restart();
            }
        } else {
            if (source == gameModeButton) {
                AiWarCompOpponent.timer.stop();
                player1Score = 0;
                player2Score = 0;
                scoreLabel.setText("Player " + player1Score + ":" + player2Score + " K2-SO");
                textPane.setText("--- Tic-Tac-Toe ---\nYou know the rules!");
                r5Label.setVisible(false);
                gameModeButton.setText("AI Battle");
                startButton.setText("ENGAGE");
                aiWar.setVisible(false);
                speedButton.setVisible(false);
                regularMode = true;
            } else if (source == startButton) {
                startButton.setText("RESTART");
                speedButton.setVisible(true);
                AiWar.restart();
                AiWarCompOpponent.delay = 2000;
            } else if (source == speedButton) {
                AiWarCompOpponent.delay = AiWarCompOpponent.delay / 2;
            }
        }

    }
}