import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P5_Tic_Tac_Toe_Game extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private char currentPlayer = 'X';

    public P5_Tic_Tac_Toe_Game() {
        setTitle("Tic-Tac-Toe Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        initButtons();

        setVisible(true);
    }

    private void initButtons() {
        Font font = new Font("Arial", Font.BOLD, 60);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton) e.getSource();

        if (!btnClicked.getText().equals("")) return;

        btnClicked.setText(String.valueOf(currentPlayer));

        if (checkWin()) {
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            resetBoard();
        } else if (checkDraw()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetBoard();
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (checkEqual(buttons[i][0], buttons[i][1], buttons[i][2]) ||
                checkEqual(buttons[0][i], buttons[1][i], buttons[2][i])) {
                return true;
            }
        }
        return checkEqual(buttons[0][0], buttons[1][1], buttons[2][2]) ||
               checkEqual(buttons[0][2], buttons[1][1], buttons[2][0]);
    }

    private boolean checkEqual(JButton b1, JButton b2, JButton b3) {
        String t1 = b1.getText(), t2 = b2.getText(), t3 = b3.getText();
        return !t1.equals("") && t1.equals(t2) && t2.equals(t3);
    }

    private boolean checkDraw() {
        for (JButton[] row : buttons) {
            for (JButton b : row) {
                if (b.getText().equals("")) return false;
            }
        }
        return true;
    }

    private void resetBoard() {
        for (JButton[] row : buttons) {
            for (JButton b : row) {
                b.setText("");
            }
        }
        currentPlayer = 'X';
    }
    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
