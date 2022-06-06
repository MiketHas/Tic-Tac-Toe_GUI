import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class VsRobotOpponent {

    static int computerMove;
    static char previousSign, currentSign;
    static Icon compIcon;
    static int delay = 2000;

    static Timer timer = new Timer(delay, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            timer.setInitialDelay(delay);

            if (!VsRobotPanel.GameOver(CommonMethods.boardArray)) {
                VsRobotOpponent.computerMove();
                timer.stop();
                timer.restart();
            } else {
                timer.stop();
                VsRobotPanel.restart();
            }
        }
    });
    
    // Determining which robot's turn it is.
    public static void xoMove() {
        if (computerMove == 0) {
            previousSign = 'O';
            compIcon = VsRobotPanel.xImg;
            currentSign = 'X';
            computerMove = 1;
        } else if (computerMove == 1) {
            previousSign = 'X';
            compIcon = VsRobotPanel.oImg;
            currentSign = 'O';
            computerMove = 0;
        }
        VsRobotPanel.emptySpaces--;
    }

    public static boolean computerPrediction(char[][] boardField) {
        // HORIZONTAL
        if (boardField[0][0] == previousSign && boardField[0][1] == previousSign && VsRobotPanel.upRightButton.isEnabled()) {
            VsRobotPanel.upRightButton.setIcon(compIcon);
            VsRobotPanel.upRightButton.setEnabled(false);
            CommonMethods.boardArray[0][2] = currentSign;
            return true;
        } else if (boardField[0][0] == previousSign && boardField[0][2] == previousSign && VsRobotPanel.upMidButton.isEnabled()) {
            VsRobotPanel.upMidButton.setIcon(compIcon);
            VsRobotPanel.upMidButton.setEnabled(false);
            CommonMethods.boardArray[0][1] = currentSign;
            return true;
        } else if (boardField[0][1] == previousSign && boardField[0][2] == previousSign && VsRobotPanel.upLeftButton.isEnabled()) {
            VsRobotPanel.upLeftButton.setIcon(compIcon);
            VsRobotPanel.upLeftButton.setEnabled(false);
            CommonMethods.boardArray[0][0] = currentSign;
            return true;
        } else if (boardField[1][0] == previousSign && boardField[1][1] == previousSign && VsRobotPanel.midRightButton.isEnabled()) {
            VsRobotPanel.midRightButton.setIcon(compIcon);
            VsRobotPanel.midRightButton.setEnabled(false);
            CommonMethods.boardArray[1][2] = currentSign;
            return true;
        } else if (boardField[1][0] == previousSign && boardField[1][2] == previousSign && VsRobotPanel.midMidButton.isEnabled()) {
            VsRobotPanel.midMidButton.setIcon(compIcon);
            VsRobotPanel.midMidButton.setEnabled(false);
            CommonMethods.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[1][1] == previousSign && boardField[1][2] == previousSign && VsRobotPanel.midLeftButton.isEnabled()) {
            VsRobotPanel.midLeftButton.setIcon(compIcon);
            VsRobotPanel.midLeftButton.setEnabled(false);
            CommonMethods.boardArray[1][0] = currentSign;
            return true;
        } else if (boardField[2][0] == previousSign && boardField[2][1] == previousSign && VsRobotPanel.bottRightButton.isEnabled()) {
            VsRobotPanel.bottRightButton.setIcon(compIcon);
            VsRobotPanel.bottRightButton.setEnabled(false);
            CommonMethods.boardArray[2][2] = currentSign;
            return true;
        } else if (boardField[2][0] == previousSign && boardField[2][2] == previousSign && VsRobotPanel.bottMidButton.isEnabled()) {
            VsRobotPanel.bottMidButton.setIcon(compIcon);
            VsRobotPanel.bottMidButton.setEnabled(false);
            CommonMethods.boardArray[2][1] = currentSign;
            return true;
        } else if (boardField[2][1] == previousSign && boardField[2][2] == previousSign && VsRobotPanel.bottLeftButton.isEnabled()) {
            VsRobotPanel.bottLeftButton.setIcon(compIcon);
            VsRobotPanel.bottLeftButton.setEnabled(false);
            CommonMethods.boardArray[2][0] = currentSign;
            return true;

            // CROSSS
        } else if (boardField[0][0] == previousSign && boardField[2][2] == previousSign && VsRobotPanel.midMidButton.isEnabled()) {
            VsRobotPanel.midMidButton.setIcon(compIcon);
            VsRobotPanel.midMidButton.setEnabled(false);
            CommonMethods.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[2][0] == previousSign && VsRobotPanel.midMidButton.isEnabled()) {
            VsRobotPanel.midMidButton.setIcon(compIcon);
            VsRobotPanel.midMidButton.setEnabled(false);
            CommonMethods.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[0][0] == previousSign && boardField[1][1] == previousSign && VsRobotPanel.bottRightButton.isEnabled()) {
            VsRobotPanel.bottRightButton.setIcon(compIcon);
            VsRobotPanel.bottRightButton.setEnabled(false);
            CommonMethods.boardArray[2][2] = currentSign;
            return true;
        } else if (boardField[1][1] == previousSign && boardField[2][2] == previousSign && VsRobotPanel.upLeftButton.isEnabled()) {
            VsRobotPanel.upLeftButton.setIcon(compIcon);
            VsRobotPanel.upLeftButton.setEnabled(false);
            CommonMethods.boardArray[0][0] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[1][1] == previousSign && VsRobotPanel.bottLeftButton.isEnabled()) {
            VsRobotPanel.bottLeftButton.setIcon(compIcon);
            VsRobotPanel.bottLeftButton.setEnabled(false);
            CommonMethods.boardArray[2][0] = currentSign;
            return true;
        } else if (boardField[2][0] == previousSign && boardField[1][1] == previousSign && VsRobotPanel.upRightButton.isEnabled()) {
            VsRobotPanel.upRightButton.setIcon(compIcon);
            VsRobotPanel.upRightButton.setEnabled(false);
            CommonMethods.boardArray[0][2] = currentSign;
            return true;

            // VERTICAL
        } else if (boardField[0][0] == previousSign && boardField[1][0] == previousSign && VsRobotPanel.bottLeftButton.isEnabled()) {
            VsRobotPanel.bottLeftButton.setIcon(compIcon);
            VsRobotPanel.bottLeftButton.setEnabled(false);
            CommonMethods.boardArray[2][0] = currentSign;
            return true;
        } else if (boardField[0][0] == previousSign && boardField[2][0] == previousSign && VsRobotPanel.midLeftButton.isEnabled()) {
            VsRobotPanel.midLeftButton.setIcon(compIcon);
            VsRobotPanel.midLeftButton.setEnabled(false);
            CommonMethods.boardArray[1][0] = currentSign;
            return true;
        } else if (boardField[1][0] == previousSign && boardField[2][0] == previousSign && VsRobotPanel.upLeftButton.isEnabled()) {
            VsRobotPanel.upLeftButton.setIcon(compIcon);
            VsRobotPanel.upLeftButton.setEnabled(false);
            CommonMethods.boardArray[0][0] = currentSign;
            return true;
        } else if (boardField[0][1] == previousSign && boardField[1][1] == previousSign && VsRobotPanel.bottMidButton.isEnabled()) {
            VsRobotPanel.bottMidButton.setIcon(compIcon);
            VsRobotPanel.bottMidButton.setEnabled(false);
            CommonMethods.boardArray[2][1] = currentSign;
            return true;
        } else if (boardField[0][1] == previousSign && boardField[2][1] == previousSign && VsRobotPanel.midMidButton.isEnabled()) {
            VsRobotPanel.midMidButton.setIcon(compIcon);
            VsRobotPanel.midMidButton.setEnabled(false);
            CommonMethods.boardArray[1][1] = currentSign;
            return true;
        } else if (boardField[1][1] == previousSign && boardField[2][1] == previousSign && VsRobotPanel.upMidButton.isEnabled()) {
            VsRobotPanel.upMidButton.setIcon(compIcon);
            VsRobotPanel.upMidButton.setEnabled(false);
            CommonMethods.boardArray[0][1] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[1][2] == previousSign && VsRobotPanel.bottRightButton.isEnabled()) {
            VsRobotPanel.bottRightButton.setIcon(compIcon);
            VsRobotPanel.bottRightButton.setEnabled(false);
            CommonMethods.boardArray[2][2] = currentSign;
            return true;
        } else if (boardField[0][2] == previousSign && boardField[2][2] == previousSign && VsRobotPanel.midRightButton.isEnabled()) {
            VsRobotPanel.midRightButton.setIcon(compIcon);
            VsRobotPanel.midRightButton.setEnabled(false);
            CommonMethods.boardArray[1][2] = currentSign;
            return true;
        } else if (boardField[1][2] == previousSign && boardField[2][2] == previousSign && VsRobotPanel.upRightButton.isEnabled()) {
            VsRobotPanel.upRightButton.setIcon(compIcon);
            VsRobotPanel.upRightButton.setEnabled(false);
            CommonMethods.boardArray[0][2] = currentSign;
            return true;
        } else return false;
    }

    public static void computerMove() {
        if (computerPrediction(CommonMethods.boardArray)) {
            xoMove();
        } else if (!computerPrediction(CommonMethods.boardArray)) {

            Random random = new Random();
            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if ((row == 0) && (col == 0) && VsRobotPanel.upLeftButton.isEnabled()) {
                VsRobotPanel.upLeftButton.setIcon(compIcon);
                VsRobotPanel.upLeftButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 0) && (col == 1) && VsRobotPanel.upMidButton.isEnabled()) {
                VsRobotPanel.upMidButton.setIcon(compIcon);
                VsRobotPanel.upMidButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 0) && (col == 2) && VsRobotPanel.upRightButton.isEnabled()) {
                VsRobotPanel.upRightButton.setIcon(compIcon);
                VsRobotPanel.upRightButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 1) && (col == 0) && VsRobotPanel.midLeftButton.isEnabled()) {
                VsRobotPanel.midLeftButton.setIcon(compIcon);
                VsRobotPanel.midLeftButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 1) && (col == 1) && VsRobotPanel.midMidButton.isEnabled()) {
                VsRobotPanel.midMidButton.setIcon(compIcon);
                VsRobotPanel.midMidButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 1) && (col == 2) && VsRobotPanel.midRightButton.isEnabled()) {
                VsRobotPanel.midRightButton.setIcon(compIcon);
                VsRobotPanel.midRightButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 2) && (col == 0) && VsRobotPanel.bottLeftButton.isEnabled()) {
                VsRobotPanel.bottLeftButton.setIcon(compIcon);
                VsRobotPanel.bottLeftButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 2) && (col == 1) && VsRobotPanel.bottMidButton.isEnabled()) {
                VsRobotPanel.bottMidButton.setIcon(compIcon);
                VsRobotPanel.bottMidButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = currentSign;
                xoMove();
            } else if ((row == 2) && (col == 2) && VsRobotPanel.bottRightButton.isEnabled()) {
                VsRobotPanel.bottRightButton.setIcon(compIcon);
                VsRobotPanel.bottRightButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = currentSign;
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
