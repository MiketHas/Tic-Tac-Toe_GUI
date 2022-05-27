import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AiWarCompOpponent {

    static int computerMove;
    static char previousSign, currentSign;
    static Icon compIcon;
    static int delay = 2000;

    static Timer timer = new Timer(delay, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            timer.setInitialDelay(delay);

            if (!AiWarPanel.GameOver(AiWarPanel.boardArray)) {
                AiWarCompOpponent.computerMove();
                timer.stop();
                timer.restart();
            } else {
                timer.stop();
                AiWarPanel.restart();
            }
        }
    });
    
    // Determining which robot's turn it is.
    public static void xoMove() {
        if (computerMove == 0) {
            previousSign = 'O';
            compIcon = AiWarPanel.xImg;
            currentSign = 'X';
            computerMove = 1;
        } else if (computerMove == 1) {
            previousSign = 'X';
            compIcon = AiWarPanel.oImg;
            currentSign = 'O';
            computerMove = 0;
        }
        AiWarPanel.emptySpaces--;
    }

    public static boolean computerPrediction(char[][] boardField) {
        // HORIZONTAL
        if (boardField[0][0] == previousSign && boardField[0][1] == previousSign && AiWarPanel.upRightButton.isEnabled()) {
            AiWarPanel.upRightButton.setIcon(compIcon);
            AiWarPanel.upRightButton.setEnabled(false);
            AiWarPanel.boardArray[0][2] = currentSign;
            return true;
        } else if (boardField[0][0] == previousSign && boardField[0][2] == previousSign && AiWarPanel.upMidButton.isEnabled()) {
            AiWarPanel.upMidButton.setIcon(compIcon);
            AiWarPanel.upMidButton.setEnabled(false);
            AiWarPanel.boardArray[0][1] = currentSign;
            return true;
        } else if (boardField[0][1] == previousSign && boardField[0][2] == previousSign && AiWarPanel.upLeftButton.isEnabled()) {
            AiWarPanel.upLeftButton.setIcon(compIcon);
            AiWarPanel.upLeftButton.setEnabled(false);
            AiWarPanel.boardArray[0][0] = currentSign;
            return true;
        } else if (boardField[1][0] == previousSign && boardField[1][1] == previousSign && AiWarPanel.midRightButton.isEnabled()) {
            AiWarPanel.midRightButton.setIcon(compIcon);
            AiWarPanel.midRightButton.setEnabled(false);
            AiWarPanel.boardArray[1][2] = currentSign;
            return true;
        } else if (boardField[1][0] == previousSign && boardField[1][2] == previousSign && AiWarPanel.midMidButton.isEnabled()) {
            AiWarPanel.midMidButton.setIcon(compIcon);
            AiWarPanel.midMidButton.setEnabled(false);
            AiWarPanel.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[1][1] == previousSign && boardField[1][2] == previousSign && AiWarPanel.midLeftButton.isEnabled()) {
            AiWarPanel.midLeftButton.setIcon(compIcon);
            AiWarPanel.midLeftButton.setEnabled(false);
            AiWarPanel.boardArray[1][0] = currentSign;
            return true;
        } else if (boardField[2][0] == previousSign && boardField[2][1] == previousSign && AiWarPanel.bottRightButton.isEnabled()) {
            AiWarPanel.bottRightButton.setIcon(compIcon);
            AiWarPanel.bottRightButton.setEnabled(false);
            AiWarPanel.boardArray[2][2] = currentSign;
            return true;
        } else if (boardField[2][0] == previousSign && boardField[2][2] == previousSign && AiWarPanel.bottMidButton.isEnabled()) {
            AiWarPanel.bottMidButton.setIcon(compIcon);
            AiWarPanel.bottMidButton.setEnabled(false);
            AiWarPanel.boardArray[2][1] = currentSign;
            return true;
        } else if (boardField[2][1] == previousSign && boardField[2][2] == previousSign && AiWarPanel.bottLeftButton.isEnabled()) {
            AiWarPanel.bottLeftButton.setIcon(compIcon);
            AiWarPanel.bottLeftButton.setEnabled(false);
            AiWarPanel.boardArray[2][0] = currentSign;
            return true;

            // CROSSS
        } else if (boardField[0][0] == previousSign && boardField[2][2] == previousSign && AiWarPanel.midMidButton.isEnabled()) {
            AiWarPanel.midMidButton.setIcon(compIcon);
            AiWarPanel.midMidButton.setEnabled(false);
            AiWarPanel.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[2][0] == previousSign && AiWarPanel.midMidButton.isEnabled()) {
            AiWarPanel.midMidButton.setIcon(compIcon);
            AiWarPanel.midMidButton.setEnabled(false);
            AiWarPanel.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[0][0] == previousSign && boardField[1][1] == previousSign && AiWarPanel.bottRightButton.isEnabled()) {
            AiWarPanel.bottRightButton.setIcon(compIcon);
            AiWarPanel.bottRightButton.setEnabled(false);
            AiWarPanel.boardArray[2][2] = currentSign;
            return true;
        } else if (boardField[1][1] == previousSign && boardField[2][2] == previousSign && AiWarPanel.upLeftButton.isEnabled()) {
            AiWarPanel.upLeftButton.setIcon(compIcon);
            AiWarPanel.upLeftButton.setEnabled(false);
            AiWarPanel.boardArray[0][0] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[1][1] == previousSign && AiWarPanel.bottLeftButton.isEnabled()) {
            AiWarPanel.bottLeftButton.setIcon(compIcon);
            AiWarPanel.bottLeftButton.setEnabled(false);
            AiWarPanel.boardArray[2][0] = currentSign;
            return true;
        } else if (boardField[2][0] == previousSign && boardField[1][1] == previousSign && AiWarPanel.upRightButton.isEnabled()) {
            AiWarPanel.upRightButton.setIcon(compIcon);
            AiWarPanel.upRightButton.setEnabled(false);
            AiWarPanel.boardArray[0][2] = currentSign;
            return true;

            // VERTICAL
        } else if (boardField[0][0] == previousSign && boardField[1][0] == previousSign && AiWarPanel.bottLeftButton.isEnabled()) {
            AiWarPanel.bottLeftButton.setIcon(compIcon);
            AiWarPanel.bottLeftButton.setEnabled(false);
            AiWarPanel.boardArray[2][0] = currentSign;
            return true;
        } else if (boardField[0][0] == previousSign && boardField[2][0] == previousSign && AiWarPanel.midLeftButton.isEnabled()) {
            AiWarPanel.midLeftButton.setIcon(compIcon);
            AiWarPanel.midLeftButton.setEnabled(false);
            AiWarPanel.boardArray[1][0] = currentSign;
            return true;
        } else if (boardField[1][0] == previousSign && boardField[2][0] == previousSign && AiWarPanel.upLeftButton.isEnabled()) {
            AiWarPanel.upLeftButton.setIcon(compIcon);
            AiWarPanel.upLeftButton.setEnabled(false);
            AiWarPanel.boardArray[0][0] = currentSign;
            return true;
        } else if (boardField[0][1] == previousSign && boardField[1][1] == previousSign && AiWarPanel.bottMidButton.isEnabled()) {
            AiWarPanel.bottMidButton.setIcon(compIcon);
            AiWarPanel.bottMidButton.setEnabled(false);
            AiWarPanel.boardArray[2][1] = currentSign;
            return true;
        } else if (boardField[0][1] == previousSign && boardField[2][1] == previousSign && AiWarPanel.midMidButton.isEnabled()) {
            AiWarPanel.midMidButton.setIcon(compIcon);
            AiWarPanel.midMidButton.setEnabled(false);
            AiWarPanel.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[1][1] == previousSign && boardField[2][1] == previousSign && AiWarPanel.upMidButton.isEnabled()) {
            AiWarPanel.upMidButton.setIcon(compIcon);
            AiWarPanel.upMidButton.setEnabled(false);
            AiWarPanel.boardArray[0][1] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[1][2] == previousSign && AiWarPanel.bottRightButton.isEnabled()) {
            AiWarPanel.bottRightButton.setIcon(compIcon);
            AiWarPanel.bottRightButton.setEnabled(false);
            AiWarPanel.boardArray[2][2] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[2][2] == previousSign && AiWarPanel.midRightButton.isEnabled()) {
            AiWarPanel.midRightButton.setIcon(compIcon);
            AiWarPanel.midRightButton.setEnabled(false);
            AiWarPanel.boardArray[1][2] = currentSign;
            return true;
        } else if (boardField[1][2] == previousSign && boardField[2][2] == previousSign && AiWarPanel.upRightButton.isEnabled()) {
            AiWarPanel.upRightButton.setIcon(compIcon);
            AiWarPanel.upRightButton.setEnabled(false);
            AiWarPanel.boardArray[0][2] = currentSign;
            return true;
        } else return false;
    }

    public static void computerMove() {
        if (computerPrediction(AiWarPanel.boardArray)) {
            xoMove();
        } else if (!computerPrediction(AiWarPanel.boardArray)) {

            Random random = new Random();
            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if ((row == 0) && (col == 0) && AiWarPanel.upLeftButton.isEnabled()) {
                AiWarPanel.upLeftButton.setIcon(compIcon);
                AiWarPanel.upLeftButton.setEnabled(false);
                AiWarPanel.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 0) && (col == 1) && AiWarPanel.upMidButton.isEnabled()) {
                AiWarPanel.upMidButton.setIcon(compIcon);
                AiWarPanel.upMidButton.setEnabled(false);
                AiWarPanel.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 0) && (col == 2) && AiWarPanel.upRightButton.isEnabled()) {
                AiWarPanel.upRightButton.setIcon(compIcon);
                AiWarPanel.upRightButton.setEnabled(false);
                AiWarPanel.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 1) && (col == 0) && AiWarPanel.midLeftButton.isEnabled()) {
                AiWarPanel.midLeftButton.setIcon(compIcon);
                AiWarPanel.midLeftButton.setEnabled(false);
                AiWarPanel.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 1) && (col == 1) && AiWarPanel.midMidButton.isEnabled()) {
                AiWarPanel.midMidButton.setIcon(compIcon);
                AiWarPanel.midMidButton.setEnabled(false);
                AiWarPanel.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 1) && (col == 2) && AiWarPanel.midRightButton.isEnabled()) {
                AiWarPanel.midRightButton.setIcon(compIcon);
                AiWarPanel.midRightButton.setEnabled(false);
                AiWarPanel.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 2) && (col == 0) && AiWarPanel.bottLeftButton.isEnabled()) {
                AiWarPanel.bottLeftButton.setIcon(compIcon);
                AiWarPanel.bottLeftButton.setEnabled(false);
                AiWarPanel.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 2) && (col == 1) && AiWarPanel.bottMidButton.isEnabled()) {
                AiWarPanel.bottMidButton.setIcon(compIcon);
                AiWarPanel.bottMidButton.setEnabled(false);
                AiWarPanel.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 2) && (col == 2) && AiWarPanel.bottRightButton.isEnabled()) {
                AiWarPanel.bottRightButton.setIcon(compIcon);
                AiWarPanel.bottRightButton.setEnabled(false);
                AiWarPanel.boardArray[row][col] = currentSign;
                xoMove();
            } else {
                computerMove();
            }
        }
    }

    public static void start() {
        timer.start();
    }
}
