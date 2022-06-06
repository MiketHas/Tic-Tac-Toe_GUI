import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class VsHumanOpponent {

    static Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            VsHumanOpponent.computerMove();
            timer.stop();
            VsHumanPanel.active=true;
        }
    });

    public static boolean computerPrediction(char[][] boardField) {
            // HORIZONTAL
        if (boardField[0][0] == 'X' && boardField[0][1] == 'X' && VsHumanPanel.upRightButton.isEnabled()) {
            VsHumanPanel.upRightButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.upRightButton.setEnabled(false);
            CommonMethods.boardArray[0][2] = 'O';
            return true;
        } else if (boardField[0][0] == 'X' && boardField[0][2] == 'X' && VsHumanPanel.upMidButton.isEnabled()) {
            VsHumanPanel.upMidButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.upMidButton.setEnabled(false);
            CommonMethods.boardArray[0][1] = 'O';
            return true;
        } else if (boardField[0][1] == 'X' && boardField[0][2] == 'X' && VsHumanPanel.upLeftButton.isEnabled()) {
            VsHumanPanel.upLeftButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.upLeftButton.setEnabled(false);
            CommonMethods.boardArray[0][0] = 'O';
            return true;
        } else if (boardField[1][0] == 'X' && boardField[1][1] == 'X' && VsHumanPanel.midRightButton.isEnabled()) {
            VsHumanPanel.midRightButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.midRightButton.setEnabled(false);
            CommonMethods.boardArray[1][2] = 'O';
            return true;
        } else if (boardField[1][0] == 'X' && boardField[1][2] == 'X' && VsHumanPanel.midMidButton.isEnabled()) {
            VsHumanPanel.midMidButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.midMidButton.setEnabled(false);
            CommonMethods.boardArray[1][1] = 'O';
            return true;
        } else if (boardField[1][1] == 'X' && boardField[1][2] == 'X' && VsHumanPanel.midLeftButton.isEnabled()) {
            VsHumanPanel.midLeftButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.midLeftButton.setEnabled(false);
            CommonMethods.boardArray[1][0] = 'O';
            return true;
        } else if (boardField[2][0] == 'X' && boardField[2][1] == 'X' && VsHumanPanel.bottRightButton.isEnabled()) {
            VsHumanPanel.bottRightButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.bottRightButton.setEnabled(false);
            CommonMethods.boardArray[2][2] = 'O';
            return true;
        } else if (boardField[2][0] == 'X' && boardField[2][2] == 'X' && VsHumanPanel.bottMidButton.isEnabled()) {
            VsHumanPanel.bottMidButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.bottMidButton.setEnabled(false);
            CommonMethods.boardArray[2][1] = 'O';
            return true;
        } else if (boardField[2][1] == 'X' && boardField[2][2] == 'X' && VsHumanPanel.bottLeftButton.isEnabled()) {
            VsHumanPanel.bottLeftButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.bottLeftButton.setEnabled(false);
            CommonMethods.boardArray[2][0] = 'O';
            return true;

            // CROSSS
        } else if (boardField[0][0] == 'X' && boardField[2][2] == 'X' && VsHumanPanel.midMidButton.isEnabled()) {
            VsHumanPanel.midMidButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.midMidButton.setEnabled(false);
            CommonMethods.boardArray[1][1] = 'O';
            return true;
        } else if (boardField[0][2] == 'X' && boardField[2][0] == 'X' && VsHumanPanel.midMidButton.isEnabled()) {
            VsHumanPanel.midMidButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.midMidButton.setEnabled(false);
            CommonMethods.boardArray[1][1] = 'O';
            return true;
        } else if (boardField[0][0] == 'X' && boardField[1][1] == 'X' && VsHumanPanel.bottRightButton.isEnabled()) {
            VsHumanPanel.bottRightButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.bottRightButton.setEnabled(false);
            CommonMethods.boardArray[2][2] = 'O';
            return true;
        } else if (boardField[1][1] == 'X' && boardField[2][2] == 'X' && VsHumanPanel.upLeftButton.isEnabled()) {
            VsHumanPanel.upLeftButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.upLeftButton.setEnabled(false);
            CommonMethods.boardArray[0][0] = 'O';
            return true;
        } else if (boardField[0][2] == 'X' && boardField[1][1] == 'X' && VsHumanPanel.bottLeftButton.isEnabled()) {
            VsHumanPanel.bottLeftButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.bottLeftButton.setEnabled(false);
            CommonMethods.boardArray[2][0] = 'O';
            return true;
        } else if (boardField[2][0] == 'X' && boardField[1][1] == 'X' && VsHumanPanel.upRightButton.isEnabled()) {
            VsHumanPanel.upRightButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.upRightButton.setEnabled(false);
            CommonMethods.boardArray[0][2] = 'O';
            return true;

            // VERTICAL
        } else if (boardField[0][0] == 'X' && boardField[1][0] == 'X' && VsHumanPanel.bottLeftButton.isEnabled()) {
            VsHumanPanel.bottLeftButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.bottLeftButton.setEnabled(false);
            CommonMethods.boardArray[2][0] = 'O';
            return true;
        } else if (boardField[0][0] == 'X' && boardField[2][0] == 'X' && VsHumanPanel.midLeftButton.isEnabled()) {
            VsHumanPanel.midLeftButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.midLeftButton.setEnabled(false);
            CommonMethods.boardArray[1][0] = 'O';
            return true;
        } else if (boardField[1][0] == 'X' && boardField[2][0] == 'X' && VsHumanPanel.upLeftButton.isEnabled()) {
            VsHumanPanel.upLeftButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.upLeftButton.setEnabled(false);
            CommonMethods.boardArray[0][0] = 'O';
            return true;
        } else if (boardField[0][1] == 'X' && boardField[1][1] == 'X' && VsHumanPanel.bottMidButton.isEnabled()) {
            VsHumanPanel.bottMidButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.bottMidButton.setEnabled(false);
            CommonMethods.boardArray[2][1] = 'O';
            return true;
        } else if (boardField[0][1] == 'X' && boardField[2][1] == 'X' && VsHumanPanel.midMidButton.isEnabled()) {
            VsHumanPanel.midMidButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.midMidButton.setEnabled(false);
            CommonMethods.boardArray[1][1] = 'O';
            return true;
        } else if (boardField[1][1] == 'X' && boardField[2][1] == 'X' && VsHumanPanel.upMidButton.isEnabled()) {
            VsHumanPanel.upMidButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.upMidButton.setEnabled(false);
            CommonMethods.boardArray[0][1] = 'O';
            return true;
        } else if (boardField[0][2] == 'X' && boardField[1][2] == 'X' && VsHumanPanel.bottRightButton.isEnabled()) {
            VsHumanPanel.bottRightButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.bottRightButton.setEnabled(false);
            CommonMethods.boardArray[2][2] = 'O';
            return true;
        } else if (boardField[0][2] == 'X' && boardField[2][2] == 'X' && VsHumanPanel.midRightButton.isEnabled()) {
            VsHumanPanel.midRightButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.midRightButton.setEnabled(false);
            CommonMethods.boardArray[1][2] = 'O';
            return true;
        } else if (boardField[1][2] == 'X' && boardField[2][2] == 'X' && VsHumanPanel.upRightButton.isEnabled()) {
            VsHumanPanel.upRightButton.setIcon(VsHumanPanel.oImg);
            VsHumanPanel.upRightButton.setEnabled(false);
            CommonMethods.boardArray[0][2] = 'O';
            return true;
        } else return false;
    }

    public static void computerMove() {
        if (computerPrediction(CommonMethods.boardArray)) {
            VsHumanPanel.GameOver(CommonMethods.boardArray);
        } else if (!computerPrediction(CommonMethods.boardArray)) {

            Random random = new Random();
            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if ((row == 0) && (col == 0) && VsHumanPanel.upLeftButton.isEnabled()) {
                VsHumanPanel.upLeftButton.setIcon(VsHumanPanel.oImg);
                VsHumanPanel.upLeftButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = 'O';
                VsHumanPanel.GameOver(CommonMethods.boardArray);
            } else if ((row == 0) && (col == 1) && VsHumanPanel.upMidButton.isEnabled()) {
                VsHumanPanel.upMidButton.setIcon(VsHumanPanel.oImg);
                VsHumanPanel.upMidButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = 'O';
                VsHumanPanel.GameOver(CommonMethods.boardArray);
            } else if ((row == 0) && (col == 2) && VsHumanPanel.upRightButton.isEnabled()) {
                VsHumanPanel.upRightButton.setIcon(VsHumanPanel.oImg);
                VsHumanPanel.upRightButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = 'O';
                VsHumanPanel.GameOver(CommonMethods.boardArray);
            } else if ((row == 1) && (col == 0) && VsHumanPanel.midLeftButton.isEnabled()) {
                VsHumanPanel.midLeftButton.setIcon(VsHumanPanel.oImg);
                VsHumanPanel.midLeftButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = 'O';
                VsHumanPanel.GameOver(CommonMethods.boardArray);
            } else if ((row == 1) && (col == 1) && VsHumanPanel.midMidButton.isEnabled()) {
                VsHumanPanel.midMidButton.setIcon(VsHumanPanel.oImg);
                VsHumanPanel.midMidButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = 'O';
                VsHumanPanel.GameOver(CommonMethods.boardArray);
            } else if ((row == 1) && (col == 2) && VsHumanPanel.midRightButton.isEnabled()) {
                VsHumanPanel.midRightButton.setIcon(VsHumanPanel.oImg);
                VsHumanPanel.midRightButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = 'O';
                VsHumanPanel.GameOver(CommonMethods.boardArray);
            } else if ((row == 2) && (col == 0) && VsHumanPanel.bottLeftButton.isEnabled()) {
                VsHumanPanel.bottLeftButton.setIcon(VsHumanPanel.oImg);
                VsHumanPanel.bottLeftButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = 'O';
                VsHumanPanel.GameOver(CommonMethods.boardArray);
            } else if ((row == 2) && (col == 1) && VsHumanPanel.bottMidButton.isEnabled()) {
                VsHumanPanel.bottMidButton.setIcon(VsHumanPanel.oImg);
                VsHumanPanel.bottMidButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = 'O';
                VsHumanPanel.GameOver(CommonMethods.boardArray);
            } else if ((row == 2) && (col == 2) && VsHumanPanel.bottRightButton.isEnabled()) {
                VsHumanPanel.bottRightButton.setIcon(VsHumanPanel.oImg);
                VsHumanPanel.bottRightButton.setEnabled(false);
                CommonMethods.boardArray[row][col] = 'O';
                VsHumanPanel.GameOver(CommonMethods.boardArray);
            } else {
                computerMove();
            }
        }
    }

    public static void start() {
        timer.start();
    }

}
