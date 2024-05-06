import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGame extends JFrame {
    private int randomNumber;
    private int attempts;
    private int totalScore;
    private JLabel feedbackLabel;
    private JLabel scoreLabel;
    private JTextField guessField;
    private JButton guessButton;
    private JButton playAgainButton;

    public NumberGuessingGame() {
        super("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        feedbackLabel = new JLabel("Guess a number between 1 and 100");
        scoreLabel = new JLabel("Score: 0");
        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        playAgainButton = new JButton("Play Again");

        add(feedbackLabel);
        add(scoreLabel);
        add(guessField);
        add(guessButton);

        generateRandomNumber();
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
    }

    private void generateRandomNumber() {
        randomNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
    }

    private void checkGuess() {
        String guessText = guessField.getText();
        int guess;
        try {
            guess = Integer.parseInt(guessText);
            attempts++;
            if (guess == randomNumber) {
                feedbackLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                totalScore += (100 - attempts); // Calculate score based on attempts
                scoreLabel.setText("Score: " + totalScore);
                add(playAgainButton);
                guessButton.setEnabled(false);
                playAgainButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        resetGame();
                    }
                });
            } else if (guess < randomNumber) {
                feedbackLabel.setText("Too low!# Try again.");


            } else 
            {
                feedbackLabel.setText("Too high!# Try again.");
            }
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Please enter a valid numbar.");
        }
        guessField.setText("");
    }

    private void resetGame() {
        feedbackLabel.setText("Guess a number between 1 and 100");
        generateRandomNumber();
        guessButton.setEnabled(true);

        remove(playAgainButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGame().setVisible(true);
            }
        });
    }
}
