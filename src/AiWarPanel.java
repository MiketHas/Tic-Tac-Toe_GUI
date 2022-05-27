import javax.swing.*;
import java.util.Random;

public class AiWarPanel extends JPanel {

    static GameButton upLeftButton, upMidButton, upRightButton, midLeftButton, midMidButton, midRightButton, bottLeftButton, bottMidButton, bottRightButton;
    static ImageIcon xImg, oImg, board;
    JLabel gameBcg;
    static char[][] boardArray;
    static int emptySpaces = 9;
    static int whoGoesFirst; // 0 is R5-J2 and 1 is K2-SO.

    AiWarPanel() {
        this.setLayout(null);

        // backend Array
        boardArray = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardArray[i][j] = ' ';
            }
        }

        xImg = new ImageIcon(getClass().getClassLoader().getResource("res/xImg.png"));
        oImg = new ImageIcon(getClass().getClassLoader().getResource("res/oImg.png"));
        board = new ImageIcon(getClass().getClassLoader().getResource("res/board.png"));

        gameBcg = new JLabel();
        gameBcg.setIcon(board);
        gameBcg.setBounds(0, 0, 390, 300);
        gameBcg.setVisible(true);
        gameBcg.setOpaque(false);

        upLeftButton = new GameButton(0, 0);
        upMidButton = new GameButton(130, 0);
        upRightButton = new GameButton(260, 0);
        midLeftButton = new GameButton(0, 100);
        midMidButton = new GameButton(130, 100);
        midRightButton = new GameButton(260, 100);
        bottLeftButton = new GameButton(0, 200);
        bottMidButton = new GameButton(130, 200);
        bottRightButton = new GameButton(260, 200);

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

    // Restarting and reseting the game
    public static void restart() {
        boardArray = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardArray[i][j] = ' ';
            }
        }

        emptySpaces = 9;
        enableAll();

        AiWarCompOpponent.computerMove = 1;
        AiWarCompOpponent.previousSign = 'O';
        AiWarCompOpponent.currentSign = 'X';
        AiWarCompOpponent.compIcon = AiWarPanel.xImg;

        disableIconsVisibility();

        Random random = new Random();
        whoGoesFirst = random.nextInt(2);
        switch (whoGoesFirst) {
            case 0 -> MainPanel.textPane.setText("R5-J2 goes first!");
            case 1 -> MainPanel.textPane.setText("K2-SO goes first!");
        }

        AiWarCompOpponent.start();
    }

    // Possibilities of X/O win
    private static boolean isTheWinner(char[][] boardField, char symbol) {
        return (boardField[0][0] == symbol && boardField[0][1] == symbol && boardField[0][2] == symbol) ||
                (boardField[1][0] == symbol && boardField[1][1] == symbol && boardField[1][2] == symbol) ||
                (boardField[2][0] == symbol && boardField[2][1] == symbol && boardField[2][2] == symbol) ||

                (boardField[0][0] == symbol && boardField[1][0] == symbol && boardField[2][0] == symbol) ||
                (boardField[0][1] == symbol && boardField[1][1] == symbol && boardField[2][1] == symbol) ||
                (boardField[0][2] == symbol && boardField[1][2] == symbol && boardField[2][2] == symbol) ||

                (boardField[0][0] == symbol && boardField[1][1] == symbol && boardField[2][2] == symbol) ||
                (boardField[0][2] == symbol && boardField[1][1] == symbol && boardField[2][0] == symbol);
    }

    // Checking if the game is over
    public static boolean GameOver(char[][] boardField) {

        boolean xWins = isTheWinner(boardField, 'X');
        boolean oWins = isTheWinner(boardField, 'O');

        if (xWins) { //True/False
            switch (whoGoesFirst) {
                case 0 -> {
                    player1Wins();
                }
                case 1 -> {
                    player2Wins();
                }
            }
            //MainPanel.messageLabel.setText("X wins");
            MainPanel.scoreLabel.setText(MainPanel.player1 + " " + MainPanel.player1Score + ":" + MainPanel.player2Score + " " + MainPanel.player2);
            disableAll();
            return true;
        } else if (oWins) { //True/False
            switch (whoGoesFirst) {
                case 0 -> {
                    player2Wins();
                }
                case 1 -> {
                    player1Wins();
                }
            }
            //MainPanel.messageLabel.setText("O wins");
            MainPanel.scoreLabel.setText(MainPanel.player1 + " " + MainPanel.player1Score + ":" + MainPanel.player2Score + " " + MainPanel.player2);
            disableAll();
            return true;
        } else if (emptySpaces == 0) {
            MainPanel.messageLabel.setText("Draw!");
            disableAll();
            return true;
        } else {
            return false;
        }
    }

    public static void enableAll() {
        upLeftButton.setEnabled(true);
        upMidButton.setEnabled(true);
        upRightButton.setEnabled(true);
        midLeftButton.setEnabled(true);
        midMidButton.setEnabled(true);
        midRightButton.setEnabled(true);
        bottLeftButton.setEnabled(true);
        bottMidButton.setEnabled(true);
        bottRightButton.setEnabled(true);
    }

    public static void disableAll() {
        upLeftButton.setEnabled(false);
        upMidButton.setEnabled(false);
        upRightButton.setEnabled(false);
        midLeftButton.setEnabled(false);
        midMidButton.setEnabled(false);
        midRightButton.setEnabled(false);
        bottLeftButton.setEnabled(false);
        bottMidButton.setEnabled(false);
        bottRightButton.setEnabled(false);
    }

    public static void disableIconsVisibility() {
        upLeftButton.setIcon(null);
        upMidButton.setIcon(null);
        upRightButton.setIcon(null);
        midLeftButton.setIcon(null);
        midMidButton.setIcon(null);
        midRightButton.setIcon(null);
        bottLeftButton.setIcon(null);
        bottMidButton.setIcon(null);
        bottRightButton.setIcon(null);
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
