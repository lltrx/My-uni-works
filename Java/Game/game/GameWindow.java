// In collaboration with 2613065y, 2614579a, 2615938b
package game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class GameWindow extends JFrame implements ActionListener {
	
	private GameButton[][] buttons;
	private JButton resetButton;
	private JLabel statusLabel;
	private int turn = 1;
	
	public GameWindow(int size) {
		super("Let's play a game!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		statusLabel = new JLabel(" ");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(size, size));
		
		buttons = new GameButton[size][];
		for (int i = 0; i < size; i++) {
			buttons[i] = new GameButton[size];
			for (int j = 0; j < size; j++) {
				GameButton button = new GameButton();
				button.setFont(button.getFont().deriveFont(25.0f));
				button.setPreferredSize(new Dimension(100, 100));
				buttonPanel.add(button);
				buttons[i][j] = button;
			}
		}

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(statusLabel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.CENTER);
		
		resetButton = new JButton("Reset");
		getContentPane().add(resetButton, BorderLayout.SOUTH);
		
		pack();
	}

	/** converts a 2d array of buttons into a 2d array of their symbols */
	private String[][] getBoardValues() {
        String[][] board = new String[buttons.length][buttons.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = buttons[i][j].getSymbol();
			}
		}
        return board;
    }
	/** checks state of board represented as 2d array of symbols */
	private void checkBoard(){
		String[][]board = getBoardValues();

		/* check to see if a 2x2 square has been filled with the same value */
        for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board[i].length - 1; j++) {
				/* Skip check for cell if the symbol is null to avoid NullPointException */
				if(board[i][j] == null){continue;}
				/* Check if a 2x2 square has been filled out */
				if (board[i][j].equals(board[i][j + 1]) && board[i][j].equals(board[i + 1][j]) && board[i][j].equals(board[i + 1][j + 1])) {
					statusLabel.setText("Winner: Player " + board[i][j]);
					disableButtons();
					return;
				}
				/* if the whole board is full: adding 1 because turn starts at 1 */
				if (turn == (board.length * board.length)+1) {
					statusLabel.setText("Board is full with no winner");
				}
			}
		}
	}

	/** Resets the board to a new game state */
	private void resetBoard(){
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].reset();
			}
		}
		turn = 1;
		statusLabel.setText("Player 1's turn");
	}

	/** Disables all buttons in game */
	private void disableButtons(){
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

	/** In your actionPerformed() method, you can check which button was clicked on by calling getSource() on the ActionEvent parameter. */
	public void actionPerformed(ActionEvent e){
		/* Reset grid if reset button is pressed */
	    if (e.getSource() == resetButton) {
            resetBoard();
			return;
        }
		GameButton buttonPressed = (GameButton) e.getSource();
		if(turn % 2 == 1) {
			/* Player 1's turn */
			buttonPressed.setSymbol("1");
			statusLabel.setText("Player 2's turn");
		}else{
			/* Player 2's turn */
			buttonPressed.setSymbol("2");
			statusLabel.setText("Player 1's turn");

		}
		turn++;
		checkBoard();
	}

    /**
     * Main method -- just creates and displays the window.
     */
    public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				/* Setup window */
				GameWindow window = new GameWindow(4);
				window.setVisible(true);
				/* Initialize ActionListners */
                window.resetButton.addActionListener(window);
				for (int i = 0; i < window.buttons.length; i++) {
					for (int j = 0; j < window.buttons[i].length; j++) {
						window.buttons[i][j].addActionListener(window);
					}
				}
				/* update statusLabel */
				window.statusLabel.setText("Player 1's turn");

			}
		});
	}
}
