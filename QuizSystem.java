import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizSystem {
    private static int score = 0;
    private static int questionIndex = 0;
    private static boolean[] answered;
    private static String[] questions = {
        "What is the capital of France?",
        "What is the largest planet in our solar system?",
        "Who wrote 'To Kill a Mockingbird'?"
    };
    private static String[][] options = {
        {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
        {"A. Earth", "B. Jupiter", "C. Mars", "D. Saturn"},
        {"A. Harper Lee", "B. J.K. Rowling", "C. Charles Dickens", "D. Ernest Hemingway"}
    };
    private static char[] answers = {'B', 'B', 'A'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        answered = new boolean[questions.length];

        while (questionIndex < questions.length) {
            displayQuestion(questionIndex);
            startTimer(10); // 10 seconds to answer each question

            char userAnswer = scanner.next().toUpperCase().charAt(0);
            if (userAnswer == answers[questionIndex]) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
            questionIndex++;
        }

        displayResult();
    }

    private static void displayQuestion(int index) {
        System.out.println("Question " + (index + 1) + ": " + questions[index]);
        for (String option : options[index]) {
            System.out.println(option);
        }
        System.out.print("Your answer: ");
    }

    private static void startTimer(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                if (!answered[questionIndex]) {
                    System.out.println("\nTime's up!");
                    questionIndex++;
                }
                cancel();
            }
        }, seconds * 1000);
    }

    private static void displayResult() {
        System.out.println("\nQuiz ended. Your final score: " + score + "/" + questions.length);
    }
}
