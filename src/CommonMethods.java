import java.util.ArrayList;
import java.util.List;

public class CommonMethods {

    static char[][] boardArray = new char[3][3];

    CommonMethods() {
       // boardArray = new char[3][3];
    }

    // Possibilities of X/O win
    static boolean isTheWinner(char[][] boardField, char symbol) {
        return (boardField[0][0] == symbol && boardField[0][1] == symbol && boardField[0][2] == symbol) ||
                (boardField[1][0] == symbol && boardField[1][1] == symbol && boardField[1][2] == symbol) ||
                (boardField[2][0] == symbol && boardField[2][1] == symbol && boardField[2][2] == symbol) ||

                (boardField[0][0] == symbol && boardField[1][0] == symbol && boardField[2][0] == symbol) ||
                (boardField[0][1] == symbol && boardField[1][1] == symbol && boardField[2][1] == symbol) ||
                (boardField[0][2] == symbol && boardField[1][2] == symbol && boardField[2][2] == symbol) ||

                (boardField[0][0] == symbol && boardField[1][1] == symbol && boardField[2][2] == symbol) ||
                (boardField[0][2] == symbol && boardField[1][1] == symbol && boardField[2][0] == symbol);
    }

    // Fills the array with white-spaces, basically resets the board
    public static void fillArray(char[][] boardArray) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardArray[i][j] = ' ';
            }
        }
    }

    public static void enableAll(List <GameButton> buttons) {

        for (GameButton button : buttons) {
            button.setEnabled(true);
        }

//        upLeftButton.setEnabled(true);
//        upMidButton.setEnabled(true);
//        upRightButton.setEnabled(true);
//        midLeftButton.setEnabled(true);
//        midMidButton.setEnabled(true);
//        midRightButton.setEnabled(true);
//        bottLeftButton.setEnabled(true);
//        bottMidButton.setEnabled(true);
//        bottRightButton.setEnabled(true);
    }

    public static void disableAll(List <GameButton> buttons) {

        for (GameButton button : buttons) {
            button.setEnabled(false);
        }

//        upLeftButton.setEnabled(false);
//        upMidButton.setEnabled(false);
//        upRightButton.setEnabled(false);
//        midLeftButton.setEnabled(false);
//        midMidButton.setEnabled(false);
//        midRightButton.setEnabled(false);
//        bottLeftButton.setEnabled(false);
//        bottMidButton.setEnabled(false);
//        bottRightButton.setEnabled(false);
    }

    public static void disableIconsVisibility(List <GameButton> buttons) {

        for (GameButton button : buttons) {
            button.setIcon(null);
        }

//        upLeftButton.setIcon(null);
//        upMidButton.setIcon(null);
//        upRightButton.setIcon(null);
//        midLeftButton.setIcon(null);
//        midMidButton.setIcon(null);
//        midRightButton.setIcon(null);
//        bottLeftButton.setIcon(null);
//        bottMidButton.setIcon(null);
//        bottRightButton.setIcon(null);
    }

    public static void player1Wins() {
        MainPanel.player1Score++;
        MainPanel.messageLabel.setText(MainPanel.player1 + " wins");
    }

    public static void player2Wins() {
        MainPanel.player2Score++;
        MainPanel.messageLabel.setText(MainPanel.player2 + " wins");
    }

}
