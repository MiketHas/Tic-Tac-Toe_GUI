import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VsHumanPanel extends JPanel implements MouseListener, ActionListener {

    static GameButton upLeftButton, upMidButton, upRightButton, midLeftButton, midMidButton, midRightButton, bottLeftButton, bottMidButton, bottRightButton;
    static List<GameButton> buttons;
    static ImageIcon xImg, oImg, board;
    JLabel gameBcg;
    //static char[][] boardArray;
    static int emptySpaces = 9;
    static boolean active = true;

    VsHumanPanel() {
        this.setLayout(null);

        // backend Array
//        boardArray = new char[3][3];
//        CommonMethods.fillArray(boardArray);

        xImg = new ImageIcon(getClass().getClassLoader().getResource("res/xImg.png"));
        oImg = new ImageIcon(getClass().getClassLoader().getResource("res/oImg.png"));
        board = new ImageIcon(getClass().getClassLoader().getResource("res/board.png"));

        gameBcg = new JLabel();
        gameBcg.setIcon(board);
        gameBcg.setBounds(0, 0, 390, 300);
        gameBcg.setVisible(true);
        gameBcg.setOpaque(false);



        upLeftButton = new GameButton(0, 0);
//        upLeftButton.addMouseListener(this);
//        upLeftButton.addActionListener(this);

        upMidButton = new GameButton(130, 0);
//        upMidButton.addMouseListener(this);
//        upMidButton.addActionListener(this);

        upRightButton = new GameButton(260, 0);
//        upRightButton.addMouseListener(this);
//        upRightButton.addActionListener(this);

        midLeftButton = new GameButton(0, 100);
//        midLeftButton.addMouseListener(this);
//        midLeftButton.addActionListener(this);

        midMidButton = new GameButton(130, 100);
//        midMidButton.addMouseListener(this);
//        midMidButton.addActionListener(this);

        midRightButton = new GameButton(260, 100);
//        midRightButton.addMouseListener(this);
//        midRightButton.addActionListener(this);

        bottLeftButton = new GameButton(0, 200);
//        bottLeftButton.addMouseListener(this);
//        bottLeftButton.addActionListener(this);

        bottMidButton = new GameButton(130, 200);
//        bottMidButton.addMouseListener(this);
//        bottMidButton.addActionListener(this);

        bottRightButton = new GameButton(260, 200);
//        bottRightButton.addMouseListener(this);
//        bottRightButton.addActionListener(this);

        buttons = Arrays.asList(upLeftButton, upMidButton, upRightButton, midLeftButton, midMidButton, midRightButton, bottLeftButton, bottMidButton, bottRightButton);
        for (GameButton button : buttons) {
            button.addActionListener(this);
            button.addMouseListener(this);
        }

        this.add(upLeftButton);
        this.add(upMidButton);
        this.add(upRightButton);
        this.add(midLeftButton);
        this.add(midMidButton);
        this.add(midRightButton);
        this.add(bottLeftButton);
        this.add(bottMidButton);
        this.add(bottRightButton);
        this.add(gameBcg);
        this.setVisible(true);
    }

    // Restarting the game
    public static void restart() {
//        boardArray = new char[3][3];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                boardArray[i][j] = ' ';
//            }
//        }
        CommonMethods.fillArray(CommonMethods.boardArray);

        emptySpaces = 9;
        active = true;

        CommonMethods.enableAll(buttons);

        CommonMethods.disableIconsVisibility(buttons);

//        for (GameButton button : buttons) {
//            button.setIcon(null);
//        }

//        upLeftButton.setIcon(null);
//        upMidButton.setIcon(null);
//        upRightButton.setIcon(null);
//        midLeftButton.setIcon(null);
//        midMidButton.setIcon(null);
//        midRightButton.setIcon(null);
//        bottLeftButton.setIcon(null);
//        bottMidButton.setIcon(null);
//        bottRightButton.setIcon(null);

        MainPanel.messageLabel.setText(" ");
    }

//    // Possibilities of X/O win
//    private static boolean isTheWinner(char[][] boardField, char symbol) {
//        return (boardField[0][0] == symbol && boardField[0][1] == symbol && boardField[0][2] == symbol) ||
//                (boardField[1][0] == symbol && boardField[1][1] == symbol && boardField[1][2] == symbol) ||
//                (boardField[2][0] == symbol && boardField[2][1] == symbol && boardField[2][2] == symbol) ||
//
//                (boardField[0][0] == symbol && boardField[1][0] == symbol && boardField[2][0] == symbol) ||
//                (boardField[0][1] == symbol && boardField[1][1] == symbol && boardField[2][1] == symbol) ||
//                (boardField[0][2] == symbol && boardField[1][2] == symbol && boardField[2][2] == symbol) ||
//
//                (boardField[0][0] == symbol && boardField[1][1] == symbol && boardField[2][2] == symbol) ||
//                (boardField[0][2] == symbol && boardField[1][1] == symbol && boardField[2][0] == symbol);
//    }

    // Checking if the game is over
    public static boolean GameOver(char[][] boardField) {
        emptySpaces--;
        boolean xWins = CommonMethods.isTheWinner(boardField, 'X');
        boolean oWins = CommonMethods.isTheWinner(boardField, 'O');

        if (xWins) { //True/False
            CommonMethods.player1Wins();
            MainPanel.scoreLabel.setText(MainPanel.player1 + " " + MainPanel.player1Score + ":" + MainPanel.player2Score + " " + MainPanel.player2);
            CommonMethods.disableAll(buttons);
            return true;
        } else if (oWins) { //True/False
            CommonMethods.player2Wins();
            MainPanel.scoreLabel.setText(MainPanel.player1 + " " + MainPanel.player1Score + ":" + MainPanel.player2Score + " " + MainPanel.player2);
            CommonMethods.disableAll(buttons);
            return true;
        } else if (emptySpaces == 0) {
            MainPanel.messageLabel.setText("Draw!");
            CommonMethods.disableAll(buttons);
            return true;
        } else {
            return false;
        }
    }

//    public void enableAll() {
//
//        for (GameButton button : buttons) {
//            button.setEnabled(true);
//        }
//
////        upLeftButton.setEnabled(true);
////        upMidButton.setEnabled(true);
////        upRightButton.setEnabled(true);
////        midLeftButton.setEnabled(true);
////        midMidButton.setEnabled(true);
////        midRightButton.setEnabled(true);
////        bottLeftButton.setEnabled(true);
////        bottMidButton.setEnabled(true);
////        bottRightButton.setEnabled(true);
//    }
//
//    public void disableAll() {
//
//        for (GameButton button : buttons) {
//            button.setEnabled(false);
//        }
//
////        upLeftButton.setEnabled(false);
////        upMidButton.setEnabled(false);
////        upRightButton.setEnabled(false);
////        midLeftButton.setEnabled(false);
////        midMidButton.setEnabled(false);
////        midRightButton.setEnabled(false);
////        bottLeftButton.setEnabled(false);
////        bottMidButton.setEnabled(false);
////        bottRightButton.setEnabled(false);
//    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (active) {
            if ((source == upLeftButton) && upLeftButton.isEnabled()) {
                upLeftButton.setIcon(xImg);
            } else if ((source == upMidButton) && upMidButton.isEnabled()) {
                upMidButton.setIcon(xImg);
            } else if ((source == upRightButton) && upRightButton.isEnabled()) {
                upRightButton.setIcon(xImg);
            } else if ((source == midLeftButton) && midLeftButton.isEnabled()) {
                midLeftButton.setIcon(xImg);
            } else if ((source == midMidButton) && midMidButton.isEnabled()) {
                midMidButton.setIcon(xImg);
            } else if ((source == midRightButton) && midRightButton.isEnabled()) {
                midRightButton.setIcon(xImg);
            } else if ((source == bottLeftButton) && bottLeftButton.isEnabled()) {
                bottLeftButton.setIcon(xImg);
            } else if ((source == bottMidButton) && bottMidButton.isEnabled()) {
                bottMidButton.setIcon(xImg);
            } else if ((source == bottRightButton) && bottRightButton.isEnabled()) {
                bottRightButton.setIcon(xImg);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if ((source == upLeftButton) && upLeftButton.isEnabled()) {
            upLeftButton.setIcon(null);
        } else if ((source == upMidButton) && upMidButton.isEnabled()) {
            upMidButton.setIcon(null);
        } else if ((source == upRightButton) && upRightButton.isEnabled()) {
            upRightButton.setIcon(null);
        } else if ((source == midLeftButton) && midLeftButton.isEnabled()) {
            midLeftButton.setIcon(null);
        } else if ((source == midMidButton) && midMidButton.isEnabled()) {
            midMidButton.setIcon(null);
        } else if ((source == midRightButton) && midRightButton.isEnabled()) {
            midRightButton.setIcon(null);
        } else if ((source == bottLeftButton) && bottLeftButton.isEnabled()) {
            bottLeftButton.setIcon(null);
        } else if ((source == bottMidButton) && bottMidButton.isEnabled()) {
            bottMidButton.setIcon(null);
        } else if ((source == bottRightButton) && bottRightButton.isEnabled()) {
            bottRightButton.setIcon(null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (active) {
            if ((source == upLeftButton) && upLeftButton.isEnabled()) {
                upLeftButton.setIcon(xImg);
                upLeftButton.setEnabled(false);
                CommonMethods.boardArray[0][0] = 'X';
            } else if ((source == upMidButton) && upMidButton.isEnabled()) {
                upMidButton.setIcon(xImg);
                upMidButton.setEnabled(false);
                CommonMethods.boardArray[0][1] = 'X';
            } else if ((source == upRightButton) && upRightButton.isEnabled()) {
                upRightButton.setIcon(xImg);
                upRightButton.setEnabled(false);
                CommonMethods.boardArray[0][2] = 'X';
            } else if ((source == midLeftButton) && midLeftButton.isEnabled()) {
                midLeftButton.setIcon(xImg);
                midLeftButton.setEnabled(false);
                CommonMethods.boardArray[1][0] = 'X';
            } else if ((source == midMidButton) && midMidButton.isEnabled()) {
                midMidButton.setIcon(xImg);
                midMidButton.setEnabled(false);
                CommonMethods.boardArray[1][1] = 'X';
            } else if ((source == midRightButton) && midRightButton.isEnabled()) {
                midRightButton.setIcon(xImg);
                midRightButton.setEnabled(false);
                CommonMethods.boardArray[1][2] = 'X';
            } else if ((source == bottLeftButton) && bottLeftButton.isEnabled()) {
                bottLeftButton.setIcon(xImg);
                bottLeftButton.setEnabled(false);
                CommonMethods.boardArray[2][0] = 'X';
            } else if ((source == bottMidButton) && bottMidButton.isEnabled()) {
                bottMidButton.setIcon(xImg);
                bottMidButton.setEnabled(false);
                CommonMethods.boardArray[2][1] = 'X';
            } else if ((source == bottRightButton) && bottRightButton.isEnabled()) {
                bottRightButton.setIcon(xImg);
                bottRightButton.setEnabled(false);
                CommonMethods.boardArray[2][2] = 'X';

            }
            active = false;
            playerMoved();
        }
    }

    public static void playerMoved() {
        if (!GameOver(CommonMethods.boardArray)) {
            VsHumanOpponent.start();
        }
    }

//    public static void player1Wins() {
//        MainPanel.player1Score++;
//        MainPanel.messageLabel.setText(MainPanel.player1 + " wins");
//    }
//
//    public static void player2Wins() {
//        MainPanel.player2Score++;
//        MainPanel.messageLabel.setText(MainPanel.player2 + " wins");
//    }

}
