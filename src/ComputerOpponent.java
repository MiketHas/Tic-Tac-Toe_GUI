import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ComputerOpponent {

    static Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            ComputerOpponent.computerMove();
            timer.stop();
            SinglePlayerPanel.active=true;
        }
    });

    public static boolean computerPrediction(char[][] boardField) {
            // HORIZONTAL
        if (boardField[0][0] == 'X' && boardField[0][1] == 'X' && SinglePlayerPanel.upRightButton.isEnabled()) {
            SinglePlayerPanel.upRightButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.upRightButton.setEnabled(false);
            SinglePlayerPanel.boardArray[0][2] = 'O';
            return true;
        } else if (boardField[0][0] == 'X' && boardField[0][2] == 'X' && SinglePlayerPanel.upMidButton.isEnabled()) {
            SinglePlayerPanel.upMidButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.upMidButton.setEnabled(false);
            SinglePlayerPanel.boardArray[0][1] = 'O';
            return true;
        } else if (boardField[0][1] == 'X' && boardField[0][2] == 'X' && SinglePlayerPanel.upLeftButton.isEnabled()) {
            SinglePlayerPanel.upLeftButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.upLeftButton.setEnabled(false);
            SinglePlayerPanel.boardArray[0][0] = 'O';
            return true;
        } else if (boardField[1][0] == 'X' && boardField[1][1] == 'X' && SinglePlayerPanel.midRightButton.isEnabled()) {
            SinglePlayerPanel.midRightButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.midRightButton.setEnabled(false);
            SinglePlayerPanel.boardArray[1][2] = 'O';
            return true;
        } else if (boardField[1][0] == 'X' && boardField[1][2] == 'X' && SinglePlayerPanel.midMidButton.isEnabled()) {
            SinglePlayerPanel.midMidButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.midMidButton.setEnabled(false);
            SinglePlayerPanel.boardArray[1][1] = 'O';
            return true;
        } else if (boardField[1][1] == 'X' && boardField[1][2] == 'X' && SinglePlayerPanel.midLeftButton.isEnabled()) {
            SinglePlayerPanel.midLeftButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.midLeftButton.setEnabled(false);
            SinglePlayerPanel.boardArray[1][0] = 'O';
            return true;
        } else if (boardField[2][0] == 'X' && boardField[2][1] == 'X' && SinglePlayerPanel.bottRightButton.isEnabled()) {
            SinglePlayerPanel.bottRightButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.bottRightButton.setEnabled(false);
            SinglePlayerPanel.boardArray[2][2] = 'O';
            return true;
        } else if (boardField[2][0] == 'X' && boardField[2][2] == 'X' && SinglePlayerPanel.bottMidButton.isEnabled()) {
            SinglePlayerPanel.bottMidButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.bottMidButton.setEnabled(false);
            SinglePlayerPanel.boardArray[2][1] = 'O';
            return true;
        } else if (boardField[2][1] == 'X' && boardField[2][2] == 'X' && SinglePlayerPanel.bottLeftButton.isEnabled()) {
            SinglePlayerPanel.bottLeftButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.bottLeftButton.setEnabled(false);
            SinglePlayerPanel.boardArray[2][0] = 'O';
            return true;

            // CROSSS
        } else if (boardField[0][0] == 'X' && boardField[2][2] == 'X' && SinglePlayerPanel.midMidButton.isEnabled()) {
            SinglePlayerPanel.midMidButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.midMidButton.setEnabled(false);
            SinglePlayerPanel.boardArray[1][1] = 'O';
            return true;
        } else if (boardField[0][2] == 'X' && boardField[2][0] == 'X' && SinglePlayerPanel.midMidButton.isEnabled()) {
            SinglePlayerPanel.midMidButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.midMidButton.setEnabled(false);
            SinglePlayerPanel.boardArray[1][1] = 'O';
            return true;
        } else if (boardField[0][0] == 'X' && boardField[1][1] == 'X' && SinglePlayerPanel.bottRightButton.isEnabled()) {
            SinglePlayerPanel.bottRightButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.bottRightButton.setEnabled(false);
            SinglePlayerPanel.boardArray[2][2] = 'O';
            return true;
        } else if (boardField[1][1] == 'X' && boardField[2][2] == 'X' && SinglePlayerPanel.upLeftButton.isEnabled()) {
            SinglePlayerPanel.upLeftButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.upLeftButton.setEnabled(false);
            SinglePlayerPanel.boardArray[0][0] = 'O';
            return true;
        } else if (boardField[0][2] == 'X' && boardField[1][1] == 'X' && SinglePlayerPanel.bottLeftButton.isEnabled()) {
            SinglePlayerPanel.bottLeftButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.bottLeftButton.setEnabled(false);
            SinglePlayerPanel.boardArray[2][0] = 'O';
            return true;
        } else if (boardField[2][0] == 'X' && boardField[1][1] == 'X' && SinglePlayerPanel.upRightButton.isEnabled()) {
            SinglePlayerPanel.upRightButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.upRightButton.setEnabled(false);
            SinglePlayerPanel.boardArray[0][2] = 'O';
            return true;

            // VERTICAL
        } else if (boardField[0][0] == 'X' && boardField[1][0] == 'X' && SinglePlayerPanel.bottLeftButton.isEnabled()) {
            SinglePlayerPanel.bottLeftButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.bottLeftButton.setEnabled(false);
            SinglePlayerPanel.boardArray[2][0] = 'O';
            return true;
        } else if (boardField[0][0] == 'X' && boardField[2][0] == 'X' && SinglePlayerPanel.midLeftButton.isEnabled()) {
            SinglePlayerPanel.midLeftButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.midLeftButton.setEnabled(false);
            SinglePlayerPanel.boardArray[1][0] = 'O';
            return true;
        } else if (boardField[1][0] == 'X' && boardField[2][0] == 'X' && SinglePlayerPanel.upLeftButton.isEnabled()) {
            SinglePlayerPanel.upLeftButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.upLeftButton.setEnabled(false);
            SinglePlayerPanel.boardArray[0][0] = 'O';
            return true;
        } else if (boardField[0][1] == 'X' && boardField[1][1] == 'X' && SinglePlayerPanel.bottMidButton.isEnabled()) {
            SinglePlayerPanel.bottMidButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.bottMidButton.setEnabled(false);
            SinglePlayerPanel.boardArray[2][1] = 'O';
            return true;
        } else if (boardField[0][1] == 'X' && boardField[2][1] == 'X' && SinglePlayerPanel.midMidButton.isEnabled()) {
            SinglePlayerPanel.midMidButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.midMidButton.setEnabled(false);
            SinglePlayerPanel.boardArray[1][1] = 'O';
            return true;
        } else if (boardField[1][1] == 'X' && boardField[2][1] == 'X' && SinglePlayerPanel.upMidButton.isEnabled()) {
            SinglePlayerPanel.upMidButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.upMidButton.setEnabled(false);
            SinglePlayerPanel.boardArray[0][1] = 'O';
            return true;
        } else if (boardField[0][2] == 'X' && boardField[1][2] == 'X' && SinglePlayerPanel.bottRightButton.isEnabled()) {
            SinglePlayerPanel.bottRightButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.bottRightButton.setEnabled(false);
            SinglePlayerPanel.boardArray[2][2] = 'O';
            return true;
        } else if (boardField[0][2] == 'X' && boardField[2][2] == 'X' && SinglePlayerPanel.midRightButton.isEnabled()) {
            SinglePlayerPanel.midRightButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.midRightButton.setEnabled(false);
            SinglePlayerPanel.boardArray[1][2] = 'O';
            return true;
        } else if (boardField[1][2] == 'X' && boardField[2][2] == 'X' && SinglePlayerPanel.upRightButton.isEnabled()) {
            SinglePlayerPanel.upRightButton.setIcon(SinglePlayerPanel.oImg);
            SinglePlayerPanel.upRightButton.setEnabled(false);
            SinglePlayerPanel.boardArray[0][2] = 'O';
            return true;
        } else return false;
    }

    public static void computerMove() {
        if (computerPrediction(SinglePlayerPanel.boardArray)) {
            SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
        } else if (!computerPrediction(SinglePlayerPanel.boardArray)) {

            Random random = new Random();
            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if ((row == 0) && (col == 0) && SinglePlayerPanel.upLeftButton.isEnabled()) {
                SinglePlayerPanel.upLeftButton.setIcon(SinglePlayerPanel.oImg);
                SinglePlayerPanel.upLeftButton.setEnabled(false);
                SinglePlayerPanel.boardArray[row][col] = 'O';
                SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
            } else if ((row == 0) && (col == 1) && SinglePlayerPanel.upMidButton.isEnabled()) {
                SinglePlayerPanel.upMidButton.setIcon(SinglePlayerPanel.oImg);
                SinglePlayerPanel.upMidButton.setEnabled(false);
                SinglePlayerPanel.boardArray[row][col] = 'O';
                SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
            } else if ((row == 0) && (col == 2) && SinglePlayerPanel.upRightButton.isEnabled()) {
                SinglePlayerPanel.upRightButton.setIcon(SinglePlayerPanel.oImg);
                SinglePlayerPanel.upRightButton.setEnabled(false);
                SinglePlayerPanel.boardArray[row][col] = 'O';
                SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
            } else if ((row == 1) && (col == 0) && SinglePlayerPanel.midLeftButton.isEnabled()) {
                SinglePlayerPanel.midLeftButton.setIcon(SinglePlayerPanel.oImg);
                SinglePlayerPanel.midLeftButton.setEnabled(false);
                SinglePlayerPanel.boardArray[row][col] = 'O';
                SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
            } else if ((row == 1) && (col == 1) && SinglePlayerPanel.midMidButton.isEnabled()) {
                SinglePlayerPanel.midMidButton.setIcon(SinglePlayerPanel.oImg);
                SinglePlayerPanel.midMidButton.setEnabled(false);
                SinglePlayerPanel.boardArray[row][col] = 'O';
                SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
            } else if ((row == 1) && (col == 2) && SinglePlayerPanel.midRightButton.isEnabled()) {
                SinglePlayerPanel.midRightButton.setIcon(SinglePlayerPanel.oImg);
                SinglePlayerPanel.midRightButton.setEnabled(false);
                SinglePlayerPanel.boardArray[row][col] = 'O';
                SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
            } else if ((row == 2) && (col == 0) && SinglePlayerPanel.bottLeftButton.isEnabled()) {
                SinglePlayerPanel.bottLeftButton.setIcon(SinglePlayerPanel.oImg);
                SinglePlayerPanel.bottLeftButton.setEnabled(false);
                SinglePlayerPanel.boardArray[row][col] = 'O';
                SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
            } else if ((row == 2) && (col == 1) && SinglePlayerPanel.bottMidButton.isEnabled()) {
                SinglePlayerPanel.bottMidButton.setIcon(SinglePlayerPanel.oImg);
                SinglePlayerPanel.bottMidButton.setEnabled(false);
                SinglePlayerPanel.boardArray[row][col] = 'O';
                SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
            } else if ((row == 2) && (col == 2) && SinglePlayerPanel.bottRightButton.isEnabled()) {
                SinglePlayerPanel.bottRightButton.setIcon(SinglePlayerPanel.oImg);
                SinglePlayerPanel.bottRightButton.setEnabled(false);
                SinglePlayerPanel.boardArray[row][col] = 'O';
                SinglePlayerPanel.GameOver(SinglePlayerPanel.boardArray);
            } else {
                computerMove();
            }
        }
    }

    public static void start() {
        timer.start();
    }

}
