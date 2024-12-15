import java.util.Scanner;

public class QuizManager {
    private final Quiz biologyQuiz;
    private final Quiz geographyQuiz;
    private final Scanner scanner;

    public QuizManager(Quiz biologyQuiz, Quiz geographyQuiz) {
        this.biologyQuiz = biologyQuiz;
        this.geographyQuiz = geographyQuiz;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        this.initGame();
        while (true) {
            System.out.println("\nChoose your quiz: ");
            System.out.println("Biology quiz - 1");
            System.out.println("Geography quiz - 2");
            System.out.println("Exit - 0");

            int userInput = scanner.nextInt();

            if (userInput == 0) {
                System.out.println("Quiz game ended by player.");
                break;
            } else if (userInput == 1) {
                biologyQuiz.startQuiz();
            } else if (userInput == 2) {
                geographyQuiz.startQuiz();
            } else {
                System.out.println("Invalid choice. Please select either 1 or 2.");
            }
        }
    }

    private void initGame() {
        System.out.println("""
                Welcome to the Quiz game!
                You can choose between biology quiz (select '1'),
                geography quiz (select '2') or exit (select '0').
                Each quiz has 3 questions with 4 options (a - d).
                Choose one or multiple options with keys a, b, c, d.
                Don't forget to put space between your answers (example: 'a b c').
                If the particular quiz has finished, you'll have a choice to exit the game,
                or continue to the other quiz.
                Have fun and good luck.""");
    }
}
