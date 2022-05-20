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

            if (!AiWar.GameOver(AiWar.boardArray)) {
                AiWarCompOpponent.computerMove();
                timer.stop();
                timer.restart();
            } else {
                timer.stop();
                AiWar.restart();
            }
        }
    });
    
    // Determining which robot's turn it is.
    public static void xoMove() {
        if (computerMove == 0) {
            previousSign = 'O';
            compIcon = AiWar.xImg;
            currentSign = 'X';
            computerMove = 1;
        } else if (computerMove == 1) {
            previousSign = 'X';
            compIcon = AiWar.oImg;
            currentSign = 'O';
            computerMove = 0;
        }
        AiWar.emptySpaces--;
    }

    public static boolean computerPrediction(char[][] boardField) {
        // HORIZONTAL
        if (boardField[0][0] == previousSign && boardField[0][1] == previousSign && AiWar.upRightButton.isEnabled()) {
            AiWar.upRightButton.setIcon(compIcon);
            AiWar.upRightButton.setEnabled(false);
            AiWar.boardArray[0][2] = currentSign;
            return true;
        } else if (boardField[0][0] == previousSign && boardField[0][2] == previousSign && AiWar.upMidButton.isEnabled()) {
            AiWar.upMidButton.setIcon(compIcon);
            AiWar.upMidButton.setEnabled(false);
            AiWar.boardArray[0][1] = currentSign;
            return true;
        } else if (boardField[0][1] == previousSign && boardField[0][2] == previousSign && AiWar.upLeftButton.isEnabled()) {
            AiWar.upLeftButton.setIcon(compIcon);
            AiWar.upLeftButton.setEnabled(false);
            AiWar.boardArray[0][0] = currentSign;
            return true;
        } else if (boardField[1][0] == previousSign && boardField[1][1] == previousSign && AiWar.midRightButton.isEnabled()) {
            AiWar.midRightButton.setIcon(compIcon);
            AiWar.midRightButton.setEnabled(false);
            AiWar.boardArray[1][2] = currentSign;
            return true;
        } else if (boardField[1][0] == previousSign && boardField[1][2] == previousSign && AiWar.midMidButton.isEnabled()) {
            AiWar.midMidButton.setIcon(compIcon);
            AiWar.midMidButton.setEnabled(false);
            AiWar.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[1][1] == previousSign && boardField[1][2] == previousSign && AiWar.midLeftButton.isEnabled()) {
            AiWar.midLeftButton.setIcon(compIcon);
            AiWar.midLeftButton.setEnabled(false);
            AiWar.boardArray[1][0] = currentSign;
            return true;
        } else if (boardField[2][0] == previousSign && boardField[2][1] == previousSign && AiWar.bottRightButton.isEnabled()) {
            AiWar.bottRightButton.setIcon(compIcon);
            AiWar.bottRightButton.setEnabled(false);
            AiWar.boardArray[2][2] = currentSign;
            return true;
        } else if (boardField[2][0] == previousSign && boardField[2][2] == previousSign && AiWar.bottMidButton.isEnabled()) {
            AiWar.bottMidButton.setIcon(compIcon);
            AiWar.bottMidButton.setEnabled(false);
            AiWar.boardArray[2][1] = currentSign;
            return true;
        } else if (boardField[2][1] == previousSign && boardField[2][2] == previousSign && AiWar.bottLeftButton.isEnabled()) {
            AiWar.bottLeftButton.setIcon(compIcon);
            AiWar.bottLeftButton.setEnabled(false);
            AiWar.boardArray[2][0] = currentSign;
            return true;

            // CROSSS
        } else if (boardField[0][0] == previousSign && boardField[2][2] == previousSign && AiWar.midMidButton.isEnabled()) {
            AiWar.midMidButton.setIcon(compIcon);
            AiWar.midMidButton.setEnabled(false);
            AiWar.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[2][0] == previousSign && AiWar.midMidButton.isEnabled()) {
            AiWar.midMidButton.setIcon(compIcon);
            AiWar.midMidButton.setEnabled(false);
            AiWar.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[0][0] == previousSign && boardField[1][1] == previousSign && AiWar.bottRightButton.isEnabled()) {
            AiWar.bottRightButton.setIcon(compIcon);
            AiWar.bottRightButton.setEnabled(false);
            AiWar.boardArray[2][2] = currentSign;
            return true;
        } else if (boardField[1][1] == previousSign && boardField[2][2] == previousSign && AiWar.upLeftButton.isEnabled()) {
            AiWar.upLeftButton.setIcon(compIcon);
            AiWar.upLeftButton.setEnabled(false);
            AiWar.boardArray[0][0] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[1][1] == previousSign && AiWar.bottLeftButton.isEnabled()) {
            AiWar.bottLeftButton.setIcon(compIcon);
            AiWar.bottLeftButton.setEnabled(false);
            AiWar.boardArray[2][0] = currentSign;
            return true;
        } else if (boardField[2][0] == previousSign && boardField[1][1] == previousSign && AiWar.upRightButton.isEnabled()) {
            AiWar.upRightButton.setIcon(compIcon);
            AiWar.upRightButton.setEnabled(false);
            AiWar.boardArray[0][2] = currentSign;
            return true;

            // VERTICAL
        } else if (boardField[0][0] == previousSign && boardField[1][0] == previousSign && AiWar.bottLeftButton.isEnabled()) {
            AiWar.bottLeftButton.setIcon(compIcon);
            AiWar.bottLeftButton.setEnabled(false);
            AiWar.boardArray[2][0] = currentSign;
            return true;
        } else if (boardField[0][0] == previousSign && boardField[2][0] == previousSign && AiWar.midLeftButton.isEnabled()) {
            AiWar.midLeftButton.setIcon(compIcon);
            AiWar.midLeftButton.setEnabled(false);
            AiWar.boardArray[1][0] = currentSign;
            return true;
        } else if (boardField[1][0] == previousSign && boardField[2][0] == previousSign && AiWar.upLeftButton.isEnabled()) {
            AiWar.upLeftButton.setIcon(compIcon);
            AiWar.upLeftButton.setEnabled(false);
            AiWar.boardArray[0][0] = currentSign;
            return true;
        } else if (boardField[0][1] == previousSign && boardField[1][1] == previousSign && AiWar.bottMidButton.isEnabled()) {
            AiWar.bottMidButton.setIcon(compIcon);
            AiWar.bottMidButton.setEnabled(false);
            AiWar.boardArray[2][1] = currentSign;
            return true;
        } else if (boardField[0][1] == previousSign && boardField[2][1] == previousSign && AiWar.midMidButton.isEnabled()) {
            AiWar.midMidButton.setIcon(compIcon);
            AiWar.midMidButton.setEnabled(false);
            AiWar.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[1][1] == previousSign && boardField[2][1] == previousSign && AiWar.upMidButton.isEnabled()) {
            AiWar.upMidButton.setIcon(compIcon);
            AiWar.upMidButton.setEnabled(false);
            AiWar.boardArray[0][1] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[1][2] == previousSign && AiWar.bottRightButton.isEnabled()) {
            AiWar.bottRightButton.setIcon(compIcon);
            AiWar.bottRightButton.setEnabled(false);
            AiWar.boardArray[2][2] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[2][2] == previousSign && AiWar.midRightButton.isEnabled()) {
            AiWar.midRightButton.setIcon(compIcon);
            AiWar.midRightButton.setEnabled(false);
            AiWar.boardArray[1][2] = currentSign;
            return true;
        } else if (boardField[1][2] == previousSign && boardField[2][2] == previousSign && AiWar.upRightButton.isEnabled()) {
            AiWar.upRightButton.setIcon(compIcon);
            AiWar.upRightButton.setEnabled(false);
            AiWar.boardArray[0][2] = currentSign;
            return true;
        } else return false;
    }

    public static void computerMove() {
        if (computerPrediction(AiWar.boardArray)) {
            xoMove();
        } else if (!computerPrediction(AiWar.boardArray)) {

            Random random = new Random();
            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if ((row == 0) && (col == 0) && AiWar.upLeftButton.isEnabled()) {
                AiWar.upLeftButton.setIcon(compIcon);
                AiWar.upLeftButton.setEnabled(false);
                AiWar.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 0) && (col == 1) && AiWar.upMidButton.isEnabled()) {
                AiWar.upMidButton.setIcon(compIcon);
                AiWar.upMidButton.setEnabled(false);
                AiWar.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 0) && (col == 2) && AiWar.upRightButton.isEnabled()) {
                AiWar.upRightButton.setIcon(compIcon);
                AiWar.upRightButton.setEnabled(false);
                AiWar.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 1) && (col == 0) && AiWar.midLeftButton.isEnabled()) {
                AiWar.midLeftButton.setIcon(compIcon);
                AiWar.midLeftButton.setEnabled(false);
                AiWar.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 1) && (col == 1) && AiWar.midMidButton.isEnabled()) {
                AiWar.midMidButton.setIcon(compIcon);
                AiWar.midMidButton.setEnabled(false);
                AiWar.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 1) && (col == 2) && AiWar.midRightButton.isEnabled()) {
                AiWar.midRightButton.setIcon(compIcon);
                AiWar.midRightButton.setEnabled(false);
                AiWar.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 2) && (col == 0) && AiWar.bottLeftButton.isEnabled()) {
                AiWar.bottLeftButton.setIcon(compIcon);
                AiWar.bottLeftButton.setEnabled(false);
                AiWar.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 2) && (col == 1) && AiWar.bottMidButton.isEnabled()) {
                AiWar.bottMidButton.setIcon(compIcon);
                AiWar.bottMidButton.setEnabled(false);
                AiWar.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 2) && (col == 2) && AiWar.bottRightButton.isEnabled()) {
                AiWar.bottRightButton.setIcon(compIcon);
                AiWar.bottRightButton.setEnabled(false);
                AiWar.boardArray[row][col] = currentSign;
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
